package com.warnett.mfnmanager.comms;

import com.warnett.mfnmanger.comms.WebpageResponseHandler;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WebpageResponseHandlerTest {
    @Mock
    private ClassicHttpResponse mockResponse;

    @Mock
    private HttpEntity mockEntity;

    private WebpageResponseHandler handler;

    @BeforeEach
    void setupHandler() {
        handler = new WebpageResponseHandler();
    }

    @Test
    void whenIOExceptionOccurs_thenExceptionIsPropogated() throws IOException {
        final var EXCEPTION_TEXT = "Test IO Exception";
        when(mockResponse.getEntity()).thenReturn(mockEntity);
        when(mockEntity.getContent()).thenThrow(new IOException(EXCEPTION_TEXT));

        final var exceptionAssertion = assertThatThrownBy(() -> handler.handleResponse(mockResponse));

        exceptionAssertion.isInstanceOf(IOException.class)
                .hasMessage(EXCEPTION_TEXT);

    }

    @Test
    void whenSingleLineOfTextInResponse_thenSingleLineReturned() throws IOException {
        when(mockResponse.getEntity()).thenReturn(mockEntity);
        when(mockEntity.getContent()).thenReturn(new ByteArrayInputStream("Single line".getBytes()));

        assertThat(handler.handleResponse(mockResponse)).isEqualTo(String.format("Single line%n"));
    }

    @Test
    void whenMultipleLinesOfTextInResponse_thenAllLinesInReturnedValue() throws IOException {
        when(mockResponse.getEntity()).thenReturn(mockEntity);
        when(mockEntity.getContent()).thenReturn(new ByteArrayInputStream(String.format("First line%sSecond line", System.lineSeparator()).getBytes()));

        assertThat(handler.handleResponse(mockResponse)).isEqualTo(String.format("First line%nSecond line%n"));
    }

    @Test
    void whenEmptyContentAvailable_thenEmptyStringReturned() throws IOException {
        when(mockResponse.getEntity()).thenReturn(mockEntity);
        when(mockEntity.getContent()).thenReturn(new ByteArrayInputStream("".getBytes()));

        assertThat(handler.handleResponse(mockResponse)).isEmpty();
    }

    @Test
    void whenNullContentAvailable_thenExceptionThrown() throws IOException {
        when(mockResponse.getEntity()).thenReturn(mockEntity);
        when(mockEntity.getContent()).thenReturn(null);

        final var exceptionAssertion = assertThatThrownBy(() -> handler.handleResponse(mockResponse));

        exceptionAssertion.isInstanceOf(IOException.class)
                .hasMessage("Response content not present");
    }

}
