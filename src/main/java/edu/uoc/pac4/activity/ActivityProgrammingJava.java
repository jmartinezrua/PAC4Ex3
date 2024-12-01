package edu.uoc.pac4.activity;

/**
 * Class representing a Java programming activity.
 */
public class ActivityProgrammingJava extends ActivityProgramming {

    private String jdkVersion;
    private String gradleVersion;

    /**
     * Constructs a new Java programming activity with the specified parameters.
     *
     * @param name the name of the activity
     * @param description the description of the activity
     * @param weight the weight of the activity
     * @param jdkVersion the JDK version to use
     * @param gradleVersion the Gradle version to use
     * @throws ActivityException if any parameter is invalid
     */
    public ActivityProgrammingJava(String name, String description, double weight, String jdkVersion, String gradleVersion) throws ActivityException {
        super(name, description, weight);
        setJdkVersion(jdkVersion);
        setGradleVersion(gradleVersion);
    }

    /**
     * Gets the JDK version used for this activity.
     *
     * @return the JDK version
     */
    public String getJdkVersion() {
        return jdkVersion;
    }

    /**
     * Sets the JDK version for this activity.
     *
     * @param jdkVersion the JDK version to set
     * @throws ActivityException if the JDK version is null or invalid
     */
    public void setJdkVersion(String jdkVersion) throws ActivityException {
        if (jdkVersion == null || !jdkVersion.matches("\\d+(\\.\\d+){0,2}")) {
            throw new ActivityException(ActivityException.INVALID_JDK_VERSION);
        }
        this.jdkVersion = jdkVersion;
    }

    /**
     * Gets the Gradle version used for this activity.
     *
     * @return the Gradle version
     */
    public String getGradleVersion() {
        return gradleVersion;
    }

    /**
     * Sets the Gradle version for this activity.
     *
     * @param gradleVersion the Gradle version to set
     * @throws ActivityException if the Gradle version is null or invalid
     */
    public void setGradleVersion(String gradleVersion) throws ActivityException {
        if (gradleVersion == null || !gradleVersion.matches("\\d+(\\.\\d+){1,2}")) {
            throw new ActivityException(ActivityException.INVALID_GRADLE_VERSION);
        }
        this.gradleVersion = gradleVersion;
    }

    /**
     * Returns a string representation of the Java programming activity.
     *
     * @return a string representation of the activity
     */
    @Override
    public String toString() {
        return "[Java] " + super.toString() + " (jdk-" + jdkVersion + ", gradle v" + gradleVersion + ")";
    }

    /**
     * Creates and returns a copy of this activity.
     *
     * @return a clone of this activity
     * @throws CloneNotSupportedException if the activity cannot be cloned
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
