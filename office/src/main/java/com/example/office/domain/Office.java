package com.example.office.domain;

import javax.persistence.*;

@Entity
@Table(name = "office")
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;

    @Column(name = "first_name")
    private String FirstName;

    @Column(name="last_name")
    private String LastName;

    @Column(name="phone")
    private Integer Phone;

    @Column(name="address")
    private String Address;

    @Column(name = "email")
    private String Email;

    @Column(name="password")
    private String Password;

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public Integer getPhone() {
        return Phone;
    }

    public String getAddress() {
        return Address;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setPhone(Integer phone) {
        Phone = phone;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setEmail(String email) {
        Email = email;
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
