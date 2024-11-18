package co.edu.unicesar.ejemplofx;

import co.edu.unicesar.ejemplofx.logica.LogicaCliente;
import co.edu.unicesar.ejemplofx.persistencia.MapaCliente;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */

//https://github.com/UpcProgramingII/Programming-II--Course--2024-II
public class App extends Application {

    private static Scene scene;
    protected static LogicaCliente logicaCliente = new LogicaCliente();

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"), 640, 480);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    protected static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}