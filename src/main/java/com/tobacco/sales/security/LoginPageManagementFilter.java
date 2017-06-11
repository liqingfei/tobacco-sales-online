package com.tobacco.sales.security;

import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginPageManagementFilter extends GenericFilterBean {

    private String redirectUrl = "/";
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    private AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();
    private RequestMatcher requiresAuthenticationRequestMatcher;

    public LoginPageManagementFilter(String defaultFilterProcessesUrl) {
        this.requiresAuthenticationRequestMatcher = new AntPathRequestMatcher(
                defaultFilterProcessesUrl);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        if (!requiresAuthenticationRequestMatcher.matches(request)) {
            chain.doFilter(request, response);
            return;
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated() && !trustResolver.isAnonymous(authentication)) {
            redirectStrategy.sendRedirect(request, response, redirectUrl);
        } else {
            chain.doFilter(request, response);
            return;
        }

    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
