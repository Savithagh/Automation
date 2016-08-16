package com.tweet.test;

import com.tweet.base.BaseApiTest;
import com.tweet.util.OAuth;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.*;

import java.util.Iterator;
import java.util.Map;

import static com.tweet.util.OAuth.*;
import static org.testng.Assert.*;

/**
 * Created by Savi on 7/16/2016.
 */
public class TimelineGETTest extends BaseApiTest{

    public String repoURL;
    public String uri;


    @BeforeTest
    @Parameters({"uri"})
    public void setBaseUri(String uri) {
        //data setup
        this.uri=uri;
        restUtil.setUri(uri);
    }

    @DataProvider(name = "users-data")
    public Object[][] getUsers() throws Exception {
        Object[][] data = excelUtils.getComplexExcelData(restUtil._configuration.DataFileName, uri);
        return data;
    }

    @Test(dataProvider = "users-data")
    public void testUser(String resource,Map<Object,Object> data) throws Exception{
        restUtil.getJSONEntity(resource);
        assertNotEquals(restUtil.isValidResponse(), null);
        String statusCode = String.valueOf(data.get("RESULT-STATUSCODE"));
        assertEquals(restUtil.getStatusCode(),statusCode);
    }
    }

