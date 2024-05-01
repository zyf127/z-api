package com.zyf.zapiinterface;

import com.zyf.zapiclientsdk.client.ZApiClient;
import com.zyf.zapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ZApiInterfaceApplicationTests {
    @Resource
    private ZApiClient zApiClient;

    @Test
    void contextLoads() {
        String result1 = zApiClient.getNameByGet("zyf");
        String result2 = zApiClient.getNameByPost("zyf");
        User user = new User();
        user.setName("zyf");
        String result3 = zApiClient.getUsernameByPost(user);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

}
