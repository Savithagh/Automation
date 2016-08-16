package com.tweet.base;

/**
 * Created by Savi on 7/14/2016.
 */

import com.tweet.util.Configuration;
import org.apache.log4j.Logger;

/**
 * Created by svelupula on 8/14/2015.
 */

public abstract class BaseRestTest {

    public static final Configuration _config;

    static {
        _config = new Configuration("rest");
    }

    //Rally connection
    public Logger _logger;

    public BaseRestTest() {
        _logger = Logger.getLogger(BaseRestTest.class);

    }

}