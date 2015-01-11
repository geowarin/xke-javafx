package fr.xebia.essentials;

import fr.xebia.essentials.model.Card;
import fr.xebia.essentials.model.Category;
import fr.xebia.essentials.model.JsonData;
import org.junit.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonDataShould {
    JsonData data = JsonData.getDataFromJsonFile();

    @Test public void
    contain_four_categories() {
        assertThat(data.getCategories()).hasSize(4);
    }

    @Test public void
    bind_category_data_properly() {
        Category category = data.getCategories().get(0);
        assertThat(category.getColor()).isEqualTo("#F80068");
        assertThat(category.getName()).isEqualTo("Craftsmanship");
        assertThat(category.getId()).isEqualTo(1);
    }

    @Test public void
    contain_all_77_cards() {
        assertThat(data.getCards()).hasSize(77);
    }

    @Test public void
    contain_74_actual_cards() {
        assertThat(data.getCards().stream().filter(card -> !card.isDeprecated()).collect(Collectors.toList())).hasSize(74);
    }

    @Test public void
    bind_card_data_properly() {
        Card card = data.getCards().get(0);
        assertThat(card.getTitle()).isEqualTo("APIs, like diamonds, are forever");
        assertThat(card.getUrl()).isEqualTo("apis-are-forever");
        assertThat(card.getSummary()).contains("So craft them carefully");
        assertThat(card.getCategory()).isEqualTo(3);
        assertThat(card.getBitly()).isEqualTo("hJOvvL");
    }
}
