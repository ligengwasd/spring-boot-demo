package com.ydb.common.validation;

import com.ydb.model.response.BaseResModel;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.annotation.Order;

/**
 * Created by ligeng on 17/1/18.
 */
//@Aspect
//@Order(5)
public class MessageAspect {
    @Autowired
    private MessageSource messageSource;

    @Around("execution(* com.ydb.controller.*.*(..))")
    public BaseResModel addMsg(ProceedingJoinPoint pjp) throws Throwable {
        BaseResModel resModel = (BaseResModel)pjp.proceed();
        resModel.setMsg(messageSource.getMessage(resModel.getCode().toString(),null,"不识别的错误码，请联系服务器！",null));
        return resModel;
    }
}
