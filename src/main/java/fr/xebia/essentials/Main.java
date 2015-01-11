package fr.xebia.essentials;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initPrimaryStage(primaryStage);
    }

    private void initPrimaryStage(Stage primaryStage) {
        primaryStage.setTitle("Xebia Essentials");
        Button button = new Button("Click me");
        button.setOnAction(event -> System.out.println("Clicked!"));
        StackPane root = new StackPane(button);
        primaryStage.setScene(new Scene(root, 320, 200));
        primaryStage.show();
    }
}
