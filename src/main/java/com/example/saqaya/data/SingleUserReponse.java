package com.example.saqaya.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SingleUserReponse {


    String id;

    String  firstName;

    String  lastName;

String email;

    boolean  marketingConsent;

    public SingleUserReponse(String id, String firstName, String lastName, String email, boolean marketingConsent) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.marketingConsent = marketingConsent;
    }

    public SingleUserReponse(String id, String firstName, String lastName, boolean marketingConsent) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.marketingConsent = marketingConsent;
    }
}
