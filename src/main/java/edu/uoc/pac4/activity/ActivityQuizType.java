package edu.uoc.pac4.activity;

/**
 * Enumeration representing different types of quiz activities.
 */
public enum ActivityQuizType {
    /**
     * Multiple choice quiz type.
     * A collection of questions with multiple choices.
     */
    MULTIPLE_CHOICE("Collection of questions with multiple choices"),

    /**
     * True or false quiz type.
     * A collection of questions with true or false answers.
     */
    TRUE_FALSE("Collection of questions with true or false answers"),

    /**
     * Short answer quiz type.
     * A collection of questions with short answers.
     */
    SHORT_ANSWER("Collection of questions with short answers");

    private final String description;

    /**
     * Constructor for ActivityQuizType enum.
     *
     * @param description the description of the quiz type
     */
    ActivityQuizType(String description) {
        this.description = description;
    }

    /**
     * Gets the description of the quiz type.
     *
     * @return the description of the quiz type
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns a string representation of the quiz type.
     *
     * @return the description of the quiz type
     */
    @Override
    public String toString() {
        return description;
    }
}
