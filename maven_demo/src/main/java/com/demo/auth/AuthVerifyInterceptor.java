package com.demo.auth;

import com.demo.enums.ResponseCodeEnum;
import com.demo.exception.ApiException;
import com.demo.service.RedisService;
import com.demo.utils.SignUtils;
import com.demo.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
* @Description:  鉴权安全验证（使用签名+时间鉴权）
* @Author:       tianjun
* @date:         2019/6/28 10:50
*/
public class AuthVerifyInterceptor implements HandlerInterceptor {

    private final static Logger LOGGER = LoggerFactory.getLogger(AuthVerifyInterceptor.class);

    @Autowired
    private RedisService redisService;

    /**
    * 进入controller层前调用
    * @author      tianjun
    * @date        2019/6/28 10:53
    * @param
    * @return
     */
    @Override
    @SuppressWarnings("all")
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String appKey = request.getHeader("appkey"); //appKey
        String signature = request.getHeader("signature"); //签名
        String timestamp = request.getHeader("timestamp"); //时间戳
        String notice = request.getHeader("notice"); //随机数
        LOGGER.info("鉴权header传入参数appKey={}signature={}timestamp={}notice={}",appKey,signature,timestamp,notice);

        boolean hasHeader = StringUtils.allNotBlank(appKey,signature,timestamp,notice);
        if(hasHeader){
            //校验签名
            validSignature(appKey,timestamp,notice,signature);
            return true;
        }
        throw new ApiException(ResponseCodeEnum.ACCESS_REJECT.code(), ResponseCodeEnum.ACCESS_REJECT.message());
    }

    /**
    * 处理完成后渲染视图之前调用
    * @author      tianjun
    * @date        2019/6/28 11:10
    * @param
    * @return
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
    * 视图渲染完成之后调用
    * @author      tianjun
    * @date        2019/6/28 11:11
    * @param
    * @return      
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    /**
    * 签名校验
    * @author      tianjun
    * @date        2019/6/28 13:08
    * @param appKey appKey
    * @param timestamp 时间戳
    * @param notice 随机数
    * @param signature 签名
    * @return
     */
    private void validSignature(String appKey, String timestamp, String notice, String signature){
        Map<String,String> params = new HashMap<String, String>();
        params.put("appkey", appKey);
        params.put("timestamp", timestamp);
        params.put("notice", notice);

        String sign = SignUtils.getSign(params, getSecretByKey(appKey));
        LOGGER.info("系统生成sign={}",sign);
        if(!sign.equals(signature)){
            new ApiException(ResponseCodeEnum.INVALID_SIGNATURE.code(), ResponseCodeEnum.INVALID_SIGNATURE.message());
        }
    }

    private String getSecretByKey(String appKey){
        Object secret = redisService.hget("auth" , appKey);
        if (secret != null && StringUtils.isNotBlank(String.valueOf(secret))){
            return String.valueOf(secret);
        }
        throw new ApiException(ResponseCodeEnum.ILLEGAL_APP_KEY.code(), ResponseCodeEnum.ILLEGAL_APP_KEY.message());
    }
}
