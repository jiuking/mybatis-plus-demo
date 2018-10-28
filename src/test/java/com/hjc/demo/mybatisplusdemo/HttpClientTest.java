package com.hjc.demo.mybatisplusdemo;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientTest {

    public static void main(String[] args) {
        HttpClient client = HttpClients.createDefault();
    }
}
