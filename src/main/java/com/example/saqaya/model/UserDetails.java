package com.example.saqaya.model;




import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.*;
@Entity
@Getter
@Setter
public class UserDetails {

    @Id
    @Column(name="id")
    String id;
    @Column(name="token")
    String token;
}
