package com.vti.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class User {
    protected int id;
    protected String fullName;
    protected String email;
    protected String password;
    protected int projectId;
    protected Role role;
}
