package fr.xebia.essentials.core;

import fr.xebia.essentials.model.Card;
import javafx.stage.Stage;
import retrofit.RestAdapter;

import java.util.List;

public enum Context {
    INSTANCE;

    private Stage primaryStage;
    private List<Card> cards;
    private Card selectedCard;
    private XebiaEssentialsApi api;

    private Context() {
        initRestClient();
    }

    private void initRestClient() {
        RestAdapter.Builder builder = new RestAdapter.Builder();
        RestAdapter adapter = builder.setEndpoint("https://raw.githubusercontent.com").build();
        api = adapter.create(XebiaEssentialsApi.class);
    }

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

    public XebiaEssentialsApi getApi() {
        return api;
    }
}
