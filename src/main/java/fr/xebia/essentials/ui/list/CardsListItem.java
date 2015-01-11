package fr.xebia.essentials.ui.list;

import fr.xebia.essentials.model.Card;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class CardsListItem extends ListCell<Card> {

    private Parent root;
    @FXML Label cardTitle;

    public CardsListItem() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/cards_list_item.fxml"));
        fxmlLoader.setController(this);
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void updateItem(Card item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            cardTitle.setText(item.getTitle());
            cardTitle.getStyleClass().clear();
            cardTitle.getStyleClass().add("default");
            cardTitle.getStyleClass().add("category-" + item.getCategory());
            setGraphic(root);
        }
    }
}
