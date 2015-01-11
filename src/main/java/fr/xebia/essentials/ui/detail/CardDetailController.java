package fr.xebia.essentials.ui.detail;

import fr.xebia.essentials.core.Context;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CardDetailController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/cards_list.fxml"));
        Context.INSTANCE.getPrimaryStage().setScene(new Scene(root));
    }
}
