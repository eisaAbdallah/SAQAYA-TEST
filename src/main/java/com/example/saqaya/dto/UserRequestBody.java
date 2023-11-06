package com.example.saqaya.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestBody {

    String firstName;
   String lastName;
    String  email;
    Boolean marketingConsent;


}
