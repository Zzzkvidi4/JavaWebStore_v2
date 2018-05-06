package com.zzzkvidi4.web_store.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzzkvidi4.web_store.responses.JsonHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Logger;

public class RESTAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Logger.getLogger("com.zzzkvidi4.web_store.security").info("Successfully logged in as " + authentication.getName() + "[" + authentication.getAuthorities().toString() + "]");
        clearAuthenticationAttributes(request);
        ObjectMapper mapper = new ObjectMapper();
        OutputStream out = response.getOutputStream();
        JsonHttpResponse<Void> resp = new JsonHttpResponse<>();
        mapper.writeValue(out, resp);
    }
}
