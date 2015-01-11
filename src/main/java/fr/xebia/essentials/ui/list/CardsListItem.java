package fr.xebia.essentials.ui.list;

import fr.xebia.essentials.model.Card;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;

public class CardsListItem extends ListCell<Card> {

    @Override
    protected void updateItem(Card item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null) {
            setText(null);
            setGraphic(null);
        } else {
            Label label = new Label(item.getTitle());
            setGraphic(label);
        }
    }
}
