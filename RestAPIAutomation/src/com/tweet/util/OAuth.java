package com.tweet.util;

/**
 * Created by Savi on 7/15/2016.
 */
import java.io.IOException;

import com.tweet.util.ResourceMethodType;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.params.HttpParams;
import org.testng.Assert;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.util.URIUtil;
public class OAuth {

    static HttpClient http;
    static HttpGet get;
    static HttpPost post;
    static HttpResponse response;
    static HttpEntity entity;
    static int statusCode;

    public static int connectOAuth1GET() throws ClientProtocolException, IOException
    {
        http = HttpClientBuilder.create().build();
        //HttpParams- build request params8
        get = new HttpGet("https://api.twitter.com/1.1/statuses/user_timeline.json");
        get.setHeader("Authorization", "OAuth oauth_consumer_key=\"DC0sePOBbQ8bYdC8r4Smg\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"1469386438\",oauth_nonce=\"1950763351\",oauth_version=\"1.0\",oauth_token=\"753471881882144768-ph1wdM2kVtlAeGd0KLUBBTNkTro40Sz\",oauth_signature=\"XB0kT07elsGZvme%2BABVaM1Pxz0w%3D\"");
        response = http.execute(get);
        statusCode = response.getStatusLine().getStatusCode();
        System.out.println("status code is:"+statusCode);
        Assert.assertTrue(200 == statusCode);
        return statusCode;
    }




    public int connectOAuth1POST() throws ClientProtocolException, IOException
    {
        http = HttpClientBuilder.create().build();
        post = new HttpPost("https://api.twitter.com/1.1/statuses/update.json");
        post.setHeader("Authorization", "OAuth oauth_consumer_key=\"DC0sePOBbQ8bYdC8r4Smg\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"1469386438\",oauth_nonce=\"1950763351\",oauth_version=\"1.0\",oauth_token=\"753471881882144768-ph1wdM2kVtlAeGd0KLUBBTNkTro40Sz\",oauth_signature=\"XB0kT07elsGZvme%2BABVaM1Pxz0w%3D\"");
        EntityBuilder entity = 
        post.setEntity(entity);

        response = http.execute(post);
        System.out.println(post);
        statusCode = response.getStatusLine().getStatusCode();
        System.out.println("status code is:"+statusCode);
        Assert.assertTrue(200 == statusCode);
        return statusCode;
    }


public static void main(String[] args) throws IOException {
    OAuth oa = new OAuth();
    oa.connectOAuth1GET();
    oa.connectOAuth1POST();
}



}


