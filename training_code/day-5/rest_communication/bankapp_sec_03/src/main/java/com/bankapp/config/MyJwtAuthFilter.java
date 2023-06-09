package com.bankapp.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
//5. create an jwt filter that will customized spring sec flow
@Service
public class MyJwtAuthFilter extends OncePerRequestFilter{

	 @Autowired
	  private JwtService jwtService;

	  @Autowired
	   private UserDetailsService userDetailsService;
	    
	@Override
	protected void doFilterInternal(HttpServletRequest request, 
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//if req have header Authorization
		   String authHeader= request.getHeader("Authorization");
	        String token=null;
	        String username=null;

	        //if authHeder is not null and start with Bearer
	            if(authHeader!=null && authHeader.startsWith("Bearer ")){
	            token=authHeader.substring(7);
	            //if extract username
	            username=jwtService.extractUsername(token);
	        }

	            //if username is not null and SecurityContextHolder dont hv authentication object
	        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
	            UserDetails userDetails=userDetailsService.loadUserByUsername(username);
	            //username is correct , and we are going to get UNAuthToeken and
	            //put that in SecurityContextHolder ....
	        
	            if(jwtService.validateToken(token, userDetails)){

	                UsernamePasswordAuthenticationToken authToken=
	                     new  UsernamePasswordAuthenticationToken
	                     (userDetails, null, userDetails.getAuthorities());

	               // authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

	                //put UsernamePasswordAuthenticationToken in securitycontext ?
	                
	                SecurityContextHolder.getContext().setAuthentication(authToken);

	            }

	        }
	        filterChain.doFilter(request, response);

	}

}










