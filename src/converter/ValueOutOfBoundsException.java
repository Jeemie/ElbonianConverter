package converter;

/**
 * Exception that is thrown when the number has a value that cannot be
 * represented by the Elbonian Numerals.
 *
 * @version April 4, 2016
 */
@SuppressWarnings("serial")
public class ValueOutOfBoundsException extends Exception {

    /**
     * Constructor with a descriptive message for the Exception
     *
     * @param message The descriptive message
     */
    public ValueOutOfBoundsException(String message) {
        super(message);
        }




    }

