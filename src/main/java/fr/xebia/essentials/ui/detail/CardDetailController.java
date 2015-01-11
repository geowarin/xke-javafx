package fr.xebia.essentials.ui.detail;

import fr.xebia.essentials.core.Context;
import fr.xebia.essentials.model.Card;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CardDetailController implements Initializable {

    @FXML Label cardTitle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Card card = Context.INSTANCE.getSelectedCard();
        cardTitle.setText(card.getTitle());
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/cards_list.fxml"));
        Context.INSTANCE.getPrimaryStage().setScene(new Scene(root));
    }
}
