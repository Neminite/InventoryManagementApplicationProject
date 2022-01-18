package com.lhaunsp.wguproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Inventory class based on the UML document
 *
 * @author Lucas Haunsperger
 */
public class Inventory {
    private static final ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static final ObservableList<Product> allProducts = FXCollections.observableArrayList();

    /**
     * Adds new Part to Inventory
     * @param newPart the part to add
     */
    public static void addPart(Part newPart) {
        allParts.add(newPart);
    }

    /**
     * Adds new Product to Inventory
     * @param newProduct the product to add
     */
    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }

    /**
     * Looks up part by its ID
     * @param partId the id of the product to find
     * @return the part found
     */
    public static Part lookupPart(int partId) {
        // Based on the Java documentation for ObservableList, streams seem like the best way to do this
        return allParts.stream().filter(p -> p.getId() == partId).findFirst().orElse(null);
    }

    /**
     * Looks up part by partial string based on name
     * @param partName the name of the product to find
     * @return the parts found
     */
    public static ObservableList<Part> lookupPart(String partName) {
        //Possible error: filtered returns filtered list
        return allParts.filtered(p -> p.getName().contains(partName));
    }

    /**
     * Looks up product by its ID
     * @param productId the id of the product to find
     * @return the product found
     */
    public static Product lookupProduct(int productId) {
        // Based on the Java documentation for ObservableList, streams seem like the best way to do this
        return allProducts.stream().filter(p -> p.getId() == productId).findFirst().orElse(null);
    }

    /**
     * Looks up product by partial string based on name
     * @param productName the name of the product to find
     * @return the products found
     */
    public static ObservableList<Product> lookupProduct(String productName) {
        return allProducts.filtered(p -> p.getName().contains(productName));
    }

    /**
     * Updates part by replacing existing part with new part
     * updatePart and updateProduct should have a better explanation in the UML and the input variable names should be more aligned due to the similar purposes
     * @param index        index of part to update
     * @param selectedPart new part to replace index with
     */
    public static void updatePart(int index, Part selectedPart) {
        allParts.set(index, selectedPart);
    }

    /**
     * Updates product by replacing existing product with new product
     * @param index      index of product to update
     * @param newProduct new product to replace index with
     */
    public static void updateProduct(int index, Product newProduct) {
        allProducts.set(index, newProduct);
    }

    /**
     * Deletes part from Inventory
     * @param selectedPart the part to remove
     * @return true if successful false otherwise
     */
    public static boolean deletePart(Part selectedPart) {
        return allParts.remove(selectedPart);
    }

    /**
     * Deletes product from Inventory
     * @param selectedProduct the product to remove
     * @return true if successful false otherwise
     */
    public static boolean deleteProduct(Product selectedProduct) {
        return allProducts.remove(selectedProduct);
    }

    /**
     * Gets all Parts from Inventory
     * @return All Parts
     */
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    /**
     * Gets all Products from Inventory
     * @return All Products
     */
    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }
}
