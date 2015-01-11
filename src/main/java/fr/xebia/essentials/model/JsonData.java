package fr.xebia.essentials.model;

import com.google.gson.Gson;

import java.io.*;
import java.util.List;

public class JsonData {

    private List<Category> categories;
    private List<Card> cards;

    public List<Category> getCategories() {
        return categories;
    }

    public List<Card> getCards() {
        return cards;
    }

    public static JsonData getDataFromJsonFile() {
        InputStream is = null;
        try {
            is = JsonData.class.getResource("/fr/xebia/essentials/data/cards_data.json").openStream();
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            return new Gson().fromJson(reader, JsonData.class);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
            }
        }
        return null;
    }
}
