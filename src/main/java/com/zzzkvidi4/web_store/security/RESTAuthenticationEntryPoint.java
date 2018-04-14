package com.zzzkvidi4.web_store.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class RESTAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        Logger.getLogger("com.zzzkvidi4.web_store.security").info("You are not authorized to perform this operation.");
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
