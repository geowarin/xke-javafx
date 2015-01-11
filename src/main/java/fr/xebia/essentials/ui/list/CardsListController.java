package fr.xebia.essentials.ui.list;

import fr.xebia.essentials.core.Context;
import fr.xebia.essentials.model.Card;
import fr.xebia.essentials.model.JsonData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class CardsListController implements Initializable {

    @FXML private ListView<Card> listView;
    private ObservableList<Card> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setListView();
    }

    private void setListView() {
        List<Card> cards = JsonData.getDataFromJsonFile().getCards();
        observableList.setAll(cards.stream().filter(card -> !card.isDeprecated()).collect(Collectors.toList()));
        listView.setItems(observableList);
        listView.setCellFactory(param -> new CardsListItem());

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/card_detail.fxml"));
                Context.INSTANCE.getPrimaryStage().setScene(new Scene(root));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
