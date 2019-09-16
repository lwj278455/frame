package com.xxx.frame.Interceptor;

import com.xxx.frame.Annotation.Api;
import com.xxx.frame.Dao.TokenMapper;
import com.xxx.frame.Entity.Token;
import com.xxx.frame.Entity.TokenExample;
import com.xxx.frame.Util.Cache;
import com.xxx.frame.Util.CacheManager;
import com.xxx.frame.Util.RRException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

public class ApiInterceptor  implements HandlerInterceptor {

    public static final String LOGIN_USER_KEY = "LOGIN_USER_KEY";
    public static final String tokenFailResult = "{\"errcode\":500,\"errmsg\":\"token验证失败！\"}";

    private TokenMapper tokenMapper;

    public ApiInterceptor(TokenMapper tokenMapper) {
        this.tokenMapper = tokenMapper;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("text/html;charset=UTF-8");

        Api annotation;
        if(handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Api.class);
        }else{
            return true;
        }

        //如果有@Api注解，则不验证token
        if(annotation != null){
            return true;
        }
        //从header中获取token
        String token = request.getHeader("token");
        //token为空
        if(StringUtils.isBlank(token)){
            //throw new RRException("token不能为空");
            response.getWriter().write(tokenFailResult);
            return false;
        }

        //查询token
        Cache cacheInfo = CacheManager.getCacheInfo(token);
        if(cacheInfo!=null&&!cacheInfo.isExpired()){
            //设置openId到request里，后续根据userId，获取用户信息
            request.setAttribute(LOGIN_USER_KEY,((Token)cacheInfo.getData()).getUserid());
            return true;
        }
        TokenExample tokenExample = new TokenExample();
        TokenExample.Criteria criteria = tokenExample.createCriteria();
        criteria.andTokenEqualTo(token);
        List<Token> tokens = tokenMapper.selectByExample(tokenExample);
        if(tokens.size()==1 && tokens.get(0).getExpireTime().after(new Date())){
            //设置openId到request里，后续根据userId，获取用户信息
            request.setAttribute(LOGIN_USER_KEY,tokens.get(0).getUserid());
            return true;
        }
        System.out.println(tokenFailResult+token);
        response.getWriter().write(tokenFailResult);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
