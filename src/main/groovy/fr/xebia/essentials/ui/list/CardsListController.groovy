package fr.xebia.essentials.ui.list;

import fr.xebia.essentials.core.Context;
import fr.xebia.essentials.model.Card;
import javafx.animation.ScaleTransition
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.util.Duration

class CardsListController implements Initializable {

    @FXML
    private ListView<Card> listView;
    private ObservableList<Card> observableList = FXCollections.observableArrayList();

    @Override
    void initialize(URL location, ResourceBundle resources) {
        setListView();
    }

    private void setListView() {
        List<Card> cards = Context.INSTANCE.getCards();
        observableList.setAll(cards.findAll { card -> !card.deprecated })
        listView.setItems(observableList);
        listView.setCellFactory({ param -> new CardsListItem() })

        ChangeListener<Card> changeListener = { observable, oldValue, newValue ->
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(1000), listView);
            scaleTransition.setToX(2f);
            scaleTransition.setToY(2f);

            scaleTransition.setOnFinished({ ActionEvent e ->
                Context.INSTANCE.selectedCard = newValue;
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/card_detail.fxml"));
                Context.INSTANCE.primaryStage.scene = new Scene(root);
            });
            scaleTransition.play();
        }
        listView.selectionModel.selectedItemProperty().addListener(changeListener);
    }
}
