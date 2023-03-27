package com.example.lab_assignment3;

import java.io.Serializable;
import java.sql.*;
public class LoginBean implements  Serializable{
    String username;
    String password;

    public void setUsername(String username){
        this.username=username;
    }

    public void setPassword(String password){
        this.password=password;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }

    public int getValid() {
        if (username.equals("tafsir") && password.equals("taf12")) {
            return 1;
        }
        else{
            return 0;
        }
    }
}
