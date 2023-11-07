package com.example.saqaya.service;

import com.example.saqaya.data.CreateUserResponse;
import com.example.saqaya.data.SingleUserReponse;
import com.example.saqaya.dto.UserRequestBody;
import com.example.saqaya.exception.BeanNotFoundException;


import com.example.saqaya.model.User;
import com.example.saqaya.model.UserDetails;
import com.example.saqaya.repository.Repository;
import com.example.saqaya.token.JwtTokenUtil;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class serviceSaqyaImpl  implements SerivceSaqaya{
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private Repository repository;
    @Override
    public CreateUserResponse createUser(UserRequestBody userRequestBody) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        User user =new User();

        user.setEmail(userRequestBody.getEmail());
        user.setFirstName(userRequestBody.getFirstName());
        user.setLastName(userRequestBody.getLastName());
        user.setMarketingConsent(userRequestBody.getMarketingConsent());
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(userRequestBody.getEmail().getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();

        StringBuilder hexString = new StringBuilder();

        for (byte b : digest) {
            hexString.append(String.format("%02x", b));
        }


        String Id=new String(hexString);



        user.setId(Id);
        repository.saveUser(user);





        String token = jwtTokenUtil.generateToken(userRequestBody);

        CreateUserResponse createUserResponse=new CreateUserResponse();



        createUserResponse.setId(Id);
        createUserResponse.setAccessToken(token);
        UserDetails userDetails=new UserDetails();
        userDetails.setId(Id);
        userDetails.setToken(token);
        repository.saveUserDetails(userDetails);

        return createUserResponse;
    }

    @Override
    public SingleUserReponse getUser(String id) throws Exception {

        List<UserDetails> userDetails =repository.getUserDetailsById(id);
if(userDetails.isEmpty()){

  throw    new BeanNotFoundException("the Id IS Not Found");


}

      String token= userDetails.get(0).getToken();
        String[] pieces = token.split("\\.");
        String b64payload = pieces[1];
        String jsonString = new String(Base64.decodeBase64(b64payload), "UTF-8");
      String firstName=  jsonString.split(",")[0].split(":")[1].replaceAll("\"","");


        User user= repository.getUserById(id);
        SingleUserReponse   userResponse=null;
        if(!user.getFirstName().equals(firstName)){

            throw new BeanNotFoundException("This user is not found, wrong Token");

        }
        if(user.isMarketingConsent()==false){

            userResponse =new SingleUserReponse(user.getId(),user.getFirstName(),user.getLastName(),user.isMarketingConsent());


         return userResponse;
        }else{

            userResponse =new SingleUserReponse(user.getId(),user.getFirstName(),user.getLastName(),user.getEmail(),user.isMarketingConsent());
        return userResponse;
        }
    }


}
