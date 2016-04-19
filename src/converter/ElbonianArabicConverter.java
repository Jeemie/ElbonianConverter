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
    int Mflag = 0;
    int Dflag = 0;
    int Cflag = 0;
    int Lflag = 0;
    int Xflag = 0;
    int Vflag = 0;
    int Iflag = 0;
    int mflag = 0;
    int dflag = 0;
    int cflag = 0;
    int lflag = 0;
    int xflag = 0;
    int vflag = 0;

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


    /**
     * Returns the value of this object as an Arabic number.
     *
     * @return The integer value of the number
     */
    public int toArabic() throws MalformedNumberException, ValueOutOfBoundsException {


        /**
         * Makes sure it's a valid Elbonian String
         */
        if (!legal.eLegal(this.value)) {
            throw new MalformedNumberException("This is not a valid Elbonian string");
        }


        //It checks if everything in the string is a number.
        if (value.matches("[0-9]+") && value.length() > 0) {

            int answer = Integer.parseInt(value);

            if (answer > 4887) {
                throw new ValueOutOfBoundsException("This number is too high to be comprehended by the Elbonians. \n" +
                        "They are a simple people with few resources.");
            }

            if (answer < 1) {
                throw new ValueOutOfBoundsException("This number is too low to be comprehended by the Elbonians. \n" +
                        "They are a simple people with few resources.");
            }


            return answer;

        }

        int sum = 0;

        /**
         * Adds the values depending on what the letters are.
         */
        for (int i = 0; i < value.length(); i++) {
            // if (Character.toString(value.charAt(i)).equals("M")) {
            switch (value.charAt(i)) {

                case 'M':
                    sum += 1000;
                    continue;

                case 'D':
                    sum += 500;
                    continue;

                case 'C':
                    sum += 100;
                    continue;

                case 'L':
                    sum += 50;
                    continue;

                case 'X':
                    sum += 10;
                    continue;

                case 'V':
                    sum += 5;
                    continue;

                case 'I':
                    sum += 1;
                    continue;

                case 'm':
                    sum += 900;
                    i += 1;
                    continue;

                case 'd':
                    sum += 400;
                    i += 1;
                    continue;

                case 'c':
                    sum+= 90;
                    i += 1;
                    continue;

                case 'l':
                    sum += 40;
                    i += 1;
                    continue;

                case 'x':
                    sum += 9;
                    i +=1;
                    continue;

                case 'v':
                    sum += 4;
                    i +=1;
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
    public String toElbonian() throws ValueOutOfBoundsException, MalformedNumberException {

        //It checks if everything in the string is a number.


        if (!legal.eLegal(this.value)) {

            if (value.matches("[0-9]+") && value.length() > 0) {
                throw new ValueOutOfBoundsException("This is not valid enough to be comprehended by the Elbonians. \n" +
                        "They are a simple people with few resources.");
            } else {
                throw new MalformedNumberException("This is a Malformed Number");
            }
        }


        String Elbonian = "";


        if (value.matches("[0-9]+") && value.length() > 0) {

            int remainder = Integer.parseInt(value);

            if (remainder > 4887) {
                throw new ValueOutOfBoundsException("This number is too high to be comprehended by the Elbonians. \n" +
                        "They are a simple people with few resources.");
            }

            if (remainder < 1) {
                throw new ValueOutOfBoundsException("This number is too low to be comprehended by the Elbonians. \n" +
                        "They are a simple people with few resources.");
            }


            while (remainder > 0) {
                if (remainder >= 1000 && Mflag < 3) {
                    remainder -= 1000;
                    Elbonian = Elbonian + "M";
                    Mflag += 1;
                    continue;
                }
                if (remainder >= 900 && mflag < 1) {
                    remainder -= 900;
                    Elbonian = Elbonian + "mM";
                    mflag += 1;
                    continue;
                }
                if (remainder >= 500 && Dflag < 1) {
                    remainder -= 500;
                    Elbonian = Elbonian + "D";
                    Dflag += 1;
                    continue;
                }
                if (remainder >= 400 && Dflag < 1) {
                    remainder -= 400;
                    Elbonian = Elbonian + "dD";
                    continue;
                }
                if (remainder >= 100 && Cflag < 3) {
                    remainder -= 100;
                    Elbonian = Elbonian + "C";
                    Cflag += 1;
                    continue;
                }
                if (remainder >= 90 && cflag < 1) {
                    remainder -= 90;
                    Elbonian = Elbonian + "cC";
                    cflag += 1;
                    continue;
                }
                if (remainder >= 50 & Lflag < 1) {
                    remainder -= 50;
                    Elbonian = Elbonian + "L";
                    Lflag += 1;
                    continue;
                }
                if (remainder >= 40 & Lflag < 1) {
                    remainder -= 40;
                    Elbonian = Elbonian + "lL";
                    continue;
                }
                if (remainder >= 10 && Xflag < 3) {
                    remainder -= 10;
                    Elbonian = Elbonian + "X";
                    Xflag += 1;
                    continue;
                }
                if (remainder >= 9 && xflag < 1) {
                    remainder -= 9;
                    Elbonian = Elbonian + "xX";
                    continue;
                }
                if (remainder >= 5 && Vflag < 1) {
                    remainder -= 5;
                    Elbonian = Elbonian + "V";
                    Vflag += 1;
                    continue;
                }
                if (remainder >= 4 & Vflag < 1) {
                    remainder -= 4;
                    Elbonian = Elbonian + "vV";
                    continue;
                }
                if (remainder >= 1) {
                    remainder -= 1;
                    Elbonian = Elbonian + "I";
                }


            }

            return Elbonian;
        }

        return value;
    }

}