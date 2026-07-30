package org.example.parcial_v1.service;

import org.example.parcial_v1.entity.Passenger;
import org.example.parcial_v1.repository.DataBase;

import java.security.spec.ECField;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;

public class PassengerServ {

    DataBase repo = new DataBase();

    public void creation(Passenger p) throws Exception{

        Optional.ofNullable(p.getName()).
                filter(name -> !name.isBlank() && name.matches("[a-zA-Z]+( [a-zA-Z]*)"))
                .orElseThrow(()->new Exception("NOMBRE INVALIDO"));

        Optional.of(p.getAge())
                .filter(age -> age >= 0 && age <=130)
                .orElseThrow(()-> new Exception("EDAD INVALIDA"));

        Optional.of(p.getId())
                .filter(id -> id>=0)
                .orElseThrow(()-> new Exception("ID INVALIDO"));

        Optional.ofNullable(p.getPhone())
                .filter(phone -> !phone.isBlank() && phone.matches("[0-9]"))
                .orElseThrow(()-> new Exception("NUMERO DE TELEFONO INCORRECTO"));

        Optional.ofNullable(p.getPassportCode())
                .filter(pass -> !pass.isBlank())
                .orElseThrow(()->new Exception("PASAPORTE INVALIDO"));

        Optional.ofNullable(p.getNationality())
                .filter(nat -> !nat.isBlank() && nat.matches("[a-zA-Z]"))
                .orElseThrow(() -> new Exception("NACIONALIDAD INVALIDA"));

        Optional.ofNullable(p.getGmail())
                        .filter(gmail -> gmail.contains("@") && !gmail.isBlank())
                                .orElseThrow(()->new Exception("GMAIL INVVALIDO"));

        repo.createPassenger(p);
    }

    public List<Passenger> show(){
        return DataBase.returnPassenger();
    }

    public void delete(long code){
        repo.deletePassenger(code);
    }

}
