package org.example.parcial_v1;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/org/example/parcial_v1/FLUXIOAIR.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800,600);
        stage.setScene(scene);
        stage.setTitle("FLUXIOAIR");
        stage.show();

    }

    public static void main(String[] args) {
        Gson gson = new Gson();

        launch();

        String json = gson.toJson("d");

    }
}
