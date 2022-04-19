package com.practice.httpclient;

import com.alibaba.fastjson.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author luoming
 */
public class HttpUtils {

    private HttpUtils() {}

    /**
     * post请求接口
     *
     * @param url 请求接口地址
     * @param urlParams 接口拼接参数
     * @return post请求返回信息
     */
    public static String doPost(String url, JSONObject urlParams, InputStream fileStream) {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost post = getHttpPost(url,urlParams);
            RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(10000)
                    .setConnectTimeout(10000).setSocketTimeout(-1).build();
            post.setConfig(requestConfig);
            post.setEntity(new InputStreamEntity(fileStream, fileStream.available()));
            try (CloseableHttpResponse response = client.execute(post)) {
                HttpEntity responseEntity = response.getEntity();
                if (responseEntity != null) {
                    return EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8.name());
                }
            }
        }catch (IOException e) {
        }
        return "";
    }

    /**
     * get请求接口
     *
     * @param url 请求接口地址
     * @param urlParams 接口拼接参数
     * @return get请求返回信息
     */
    public static String doGet(String url, JSONObject urlParams) {

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet get = getHttpGet(url,urlParams);
            try (CloseableHttpResponse response = client.execute(get)) {
                HttpEntity responseEntity = response.getEntity();
                if (responseEntity != null) {
                    return EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8.name());
                }
            }
        } catch (IOException e) {
        }
        return "";
    }

    /**
     * 获取httpPost
     *
     * @param url 请求接口地址
     * @param urlParams 接口拼接参数
     * @return post
     */
    private static HttpPost getHttpPost(String url, JSONObject urlParams) {
        URI uri = getURI(url,urlParams);
        HttpPost httpPost = new HttpPost(uri);
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(10000)
                .setConnectTimeout(10000).setSocketTimeout(-1).build();
        httpPost.setConfig(requestConfig);
        return httpPost;
    }

    /**
     * 获取httpGet
     *
     * @param url 请求接口地址
     * @param urlParams 接口拼接参数
     * @return get
     */
    private static HttpGet getHttpGet(String url, JSONObject urlParams) {
        URI uri = getURI(url,urlParams);
        HttpGet httpGet = new HttpGet(uri);
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(10000)
                .setConnectTimeout(10000).build();
        httpGet.setConfig(requestConfig);
        return httpGet;
    }

    /**
     * 获取请求uri
     *
     * @param url 请求接口地址
     * @param urlParams 接口拼接参数
     * @return uri
     */
    private static URI getURI(String url, JSONObject urlParams) {
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            if (urlParams != null && !urlParams.isEmpty()) {
                for (Map.Entry<String, Object> entry : urlParams.entrySet()) {
                    uriBuilder.addParameter(entry.getKey(), entry.getValue().toString());
                }
            }
            return uriBuilder.build();
        } catch (URISyntaxException e) {
        }
        return null;
    }
}
