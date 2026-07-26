package org.example.parcial_v1.service;


import org.example.parcial_v1.entity.Data;
import org.example.parcial_v1.entity.Reservation;
import org.example.parcial_v1.entity.Travel;
import org.example.parcial_v1.repository.DataBase;

import java.net.PortUnreachableException;
import java.util.List;

public class TravelServ {
    private final int BASE_VALUE = 800000;
    private final int INTERNATIONAL_CHARGE = 100000;

    DataBase repo = new DataBase();

    public void creation(Travel t) throws Exception{

        t.setState(Data.PROGRAMADO);
        t.setSitsAvb(t.getCapacity());
        if(t.getFlyTyp() == null){
            throw new Exception("SELECCIONE TIPO DE VUELO");
        }

        if (t.getDate() == null){
            throw new Exception("INGRESE UNA FECHA");
        }

        if(t.getDestiny() == t.getOrigen()){
            throw new Exception("DESTINO INVALIDO");
        }

        if(t.getSitsAvb() < 0 ) {
            throw new Exception("NO HAY MAS SILLAS DISPONIBLES");
        }

        if (t.getOrigen() == null || t.getDestiny() == null){
            throw new Exception("INGRESE DESTINOS VALIDOS");
        }

        if(t.getFood() == null){
            throw new Exception("INGRESE UNA OPCION DE ALIMENTO");
        }

        if(t.getVisa() == null){
            throw new Exception("INGRESE LA OPCION DE VISADO");
        }

        t.setCode(repo.returnTravel().size() + 1);
        repo.createTravel(t);
    }

    public List<Travel> show(){
        return repo.returnTravel();
    }

    public void delete(int code){
        repo.deleteTravel(code) ;
    }
    public void deleteReservation(int code) {repo.deleteReservation(code);}

    public long priceCalculator(int code){

        Travel t = returnCode(code);

        if(t.getFlyTyp() == Data.INTERNACIONAL){
            t.setPrice(BASE_VALUE + INTERNATIONAL_CHARGE);
            return (BASE_VALUE + INTERNATIONAL_CHARGE);
        }else {
            t.setPrice(BASE_VALUE);
            return (BASE_VALUE);
        }
    }

    //esta funcion sirve a favor de una operacion aplicada para Reservations
    public void sits(Data d, int sits, int code){
        Travel t = returnCode(code);

        if(d == Data.CONFIRMADO){
            t.setSitsAvb(t.getCapacity() - sits);
        }
        else
            if(d == Data.CANCELADO){
                t.setSitsAvb(t.getSitsAvb() + sits);
            }
    }

    private Travel returnCode(int code){
        return DataBase.returnTravel().stream()
                .filter(event -> event.getCode() == code)
                .findFirst()
                .orElse(null);
    }

    public void initiateFly(int code){
        Travel t = returnCode(code);
        t.setState(Data.EN_VUELO);
    }
}
