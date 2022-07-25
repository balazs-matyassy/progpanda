package hu.progmatic.progpanda.model;

public class Food {
    private Integer id;
    private String name;
    private int quantity;

    public Food() {
    }

    public Food(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Food(Integer id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
