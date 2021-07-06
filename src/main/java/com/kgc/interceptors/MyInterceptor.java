package com.kgc.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    /**
     * 在前端控制器(DispatcherServlet)拦截用户请求之后执行的方法，这个时候用户发送的请求还没有到达
     * Controller中
     * @param request
     * @param response
     * @param o
     * @return  false表示拦截用户请求，返回到DispatcherServlet
     *          true表示放行，会继续请求控制器
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("preHandle。。。。。。。。。。。。。。");
        return true; //放行
    }

    /**
     * 这个方法表示controller执行完毕后会回到这个方法,这个时候用户的请求刚刚离开
     * Controller，这个时候ModelAndView对象还没有返回到DispatcherServlet
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle。。。。。。。。。。。。。。");
    }

    /**
     * 执行这个方法的时候DispatcherServlet已经生成了View对象了，已经准备响应
     * 数据给用户了
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion。。。。。。。。。。。。。。");
    }
}
