package com.warnett.mfnmanager.comms;

import com.warnett.mfnmanager.exceptions.comms.CommunicationsException;
import com.warnett.mfnmanger.comms.CommsOperation;
import com.warnett.mfnmanger.comms.WebpageResponseHandler;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CommsOperationTest {
    @Mock
    private ClassicHttpRequest mockRequest;

    @Mock
    private CloseableHttpClient mockClient;

    private CommsOperation<List<String>> testOperation;

    @BeforeEach
    void setupTestOperation() {
        testOperation = new DummyCommsOperation(mock(WebpageResponseHandler.class));
    }

    @Test
    void whenIOExceptionOccursConnecting_thenCommsExceptionIsThrown() throws IOException {
        when(mockClient.execute(any(ClassicHttpRequest.class), any(HttpClientResponseHandler.class))).thenThrow(new IOException("Connection error"));

        final var exceptionAssertion = assertThatThrownBy(() -> testOperation.performOperation(mockClient));

        exceptionAssertion.isInstanceOf(CommunicationsException.class)
                .hasMessage("Failed to process response");

        exceptionAssertion.cause()
                .isInstanceOf(IOException.class)
                .hasMessage("Connection error");
    }


    @Test
    void whenResponseReturned_thenConvertedResponseIsReturned() throws IOException,CommunicationsException {
        final var text = String.format("this is some example%scontent text", System.lineSeparator());

        when(mockClient.execute(any(ClassicHttpRequest.class), any(HttpClientResponseHandler.class)))
                .thenReturn(text);


        assertThat(testOperation.performOperation(mockClient))
                .isInstanceOf(List.class)
                .isEqualTo(List.of("this is some example", "content text"));
    }

    private class DummyCommsOperation extends CommsOperation<List<String>> {

        DummyCommsOperation(WebpageResponseHandler commsHandler) {
            super(commsHandler);
        }

        @Override
        public List<String> convert(String responseText) {
            return Arrays.stream(responseText.toLowerCase().split(System.lineSeparator())).toList();
        }

        @Override
        public ClassicHttpRequest generateRequest() {
            return mockRequest;
        }
    }
}
