package com.example.datamigration.domain;




public class Office {

    private Integer id ;


    private String FirstName;


    private String LastName;


    private Integer Phone;


    private String Address;


    private String Email;


    private String Password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Integer getPhone() {
        return Phone;
    }

    public void setPhone(Integer phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Office(String firstName, String lastName, Integer phone, String address, String email, String password) {
        FirstName = firstName;
        LastName = lastName;
        Phone = phone;
        Address = address;
        Email = email;
        Password = password;
    }

    public Office() {
    }
}
