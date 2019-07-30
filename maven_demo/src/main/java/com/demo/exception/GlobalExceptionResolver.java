package com.demo.exception;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.demo.enums.ResponseCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.Ordered;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
* @Description: 全局异常处理
* @Author:       tianjun
* @date:         2019/6/28 14:06
*/
@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver, Ordered {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    @SuppressWarnings("all")
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        //返回ModelAndView后，spring内置ExceptionResolver便不再执行，
        //若需执行spring内置ExceptionResolver，返回null即可
        ModelAndView mv = new ModelAndView();

        logger.error("请求[{}]错误，错误原因：", request.getRequestURI() ,e);
        if(e instanceof ApiException){ //业务异常
            return this.handleApiException((ApiException) e, mv);
        }

        if (e instanceof MethodArgumentNotValidException) { //参数校验失败异常
            return this.handleMethodArgumentNotValidException((MethodArgumentNotValidException)e, mv);
        }

        if(e instanceof ConstraintViolationException){
            return this.handleConstraintViolationException((ConstraintViolationException)e, mv);
        }

        if (e instanceof HttpRequestMethodNotSupportedException) {
            return this.handleHttpRequestMethodNotSupported((HttpRequestMethodNotSupportedException)e, mv);
        }

        if (e instanceof HttpMediaTypeNotSupportedException) {
            return this.handleHttpMediaTypeNotSupported((HttpMediaTypeNotSupportedException)e, mv);
        }

        if (e instanceof HttpMediaTypeNotAcceptableException) {
            return this.handleHttpMediaTypeNotAcceptable((HttpMediaTypeNotAcceptableException)e, mv);
        }

        if (e instanceof MissingPathVariableException) {
            return this.handleMissingPathVariable((MissingPathVariableException)e, mv);
        }

        if (e instanceof MissingServletRequestParameterException) {
            return this.handleMissingServletRequestParameter((MissingServletRequestParameterException)e, mv);
        }

        if (e instanceof ServletRequestBindingException) {
            return this.handleServletRequestBindingException((ServletRequestBindingException)e, mv);
        }

        if (e instanceof ConversionNotSupportedException) {
            return this.handleConversionNotSupported((ConversionNotSupportedException)e, mv);
        }

        if (e instanceof TypeMismatchException) {
            return this.handleTypeMismatch((TypeMismatchException)e, mv);
        }

        if (e instanceof HttpMessageNotReadableException) {
            return this.handleHttpMessageNotReadable((HttpMessageNotReadableException)e, mv);
        }

        if (e instanceof HttpMessageNotWritableException) {
            return this.handleHttpMessageNotWritable((HttpMessageNotWritableException)e, mv);
        }

        if (e instanceof MissingServletRequestPartException) {
            return this.handleMissingServletRequestPartException((MissingServletRequestPartException)e, mv);
        }

        if (e instanceof BindException) {
            return this.handleBindException((BindException)e, mv);
        }

        if (e instanceof NoHandlerFoundException) {
            return this.handleNoHandlerFoundException((NoHandlerFoundException)e, mv);
        }

        if (e instanceof AsyncRequestTimeoutException) {
            return this.handleAsyncRequestTimeoutException((AsyncRequestTimeoutException)e, mv);
        }

        if(e instanceof  Exception){ //其他所有未知异常统一处理
            return this.handleException(e, mv);
        }


        return null;
    }

    @Override
    public int getOrder() {
        //优先级设置为最高，spring默认ExceptionResolver在此之后执行
        return Ordered.HIGHEST_PRECEDENCE;
    }

    protected ModelAndView handleApiException(ApiException ex, ModelAndView mv){
        Map<String,String> data = new HashMap<>();
        data.put("code", ex.getCode());
        data.put("desc", ex.getDesc());

        FastJsonJsonView view = new FastJsonJsonView();
        view.setAttributesMap(data);
        mv.setView(view);
        return mv;
    }

    protected ModelAndView handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, ModelAndView mv) {
        modelAndView(mv, ResponseCodeEnum.METHOD_NOT_ALLOWED);
        return mv;
    }

    protected ModelAndView handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, ModelAndView mv) {
        modelAndView(mv, ResponseCodeEnum.UNSUPPORTED_MEDIA_TYPE);
        return mv;
    }

    protected ModelAndView handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, ModelAndView mv) {
        modelAndView(mv, ResponseCodeEnum.UNACCEPTABLE_REQUEST);
        return mv;
    }

    protected ModelAndView handleMissingPathVariable(MissingPathVariableException ex, ModelAndView mv) {
        modelAndView(mv, ResponseCodeEnum.INTERNAL_ERROR);
        return mv;
    }

    protected ModelAndView handleMissingServletRequestParameter(MissingServletRequestParameterException ex, ModelAndView mv) {
        modelAndView(mv, ResponseCodeEnum.INVALID_REQUEST);
        return mv;
    }

    protected ModelAndView handleServletRequestBindingException(ServletRequestBindingException ex, ModelAndView mv) {
        modelAndView(mv, ResponseCodeEnum.INVALID_REQUEST);
        return mv;
    }

    protected ModelAndView handleConversionNotSupported(ConversionNotSupportedException ex, ModelAndView mv) {
        modelAndView(mv, ResponseCodeEnum.INTERNAL_ERROR);
        return mv;
    }

    protected ModelAndView handleTypeMismatch(TypeMismatchException ex, ModelAndView mv) {
        modelAndView(mv, ResponseCodeEnum.INVALID_REQUEST);
        return mv;
    }

    protected ModelAndView handleHttpMessageNotReadable(HttpMessageNotReadableException ex, ModelAndView mv) {
        modelAndView(mv, ResponseCodeEnum.INVALID_REQUEST);
        return mv;
    }

    protected ModelAndView handleHttpMessageNotWritable(HttpMessageNotWritableException ex, ModelAndView mv) {
        modelAndView(mv, ResponseCodeEnum.INTERNAL_ERROR);
        return mv;
    }

    protected ModelAndView handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, ModelAndView mv) {
        BindingResult result = ex.getBindingResult();
        StringBuffer errorMsg = new StringBuffer();
        for (ObjectError error : result.getAllErrors()) {
            FieldError fieldError = (FieldError) error;
            errorMsg.append(fieldError.getField()).append(":")
                    .append(fieldError.getDefaultMessage()).append(";");
        }

        Map<String,String> data = new HashMap<>();
        data.put("code", ResponseCodeEnum.ERROR_PARAM.code());
        data.put("desc", errorMsg.toString());

        FastJsonJsonView view = new FastJsonJsonView();
        view.setAttributesMap(data);
        mv.setView(view);
        return mv;
    }

    @SuppressWarnings("all")
    protected ModelAndView handleConstraintViolationException(ConstraintViolationException ex, ModelAndView mv){
        Map<String, String> failReason = new HashMap<>(); //校验失败字段原因

        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            Path path = violation.getPropertyPath();
            String field = path.toString();
            if(failReason.containsKey(field)){
                failReason.put(field, failReason.get(field)+","+violation.getMessage());
            }else{
                failReason.put(field, violation.getMessage());
            }
        }

        StringBuffer errorMsg = new StringBuffer();
        for(String field:failReason.keySet()){
            errorMsg.append(field).append(":");
            errorMsg.append(failReason.get(field)).append(";");
        }

        Map<String,String> data = new HashMap<>();
        data.put("code", ResponseCodeEnum.INTERNAL_ERROR.code());
        data.put("desc", errorMsg.toString());

        FastJsonJsonView view = new FastJsonJsonView();
        view.setAttributesMap(data);
        mv.setView(view);
        return mv;
    }

    protected ModelAndView handleMissingServletRequestPartException(MissingServletRequestPartException ex, ModelAndView mv){
        modelAndView(mv, ResponseCodeEnum.INVALID_REQUEST);
        return mv;
    }

    protected ModelAndView handleBindException(BindException ex, ModelAndView mv) {
        modelAndView(mv, ResponseCodeEnum.INVALID_REQUEST);
        return mv;
    }

    protected ModelAndView handleNoHandlerFoundException(NoHandlerFoundException ex, ModelAndView mv) {
        modelAndView(mv, ResponseCodeEnum.INVALID_URL);
        return mv;
    }

    protected ModelAndView handleAsyncRequestTimeoutException(AsyncRequestTimeoutException ex, ModelAndView mv) {
        modelAndView(mv, ResponseCodeEnum.INVALID_SERVER);
        return mv;
    }

    protected ModelAndView handleException(Exception ex, ModelAndView mv){
        Map<String,String> data = new HashMap<>();
        data.put("code", ResponseCodeEnum.FAIL.code());
        data.put("desc", ResponseCodeEnum.FAIL.message());

        FastJsonJsonView view = new FastJsonJsonView();
        view.setAttributesMap(data);
        mv.setView(view);
        return mv;
    }

    private void modelAndView(ModelAndView mv, ResponseCodeEnum codeEnum){
        Map<String,String> data = new HashMap<>();
        data.put("code", codeEnum.code());
        data.put("desc", codeEnum.message());

        FastJsonJsonView view = new FastJsonJsonView();
        view.setAttributesMap(data);
        mv.setView(view);
    }

}
