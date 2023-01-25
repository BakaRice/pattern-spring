package com.ricemarch.patternspring.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class UserInfo {

    private String username;
    private String city;
    private List<String> buyProducts;
    private boolean isNewUser;
}
