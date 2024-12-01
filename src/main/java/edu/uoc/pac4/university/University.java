package edu.uoc.pac4.university;

import java.time.LocalDate;

/**
 * Represents a University with details such as name, abbreviation, foundation date, address, and website.
 */
public class University {

    private String name;
    private String abbreviation;
    private LocalDate foundationDate;
    private String address;
    private String website;

    /**
     * Constructs a new University with the specified details.
     *
     * @param name the name of the university
     * @param abbreviation the abbreviation of the university
     * @param foundationDate the foundation date of the university
     * @param address the address of the university
     * @param website the website of the university
     * @throws UniversityException if any of the parameters are invalid
     */
    public University(String name, String abbreviation, LocalDate foundationDate, String address, String website) throws UniversityException {
        setName(name);
        setAbbreviation(abbreviation);
        setFoundationDate(foundationDate);
        setAddress(address);
        setWebsite(website);
    }

    /**
     * Gets the name of the university.
     *
     * @return the name of the university
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the university.
     *
     * @param name the name to set
     * @throws UniversityException if the name is null or empty
     */
    public void setName(String name) throws UniversityException {
        if (name == null || name.trim().isEmpty()) {
            throw new UniversityException(UniversityException.INVALID_NAME);
        }
        this.name = name.trim();
    }

    /**
     * Gets the abbreviation of the university.
     *
     * @return the abbreviation of the university
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Sets the abbreviation of the university.
     *
     * @param abbreviation the abbreviation to set
     * @throws UniversityException if the abbreviation is null or does not match the required pattern
     */
    public void setAbbreviation(String abbreviation) throws UniversityException {
        if (abbreviation == null || !abbreviation.matches("[A-Z]{2,6}")) {
            throw new UniversityException(UniversityException.INVALID_ABBREVIATION);
        }
        this.abbreviation = abbreviation;
    }

    /**
     * Gets the foundation date of the university.
     *
     * @return the foundation date of the university
     */
    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    /**
     * Sets the foundation date of the university.
     *
     * @param foundationDate the foundation date to set
     * @throws UniversityException if the foundation date is null or in the future
     */
    public void setFoundationDate(LocalDate foundationDate) throws UniversityException {
        if (foundationDate == null || foundationDate.isAfter(LocalDate.now())) {
            throw new UniversityException(UniversityException.INVALID_FOUNDATION_DATE);
        }
        this.foundationDate = foundationDate;
    }

    /**
     * Gets the address of the university.
     *
     * @return the address of the university
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the university.
     *
     * @param address the address to set
     * @throws UniversityException if the address is null
     */
    public void setAddress(String address) throws UniversityException {
        if (address == null) {
            throw new UniversityException(UniversityException.INVALID_ADDRESS);
        }
        this.address = address.trim();
    }

    /**
     * Gets the website of the university.
     *
     * @return the website of the university
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Sets the website of the university.
     *
     * @param website the website to set
     * @throws UniversityException if the website is null or does not match the required pattern
     */
    public void setWebsite(String website) throws UniversityException {
        if (website == null || !website.matches("^(https?://)?([\\w.-]+)\\.([a-z]{2,6})([/\\w .-]*)*/?$")) {
            throw new UniversityException(UniversityException.INVALID_WEBSITE);
        }
        this.website = website;
    }

    /**
     * Returns a string representation of the university.
     *
     * @return a string representation of the university
     */
    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s", name, abbreviation, foundationDate, address, website);
    }
}
