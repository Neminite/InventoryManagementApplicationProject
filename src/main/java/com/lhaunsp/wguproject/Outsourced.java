package com.lhaunsp.wguproject;

/**
 * Outsourced class based on the provided UML document
 *
 * @author Lucas Haunsperger
 */
public class Outsourced extends Part {
    private String companyName;

    /**
     * Constructor
     *
     * @param id          the id of the Part
     * @param name        the name of the Part
     * @param price       the price of the Part
     * @param stock       the current stock
     * @param min         the minimum stock
     * @param max         the maximum stock
     * @param companyName the name of the company the part came from
     */
    public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName) {
        super(id, name, price, stock, min, max);
        this.companyName = companyName;
    }

    /**
     * Gets companyName
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * sets companyName
     * @param companyName the id to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
