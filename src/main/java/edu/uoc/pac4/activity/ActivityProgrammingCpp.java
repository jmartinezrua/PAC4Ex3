package edu.uoc.pac4.activity;

/**
 * Class representing a C++ programming activity.
 */
public class ActivityProgrammingCpp extends ActivityProgramming {

    private String compiler;
    private String standard;

    /**
     * Constructs a new C++ programming activity with the specified parameters.
     *
     * @param name the name of the activity
     * @param description the description of the activity
     * @param weight the weight of the activity
     * @param compiler the C++ compiler to use
     * @param standard the C++ standard to follow
     * @throws ActivityException if any parameter is invalid
     */
    public ActivityProgrammingCpp(String name, String description, double weight, String compiler, String standard) throws ActivityException {
        super(name, description, weight);
        setCompiler(compiler);
        setStandard(standard);
    }

    /**
     * Gets the C++ compiler used for this activity.
     *
     * @return the compiler
     */
    public String getCompiler() {
        return compiler;
    }

    /**
     * Sets the C++ compiler for this activity.
     *
     * @param compiler the compiler to set
     * @throws ActivityException if the compiler is null, empty, or blank
     */
    public void setCompiler(String compiler) throws ActivityException {
        if (compiler == null || compiler.trim().isEmpty()) {
            throw new ActivityException(ActivityException.INVALID_CPP_COMPILER);
        }
        this.compiler = compiler.trim();
    }

    /**
     * Gets the C++ standard used for this activity.
     *
     * @return the standard
     */
    public String getStandard() {
        return standard;
    }

    /**
     * Sets the C++ standard for this activity.
     *
     * @param standard the standard to set
     * @throws ActivityException if the standard is null, empty, or blank
     */
    public void setStandard(String standard) throws ActivityException {
        if (standard == null || standard.trim().isEmpty()) {
            throw new ActivityException(ActivityException.INVALID_CPP_STANDARD);
        }
        this.standard = standard.trim();
    }

    /**
     * Returns a string representation of the C++ programming activity.
     *
     * @return a string representation of the activity
     */
    @Override
    public String toString() {
        return "[C++] " + super.toString() + " (" + getCompiler() + ", " + getStandard() + ")";
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
