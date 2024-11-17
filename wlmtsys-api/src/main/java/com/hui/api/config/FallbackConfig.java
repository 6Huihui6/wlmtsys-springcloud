package com.hui.api.config;


import com.hui.api.client.user.fallback.UserClientFallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FallbackConfig {


    @Bean
    public UserClientFallback userClientFallback(){
        return new UserClientFallback();
    }

}
