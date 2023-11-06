package com.example.saqaya.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



import javax.persistence.*;
import java.util.Collection;

@Entity
@Setter
@Getter
@Table(name = "users")
@NoArgsConstructor
public class User   {

    @Id
    @Column(name="id")
    String id;
    @Column(name="first_name")
    String  firstName;
    @Column(name="last_name")
    String  lastName;
    @Column(name="email_address")
    String  email;

    @Column(name="marketing_consent")
    boolean  marketingConsent;

    public User(String id, String firstName, String lastName, boolean marketingConsent) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.marketingConsent = marketingConsent;
    }
}
