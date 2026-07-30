package org.example.parcial_v1.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.example.parcial_v1.entity.Reservation;
import org.example.parcial_v1.service.ReservationServ;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ControllerReservation extends ControllerTravel implements Initializable {

    ReservationServ srv = new ReservationServ();

    @FXML private TextField date;
    @FXML private TextField sitsAskd;
    @FXML private TextField idUser;
    @FXML private TextField idFly;
    @FXML private ListView<Reservation> list;
    private Reservation selectedItem;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        list.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if(newVal != null){
                selectedItem = newVal;
            }
        });
    }

    public void handleReg(){
        try {
            DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String _date = date.getText();
            LocalDate _Date = LocalDate.parse(_date, dateFormater);

            String _sitsAskd = sitsAskd.getText();
            int _SitsAskd = Integer.parseInt(_sitsAskd);

            String _idUser = idUser.getText();
            long _IdUser = Long.parseLong(_idUser);

            String _idFly = idFly.getText();
            int _IdFly = Integer.parseInt(_idFly);

            Reservation r = new Reservation(_IdUser, _SitsAskd, _Date, _IdFly);
            srv.creation(r);
            show();
        }catch(Exception e){
            error(e);
        }
    }

    public void show(){
        list.setItems(FXCollections.observableList(srv.show()));
    }

    public void handleCancelR(){
        try {
            srv.delete(selectedItem.getCode());
            show();
        }catch (Exception e){
            error(e);
        }
    }
    public void refresh1(){
        show();
    }
}
