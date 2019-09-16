package com.xxx.frame.Util;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.config.SocketConfig;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HttpClientUtils {
    private static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    private static CloseableHttpClient CLIENT;

    static {
        try {
            HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
            httpClientBuilder.setMaxConnTotal(1000);
            httpClientBuilder.setMaxConnPerRoute(100);
            httpClientBuilder.evictIdleConnections(15, TimeUnit.SECONDS);
            SocketConfig.Builder socketConfigBuilder = SocketConfig.custom();
            socketConfigBuilder.setTcpNoDelay(true);
            httpClientBuilder.setDefaultSocketConfig(socketConfigBuilder.build());
            RequestConfig.Builder requestConfigBuilder = RequestConfig.custom();
            requestConfigBuilder.setConnectTimeout(3000);
            requestConfigBuilder.setSocketTimeout(3000);
            httpClientBuilder.setDefaultRequestConfig(requestConfigBuilder.build());
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new EasyX509TrustManager();
            ctx.init(null, new TrustManager[]{tm}, null);
            httpClientBuilder.setSSLContext(ctx);
            CLIENT = httpClientBuilder.build();
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    public static String doGet(String url) throws Exception {
        return execute(new HttpGet(url));
    }

    public static String doGet(String url, String hostname) throws Exception {
        HttpGet getMethod = new HttpGet(url);
        if (StringUtils.isNotEmpty(hostname)) {
            getMethod.setHeader(ClientPNames.VIRTUAL_HOST, hostname);
        }
        return execute(getMethod);
    }

    public static String doPost(String url, Map<String, String> params) throws Exception {
        return doPost(url, params, null);
    }

    public static String doPost(String url, Map<String, String> params, String hostname) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("request url = {}, params = {}",url,params);
        }

        HttpPost post = new HttpPost(url);
        List<BasicNameValuePair> urlParameters = new ArrayList();
        BasicNameValuePair basicNameValuePair = null;

        for (Map.Entry<String,String> kvEntry : params.entrySet()) {
            basicNameValuePair = new BasicNameValuePair(kvEntry.getKey(), kvEntry.getValue());
            urlParameters.add(basicNameValuePair);
        }
        HttpEntity postParams = new UrlEncodedFormEntity(urlParameters);
        post.setEntity(postParams);
        if (StringUtils.isNotEmpty(hostname)) {
            post.setHeader(ClientPNames.VIRTUAL_HOST, hostname);
        }
        return execute(post);
    }

    public static String doPostWithJson(String url, String context) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("request url = {}, content = {}",url,context);
        }

        HttpPost post = new HttpPost(url);
        HttpEntity requestEntity = new StringEntity(context, ContentType.APPLICATION_JSON);
        post.setEntity(requestEntity);
        return execute(post);
    }

    private static String execute(HttpUriRequest request) throws Exception {
        CloseableHttpResponse response = CLIENT.execute(request);
        if (HttpStatus.SC_OK != response.getStatusLine().getStatusCode()) {
            throw new Exception("Invalid http status code:" + response.getStatusLine().getStatusCode());
        }
        return EntityUtils.toString(response.getEntity(), Consts.UTF_8);
    }
}
