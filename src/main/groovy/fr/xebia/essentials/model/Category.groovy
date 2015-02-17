package fr.xebia.essentials.model;

class Category {
    int id
    String color
    String name

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
