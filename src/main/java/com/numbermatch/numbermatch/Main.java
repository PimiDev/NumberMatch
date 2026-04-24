package com.numbermatch.numbermatch;

import com.numbermatch.numbermatch.GUI.BotonesView;
import com.numbermatch.numbermatch.GUI.CuadriculaView;
import com.numbermatch.numbermatch.Logica.Cuadricula;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        BotonesView bv = new BotonesView();
        CuadriculaView cv = new CuadriculaView(new Cuadricula(4,5));
        Scene scene = new Scene(cv, 400, 300);

        scene.getStylesheets().add(getClass().getResource("/estilos.css").toExternalForm());

        primaryStage.setTitle("Number Match - Test CSS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}