package com.tweet.util;

/**
 * Created by Savi on 7/13/2016.
 */
import org.apache.http.Header;

import java.util.HashMap;
import java.util.Map;

public class Headers {

    public Header[] headers; //response.getAllHeaders();

    public String getHeader(String name) {
        for (Header header : headers) {
            if (header.getName().equals(name)) {
                return header.getValue();
            }
        }
        return null;
    }

    public String getContentType() {
        return getHeader("Content-Type");
    }

    public String getContentLength()
    {
        return getHeader("Content-length") ;
    }

    public String getServer() { return getHeader("Server");}

    public String getAccept()
    {
        return getHeader("Accept-Ranges");
    }

    public String getLastModified()
    {
        return getHeader("Last-Modified");
    }

    public String getDate()
    {
        return getHeader("Date");
    }

}