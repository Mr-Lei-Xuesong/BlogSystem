package com.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("execution(* com.demo.controller.*.*(..))")
    public void pointCut() {
    }

    @Before(value = "pointCut()")
    public void LogRequestInfo(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String type = request.getMethod();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url, ip, type, classMethod, args);
        log.info("Request : {}", requestLog);
    }

    @AfterReturning(returning = "result", pointcut = "pointCut()")
    public void doAfterReturn(Object result) {
        log.info("Result : {}", result);
    }

    private static class RequestLog {
        private String url;
        private String ip;
        private String type;
        private String classMethod;
        private Object[] args;

        public RequestLog(String url, String ip, String type, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.type = type;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", type='" + type + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
