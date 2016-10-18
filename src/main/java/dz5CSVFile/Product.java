package dz5CSVFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dmitriy on 8/20/15.
 */
public class Product implements Comparable {
    private int position;
    private double price;
    private String name;
    private Date freshness;

    public Product(int position, double price, String name, String freshness) throws ParseException {
        this.position = position;
        this.price = price;
        this.name = name;
        this.freshness = new SimpleDateFormat("dd.MM.yyyy").parse(freshness);
    }


    public int compareTo(Object o) {
        return this.getPosition() - ((Product) o).getPosition();
    }

    @Override
    public String toString() {
        return String.valueOf(getPosition()) + ", " + String.valueOf(getPrice()) + ", " + getName() + ", " + getFreshness() + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        Product product = (Product) obj;

        return this.getPrice() == product.getPrice() && this.getName().equals(product.getName())
                && this.getFreshness().equals(product.getFreshness());
    }


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFreshness() {
        return freshness;
    }

    public void setFreshness(Date freshness) {
        this.freshness = freshness;
    }
}
