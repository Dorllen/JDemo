package com.example1;


//import sun.net.www.http.HttpClient;


import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HttpClientTest {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newBuilder().sslContext(null)
                .version(HttpClient.Version.HTTP_2).build();// 设置HttpClient模版
        try {
            HttpRequest request = HttpRequest.newBuilder(
                    new URI("http://openjdk.java.net/jeps/247"))
                    .GET().build();// 构建请求
            CompletableFuture future = client.sendAsync(request,//异步的访问
                    HttpResponse.BodyHandler.asString())// 响应的解析方式：文本或流
                    .thenApply(response -> response.body());// 解析详情体
            String content = (String) future.get();// 获得响应体
            System.out.println(content);

        } catch (URISyntaxException | InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
