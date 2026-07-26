package org.example.parcial_v1.service;

import org.example.parcial_v1.entity.Passenger;
import org.example.parcial_v1.repository.DataBase;

import java.util.List;

public class PassengerServ {

    DataBase repo = new DataBase();

    public void creation(Passenger p) throws Exception{
        if(p.getName() == null || p.getName().isBlank() || !p.getName().matches("[a-zA-Z]+( [a-zA-Z+]*)")){
            throw new Exception("Nombre invalido".toUpperCase());
        }

        if(p.getId()<0){
            throw new Exception("VALOR DE ID INVALIDO");
        }

        if(p.getAge() < 0 || p.getAge() > 130){
            throw new Exception("VALOR DE EDAD INVALIDO");
        }

        if(p.getPhone() == null || p.getPhone().isBlank()){
            throw new Exception("NUMERO DE TELFONO INVALIDO");
        }

        if(p.getPassportCode() == null || p.getPassportCode().isBlank()){
            throw new Exception("VALOR DE PASAPORTE INCORRECTO");
        }

        if(p.getNationality() == null || !p.getNationality().matches("[a-zA-Z]+")){
            throw new Exception("VALOR DE NACIONALIDAD INCORRECTO");
        }

        if(!p.getGmail().contains("@")){
            throw new Exception("DEDBE INCLUIR @ EN EL CORREO");
        }else
            if(p.getGmail() == null || p.getGmail().isBlank()){
                throw new Exception("VALOR DE CORREO INVALIDO");
            }
        repo.createPassenger(p);
    }

    public List<Passenger> show(){
        return repo.returnPassenger();
    }

    public void delete(long code){
        repo.deletePassenger(code);
    }

}
