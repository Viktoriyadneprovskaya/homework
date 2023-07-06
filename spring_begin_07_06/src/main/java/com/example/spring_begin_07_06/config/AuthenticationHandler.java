package com.example.spring_begin_07_06.config;

import com.example.spring_begin_07_06.model.SecurityUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
@Component
public class AuthenticationHandler implements AuthenticationSuccessHandler {
    SimpleUrlAuthenticationSuccessHandler userSuccessHandler = new SimpleUrlAuthenticationSuccessHandler("/");
    SimpleUrlAuthenticationSuccessHandler adminSuccessHandler = new SimpleUrlAuthenticationSuccessHandler("/admin");
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        SecurityUser principal = (SecurityUser) authentication.getPrincipal();
        for (GrantedAuthority grantedAuthority:authorities) {
            String authorityName = grantedAuthority.getAuthority();
            if (authorityName.equals("ADMIN")) {
                this.adminSuccessHandler.onAuthenticationSuccess(request, response, authentication);
                return;
            }
        }

        userSuccessHandler.setDefaultTargetUrl("/"+ principal.getId() + "/" + principal.getUsername());
        this.userSuccessHandler.onAuthenticationSuccess(request,response,authentication);
    }
}
