package org.example.parcial_v1.entity;

import java.time.LocalDate;

public class Reservation {
    private int code;
    private int internal;
    private String name;
    private Data state;
    private int sitsAskd;
    private LocalDate date;
    private long id;
    private int idFly;
    private long price;

    public Reservation( long id, int sitsAskd, LocalDate date, int idFly) {

        this.sitsAskd = sitsAskd;
        this.date = date;
        this.id = id;
        this.idFly = idFly;
    }

    public Reservation(){
    }

    public int getInternal() {
        return internal;
    }

    public void setInternal(int internal) {
        this.internal = internal;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Data getState() {
        return state;
    }

    public void setState(Data state) {
        this.state = state;
    }

    public int getSitsAskd() {
        return sitsAskd;
    }

    public void setSitsAskd(int sitsAskd) {
        this.sitsAskd = sitsAskd;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getIdFly(){
        return idFly;
    }

    public void setIdFly(int idFly){
        this.idFly = idFly;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "R" + code + " | " + name + " | " + state + " | " + "\nAsientos solicitados: " +
                sitsAskd + " | " + date + " | " + price + "$" + " | " + "En el vuelo: GA" + internal;

    }
}
