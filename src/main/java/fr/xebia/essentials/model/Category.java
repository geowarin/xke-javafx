package fr.xebia.essentials.model;

public class Category {

    private int id;
    private String color;
    private String name;

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public static String getColorForCategory(int category) {
        switch (category) {
            case 1:
                return "#F80068";
            case 2:
                return "#FC7A25";
            case 3:
                return "#107FD5";
            default:
                return "#6DC726";
        }
    }
}
