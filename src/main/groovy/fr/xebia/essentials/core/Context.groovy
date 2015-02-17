package fr.xebia.essentials.core

import fr.xebia.essentials.model.Card
import javafx.stage.Stage
import retrofit.RestAdapter

enum Context {
    INSTANCE

    Stage primaryStage
    List<Card> cards
    Card selectedCard
    XebiaEssentialsApi api

    private Context() {
        initRestClient();
    }

    private void initRestClient() {
        RestAdapter.Builder builder = new RestAdapter.Builder()
        RestAdapter adapter = builder.setEndpoint('https://raw.githubusercontent.com').build()
        api = adapter.create(XebiaEssentialsApi)
    }
}
