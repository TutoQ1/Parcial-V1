package org.example.parcial_v1.repository;

import org.example.parcial_v1.entity.Passenger;
import org.example.parcial_v1.entity.Reservation;
import org.example.parcial_v1.entity.Travel;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    static List<Passenger> passengers = new ArrayList<>();
    static List<Reservation> reservations = new ArrayList<>();
    static List<Travel> travels = new ArrayList<>();


    // ---------------------------------------

    public void createPassenger(Passenger p){
        passengers.add(p);
    }
    public void createReservation(Reservation r){
        reservations.add(r);
    }
    public void createTravel(Travel t){
        travels.add(t);
    }

    // ---------------------------------------

    public static List<Passenger> returnPassenger(){
        return passengers;
    }

    public static List<Reservation> returnReservation(){
        return reservations;
    }

    public static  List<Travel> returnTravel(){
        return travels;
    }

    //----------------------------------------

    public void deletePassenger(long code){passengers.removeIf(event -> event.getId() == code);}

    public void deleteReservation(int code){reservations.removeIf(event -> event.getCode() == code);}

    public void deleteTravel(int code){
         travels.removeIf(event -> event.getCode() == code);
    }

    public void deletePeers(int code) {reservations.removeIf(event -> event.getInternal() == code); }

    // ---------------------------------------


}
