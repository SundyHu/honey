package io.ryan.honey.oauth2.demo.controller;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * CallbackController
 *
 * @author hkc
 * @version 1.0.0
 * @date 2021-08-10 13:50
 */
@RestController
@RequestMapping("/auth")
public class CallbackController {

    @GetMapping("/callback")
    public String get(@RequestParam(value = "code") String code) {
        System.out.println("callback-code:" + code);
        HttpPost post = new HttpPost("http://localhost:18010/oauth/token");
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("code", code));
        try {
            post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            CloseableHttpResponse res = HttpClients.createDefault().execute(post);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String content = EntityUtils.toString(res.getEntity(), "UTF-8");
                return content;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "err";

    }
}
