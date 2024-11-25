package com.hui.auth.service;

import com.hui.model.info.dtos.InterviewInvitationDTO;

public interface ICaptchaService {

    /**
     * 生成验证码
     */
     void generateCaptcha(String email);

     /**
     * 验证验证码
     */
    boolean verifyCaptcha(String email, String inputCaptcha);


}
