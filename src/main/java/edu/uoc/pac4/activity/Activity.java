package edu.uoc.pac4.activity;

import edu.uoc.pac4.execution.Execution;
import java.util.LinkedList;

/**
 * Abstract class representing an activity.
 */
public abstract class Activity implements Cloneable {

    private String name;
    private String description;
    private LinkedList<Execution> executions;

    /**
     * Constructs a new activity with the specified name and description.
     *
     * @param name the name of the activity
     * @param description the description of the activity
     * @throws ActivityException if the name is invalid
     */
    public Activity(String name, String description) throws ActivityException {
        setName(name);
        setDescription(description);
        this.executions = new LinkedList<>();
    }

    /**
     * Gets the name of the activity.
     *
     * @return the name of the activity
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the activity.
     *
     * @param name the name to set
     * @throws ActivityException if the name is null, empty, or blank
     */
    public void setName(String name) throws ActivityException {
        if (name == null || name.trim().isEmpty()) {
            throw new ActivityException(ActivityException.INVALID_NAME);
        }
        this.name = name.trim();
    }

    /**
     * Gets the description of the activity.
     *
     * @return the description of the activity
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the activity.
     *
     * @param description the description to set; if null, sets an empty description
     */
    public void setDescription(String description) {
        if (description == null) {
            this.description = "";
        } else {
            this.description = description.trim();
        }
    }

    /**
     * Adds an execution to the activity.
     *
     * @param execution the execution to add
     */
    public void addExecution(Execution execution) {
        this.executions.add(execution);
    }

    /**
     * Gets the executions of the activity.
     *
     * @return a list of executions
     */
    public LinkedList<Execution> getExecutions() {
        return executions;
    }

    /**
     * Creates and returns a copy of this activity.
     *
     * @return a clone of this activity
     * @throws CloneNotSupportedException if the activity cannot be cloned
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Activity cloned = (Activity) super.clone();
        cloned.executions = new LinkedList<>();
        return cloned;
    }

    /**
     * Returns a string representation of the activity.
     *
     * @return a string representation of the activity
     */
    @Override
    public String toString() {
        return String.format("%s: %s%nTotal executions: %d", name, description, executions.size());
    }

    /**
     * Gets the count of executions of the activity.
     *
     * @return the count of executions
     */
    public long getExecutionsCount() {
        return executions.size();
    }
}
