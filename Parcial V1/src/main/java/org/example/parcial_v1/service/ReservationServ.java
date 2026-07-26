package org.example.parcial_v1.service;

import org.example.parcial_v1.entity.Data;
import org.example.parcial_v1.entity.Reservation;
import org.example.parcial_v1.repository.DataBase;

import java.util.List;
import java.util.Objects;


public class ReservationServ {

    DataBase repo = new DataBase();
    TravelServ travelServ = new TravelServ();

    public void creation(Reservation r) throws Exception{

        if(DataBase.returnTravel().stream()
                .noneMatch(t -> t.getState().equals(Data.PROGRAMADO)))
        {throw new Exception("VUELO NO DISPONIBLE");}

        if(r.getSitsAskd() < 0 || r.getSitsAskd() > 5){
            throw new Exception("VALOR DE SILLAS INVALIDO");
        }

        if(r.getId()<0 || DataBase.returnPassenger().stream()
                .noneMatch(p -> p.getId() == r.getId())){
            throw new Exception("ID NO VAlIDO");
        }

        if(r.getIdFly() < 0 || DataBase.returnTravel().stream()
                .noneMatch(t -> t.getCode() == r.getIdFly()))
        {throw new Exception("ID DE VUELO NO VALIDO");}

        if(DataBase.returnTravel().stream()
                .anyMatch(t -> t.getCode() == r.getIdFly())){

            r.setInternal(r.getIdFly());
        }else {
            throw new Exception("NO EXISTE EL VUELO");
        }

        r.setCode(DataBase.returnPassenger().size() + 1);

        r.setName(Objects.requireNonNull(DataBase.returnPassenger().stream()
                .filter(event -> event.getId() == r.getId())
                .findFirst()
                .orElse(null)).getName());

        r.setState(Data.CONFIRMADO);
        returnSits(r); // primera peticion
        passengerPrice(r); //precio por silla reservada
        repo.createReservation(r);
    }

    public List<Reservation> show(){
        return DataBase.returnReservation();
    }

    public void delete(int code){
        Reservation r = returnCode(code);
        r.setState(Data.CANCELADO);
        returnSits(r);
        repo.deleteReservation(code);
    }

    public void returnSits(Reservation r){
        travelServ.sits(r.getState(), r.getSitsAskd(), r.getIdFly());
    }

    public void passengerPrice(Reservation r){
        long price = travelServ.priceCalculator(r.getIdFly());

        r.setPrice(price * r.getSitsAskd());
    }

    private Reservation returnCode(int code){
        return DataBase.returnReservation().stream()
                .filter(event -> event.getCode() == code)
                .findFirst()
                .orElse(null);
    }

    public void deletePeers(int code){
        repo.deletePeers(code);
    }


}
