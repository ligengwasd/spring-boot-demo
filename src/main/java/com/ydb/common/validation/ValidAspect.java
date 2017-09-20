package com.ydb.common.validation;

import com.ydb.model.response.BaseResModel;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * Created by dev on 16-5-24.
 */

//@Aspect
//@Order(30)
public class ValidAspect {

    @Around("execution(* com.ydb.controller.*.*(..,@javax.validation.Valid (*), org.springframework.validation.BindingResult,..))")
    public BaseResModel doValid(ProceedingJoinPoint pjp) throws Throwable {
        BaseResModel repModel = new BaseResModel();
        repModel.setCode(-99);

        Object[] args = pjp.getArgs();
        BindingResult result = null;
        for (Object arg : args){
            if (arg instanceof BindingResult){
                result = (BindingResult) arg;
            }
        }
        if (result != null && result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error:list){
                repModel.setCode(new Integer(error.getDefaultMessage()));
                return repModel;
            }
        }
        return (BaseResModel)pjp.proceed();
    }
}
