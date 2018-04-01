package com.zk.demo.dubbocomsumer.lib.http;

import com.zk.demo.dubboapi.entity.HttpResult;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class HttpUtils implements BeanFactoryAware {
    public static final Integer SUCCESS_CODE = 200;
    public static final String ENCODING_UTF = "UTF-8";


    private BeanFactory beanFactory;

    @Autowired(required = false)
    private RequestConfig requestConfig;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    private CloseableHttpClient getHttpClient() {
        return beanFactory.getBean("httpClient", CloseableHttpClient.class);
    }


    /**
     * 无参get请求
     *
     * @param url
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public String doGet(String url) throws ClientProtocolException, IOException {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        String body = null;
        try {
            response = getHttpClient().execute(httpGet);
            if (response.getStatusLine().getStatusCode() == HttpUtils.SUCCESS_CODE) {
                body = EntityUtils.toString(response.getEntity(), HttpUtils.ENCODING_UTF);
            }
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return body;
    }

    /**
     * 有参get请求
     *
     * @param url
     * @param params
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public String doGet(String url, Map<String, String> params) throws URISyntaxException, IOException {
        URIBuilder uriBuilder = new URIBuilder(url);
        if (params != null && params.size() > 0) {
            for (String key : params.keySet()) {
                uriBuilder.setParameter(key, params.get(key));
            }
        }
        return doGet(uriBuilder.build().toString());
    }

    /**
     * 有参post请求
     *
     * @param url
     * @param params
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public HttpResult doPost(String url, Map<String, String> params) throws ClientProtocolException, IOException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        if (params != null && params.size() > 0) {
            //设置post的参数
            List<NameValuePair> parameters = new ArrayList<>();
            for (String key : params.keySet()) {
                parameters.add(new BasicNameValuePair(key, params.get(key)));
            }
            // 构造一个form表单式的实体
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
            // 将请求实体设置到httpPost对象中
            httpPost.setEntity(formEntity);
        }
        CloseableHttpResponse response = null;
        try {
            response = getHttpClient().execute(httpPost);
            return new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(response.getEntity(), ENCODING_UTF));
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

    /**
     * json参数 post请求
     *
     * @param url
     * @param json
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public HttpResult doPost(String url, String json) throws ClientProtocolException, IOException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        if (!StringUtils.isEmpty(json)) {
            StringEntity jsonParam = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(jsonParam);
        }
        CloseableHttpResponse response = null;
        try {
            response = getHttpClient().execute(httpPost);
            return new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(response.getEntity(), ENCODING_UTF));
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

    /**
     * 无参post请求
     *
     * @param url
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public HttpResult doPost(String url) throws ClientProtocolException, IOException {
        return doPost(url, "");
    }

}
