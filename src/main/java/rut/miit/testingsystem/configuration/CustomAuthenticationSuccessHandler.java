package rut.miit.testingsystem.configuration;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import rut.miit.testingsystem.auth.authority.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        Iterator<Role> authoritiesIterator = (Iterator<Role>) SecurityContextHolder.getContext().getAuthentication().getAuthorities().iterator();
        response.getWriter().write(authoritiesIterator.next().getAuthority()); //TODO: CHECK IT PLEASE
        response.getWriter().flush();
    }
}
