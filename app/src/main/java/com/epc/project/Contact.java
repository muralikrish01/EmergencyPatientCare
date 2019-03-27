package com.epc.project;

public class Contact {

    //private variables
    int _id;
    String _name;
    String _phone_number1;
    String _phone_number2;

    // Empty constructor
    public Contact(){

    }
    // constructor
    public Contact(int id, String name, String _phone_number1){
        this._id = id;
        this._name = name;
        this._phone_number1 = _phone_number1;
        this._phone_number2 = _phone_number2;
    }

    // constructor
    public Contact(String name, String _phone_number1, String _phone_number2){
        this._name = name;
        this._phone_number1 = _phone_number1;
        this._phone_number2 = _phone_number2;
    }
    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting phone number
    public String getPhoneNumber1(){
        return this._phone_number1;
    }

    // setting phone number
    public void setPhoneNumber1(String phone_number1){
        this._phone_number1 = phone_number1;
    }

    // getting phone number
    public String getPhoneNumber2(){
        return this._phone_number2;
    }

    // setting phone number
    public void setPhoneNumber2(String phone_number2){
        this._phone_number2 = phone_number2;
    }

}

