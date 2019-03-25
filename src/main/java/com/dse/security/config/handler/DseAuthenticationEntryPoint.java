package com.dse.security.config.handler;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义认证失败返回的逻辑
 */
/*@Component*/
public class DseAuthenticationEntryPoint implements  AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json;chartset=UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getOutputStream(),new String("未登录访问授权页面，请引导用户登录"));
    }
}
