package com.hui.auth.service.impl;

import com.hui.auth.service.ICaptchaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class CaptchaServiceImpl implements ICaptchaService {
    private final StringRedisTemplate stringRedisTemplate;
    private final JavaMailSender javaMailSender; //可直接注入邮件发送的对象
    @Value("${spring.mail.username}") //动态获取配置文件中 发送邮件的账户
    private String sendemail;

    // 生成验证码
    public void generateCaptcha(String email) {
        // 这里简单地生成一个6位数的随机验证码
        String captcha = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
        //创建简单邮件消息
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sendemail);
        message.setTo(email);
        //邮件标题
        message.setSubject("欢迎访问未来媒体实验室");
        message.setText("您的登录验证码是"+captcha);
        javaMailSender.send(message);
        // 将验证码存储到Redis中，设置有效期为5分钟
        stringRedisTemplate.opsForValue().set("captcha:" + email, captcha, 5, TimeUnit.MINUTES);
        // 发送验证码到用户邮箱（这里省略实际的邮件发送代码）
        System.out.println("验证码已发送到 " + email + ": " + captcha);
    }

    // 校验验证码
    public boolean verifyCaptcha(String email, String inputCaptcha) {
        // 从Redis中获取验证码
        String storedCaptcha = stringRedisTemplate.opsForValue().get("captcha:" + email);
        if (storedCaptcha == null || !storedCaptcha.equals(inputCaptcha)) {
            return false;
        }
        // 验证成功后删除验证码
        stringRedisTemplate.delete("captcha:" + email);
        return true;
    }
}
