package org.example.parcial_v1.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Travel {
    private int code;
    private Data origen;
    private Data destiny;
    private LocalDate date;
    private LocalTime exitHour;
    private LocalTime incHour;
    private int capacity = 180;
    private int sitsAvb;
    private Data state;
    private Data food;
    private int price;
    private Data visa;
    private Data flyTyp;

    public Travel(Data origen, Data destiny, LocalDate date, LocalTime exitDate,
                  LocalTime incDate, Data food, Data visa, Data flyTyp) {

        this.origen = origen;
        this.destiny = destiny;
        this.date = date;
        this.exitHour = exitDate;
        this.incHour = incDate;
        this.food = food;
        this.visa = visa;
        this.flyTyp = flyTyp;
    }
    public Travel (){

    }

    public Data getFlyTyp() {
        return flyTyp;
    }

    public void setFlyTyp(Data flyTyp) {
        this.flyTyp = flyTyp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Data getVisa() {
        return visa;
    }

    public void setVisa(Data visa) {
        this.visa = visa;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Data getFood() {
        return food;
    }

    public void setFood(Data food) {
        this.food = food;
    }

    public Data getOrigen() {
        return origen;
    }

    public void setOrigen(Data origen) {
        this.origen = origen;
    }

    public Data getDestiny() {
        return destiny;
    }

    public void setDestiny(Data destiny) {
        this.destiny = destiny;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getExitHour() {return exitHour;}

    public void setExitHour(LocalTime exitHour) {this.exitHour = exitHour;}

    public LocalTime getIncHour() {return incHour;}

    public void setIncHour(LocalTime incHour) {this.incHour = incHour;}

    public int getCapacity() { return capacity;}

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSitsAvb() {
        return sitsAvb;
    }

    public void setSitsAvb(int sitsAvb) {
        this.sitsAvb = sitsAvb;
    }

    public Data getState() {
        return state;
    }

    public void setState(Data state) {
        this.state = state;
    }
    @Override
    public String toString(){
        return "GA" + code + " | " + origen + " | " + destiny + " | " + date + " | " + "Hora de salida: " +
                exitHour + " \n" + "Hora de llegada: " + incHour + " | " + "Capacidad: " +
                capacity + " | " + "Sillas disponibles: " + sitsAvb + " | " + state + " | " +
                "Icluye comida: " + food + " | " + price + "$" + "\nRequiere visa: " + visa + " | " + "Tipo de vuelo: " + flyTyp;
    }
}
