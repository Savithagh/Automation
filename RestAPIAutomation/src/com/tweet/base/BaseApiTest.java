package com.tweet.base;

/**
 * Created by Savi on 7/14/2016.
 */

import com.tweet.util.OAuth;
import com.tweet.util.ExcelUtils;
import com.tweet.util.RESTUtil;
import com.tweet.util.ResourceMethodType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by svelupula on 8/14/2015.
 */
public abstract class BaseApiTest extends BaseRestTest {

    public RESTUtil restUtil;
    public ExcelUtils excelUtils;
    public OAuth oauth;
    @BeforeSuite
    public void beforeSuite() {
        restUtil = new RESTUtil(_config);
        excelUtils = new ExcelUtils();
        ResourceMethodType.loadJsonMap(String.format("%s/RestMethod.json", System.getProperty("user.dir")));
  }

    @AfterSuite
    public void afterSuite() {
        restUtil = null;
        excelUtils = null;
        oauth = null;
    }

}