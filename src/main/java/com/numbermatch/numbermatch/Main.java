package com.numbermatch.numbermatch;

import com.numbermatch.numbermatch.Controlador;
import com.numbermatch.numbermatch.GUI.BotonesView;
import com.numbermatch.numbermatch.GUI.CuadriculaView;
import com.numbermatch.numbermatch.GUI.TableroView;
import com.numbermatch.numbermatch.Logica.Cuadricula;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Cuadricula cuadricula = new Cuadricula(4, 5);
        BotonesView botones = new BotonesView();
        CuadriculaView grid = new CuadriculaView(cuadricula);
        TableroView tb = new TableroView(botones, grid);

        Controlador controlador = new Controlador(tb, cuadricula);
        controlador.asignarAccionesBotones();
        Scene scene = new Scene(tb, 600, 500);
        if (getClass().getResource("/estilos.css") != null) {
            scene.getStylesheets().add(getClass().getResource("/estilos.css").toExternalForm());
        }

        primaryStage.setTitle("Number Match");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}