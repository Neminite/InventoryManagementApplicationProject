package com.lhaunsp.wguproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Product class based on provided UML document
 *
 * @author Lucas Haunsperger
 */
public class Product {
    private final ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    /**
     * Constructor
     *
     * @param id    the id of the Product
     * @param name  the name of the Product
     * @param price the price of the Product
     * @param stock the current stock
     * @param min   the minimum stock
     * @param max   the maximum stock
     */
    public Product(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }


    /**
     * gets the id
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * sets the id
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * gets name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * sets name
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets price
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * sets price
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * gets stock
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * sets stock
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * gets min
     * @return the min
     */
    public int getMin() {
        return min;
    }

    /**
     * sets min
     * @param min the min to set
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * gets max
     * @return the max
     */
    public int getMax() {
        return max;
    }

    /**
     * sets max
     * @param max the max to set
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * Adds associated Part to Product
     * @param part the part to add
     */
    public void addAssociatedPart(Part part) {
        this.associatedParts.add(part);
    }

    /**
     * Removes associated Part from Product
     * @param selectedAssociatedPart the part to remove
     * @return true if successful false otherwise
     */
    public boolean deleteAssociatedPart(Part selectedAssociatedPart) {
        return associatedParts.remove(selectedAssociatedPart);
    }

    /**
     * Returns a list of all associated parts
     * @return all Associated Parts
     */
    public ObservableList<Part> getAllAssociatedParts() {
        return associatedParts;
    }
}
