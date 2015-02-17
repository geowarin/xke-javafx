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
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/cards_list_item.fxml"));
        fxmlLoader.setController(this);
        root = fxmlLoader.load();
    }

    @Override
    protected void updateItem(Card item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            text = null;
            graphic = null;
        } else {
            cardTitle.text = item.getTitle();
            cardTitle.styleClass.clear();
            cardTitle.styleClass.add("default");
            cardTitle.styleClass.add("category-" + item.getCategory());
            setGraphic(root);
        }
    }
}
