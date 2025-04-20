package com.warnett.mfnmanager.exceptions.comms;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class CommunicationsExceptionTest {
    private static final String TEST_MESSAGE = "Test Message";
    
    @Test
    void whenOnlyMessageProvided_thenMessageCorrectlyReturned() {
        final var testException = new CommunicationsException(TEST_MESSAGE);
        assertThat(testException.getMessage()).isEqualTo(TEST_MESSAGE);
    }

    @Test
    void whenMessageAndEceptionProvided_thenBothCorrectlyReturned() {
        final var testCause = new NullPointerException("Null exception");
        final var testException = new CommunicationsException(TEST_MESSAGE, testCause);
        
        assertThat(testException.getMessage()).isEqualTo(TEST_MESSAGE);
        assertThat(testException.getCause()).isEqualTo(testCause);
    }
}
