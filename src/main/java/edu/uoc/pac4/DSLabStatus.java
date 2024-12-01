package edu.uoc.pac4;

/**
 * Enumeration representing the status of a DSLab.
 */
public enum DSLabStatus {

    /**
     * Status when the lab is active.
     */
    ACTIVE("Active"),

    /**
     * Status when the lab is inactive.
     */
    INACTIVE("Inactive"),

    /**
     * Status when the lab is under maintenance.
     */
    MAINTENANCE("Maintenance");

    private final String status;

    /**
     * Constructor for DSLabStatus.
     *
     * @param status the status of the lab
     */
    DSLabStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the status of the lab.
     *
     * @return the status of the lab
     */
    public String getStatus() {
        return status;
    }

    /**
     * Returns a string representation of the status in uppercase and enclosed in brackets.
     *
     * @return the string representation of the status
     */
    @Override
    public String toString() {
        return "[" + status.toUpperCase() + "]";
    }
}
