package seminars.first.hw;

public class Product {
    private int cost; // Стоимость продукта
    private String title; // Название

    public Product(String title, int cost) {
        this.cost = cost;
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}