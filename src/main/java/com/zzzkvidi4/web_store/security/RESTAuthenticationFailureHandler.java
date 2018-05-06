package com.zzzkvidi4.web_store.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzzkvidi4.web_store.responses.JsonHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class RESTAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        Logger.getLogger("com.zzzkvidi4.web_store.security").info("Authorization error occurred!");
        super.onAuthenticationFailure(request, response, exception);
        ObjectMapper mapper = new ObjectMapper();
        JsonHttpResponse<Void> authFailure = new JsonHttpResponse<>();
        authFailure.addError("Wrong login/password!");
        mapper.writeValue(response.getOutputStream(), authFailure);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
