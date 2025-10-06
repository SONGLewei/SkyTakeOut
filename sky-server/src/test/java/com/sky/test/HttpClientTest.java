package com.sky.test;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class HttpClientTest {

    /**
     * 测试Httpclient发送Get方式的请求
     */
    @Test
    public void testGet() throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("http://localhost:8080/user/shop/status");

        CloseableHttpResponse response = httpClient.execute(httpGet);

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
}
