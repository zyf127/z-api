package com.zyf.zapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.zyf.zapiclientsdk.model.User;
import com.zyf.zapiclientsdk.utils.SignUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 调用第三方接口的客户端
 *
 * @author zyf
 */
public class ZApiClient {
    private String accessKey;
    private String secretKey;

    public ZApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getNameByGet(String name) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        return HttpUtil.get("http://localhost:8123/api/name/", paramMap);
    }

    public String getNameByPost(String name) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        return HttpUtil.post("http://localhost:8123/api/name/", paramMap);
    }

    private Map<String, String> genHeaderMap(String body) {
        Map<String, String> map = new HashMap<>();
        map.put("accessKey", accessKey);
        map.put("nonce", RandomUtil.randomNumbers(5));
        map.put("body", body);
        map.put("timestamp", String.valueOf(System.currentTimeMillis()));
        map.put("sign", SignUtils.genSign(body, secretKey));
        return map;
    }

    public String getUsernameByPost(User user) {
        String userJson = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post("http://localhost:8123/api/name/user")
                .addHeaders(genHeaderMap(userJson))
                .body(userJson)
                .execute();
        String result = httpResponse.body();
        return result;
    }
}
