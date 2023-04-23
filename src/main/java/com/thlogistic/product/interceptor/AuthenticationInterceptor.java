package com.thlogistic.product.interceptor;

import com.thlogistic.product.aop.exception.UnauthorizedException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AuthenticationInterceptor implements HandlerInterceptor {
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private final RestTemplate restTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        String token = request.getHeader(AUTHORIZATION_HEADER);

        if (token != null) {
            // "http://www.thinhlh.com:8000/check-permissions"
            // "[\"admin\"]"

        } else {
            throw new UnauthorizedException("Invalid token credential");
        }
        return true;
    }
}
