package com.jwt.auth.jwt.security.controller;

import com.jwt.auth.jwt.security.config.JwtUtil;
import com.jwt.auth.jwt.security.config.MyUserDetailService;
import com.jwt.auth.jwt.security.dto.AuthRequest;
import com.jwt.auth.jwt.security.dto.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MyUserDetailService myUserDetailService;

    @GetMapping(value = "/hello")
    public ResponseEntity<?> getHelloMessage(){
        return ResponseEntity.status(HttpStatus.OK).body("Hello world private url");
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest authRequest){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getPassword()));
        }catch (BadCredentialsException badCredentialsException){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect username or password");
        }
        final UserDetails userDetails=myUserDetailService.loadUserByUsername(authRequest.getUserName());
        final String jwtToken=jwtUtil.generateToken(userDetails);
        return ResponseEntity.status(HttpStatus.OK).body(new AuthResponse(jwtToken));
    }
}
