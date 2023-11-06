package com.example.saqaya.controller;

import com.example.saqaya.data.CreateUserResponse;
import com.example.saqaya.data.SingleUserReponse;
import com.example.saqaya.dto.UserRequestBody;
import com.example.saqaya.model.User;
import com.example.saqaya.service.SerivceSaqaya;
import com.example.saqaya.token.JwtTokenUtil;
import com.example.saqaya.token.JwtUserDetailsService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;


@RestController
public class Controller {

    @Autowired
    SerivceSaqaya serivceSaqaya;

    @PostMapping("user")
    public ResponseEntity<?> createUser(@RequestBody UserRequestBody userRequestBody) throws NoSuchAlgorithmException, UnsupportedEncodingException {


        CreateUserResponse createUserResponse =  serivceSaqaya.createUser(userRequestBody);

         return ResponseEntity.ok(createUserResponse);
    }
    @GetMapping("user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id")String id) throws Exception {


        SingleUserReponse userResponse =  serivceSaqaya.getUser(id);

        return ResponseEntity.ok(userResponse);
    }











}
