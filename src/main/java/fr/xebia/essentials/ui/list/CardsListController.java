package fr.xebia.essentials.ui.list;

import fr.xebia.essentials.model.Card;
import fr.xebia.essentials.model.JsonData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class CardsListController implements Initializable {

    @FXML private ListView<String> listView;
    private ObservableList<String> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setListView();
    }

    private void setListView() {
        List<Card> cards = JsonData.getDataFromJsonFile().getCards();
        observableList.setAll(cards.stream().filter(card -> !card.isDeprecated()).map(Card::getTitle).collect(Collectors.toList()));
        listView.setItems(observableList);
    }
}
