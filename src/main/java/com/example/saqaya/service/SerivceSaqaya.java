package com.example.saqaya.service;

import com.example.saqaya.data.CreateUserResponse;
import com.example.saqaya.data.SingleUserReponse;
import com.example.saqaya.dto.UserRequestBody;
import com.example.saqaya.model.User;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface SerivceSaqaya {

    CreateUserResponse createUser(UserRequestBody userRequestBody) throws NoSuchAlgorithmException, UnsupportedEncodingException;

    SingleUserReponse getUser(String id) throws Exception;
}
