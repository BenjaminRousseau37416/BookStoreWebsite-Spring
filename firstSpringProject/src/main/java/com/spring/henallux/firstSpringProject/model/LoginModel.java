package com.spring.henallux.firstSpringProject.model;

public class LoginModel
{
    private String email;
    private String mdp;

    public LoginModel() { }

    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

}
