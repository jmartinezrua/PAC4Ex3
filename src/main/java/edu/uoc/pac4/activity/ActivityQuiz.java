package edu.uoc.pac4.activity;

/**
 * Class representing a quiz activity.
 */
public class ActivityQuiz extends Activity {

    private ActivityQuizType type;

    /**
     * Constructs a new quiz activity with the specified name, description, and type.
     *
     * @param name the name of the activity
     * @param description the description of the activity
     * @param type the type of the quiz activity
     * @throws ActivityException if any parameter is invalid
     */
    public ActivityQuiz(String name, String description, ActivityQuizType type) throws ActivityException {
        super(name, description);
        setType(type);
    }

    /**
     * Gets the type of the quiz activity.
     *
     * @return the type of the quiz activity
     */
    public ActivityQuizType getType() {
        return type;
    }

    /**
     * Sets the type of the quiz activity.
     *
     * @param type the type to set
     */
    public void setType(ActivityQuizType type) {
        this.type = type;
    }

    /**
     * Returns a string representation of the quiz activity.
     *
     * @return a string representation of the quiz activity
     */
    @Override
    public String toString() {
        return String.format("%s%n%s", super.toString(), type.toString());
    }
}
