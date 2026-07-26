        package org.example.parcial_v1.controllers;

        import javafx.animation.PauseTransition;
        import javafx.collections.FXCollections;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.ComboBox;
        import javafx.scene.control.Label;
        import javafx.scene.control.ListView;
        import javafx.scene.control.TextField;
        import javafx.util.Duration;
        import org.example.parcial_v1.entity.Data;
        import org.example.parcial_v1.entity.Travel;
        import org.example.parcial_v1.service.ReservationServ;
        import org.example.parcial_v1.service.TravelServ;

        import java.net.URL;
        import java.time.LocalDate;
        import java.time.LocalTime;
        import java.time.format.DateTimeFormatter;
        import java.util.List;
        import java.util.Locale;
        import java.util.ResourceBundle;

        public class ControllerTravel implements Initializable {
            TravelServ srv = new TravelServ();
            ReservationServ srv1 = new ReservationServ();

            @FXML private ComboBox<Data> origen;
            @FXML private ComboBox<Data> destination;
            @FXML private ComboBox<Data> flyTyp;
            @FXML private ComboBox<Data> visa;
            @FXML private ComboBox<Data> food;
            @FXML private TextField date;
            @FXML private TextField incHour;
            @FXML private TextField exitHour;
            @FXML private ListView<Travel> list;
            @FXML private Label error;
            List<Data> destiny;
            private Travel selectedItem;

            @Override
            public void initialize(URL url, ResourceBundle resourceBundle ){

                list.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
                    if(newVal != null){
                        selectedItem = newVal;

                    }
                });

                flyTyp.getItems().addAll(
                        Data.NACIONAL,
                        Data.INTERNACIONAL
                );

                flyTyp.getSelectionModel()
                                .selectedItemProperty()
                                        .addListener((observableValue, data, t1) ->
                                                setDestinations());

                visa.getItems().addAll(
                        Data.SI,
                        Data.NO
                );

                food.getItems().addAll(
                        Data.SI,
                        Data.NO
                );
                error.setVisible(false);
            }

            public void setDestinations() {
                if (flyTyp.getValue() == Data.NACIONAL) {
                    destiny = List.of(
                            Data.SAN_ANDRES,
                            Data.CALI,
                            Data.BOGOTA,
                            Data.BARRANQUILLA,
                            Data.MEDELLIN,
                            Data.VALLEDUPAR
                    );
                } else {
                    destiny = List.of(
                            Data.LIMA,
                            Data.MEXICO,
                            Data.MIAMI,
                            Data.PERU,
                            Data.BOGOTA
                    );
                }
                origen.getSelectionModel().clearSelection();
                destination.getSelectionModel().clearSelection();

                origen.getItems().setAll(destiny);
                destination.getItems().setAll(destiny);
            }

            public void handleReg(){
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a", Locale.ENGLISH);
                    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    Data _origen = origen.getValue();
                    Data _destination = destination.getValue();

                    String _date = date.getText();
                    LocalDate __date = LocalDate.parse(_date,dateFormat);
                    String _exitHour = exitHour.getText();
                    LocalTime __exitHour = LocalTime.parse(_exitHour,formatter);
                    String _incHour = incHour.getText();
                    LocalTime __incHour = LocalTime.parse(_incHour,formatter);

                    Data _food = food.getValue();
                    Data _visa = visa.getValue();
                    Data _flyTyp = flyTyp.getValue();

                    Travel t = new Travel(_origen, _destination, __date, __exitHour, __incHour,
                            _food, _visa, _flyTyp);

                    srv.creation(t);

                    show();
                }catch (Exception e){
                    error(e);
                }
            }

            public void show(){
                list.setItems(FXCollections.observableList(srv.show()));
            }

            public void error(Exception e){
                error.setVisible(true);
                error.setText(e.getMessage());
                PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1.3));
                pauseTransition.setOnFinished(event -> error.setVisible(false));
                pauseTransition.play();
            }

            public void handleComplete(){
                srv.delete(selectedItem.getCode());
                srv1.deletePeers(selectedItem.getCode());
                show();
            }
            public void handleCancel(){
                srv.delete(selectedItem.getCode());
                srv1.deletePeers(selectedItem.getCode());
                show();
            }
            public void handleInit(){
                srv.initiateFly(selectedItem.getCode());
                show();
            }

            public void refresh(){
                show();
            }
        }

