package fr.xebia.essentials;

import fr.xebia.essentials.core.Context;
import fr.xebia.essentials.model.JsonData;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initPrimaryStage(primaryStage);
        initLoading(primaryStage);
    }

    private void initPrimaryStage(Stage primaryStage) throws IOException {
        Context.INSTANCE.setPrimaryStage(primaryStage);

        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        double height = bounds.getHeight() * 0.8;
        double width = height * 0.7;
        primaryStage.setWidth(width);
        primaryStage.setHeight(height);
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
    }

    private void initLoading(Stage primaryStage) throws IOException {
        final Stage progressBar = openLoadingWindow();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Task<JsonData> task = new Task<JsonData>() {
            @Override
            protected JsonData call() throws Exception {
                Thread.sleep(4000);
                return JsonData.getDataFromJsonFile();
            }
        };
        task.setOnFailed(event -> progressBar.close());
        task.setOnSucceeded(workerStateEvent -> {
            JsonData data = (JsonData) workerStateEvent.getSource().getValue();
            Context.INSTANCE.setCards(data.getCards());

            try {
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/cards_list.fxml"));
                primaryStage.setTitle("Xebia Essentials");
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
                progressBar.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(task);
        executorService.shutdown();
    }

    private Stage openLoadingWindow() throws IOException {
        final Stage progressBar = new Stage();
        progressBar.initModality(Modality.WINDOW_MODAL);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/loading.fxml"));
        progressBar.setScene(new Scene(root));
        progressBar.setTitle("Loading...");
        progressBar.show();
        return progressBar;
    }
}
