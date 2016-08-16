package com.tweet.test;

/**
 * Created by Savi on 7/15/2016.
 */
    import java.io.BufferedInputStream;
    import java.io.IOException;
    import java.io.InputStream;
    import java.net.URLEncoder;

    import org.apache.http.HttpEntity;
    import org.apache.http.HttpResponse;
    import org.apache.http.client.ClientProtocolException;
    import org.apache.http.client.HttpClient;
    import org.apache.http.client.methods.HttpGet;
    import org.apache.http.client.methods.HttpPost;
    import org.apache.http.client.utils.URLEncodedUtils;
    import org.apache.http.entity.StringEntity;
    import org.apache.http.impl.client.HttpClientBuilder;
    import org.apache.http.params.HttpParams;
    import org.apache.http.params.HttpProtocolParams;
    import org.json.JSONArray;
    import org.testng.Assert;
    import org.testng.annotations.Test;

    import static org.testng.Assert.*;

    public class DemoHttpClient {
        HttpClient http;

        HttpGet get;
        HttpPost post;
        HttpResponse response;
        HttpEntity entity;
        int statusCode;

        @Test
        public void testRest() throws ClientProtocolException, IOException {
            http = HttpClientBuilder.create().build();

            //HttpParams- build request params8
            get = new HttpGet("https://api.twitter.com"
                    + "/1.1/statuses/user_timeline.json?screen_name=s_neja");
get.setHeader("Authorization", "OAuth oauth_consumer_key=\"WdY6rdgX6iL9g9gXg2G0VAXH2\",oauth_token=\"753471881882144768-8HYnPsqlgoHp3xQdHeiOI7VDRcP5hqM\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"1468714581\",oauth_nonce=\"KLdRTD\",oauth_version=\"1.0\",oauth_signature=\"vZb%2FTqfQXHVEaAxD9LChSANfbTg%3D\"");

         //   req.addHeader("Authorization", "OAuth oauth_consumer_key=\"WdY6rdgX6iL9g9gXg2G0VAXH2\", oauth_nonce=\"b1d4c32436e3d19687cb2755bcb8709a\", oauth_signature=\"%2BBYIWwwtq4l%2BvYJNCUCpKFuq1zQ%3D\", oauth_signature_method=\"HMAC-SHA1\", oauth_timestamp=\"1468714079\", oauth_token=\"753471881882144768-8HYnPsqlgoHp3xQdHeiOI7VDRcP5hqM\", oauth_version=\"1.0\"");
       //    System.out.println(req);

            response = http.execute(get);
            statusCode = response.getStatusLine().getStatusCode();
            System.out.println("status code is:"+statusCode);
            Assert.assertTrue(200 == statusCode);
        }

        @Test(enabled = false)
        public void jsonParsingTest() throws ClientProtocolException, IOException {

            //HttpParams- build request params

            //response.
            http = HttpClientBuilder.create().build();
             post = new HttpPost("https://api.twitter.com/1.1/statuses/update.json?status=My%20third%20Tweet%20Feels%20great");
            post.setHeader("Authorization", "OAuth oauth_consumer_key=\"WdY6rdgX6iL9g9gXg2G0VAXH2\",oauth_token=\"753471881882144768-8HYnPsqlgoHp3xQdHeiOI7VDRcP5hqM\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"1468716008\",oauth_nonce=\"opB4k8\",oauth_version=\"1.0\",oauth_signature=\"YIASLeTRCZC78JOY1JBryWwNlzI%3D\"");


            response = http.execute(post);
            statusCode = response.getStatusLine().getStatusCode();
            System.out.println(response.getStatusLine().getStatusCode());
            Assert.assertTrue(200 == statusCode);

            //JSONArray js = new JSONArray(response.getEntity());


        }
    }
/*
      // If the response does not enclose an entity, there is no need
      // to bother about connection release
     */

