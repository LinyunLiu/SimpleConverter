/*
Name: Linyun Liu
Title: Simple Converter
 */
package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.Objects;
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            AnchorPane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("layout.fxml")));
            Scene scene = new Scene(root,640,226);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("application.css")).toExternalForm());
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Simple Converter");
            stage.show();
            
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
       launch(args);
    }
}