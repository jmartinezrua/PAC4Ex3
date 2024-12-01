package edu.uoc.pac4.activity;

/**
 * Abstract class representing a programming activity.
 */
public abstract class ActivityProgramming extends Activity implements Evaluable {

    private double weight;

    /**
     * Constructs a new programming activity with the specified name, description, and weight.
     *
     * @param name the name of the activity
     * @param description the description of the activity
     * @param weight the weight of the activity
     * @throws ActivityException if the name is invalid
     */
    public ActivityProgramming(String name, String description, double weight) throws ActivityException {
        super(name, description);
        setWeight(weight);
    }

    /**
     * Gets the weight of the activity.
     *
     * @return the weight of the activity
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the activity. Ensures the weight is between 0 and 100.
     *
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        if (weight < 0 || weight > 100) {
            weight = Math.max(0, Math.min(weight, 100));
        }
        this.weight = weight;
    }

    /**
     * Returns a string representation of the programming activity.
     *
     * @return a string representation of the programming activity
     */
    @Override
    public String toString() {
        return super.toString() + " (" + weight + "%)";
    }
}
