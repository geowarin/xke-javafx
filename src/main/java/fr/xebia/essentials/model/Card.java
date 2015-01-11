package fr.xebia.essentials.model;

public class Card {

    private boolean deprecated;
    private int category;
    private String title;
    private String url;
    private String summary;
    private String description;
    private String bitly;

    public boolean isDeprecated() {
        return deprecated;
    }

    public int getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    public String getBitly() {
        return bitly;
    }
}
