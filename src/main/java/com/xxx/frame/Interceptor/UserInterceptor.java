package com.xxx.frame.Interceptor;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.xxx.frame.Annotation.Api;
import com.xxx.frame.Annotation.Login;
import com.xxx.frame.Entity.AdminUser;
import com.xxx.frame.Util.ConstantManger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class UserInterceptor  implements HandlerInterceptor {
    private static final Logger logger = new LoggerContext().getLogger(UserInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        String requestURI = request.getRequestURI();
        if(requestURI.contains("_")){
            requestURI = requestURI.substring(0,requestURI.indexOf("_"));
        }
        Login annotation;
        if(handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
        }else{
            return true;
        }

        //如果有@Api注解，则不验证token
        if(annotation != null){
            return true;
        }
        AdminUser user = null;
        try{
            Object o  = request.getSession().getAttribute("user");
            if(o==null){
               throw new Exception("Null");
            }
            user = (AdminUser)o;
        }catch (Exception e){
            // 跳转登录
            String url = request.getContextPath() + "/Manager/login";
            response.sendRedirect(url);
            return false;
        }
        if("2".equals(user.getAdminlevel())&&!Arrays.asList(ConstantManger.NOTROOTURL).contains(requestURI)){
            // 跳转登录
            String url = request.getContextPath() + "/Manager/dashboard";
            response.sendRedirect(url);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
