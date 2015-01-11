package fr.xebia.essentials.core;

import fr.xebia.essentials.model.Card;
import javafx.stage.Stage;

import java.util.List;

public enum Context {
    INSTANCE;

    private Stage primaryStage;
    private List<Card> cards;
    private Card selectedCard;

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Card getSelectedCard() {
        return selectedCard;
    }

    public void setSelectedCard(Card selectedCard) {
        this.selectedCard = selectedCard;
    }
}
