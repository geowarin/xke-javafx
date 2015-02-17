package fr.xebia.essentials.ui.detail;

import fr.xebia.essentials.core.Context;
import fr.xebia.essentials.model.Card;
import fr.xebia.essentials.model.Category;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

class CardDetailController implements Initializable {
    @FXML
    Label cardTitle;
    @FXML
    WebView cardDetail;

    @Override
    void initialize(URL location, ResourceBundle resources) {
        Card card = Context.INSTANCE.selectedCard
        String categoryColor = Category.getColorForCategory(card.category)

        cardTitle.text = card.title;
        cardTitle.style = "-fx-background-color: " + categoryColor;
        cardDetail.engine.loadContent(String.format(Locale.US,
                "<html><head><style>a, h1, h2, h3 { color: %s }</style><body>%s</body></html>",
                categoryColor, card.description));
    }

    void goBack(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/cards_list.fxml"));
        Context.INSTANCE.primaryStage.scene = new Scene(root);
    }
}
