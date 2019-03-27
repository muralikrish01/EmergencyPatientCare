package com.epc.project;

public class UserDetails {
    private String uFirstName;
    private String uLastName;
    private String uCity;
    private String uEc1;
    private String uEc2;
    private String uEmail;
    private String uPhone;
    private String uId;
    public UserDetails(){
        /*uFirstName=firstname;
        uLastName=lastname;
        uCity=city;
        uEc1=ec1;
        uEc2=ec2;
        uEmail=email;
        uPhone = phone;*/
    }
    public String getuFirstName() {
        return uFirstName;
    }

    public void setuFirstName(String uFirstName) {
        this.uFirstName = uFirstName;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuLastName() {
        return uLastName;
    }

    public void setuLastName(String uLastName) {
        this.uLastName = uLastName;
    }

    public String getuCity() {
        return uCity;
    }

    public void setuCity(String uCity) {
        this.uCity = uCity;
    }

    public String getuEc1() {
        return uEc1;
    }

    public void setuEc1(String uEc1) {
        this.uEc1 = uEc1;
    }

    public String getuEc2() {
        return uEc2;
    }

    public void setuEc2(String uEc2) {
        this.uEc2 = uEc2;
    }



    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

}
