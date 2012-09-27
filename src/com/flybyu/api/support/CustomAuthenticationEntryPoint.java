package com.flybyu.api.support;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;


// 直接关闭Form入口，所有的From认证失败，
/*
 *  <beans:bean id="formAuthenticationEntryPoint"
          class="org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter"
          p:authenticationManager-ref="authenticationManager"
          p:authenticationEntryPoint-ref="CustomAuthenticationEntryPoint" />
    <默认是有org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter>
    或者<form-login />与之等价
    <bean id="formAuthenticationEntryPoint"
          class="org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint"
          p:loginFormUrl="/login.jsp"/>
    http://stackoverflow.com/questions/4397062/handle-unauthorized-error-message-for-basic-authentication-in-spring-security
    http://stackoverflow.com/questions/10826293/restful-authentication-via-spring
 */
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {
        response.sendError( HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized: Authentication token was either missing or invalid." );
    }
}
