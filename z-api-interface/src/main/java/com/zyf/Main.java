package com.zyf;

import com.zyf.client.ZApiClient;
import com.zyf.model.User;

public class Main {
    public static void main(String[] args) {
        String accessKey = "zyf";
        String secretKey = "abcdefg";
        ZApiClient zApiClient = new ZApiClient(accessKey, secretKey);
        String result1 = zApiClient.getNameByGet("zyf");
        System.out.println(result1);
        String result2 = zApiClient.getNameByPost("zyf");
        System.out.println(result2);
        User user = new User();
        user.setName("zyf");
        String result3 = zApiClient.getUsernameByPost(user);
        System.out.println(result3);
    }
}
