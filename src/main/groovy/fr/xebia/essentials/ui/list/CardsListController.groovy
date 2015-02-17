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
    private ObservableList<Card> observableList = FXCollections.observableArrayList()
    @FXML
    private ListView<Card> listView

    @Override
    void initialize(URL location, ResourceBundle resources) {
        setListView()
    }

    private void setListView() {
        List<Card> cards = Context.INSTANCE.cards
        observableList.setAll(cards.findAll { card -> !card.deprecated })
        listView.items = observableList
        listView.cellFactory = { param -> new CardsListItem() }

        ChangeListener<Card> changeListener = { observable, oldValue, newValue ->
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(1000), listView)
            scaleTransition.toX = 2f
            scaleTransition.toY = 2f

            scaleTransition.onFinished = { ActionEvent e ->
                Context.INSTANCE.selectedCard = newValue
                Parent root = FXMLLoader.load(getClass().getResource('/fxml/card_detail.fxml'))
                Context.INSTANCE.primaryStage.scene = new Scene(root);
            }
            scaleTransition.play()
        }
        listView.selectionModel.selectedItemProperty().addListener(changeListener)
    }
}
