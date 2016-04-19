package converter;

/**
 * Created by Jimmy & Rebecca on 4/12/2016.
 */
public class Legality {

    public Legality() {

    }

    /*

    These contains the flags that are used to track how many times the letters appear.

     */
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
     * This method checks whether or not the string is a legitimate string or not.
     *
     * @param astring
     * @return Whether or not the string is a valid Eldonian or Arabic Number
     */
    public boolean eLegal(String astring) {

        //Strips both beginning and ending whitespace.
        astring = astring.replaceAll("^\\s+", "");//Strips off the white spaces at the beginning of the string
        astring = astring.replaceAll("\\s+$", "");//Strips off the white spaces at the end of the string

        //This for loop will iterate through each individual value in the string and does actions depending on the value.
        for (int i = 0; i < astring.length(); i++) {

            //It checks if everything in the string is a number.
            if (astring.matches("[0-9]+") && astring.length() > 0) {

                return true;

            }


            /**
             * START BLOCK1
             * This whole bunch is checking to make sure the letters are legitimate Elbonian Numbers
             *
             */
            //if a Numeral is M
            //Checks how many "M" in a row.
            if (Character.toString(astring.charAt(i)).equals("M") && Mflag < 3) {

                //An uppercase M should not occur after the mM pair of characters
                if (mflag == 1) {
                    return false;
                }
                //Increments flag by 1
                Mflag += 1;

                //When at the end of the string
                //So far the string has not returned false so it must be valid
                if (i == astring.length() - 1) {
                    return true;
                }

                //Goes back to the start of the loop
                continue;
            }

            /**
             * if a Numeral is D
             * Checks how many "D" in a row.
             */
            if (Character.toString(astring.charAt(i)).equals("D") && Dflag < 1) {

                // An uppercase D should not occur after the dD pair of characters which sets dflag=1
                if (dflag == 1) {
                    return false;
                }

                //Increments Dflag by 1
                Dflag += 1;

                //At the end of the string
                //So far the string has not returned false so it must be valid
                if (i == astring.length() - 1) {
                    return true;
                }

                /**
                 * Checks to make sure that no "bigger" numbers follow the "smaller" numbers.
                 * Should happen once we know it is not the last Numeral in the string
                 */
                for (int j = i; j < astring.length(); j++) {
                    if (Character.toString(astring.charAt(j)).equals("M")) {
                        return false;
                    }
                }

                //Goes back to the start of the loop
                continue;
            }

            /**
             * if a Numeral is C
             * Checks how many "C" in a row.
             */
            if (Character.toString(astring.charAt(i)).equals("C") && Cflag < 3) {

                //An uppercase C should not occur after the cC pair of characters
                if (cflag == 1) {
                    return false;
                }

                //Increments Cflag by 1
                Cflag += 1;

                //At the end of the string
                //So far the string has not returned false so it must be valid
                if (i == astring.length() - 1) {
                    return true;
                }

                /**
                 * Checks to make sure that no "bigger" numbers follow the "smaller" numbers.
                 * Should happen once we know it is not the last Numeral in the string
                 */
                for (int j = i; j < astring.length(); j++) {
                    if (Character.toString(astring.charAt(j)).equals("M")) {
                        return false;
                    }
                    if (Character.toString(astring.charAt(j)).equals("D")) {
                        return false;
                    }
                }

                //Goes back to the start of the loop
                continue;
            }

            /**
             *  if a Numeral is L
             *  Checks how many "L" in a row.
             */
            if (Character.toString(astring.charAt(i)).equals("L") && Lflag < 1) {

                //An uppercase L should not occur after the lL pair of characters
                if (lflag == 1) {
                    return false;
                }

                //Increments Lflag by 1
                Lflag += 1;

                //At the end of the string
                //So far the string has not returned false so it must be valid
                if (i == astring.length() - 1) {
                    return true;
                }

                /**
                 * Checks to make sure that no "bigger" numbers follow the "smaller" numbers.
                 * Should happen once we know it is not the last Numeral in the string
                 */
                for (int j = i; j < astring.length(); j++) {
                    if (Character.toString(astring.charAt(j)).equals("M")) {
                        return false;
                    }
                    if (Character.toString(astring.charAt(j)).equals("D")) {
                        return false;
                    }
                    if (Character.toString(astring.charAt(j)).equals("C")) {
                        return false;
                    }
                }
                //Goes back to the start of the loop
                continue;
            }

            /**
             *  if a Numeral is X
             *  Checks how many "X" in a row.
             */
            if (Character.toString(astring.charAt(i)).equals("X") && Xflag < 3) {

                //An uppercase X should not occur after the xX pair of characters
                if (xflag == 1) {
                    return false;
                }

                //Increments Lflag by 1
                Xflag += 1;

                //At the end of the string
                //So far the string has not returned false so it must be valid
                if (i == astring.length() - 1) {
                    return true;
                }

                /**
                 * Checks to make sure that no "bigger" numbers follow the "smaller" numbers.
                 * Should happen once we know it is not the last Numeral in the string
                 */
                for (int j = i; j < astring.length(); j++) {
                    if (Character.toString(astring.charAt(j)).equals("M")) {
                        return false;
                    }
                    if (Character.toString(astring.charAt(j)).equals("D")) {
                        return false;
                    }
                    if (Character.toString(astring.charAt(j)).equals("C")) {
                        return false;
                    }
                    if (Character.toString(astring.charAt(j)).equals("L")) {
                        return false;
                    }
                }

                //Goes back to the start of the loop
                continue;
            }

            /**
             *  if a Numeral is V
             *  Checks how many "V" in a row.
             */
            if (Character.toString(astring.charAt(i)).equals("V") && Vflag < 1) {

                //An uppercase V should not occur after the vV pair of characters
                if (vflag == 1) {
                    return false;
                }
                //Increments Vflag by 1
                Vflag += 1;

                //At the end of the string
                //So far the string has not returned false so it must be valid
                if (i == astring.length() - 1) {
                    return true;
                }

                /**
                 * Checks to make sure that no "bigger" numbers follow the "smaller" numbers.
                 * Should happen once we know it is not the last Numeral in the string
                 */
                for (int j = i; j < astring.length(); j++) {

                    if (Character.toString(astring.charAt(j)).equals("M")) {
                        return false;
                    }

                    if (Character.toString(astring.charAt(j)).equals("D")) {
                        return false;
                    }

                    if (Character.toString(astring.charAt(j)).equals("C")) {
                        return false;
                    }

                    if (Character.toString(astring.charAt(j)).equals("L")) {
                        return false;
                    }

                    if (Character.toString(astring.charAt(j)).equals("X")) {
                        return false;
                    }
                }

                //Goes back to the start of the loop
                continue;
            }

            /**
             *  if a Numeral is I
             *  Checks how many "I" in a row.
             */
            if (Character.toString(astring.charAt(i)).equals("I") && Iflag < 3) {

                //Increments Iflag by 1
                Iflag += 1;

                //At the end of the string
                //So far the string has not returned false so it must be valid
                if (i == astring.length() - 1) {
                    return true;
                }

                /**
                 * Checks to make sure that no "bigger" numbers follow the "smaller" numbers.
                 * Should happen once we know it is not the last Numeral in the string
                 */
                for (int j = i; j < astring.length(); j++) {

                    if (Character.toString(astring.charAt(j)).equals("M")) {
                        return false;
                    }
                    if (Character.toString(astring.charAt(j)).equals("D")) {
                        return false;
                    }
                    if (Character.toString(astring.charAt(j)).equals("C")) {
                        return false;
                    }
                    if (Character.toString(astring.charAt(j)).equals("L")) {
                        return false;
                    }
                    if (Character.toString(astring.charAt(j)).equals("X")) {
                        return false;
                    }
                    if (Character.toString(astring.charAt(j)).equals("V")) {
                        return false;
                    }
                }

                //Goes back to the start of the loop
                continue;
            }

            /**
             * END BLOCK 2
             */


            /**
             * LOWER CASE
             *
             * for Numeral m
             * Ensures that only 1 lowercase m is called within a string
             */
            if (Character.toString(astring.charAt(i)).equals("m") && mflag < 1) {//Ensures that only 1 lowercase m is called

                //If it's the only letter, it's not valid
                if (i == astring.length() - 1) {
                    return false;
                }

                //If the next letter is not the uppercase letter, it is not valid
                //must check first that there is a next letter
                if (!Character.toString(astring.charAt(i + 1)).equals("M")) {
                    return false;
                }

                //Increment mflag by 1
                //Since we know the next letter is "M" we just skip it.
                mflag += 1;
                i += 1;

                //if the next letter is last and valid, then it's valid.
                if (i == astring.length() - 1) {
                    return true;
                }

                //Goes back to the start of the loop
                continue;
            }

            /**
             * for Numeral d
             * Ensures that only 1 lowercase d is called within a string
             */
            if (Character.toString(astring.charAt(i)).equals("d") && dflag < 1) {

                //If it's the only letter, it's not valid
                if (i == astring.length() - 1) {
                    return false;
                }

                //If the next letter is not the uppercase letter, it is not valid
                //must check first that there is a next letter
                if (!Character.toString(astring.charAt(i + 1)).equals("D")) {
                    return false;
                }

                // mMdD is not a valid representation
                // 900 + 400 = 1300 -> MCCC
                if (mflag != 0 ){
                    return false;
                }

                //Increment dflag by 1
                //Since we know the next letter is "D" we just skip it.
                dflag += 1;
                i += 1;

                //if the next letter is last and valid, then it's valid.
                if (i == astring.length() - 1) {
                    return true;
                }

                /**
                 * Checks to make sure that no "bigger" numbers follow the "smaller" numbers.
                 * Should happen once we know it is not the last Numeral in the string
                 */
                for (int j = i; j < astring.length(); j++) {
                    if (Character.toString(astring.charAt(j)).equals("M")) {
                        return false;
                    }
                }

                //Goes back to the start of the loop
                continue;
            }

            /**
             * for Numeral c
             * Ensures that only 1 lowercase c is called within a string
             */
            if (Character.toString(astring.charAt(i)).equals("c") && cflag < 1) {

                //If it's the only letter, it's not valid
                if (i == astring.length() - 1) {
                    return false;
                }

                //If the next letter is not the uppercase letter, it is not valid
                //must check first that there is a next letter
                if (!Character.toString(astring.charAt(i + 1)).equals("C")) {
                    return false;
                }

                //Increment dflag by 1
                //Since we know the next letter is "D" we just skip it.
                cflag += 1;
                i += 1;

                //if the next letter is last and valid, then it's valid.
                if (i == astring.length() - 1) {
                    return true;
                }

                /**
                 * Checks to make sure that no "bigger" numbers follow the "smaller" numbers.
                 * Should happen once we know it is not the last Numeral in the string
                 */
                for (int j = i; j < astring.length(); j++) {
                    if (Character.toString(astring.charAt(j)).equals("M")) {
                        return false;
                    }
                    if (Character.toString(astring.charAt(j)).equals("D")) {
                        return false;
                    }
                }

                //Goes back to the start of the loop
                continue;
            }

            /**
             * for Numeral l
             * Ensures that only 1 lowercase l is called within a string
             */
            if (Character.toString(astring.charAt(i)).equals("l") && lflag < 1) {

                //If it's the only letter, it's not valid
                if (i == astring.length() - 1) {
                    return false;
                }

                //If the next letter is not the uppercase letter, it is not valid
                //must check first that there is a next letter
                if (!Character.toString(astring.charAt(i + 1)).equals("L")) {
                    return false;
                }

                // cClL is not a valid representation
                // 90 + 40 = 130 -> CXXX
                if (cflag != 0 ){
                    return false;
                }

                //Increment lflag by 1
                //Since we know the next letter is "L" we just skip it.
                lflag += 1;
                i += 1;

                //if the next letter is last and valid, then it's valid.
                if (i == astring.length() - 1) {
                    return true;
                }

                /**
                 * Checks to make sure that no "bigger" numbers follow the "smaller" numbers.
                 * Should happen once we know it is not the last Numeral in the string
                 */
                for (int j = i; j < astring.length(); j++) {

                    /**
                     * Check BLOCK2
                     */
                    if (Character.toString(astring.charAt(j)).equals("M")) {
                        return false;
                    }

                    if (Character.toString(astring.charAt(j)).equals("D")) {
                        return false;
                    }

                    if (Character.toString(astring.charAt(j)).equals("C")) {
                        return false;
                    }

                }

                //Goes back to the start of the loop
                continue;
            }

            /**
             * for Numeral x
             * Ensures that only 1 lowercase x is called within a string
             */
            if (Character.toString(astring.charAt(i)).equals("x") && xflag < 1) {

                //If it's the only letter, it's not valid
                if (i == astring.length() - 1) {
                    return false;
                }

                //If the next letter is not the uppercase letter, it is not valid
                //must check first that there is a next letter
                if (!Character.toString(astring.charAt(i + 1)).equals("X")) {
                    return false;
                }

                //Increment xflag by 1
                //Since we know the next letter is "X" we just skip it.
                xflag += 1;
                i += 1;

                //if the next letter is last and valid, then it's valid.
                if (i == astring.length() - 1) {
                    return true;
                }

                /**
                 * Checks to make sure that no "bigger" numbers follow the "smaller" numbers.
                 * Should happen once we know it is not the last Numeral in the string
                 */
                for (int j = i; j < astring.length(); j++) {
                    if (Character.toString(astring.charAt(j)).equals("M")) {
                        return false;
                    }
                    if (Character.toString(astring.charAt(j)).equals("D")) {
                        return false;
                    }
                    if (Character.toString(astring.charAt(j)).equals("C")) {
                        return false;
                    }
                    if (Character.toString(astring.charAt(j)).equals("L")) {
                        return false;
                    }
                }

                //Goes back to the start of the loop
                continue;
            }

            /**
             * for Numeral v
             * Ensures that only 1 lowercase v is called within a string
             */
            if (Character.toString(astring.charAt(i)).equals("v") && vflag < 1) {

                //If it's the only letter, it's not valid
                if (i == astring.length() - 1) {
                    return false;
                }

                //If the next letter is not the uppercase letter, it is not valid
                //must check first that there is a next letter
                if (!Character.toString(astring.charAt(i + 1)).equals("V")) {
                    return false;
                }

                // xXvV is not a valid representation
                // 9 + 4 = 13 -> XIII
                if (xflag != 0 ){
                    return false;
                }

                //Increment vflag by 1
                //Since we know the next letter is "V" we just skip it.
                vflag += 1;
                i += 1;

                //if the next letter is last and valid, then it's valid.
                if (i == astring.length() - 1) {
                    return true;
                }

                /**
                 * Checks to make sure that no "bigger" numbers follow the "smaller" numbers.
                 * Should happen once we know it is not the last Numeral in the string
                 */
                for (int j = i; j < astring.length(); j++) {
                    if (Character.toString(astring.charAt(j)).equals("M")) {
                        return false;
                    }
                    if (Character.toString(astring.charAt(j)).equals("D")) {
                        return false;
                    }
                    if (Character.toString(astring.charAt(j)).equals("C")) {
                        return false;
                    }
                    if (Character.toString(astring.charAt(j)).equals("L")) {
                        return false;
                    }
                    if (Character.toString(astring.charAt(j)).equals("X")) {
                        return false;
                    }
                }

            }

            /**
             * This returns false when it hits none of these, meaning it is NOT valid
             * Also does whitespace.
             */
            else {
                return false;
            }

        }
        /**
         * This returns false when it hits none of these, meaning it is NOT valid
         */
        return false;
    }

}
