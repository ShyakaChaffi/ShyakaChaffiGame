package domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Borrower implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //TRAINER: use Strategy for your primary key
    private int id;
    @Column(nullable = false,length = 200)
    //TRAINER: use @Column(name = "borrower_name") and give this field a proper name, where you follow the naming conventions of java
    //TRAINER no snake casing, use camel casing for your field names
    private String borrower_name;
    @Column(nullable = false,length = 200)
    private String street;

    //TRAINER: use @Column(name = "house_number") and give this field a proper name, where you follow the naming conventions of java
    //TRAINER no snake casing, use camel casing for your field names
    private String house_number;


    public Borrower(String borrowerName) {
        this.borrower_name = borrowerName;
    }

    public Borrower(String borrowerName, String city) {
        this.borrower_name = borrowerName;
        this.city = city;
    }

    public Borrower() {

    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    @Column(nullable = true,length = 200) //TRAINER: bus number can be null
    private String bus_number;
    private int postcode;
    @Column(nullable = false,length = 200)
    private String city;
    private String telephone;
    @Column(nullable = false,length = 200)
    private  String email;

    public Borrower(Integer id, String borrowerName, String street, String houseNumber, String busNumber, int postcode, String city, String telephone, String email) {
        this.id = id;
        this.borrower_name = borrowerName;
        this.street = street;
        this.house_number = houseNumber;
        this.bus_number = busNumber;
        this.postcode = postcode;
        this.city = city;
        this.telephone = telephone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBorrower_name() {
        return borrower_name;
    }

    public void setBorrower_name(String borrower_name) {
        this.borrower_name = borrower_name;
    }



    public String getHouse_number() {
        return house_number;
    }

    public void setHouse_number(String house_number) {
        this.house_number = house_number;
    }

    public String getBus_number() {
        return bus_number;
    }

    public void setBus_number(String bus_number) {
        if(bus_number != null){
            this.bus_number = bus_number;
        }

    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Borrower{" +
                ", borrower_name='" + getBorrower_name() + '\'' +
                ", street='" + getStreet() + '\'' +
                ", house_number=" + getHouse_number() +
                ", bus_number=" + getBus_number() +
                ", postcode=" + getPostcode() +
                ", city='" + getCity() + '\'' +
                ", telephone=" + getTelephone() +
                ", email='" + getEmail() + '\'' +
                '}';
    }
}
