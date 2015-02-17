package fr.xebia.essentials.core;

import fr.xebia.essentials.model.JsonData;
import retrofit.http.GET;

interface XebiaEssentialsApi {

    @GET("/Nilhcem/xebia-essentials-android/master/essentials-android/src/main/res/raw/cards_data.json")
    JsonData getCards()
}
