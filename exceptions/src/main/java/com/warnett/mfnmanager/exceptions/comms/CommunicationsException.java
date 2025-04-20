package com.warnett.mfnmanager.exceptions.comms;


public class CommunicationsException extends Exception {
    public CommunicationsException(String message) {
        super(message);
    }

    public CommunicationsException(String message, Throwable cause) {
        super(message, cause);
    }
}
