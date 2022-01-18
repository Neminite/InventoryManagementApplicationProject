package com.lhaunsp.wguproject;

/**
 * InHouse class based on the UML document
 *
 * @author Lucas Haunsperger
 */
public class InHouse extends Part {
    private int machineId;

    /**
     * Constructor
     *
     * @param id        the id of the Part
     * @param name      the name of the Part
     * @param price     the price of the Part
     * @param stock     the current stock
     * @param min       the minimum stock
     * @param max       the maximum stock
     * @param machineId the machineID of the part
     */
    public InHouse(int id, String name, double price, int stock, int min, int max, int machineId) {
        super(id, name, price, stock, min, max);
        this.machineId = machineId;
    }

    /**
     * Gets the Machine ID
     * @return the MachineId
     */
    public int getMachineId() {
        return machineId;
    }

    /**
     * Sets the Machine ID
     * @param machineId the id to set
     */
    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

}
