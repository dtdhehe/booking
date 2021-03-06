package com.dtdhehe.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author Xie_东
 * @version 1.0.0
 * @date 2021/3/26 17:04
 * @description
 **/
public class JwtTokenFilter extends GenericFilterBean {

    private String secret;

    private UserDetailsService userDetailsService;

    private static final String BEARER = "Bearer";

    public JwtTokenFilter(UserDetailsService userDetailsService,String secret){
//        this.secret = Base64.getEncoder().encodeToString(secret.getBytes());
        this.secret = secret;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        String headerValue = ((HttpServletRequest) req).getHeader("Authorization");
        getBearerToken(headerValue).ifPresent(token -> {
            String username = getClaimFromTokenS((String) token, Claims::getSubject);
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            if (username.equals(userDetails.getUsername()) && !isJwtExpired((String) token)) {
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails((HttpServletRequest) req));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        });

        filterChain.doFilter(req, resp);
    }

    private Optional getBearerToken(String headerVal) {
        if (headerVal != null && headerVal.startsWith(BEARER)) {
            return Optional.of(headerVal.replace(BEARER, "").trim());
        }
        return Optional.empty();
    }

    private Date getClaimFromToken(String token, Function<Claims, Date> claimsResolver) {
        final Claims claims = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(secret.getBytes())).build().parseClaimsJws(token).getBody();
        return claimsResolver.apply(claims);
    }

    private String getClaimFromTokenS(String token, Function<Claims, String> claimsResolver) {
        final Claims claims = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(secret.getBytes())).build().parseClaimsJws(token).getBody();
        return claimsResolver.apply(claims);
    }

    private boolean isJwtExpired(String token) {
        Date expirationDate = getClaimFromToken(token, Claims::getExpiration);
        return expirationDate.before(new Date());
    }
}
