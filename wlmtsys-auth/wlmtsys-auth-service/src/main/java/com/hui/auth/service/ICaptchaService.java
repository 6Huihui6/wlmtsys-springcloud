package com.hui.auth.service;

public interface ICaptchaService {

     void generateCaptcha(String email);

    boolean verifyCaptcha(String email, String inputCaptcha);
}
