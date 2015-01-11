package fr.xebia.essentials;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initPrimaryStage(primaryStage);
    }

    private void initPrimaryStage(Stage primaryStage) throws IOException {
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        double height = bounds.getHeight() * 0.8;
        double width = height * 0.7;
        primaryStage.setWidth(width);
        primaryStage.setHeight(height);
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/cards_list.fxml"));
        primaryStage.setTitle("Xebia Essentials");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
