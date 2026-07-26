package org.example.parcial_v1.entity;

public class Passenger {
    private String name;
    private long id;
    private int age;
    private String gmail;
    private String phone;
    private String passportCode;
    private String nationality;

    public Passenger(String name, long id, int age, String gmail, String phone, String passportCode, String nationality) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.gmail = gmail;
        this.phone = phone;
        this.passportCode = passportCode;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassportCode() {
        return passportCode;
    }

    public void setPassportCode(String passportCode) {
        this.passportCode = passportCode;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    @Override
    public String toString(){
        return "Nombre: " + name + " | Edad: " + age +  " | Id: " + id +" | Telefono:" + phone + " | \nGmail: " +
                gmail + " | Pasaporte: " + passportCode + " | Nacionalidad: " + nationality;
    }
}
