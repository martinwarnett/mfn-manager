package com.warnett.mfnmanger.comms;
import com.warnett.mfnmanager.exceptions.comms.CommunicationsException;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.core5.http.ClassicHttpRequest;

import java.io.IOException;

/**
 * Abstract class encapsulating an operation invoking a call to read the contents of an external site.
 * <p/>
 * The work is contained within the performOperation method; client implementations must override two methods;
 * generateRequest to create the web request to used and convert, which is used to convert the returned content into
 * specific data.
 *
 * @param <T>  The genericised type of data to return.
 */
public abstract class CommsOperation<T> {
    private final WebpageResponseHandler commsHandler;

    protected CommsOperation(WebpageResponseHandler commsHandler) {
        this.commsHandler = commsHandler;
    }

    /**
     * This method executed a web request to return requested data.
     * <p/>
     * The generated request is executed upon the
     * @param connection The connection on which to execute the call
     * @return T - the genericised return type
     * @throws CommunicationsException thrown on exception, wrapped in project exception.
     */
    public T performOperation(final CloseableHttpClient connection) throws CommunicationsException {
        var request = generateRequest();

        try {
            var responseText = connection.execute(request, commsHandler);
            return convert(responseText);
        } catch (IOException e) {
            throw new CommunicationsException("Failed to process response", e);
        }
    }

    protected abstract T convert(String responseText);

    protected abstract ClassicHttpRequest generateRequest();
}