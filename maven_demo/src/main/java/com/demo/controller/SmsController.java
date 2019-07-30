package com.demo.controller;

import com.demo.bean.sms.PhoneVerifyCode;
import com.demo.enums.ResponseCodeEnum;
import com.demo.enums.VerifyTypeEnum;
import com.demo.service.RedisService;
import com.demo.vo.out.BaseResponseVO;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {

    @Autowired
    private RedisService redisService;

    @RequestMapping(value="/sms/send")
    public BaseResponseVO sendSms(){
        String verifyCode = RandomStringUtils.randomNumeric(4);
        String phone = "15215071279";
        PhoneVerifyCode phoneVerifyCode = new PhoneVerifyCode(phone, verifyCode, Integer.parseInt(VerifyTypeEnum.VERIFY_REGISTER_ONE.getCode()));
        redisService.updateGetSmsVerifyCodeHourTimes(phone);
        redisService.updateGetSmsVerifyCodeTimes(phone);
        redisService.updateSmsVerifyCode(phoneVerifyCode);
        return new BaseResponseVO(ResponseCodeEnum.SUCCESS.code(), ResponseCodeEnum.SUCCESS.message(), phoneVerifyCode);
    }

}
