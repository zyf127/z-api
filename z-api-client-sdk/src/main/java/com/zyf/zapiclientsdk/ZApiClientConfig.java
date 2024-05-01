package com.zyf.zapiclientsdk;

import com.zyf.zapiclientsdk.client.ZApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("zapi.client")
@Data
@ComponentScan
public class ZApiClientConfig {
    /**
     * 标识
     */
    private String accessKey;
    /**
     * 密钥
     */
    private String secretKey;

    @Bean
    public ZApiClient zApiClient() {
        return new ZApiClient(accessKey, secretKey);
    }
}
