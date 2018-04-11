package com.zk.demo.dubbocomsumer.area;

import com.zk.demo.dubbocomsumer.lib.http.HttpUtils;
import com.zk.demo.dubbocomsumer.lib.util.Sign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Component
public class AreaApi {

    @Autowired
    private HttpUtils httpUtils;

    private static String url = "http://message.guanyisoft.com/router/rest";
    private  static String method = "taobao.areas.get";
    private static String app_key = "21151296950125";
    private  static String sign_method = "md5";
    private static String sign = "***";
    private static String timestamp = "2015-01-01 12:00:00";
    private static String v = "2.0";

    public void aa(String[] args) throws IOException{
        Map<String, String> params = new HashMap<>();
        params.put("method", method);
        params.put("app_key", app_key);
        params.put("sign_method", sign_method);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        params.put("timestamp", LocalDateTime.now().format(dtf));
        params.put("format", "json");
        params.put("v", v);
        params.put("fields", "id,type,name,parent_id,zip");
        String sign = Sign.signTopRequest(params, "******", sign_method);
        params.put("sign", sign);

        try {
            String str = httpUtils.doGet(url, params);
            System.out.println(str);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }



}
