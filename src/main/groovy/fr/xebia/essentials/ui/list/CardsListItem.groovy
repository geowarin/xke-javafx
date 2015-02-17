package fr.xebia.essentials.ui.list;

import fr.xebia.essentials.model.Card;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;

import java.io.IOException;

class CardsListItem extends ListCell<Card> {
    private Parent root;
    @FXML
    Label cardTitle;

    CardsListItem() {
        super()
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource('/fxml/cards_list_item.fxml'))
        fxmlLoader.controller = this
        root = fxmlLoader.load()
    }

    @Override
    protected void updateItem(Card item, boolean empty) {
        super.updateItem(item, empty)
        if (empty) {
            text = null
            setGraphic(null)
        } else {
            cardTitle.text = item.title
            cardTitle.styleClass.clear()
            cardTitle.styleClass.add("default")
            cardTitle.styleClass.add("category-" + item.category)
            setGraphic(root) // Do not touch this. Magic setter
        }
    }
}
