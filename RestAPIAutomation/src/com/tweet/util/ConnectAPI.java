package com.tweet.util;

import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created by Savi on 7/24/2016.
 */
public class ConnectAPI {
    private static final Logger log = LogManager.getLogger();
    protected HttpUriRequest constructHttpMethod(String methodName, String url, String payload) {

        HttpUriRequest httpUriRequest = null;

        if (methodName.equalsIgnoreCase("POST")) {
            httpUriRequest = new HttpPost(url);
            log.debug("POST method created based on client request");
        } else if (methodName.equalsIgnoreCase("PUT")) {
            httpUriRequest = new HttpPut(url);
            log.debug("PUT method created based on client request");
        } else if (methodName.equalsIgnoreCase("DELETE")) {
            httpUriRequest = new HttpDelete(url);
            log.debug("DELETE method created based on client request");
        } else if (methodName.equalsIgnoreCase("GET")) {
            httpUriRequest = new HttpGet(url);
            log.debug("GET method created based on client request");
        } else if (methodName.equalsIgnoreCase("HEAD")) {
            httpUriRequest = new HttpHead(url);
            log.debug("HEAD method created based on client request");
        }

        if (httpUriRequest != null && httpUriRequest instanceof HttpEntityEnclosingRequestBase && payload != null) {
            EntityBuilder entityBuilder = EntityBuilder.create()
                    .setText(payload)
                    .setContentType(requestContentType);

            if (isRequestCompressionEnabled()) {
                entityBuilder.gzipCompress();
            }

            ((HttpEntityEnclosingRequestBase) httpUriRequest).setEntity(entityBuilder.build());
        }

        return httpUriRequest;
    }

}
