package com.epc.project;

public class UserMedDetails {
    private String uAge;
    private String uHeight;
    private String uWeight;
    private String uPressure;
    private String uSugar;
    private String uBloodgroup;
    private String uId;

    public UserMedDetails(){
      /*  uAge=age;
        uHeight=height;
        uWeight=weight;
        uPressure=pressure;
        uSugar=sugar;
        uBloodgroup=bloodgroup;*/
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }
    public String getuAge() {
        return uAge;
    }

    public void setuAge(String uAge) {
        this.uAge = uAge;
    }

    public String getuHeight() {
        return uHeight;
    }

    public void setuHeight(String uHeight) {
        this.uHeight = uHeight;
    }

    public String getuWeight() {
        return uWeight;
    }

    public void setuWeight(String uWeight) {
        this.uWeight = uWeight;
    }

    public String getuPressure() {
        return uPressure;
    }

    public void setuPressure(String uPressure) {
        this.uPressure = uPressure;
    }

    public String getuSugar() {
        return uSugar;
    }

    public void setuSugar(String uSugar) {
        this.uSugar = uSugar;
    }



    public String getuBloodgroup() {
        return uBloodgroup;
    }

    public void setuBloodgroup(String uBloodgroup) {
        this.uBloodgroup = uBloodgroup;
    }

}
