package unit.com.warnett.mfnmanager.ui.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.warnett.mfnmanager.ui.controller.CustomErrorController;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;

import java.util.stream.Stream;

class CustomErrorControllerTest extends BaseControllerTest<CustomErrorController> {

    @Mock
    private HttpServletRequest mockRequest;

    @BeforeEach
    void setup() {
        controller = new CustomErrorController();
    }

    @Test
    @DisplayName("Error Page Title set correctly")
    void whenErrorPageMethodInvoked_thenPageTitleSetCorrectly() {
        controller.handleError(mockRequest, model);

        verify(model).addAttribute("page_title", "MFN Manager - Error");
    }

    @Test
    @DisplayName("Error Page returned correctly")
    void whenErrorPageMethodInvoked_thenPageReturnedCorrectly() {
        assertThat(controller.handleError(mockRequest, model)).isEqualTo("pages/mfn-error");
    }

    @Test
    @DisplayName("When Error has no status or message, model attributes set correctly")
    void whenHomePageMethodInvokedWithNullStatusAndNullMessage_thenModelAttributesSetCorrectly() {
        when(mockRequest.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)).thenReturn(null);
        when(mockRequest.getAttribute(RequestDispatcher.ERROR_MESSAGE)).thenReturn(null);

        controller.handleError(mockRequest, model);

        checkAttributeSet("error_code", "UNKNOWN");
        checkAttributeSet("error_message", "An unknown error occurred");
    }

    @Test
    @DisplayName("When Error has no status but a message, model attributes set correctly")
    void whenHomePageMethodInvokedWithNullStatusAndAMessage_thenModelAttributesSetCorrectly() {
        when(mockRequest.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)).thenReturn(null);
        when(mockRequest.getAttribute(RequestDispatcher.ERROR_MESSAGE)).thenReturn("Test Error Message");

        controller.handleError(mockRequest, model);

        checkAttributeSet("error_code", "UNKNOWN");
        checkAttributeSet("error_message", "Test Error Message");
    }

    @ParameterizedTest
    @MethodSource("provideStatusExpectations")
    @DisplayName("When Error has a status but no message, model attributes set correctly based on status")
    void whenErrorPageMethodInvokedWithStatusNoMessage_thenModelAttributesSetCorrectly(int status, String expectedMessage) {
        when(mockRequest.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)).thenReturn(status);
        when(mockRequest.getAttribute(RequestDispatcher.ERROR_MESSAGE)).thenReturn(null);

        controller.handleError(mockRequest, model);

        checkAttributeSet("error_code", String.valueOf(status));
        checkAttributeSet("error_message", expectedMessage);
    }

    private static Stream<Arguments> provideStatusExpectations() {
        return Stream.of(
                Arguments.of(400, "Bad Request"),
                Arguments.of(403, "Forbidden"),
                Arguments.of(404, "Page Not Found"),
                Arguments.of(500, "Internal Server Error"),
                Arguments.of(666, "Unknown Error")
        );
    }

    @Test
    void whenErrorPageMethodInvokedWithStatusAndMessage_thenModelAttributesSetCorrectly() {
        when(mockRequest.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)).thenReturn(406);
        when(mockRequest.getAttribute(RequestDispatcher.ERROR_MESSAGE)).thenReturn("Error occurred");

        controller.handleError(mockRequest, model);

        checkAttributeSet("error_code", String.valueOf(406));
        checkAttributeSet("error_message", "Error occurred");
    }
}
