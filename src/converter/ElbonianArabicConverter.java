package converter;

/**
 * This class implements a converter that takes a string that represents a
 * number in either Elbonian or Arabic numeral form and offers methods that will
 * return either the integer value or a string representing the value in Elbonian
 * numeral form.
 *
 * @version April 4, 2016
 */
public class ElbonianArabicConverter {


    private String value;
    private Legality legal;

    /**
     * Constructor that takes in a string. The string should contain either a
     * valid Elbonian numeral or a valid Arabic numeral. The string can have
     * leading and/or trailing spaces. There are no spaces within the actual
     * number characters. If the string represents an Arabic number, it may be
     * positive or negative. It will never be larger than a value that can fit
     * into an int.
     *
     * @param value The string representing the Elbonian or Arabic number.
     * @throws MalformedNumberException if the string (less leading and trailing
     *                                  spaces) does not represent a valid Elbonian or Arabic number.
     *                                  <p>
     *                                  NOTE: an Arabic number may be out of the acceptable range and
     *                                  will still be accepted by this constructor.
     */
    public ElbonianArabicConverter(String value) throws MalformedNumberException {

        this.value = value;
        legal = new Legality();
    }



/*    public void main(String[] args) throws MalformedNumberException {
        System.out.println("Hello World!"); // Display the string.
        String ET1 = "M";
        int ET1I = ET1.toArabic();

        System.out.println(ET1I);

    }*/

    /**
     * Returns the value of this object as an Arabic number.
     *
     * @return The integer value of the number
     */
    public int toArabic() throws MalformedNumberException {


        /**
         * Makes sure it's a valid Elbonian String
         */
        if (!legal.eLegal(this.value)) {
            throw new MalformedNumberException("This is not a valid Elbonian string");
        }


        int sum = 0;//Isn't this obvious?


        /**
         * Adds the values depending on what the letters are.
         */
        for (int i = 0; i < value.length(); i++) {
            if (Character.toString(value.charAt(i)).equals("M")) {
                sum += 1000;
            }
            if (Character.toString(value.charAt(i)).equals("D")) {
                sum += 500;
            }
            if (Character.toString(value.charAt(i)).equals("C")) {
                sum += 100;
            }
            if (Character.toString(value.charAt(i)).equals("L")) {
                sum += 50;
            }
            if (Character.toString(value.charAt(i)).equals("X")) {
                sum += 10;
            }
            if (Character.toString(value.charAt(i)).equals("V")) {
                sum += 5;
            }
            if (Character.toString(value.charAt(i)).equals("I")) {
                sum += 1;
            }
            if (Character.toString(value.charAt(i)).equals("m")) {
                sum += 900;
                i += 1;
            }
            if (Character.toString(value.charAt(i)).equals("d")) {
                sum += 400;
                i += 1;
            }
            if (Character.toString(value.charAt(i)).equals("c")) {
                sum += 90;
                i += 1;
            }
            if (Character.toString(value.charAt(i)).equals("l")) {
                sum += 40;
                i += 1;
            }
            if (Character.toString(value.charAt(i)).equals("x")) {
                sum += 9;
                i += 1;
            }
            if (Character.toString(value.charAt(i)).equals("v")) {
                sum += 4;
                i += 1;
            }
        }

        return sum; //What do you think?

    }

    /**
     * Returns the value of this object as an Elbonian Numeral
     *
     * @return
     * @throws ValueOutOfBoundsException if the number is too small or too large
     *                                   to be represented using Roman numerals
     */
    public String toElbonian() throws ValueOutOfBoundsException {

        if (Integer.parseInt(value) > 3888) {
            throw new ValueOutOfBoundsException("This number is too large to be comprehended by the Elbonians. \n" +
                    "They are a simple people with few resources.");
        }

        if (Integer.parseInt(value) < 1) {
            throw new ValueOutOfBoundsException("This number is too small to be comprehended by the Elbonians. \n" +
                    "They are a simple people with few resources.");
        }

        if (!legal.eLegal(this.value)) {
            throw new ValueOutOfBoundsException("This number is too large to be comprehended by the Elbonians. \n" +
                    "They are a simple people with few resources.");
        }

        int remainder = Integer.parseInt(value);

        String Elbonian = "";


        while (remainder > 0) {
            if (remainder >= 1000) {
                remainder -= 1000;
                Elbonian = Elbonian + "M";
                continue;
            }
            if (remainder >= 900) {
                remainder -= 900;
                Elbonian = Elbonian + "mM";
                continue;
            }
            if (remainder >= 500) {
                remainder -= 500;
                Elbonian = Elbonian + "D";
                continue;
            }
            if (remainder >= 400) {
                remainder -= 400;
                Elbonian = Elbonian + "dD";
                continue;
            }
            if (remainder >= 100) {
                remainder -= 100;
                Elbonian = Elbonian + "C";
                continue;
            }
            if (remainder >= 90) {
                remainder -= 90;
                Elbonian = Elbonian + "cC";
                continue;
            }
            if (remainder >= 50) {
                remainder -= 50;
                Elbonian = Elbonian + "L";
                continue;
            }
            if (remainder >= 40) {
                remainder -= 40;
                Elbonian = Elbonian + "lL";
                continue;
            }
            if (remainder >= 10) {
                remainder -= 10;
                Elbonian = Elbonian + "X";
                continue;
            }
            if (remainder >= 9) {
                remainder -= 9;
                Elbonian = Elbonian + "xX";
                continue;
            }
            if (remainder >= 5) {
                remainder -= 5;
                Elbonian = Elbonian + "V";
                continue;
            }
            if (remainder >= 4) {
                remainder -= 4;
                Elbonian = Elbonian + "vV";
                continue;
            }
            if (remainder >= 1) {
                remainder -= 1;
                Elbonian = Elbonian + "I";
                continue;
            }


        }

        return Elbonian;

    }
}