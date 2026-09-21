package Study_Brod.OOP;

import fileworks.DataImport;

import java.util.ArrayList;

class Product{

    private String  name;
    private String category;
    private int amount;
    private double pricePerPiece;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        //this.amount = Math.max(amount,0);

        if (amount<0) this.amount = 0;
        else this.amount = amount;

    }

    public double getPricePerPiece() {
        return pricePerPiece;
    }

    public void setPricePerPiece(double pricePerPiece) {
        if (pricePerPiece<0) this.pricePerPiece = 0;
        else this.pricePerPiece = pricePerPiece;
    }

    public Product(String category, String name) {
        this.category = category;
        this.name = name;
    }

    public Product(String name, String category, int amount) {
        this(name,category);
        this.amount = amount;
    }

    public Product(String name, String category, int amount, int pricePerPiece) {
        this(name,category,amount);
        this.pricePerPiece = pricePerPiece;
    }
}

public class Products {

    public static void main(String[] args) {
        DataImport di = new DataImport("data/products");
        ArrayList <Product> productList = new ArrayList<>();

        while (di.hasNext()){
            String line = di.readLine();
            String[] tokens = line.split(";");

            if (tokens.length == 3)
        }

    }
}
