package gino.desiigner.genbuild_billing_system.filters;

import gino.desiigner.genbuild_billing_system.service.impl.AppUserDetailsService;
import gino.desiigner.genbuild_billing_system.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {

    private final AppUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");

        String email = null;
        String jwt = null;

        // DEBUG: Log the incoming request
        System.out.println("=== JWT FILTER DEBUG ===");
        System.out.println("Request URL: " + request.getRequestURL());
        System.out.println("Request Method: " + request.getMethod());
        System.out.println("Authorization Header: " + authorizationHeader);

        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            jwt = authorizationHeader.substring(7);
            System.out.println("JWT Token extracted: " + jwt.substring(0, 50) + "...");

            try {
                email = jwtUtil.extractUsername(jwt);
                System.out.println("Email extracted from JWT: " + email);
            } catch (Exception e) {
                System.out.println("ERROR extracting email from JWT: " + e.getMessage());
            }
        }

        if(email != null && SecurityContextHolder.getContext().getAuthentication() == null){
            System.out.println("Loading user details for: " + email);

            try {
                UserDetails userDetails = userDetailsService.loadUserByUsername(email);
                System.out.println("User found: " + userDetails.getUsername());
                System.out.println("User authorities: " + userDetails.getAuthorities());
                System.out.println("User enabled: " + userDetails.isEnabled());
                System.out.println("User account non-expired: " + userDetails.isAccountNonExpired());
                System.out.println("User account non-locked: " + userDetails.isAccountNonLocked());
                System.out.println("User credentials non-expired: " + userDetails.isCredentialsNonExpired());

                if(jwtUtil.validateToken(jwt, userDetails)){
                    System.out.println("JWT Token is VALID");
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                    System.out.println("Authentication set in SecurityContext");
                    System.out.println("Final authorities in context: " + SecurityContextHolder.getContext().getAuthentication().getAuthorities());
                } else {
                    System.out.println("JWT Token is INVALID");
                }
            } catch (Exception e) {
                System.out.println("ERROR loading user or validating token: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            if (email == null) {
                System.out.println("No email extracted from JWT");
            }
            if (SecurityContextHolder.getContext().getAuthentication() != null) {
                System.out.println("Authentication already exists in context");
            }
        }

        System.out.println("=== END JWT FILTER DEBUG ===");
        filterChain.doFilter(request, response);
    }
}