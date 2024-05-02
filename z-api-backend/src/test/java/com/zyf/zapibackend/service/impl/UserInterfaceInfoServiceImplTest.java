package com.zyf.zapibackend.service.impl;

import com.zyf.zapibackend.service.UserInterfaceInfoService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.validation.constraints.AssertTrue;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInterfaceInfoServiceImplTest {
    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Test
    void testInvokeCount() {
        boolean result = userInterfaceInfoService.invokeCount(1L, 1L);
        Assert.assertTrue(result);
    }
}