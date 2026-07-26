package org.example.parcial_v1.controllers;


import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.example.parcial_v1.entity.Passenger;
import org.example.parcial_v1.service.PassengerServ;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerPassenger extends ControllerTravel implements Initializable {

    PassengerServ srv = new PassengerServ();

    @FXML private TextField name;
    @FXML private TextField age;
    @FXML private TextField id;
    @FXML private TextField phone;
    @FXML private TextField gmail;
    @FXML private TextField passport;
    @FXML private TextField nationality;
    @FXML private ListView<Passenger> list;
    private Passenger selectedItem;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        list.getSelectionModel().selectedItemProperty().addListener((obs,oldVal,newVal) ->{
            if(newVal != null){
                selectedItem = newVal;
            }
        });

    }

    public void handleReg(){
        try {
            String _name = name.getText();
            int _age = Integer.parseInt(age.getText());
            long _id = Long.parseLong(id.getText());
            String _phone = phone.getText();
            String _gmail = gmail.getText();
            String _passport = passport.getText();
            String _nationality = nationality.getText();

            Passenger p = new Passenger(_name, _id, _age, _gmail, _phone, _passport, _nationality);
            srv.creation(p);
            show();
        } catch (Exception e) {
            error(e);
        }
    }

    public void show(){
        list.setItems(FXCollections.observableList(srv.show()));
    }

    public void handleCancelP(){
        srv.delete(selectedItem.getId());
        show();
    }

}
