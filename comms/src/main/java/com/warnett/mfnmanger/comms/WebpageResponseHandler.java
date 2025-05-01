package com.warnett.mfnmanger.comms;

import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Implementation of a {@see HttpClientResponseHandler}.
 * <p>/>
 * This class overrides the handleResponse method to retrieve the response text from a webpage.
 */
public class WebpageResponseHandler implements HttpClientResponseHandler<String> {

    /**
     * Overrides the {@see HttpClientResponseHandler} handleResponse method to retrieve the response content, returning
     * the webpage HTML as a String value.
     *
     * @param response The response from the web call
     * @return Returns the webpage HTML text as a String
     * @throws IOException thrown on the response containing no content or an error reading the content
     */
    @Override
    public String handleResponse(ClassicHttpResponse response) throws IOException {
        final var responseContent = response.getEntity().getContent();

        if (responseContent == null) {
            throw new IOException("Response content not present");
        }

        StringBuilder builder;
        try (var bufferedReader = new BufferedReader(new InputStreamReader(responseContent))) {
            var line = "";
            builder = new StringBuilder();

                while ((line = bufferedReader.readLine()) != null) {
                    builder.append(line);
                    builder.append(System.lineSeparator());
                }
        }
        EntityUtils.consume(response.getEntity());
        return builder.toString();
    }
}
