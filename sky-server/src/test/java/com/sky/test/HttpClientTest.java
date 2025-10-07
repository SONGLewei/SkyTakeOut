package com.sky.test;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@SpringBootTest
public class HttpClientTest {

    /**
     * 测试Httpclient发送Get方式的请求
     */
    @Test
    public void testGet() throws Exception{
        // create httpclient object
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // send the request object
        HttpGet httpGet = new HttpGet("http://localhost:8080/user/shop/status");

        // send the demande, receive the result of response
        CloseableHttpResponse response = httpClient.execute(httpGet);

        // return the status code
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("服务器返回状态码为：" + statusCode);

        HttpEntity entity = response.getEntity();

        String body = EntityUtils.toString(entity);
        System.out.println("服务器返回数据为 ： "+body);

        response.close();
        httpClient.close();

    }

    /**
     * 测试Httpclient发送Post方式的请求
     */
    public void testPOST() throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("http://localhost:8080/admin/employee/login");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username","root");
        jsonObject.put("password","123456");

        StringEntity entity = new StringEntity("{username:'',password:''}");

        //format of data
        entity.setContentEncoding("utf-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);

        //send demande
        CloseableHttpResponse response = httpClient.execute(httpPost);

        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Status code is : "+ statusCode);

        HttpEntity entity1 = response.getEntity();
        String body = EntityUtils.toString(entity1);
        System.out.println("响应数据为: " + body);

        response.close();
        httpClient.close();
    }
}
