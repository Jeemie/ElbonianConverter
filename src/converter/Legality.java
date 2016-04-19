package converter;

/**
 * Created by Jimmy on 4/12/2016.
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
            if (Character.toString(astring.charAt(i)).equals("M") && Mflag < 3) {//Makes sure there isn't 4 "M" in a row.

                //System.out.println("I reached M"); //Debug


                if (mflag == 1) { //An uppercase letter should not be 2 past the lowercase. This flag set in "m" statements.
                    return false;
                }
                Mflag += 1; //Increments flag by 1


                if (i == astring.length() - 1) { //If last value in the string, ends.
                    return true;
                }

                //No spaces allowed in between letters.
                if (Character.toString(astring.charAt(i + 1)).equals(" ")) {
                    return false;
                }

                continue; //Goes back to the start of the loop
            }

            //Same as M. Look at that . Geez. I don't have time to write all these comments.
            if (Character.toString(astring.charAt(i)).equals("D") && Dflag < 1) {

                if (dflag == 1) { //An uppercase letter should not be 2 past the lowercase. This flag set in "m" statements.
                    return false;
                }
                Dflag += 1;
                //System.out.println("I reached D");


                /**
                 * START BLOCK2
                 * Starting from here, it checks to make sure that no "bigger" numbers follow the "smaller" numbers.
                 */
                for (int j = i; j < astring.length(); j++) {
                    /**
                     * Example for Block 2
                     */
                    if (Character.toString(astring.charAt(j)).equals("M")) {
                        return false;
                    }
                }


                if (i == astring.length() - 1) {
                    return true;
                }

                if (Character.toString(astring.charAt(i + 1)).equals(" ")) {
                    return false;
                }

                continue;
            }
            if (Character.toString(astring.charAt(i)).equals("C") && Cflag < 3) {

                if (cflag == 1) { //An uppercase letter should not be 2 past the lowercase. This flag set in "m" statements.
                    return false;
                }
                Cflag += 1;
                //System.out.println("I reached C"); debug

                for (int j = i; j < astring.length(); j++) {
                    /**
                     * Check BLOCK2
                     */
                    switch (astring.charAt(j)) {

                        case 'M':
                            return false;

                        case 'D':
                            return false;
                    }
                }

                if (i == astring.length() - 1) {
                    return true;
                }

                if (Character.toString(astring.charAt(i + 1)).equals(" ")) {
                    return false;
                }

                continue;
            }
            if (Character.toString(astring.charAt(i)).equals("L") && Lflag < 1) {

                if (lflag == 1) { //An uppercase letter should not be 2 past the lowercase. This flag set in "m" statements.
                    return false;
                }
                Lflag += 1;
                // System.out.println("I reached L"); debug

                for (int j = i; j < astring.length(); j++) {

                    /**
                     * Check BLOCK2
                     */
                    switch (astring.charAt(j)) {

                        case 'M':
                            return false;

                        case 'D':
                            return false;

                        case 'C':
                            return false;
                    }
                }

                if (i == astring.length() - 1) {
                    return true;
                }

                if (Character.toString(astring.charAt(i + 1)).equals(" ")) {
                    return false;
                }

                continue;
            }
            if (Character.toString(astring.charAt(i)).equals("X") && Xflag < 3) {

                if (xflag == 1) { //An uppercase letter should not be 2 past the lowercase. This flag set in "m" statements.
                    return false;
                }
                Xflag += 1;
                // System.out.println("I reached X"); debug

                for (int j = i; j < astring.length(); j++) {

                    /**
                     * Check BLOCK2
                     */
                    switch (astring.charAt(j)) {

                        case 'M':
                            return false;

                        case 'D':
                            return false;

                        case 'C':
                            return false;

                        case 'L':
                            return false;
                    }
                }

                if (i == astring.length() - 1) {
                    return true;
                }

                if (Character.toString(astring.charAt(i + 1)).equals(" ")) {
                    return false;
                }

                continue;
            }
            if (Character.toString(astring.charAt(i)).equals("V") && Vflag < 1) {

                if (vflag == 1) { //An uppercase letter should not be 2 past the lowercase. This flag set in "m" statements.
                    return false;
                }
                Vflag += 1;
                //    System.out.println("I reached V"); debug

                for (int j = i; j < astring.length(); j++) {

                    /**
                     * Check BLOCK2
                     */
                    switch (astring.charAt(j)) {

                        case 'M':
                            return false;

                        case 'D':
                            return false;

                        case 'C':
                            return false;

                        case 'L':
                            return false;

                        case 'X':
                            return false;
                    }
                }


                if (i == astring.length() - 1) {
                    return true;
                }

                if (Character.toString(astring.charAt(i + 1)).equals(" ")) {
                    return false;
                }

                continue;
            }
            if (Character.toString(astring.charAt(i)).equals("I") && Iflag < 3) {

                Iflag += 1;
                //System.out.println("I reached I"); debug

                for (int j = i; j < astring.length(); j++) {

                    /**
                     * Check BLOCK2
                     */
                    switch (astring.charAt(j)) {

                        case 'M':
                            return false;

                        case 'D':
                            return false;

                        case 'C':
                            return false;

                        case 'L':
                            return false;

                        case 'X':
                            return false;

                        case 'V':
                            return false;
                    }
                }

                if (i == astring.length() - 1) {
                    return true;
                }

                if (Character.toString(astring.charAt(i + 1)).equals(" ")) {
                    return false;
                }

                continue;
            }

            /**
             * END BLOCK 2
             */


            /**
             * START BLOCK 3
             * These deal with when a lowercase letter is found
             *
             */
            if (Character.toString(astring.charAt(i)).equals("m") && mflag < 1) {//Ensures that only 1 lowercase m is called

                //If it's the only letter, it's not valid
                if (i == astring.length() - 1) {
                    return false;
                }
                //If the next letter is not the uppercase letter, it is not valid
                if (!Character.toString(astring.charAt(i + 1)).equals("M")) {
                    return false;
                }


                mflag += 1;
                i += 1; //Since we know the next letter is "M" we just skip it.

                //System.out.println("I reached m"); debug

                if (i == astring.length() - 1) { //if the next letter is last and valid, then it's valid.
                    return true;
                }

                //If the next is a white space, it is NOT valid.
                if (Character.toString(astring.charAt(i + 1)).equals(" ")) {
                    return false;
                }

                continue;
            }
            if (Character.toString(astring.charAt(i)).equals("d") && dflag < 1) {

                if (i == astring.length() - 1) {
                    return false;
                }
                if (!Character.toString(astring.charAt(i + 1)).equals("D")) {
                    return false;
                }

                if (mflag == 1) {
                    return false;
                }

                dflag += 1;
                i += 1;
                // System.out.println("I reached d"); debug

                for (int j = i; j < astring.length(); j++) {

                    /**
                     * Check BLOCK2
                     */
                    if (Character.toString(astring.charAt(j)).equals("M")) {
                        return false;
                    }
                }

                if (i == astring.length() - 1) {
                    return true;
                }

                if (Character.toString(astring.charAt(i + 1)).equals(" ")) {
                    return false;
                }


                continue;

            }
            if (Character.toString(astring.charAt(i)).equals("c") && cflag < 1) {

                if (i == astring.length() - 1) {
                    return false;
                }
                if (!Character.toString(astring.charAt(i + 1)).equals("C")) {
                    return false;
                }

                cflag += 1;
                i += 1;
                // System.out.println("I reached c"); debug

                for (int j = i; j < astring.length(); j++) {

                    /**
                     * Check BLOCK2
                     */
                    switch (astring.charAt(j)) {

                        case 'M':
                            return false;

                        case 'D':
                            return false;
                    }

                }

                if (i == astring.length() - 1) {
                    return true;
                }
                if (Character.toString(astring.charAt(i + 1)).equals(" ")) {
                    return false;
                }

                continue;
            }
            if (Character.toString(astring.charAt(i)).equals("l") && lflag < 1) {

                if (i == astring.length() - 1) {
                    return false;
                }
                if (!Character.toString(astring.charAt(i + 1)).equals("L")) {
                    return false;
                }

                if (cflag == 1) {
                    return false;
                }
                lflag += 1;
                i += 1;
                //System.out.println("I reached l");debug

                for (int j = i; j < astring.length(); j++) {

                    /**
                     * Check BLOCK2
                     */
                    switch (astring.charAt(j)) {

                        case 'M':
                            return false;

                        case 'D':
                            return false;

                        case 'C':
                            return false;

                    }

                }

                if (i == astring.length() - 1) {
                    return true;
                }

                if (Character.toString(astring.charAt(i + 1)).equals(" ")) {
                    return false;
                }

                continue;
            }
            if (Character.toString(astring.charAt(i)).equals("x") && xflag < 1) {

                if (i == astring.length() - 1) {
                    return false;
                }
                if (!Character.toString(astring.charAt(i + 1)).equals("X")) {
                    return false;
                }

                xflag += 1;
                i += 1;
                //System.out.println("I reached x");debug

                for (int j = i; j < astring.length(); j++) {

                    /**
                     * Check BLOCK2
                     */
                    switch (astring.charAt(j)) {

                        case 'M':
                            return false;

                        case 'D':
                            return false;

                        case 'C':
                            return false;

                        case 'L':
                            return false;
                    }
                }

                if (i == astring.length() - 1) {
                    return true;
                }

                if (Character.toString(astring.charAt(i + 1)).equals(" ")) {
                    return false;
                }
                continue;
            }
            if (Character.toString(astring.charAt(i)).equals("v") && vflag < 1) {

                if (i == astring.length() - 1) {
                    return false;
                }
                if (!Character.toString(astring.charAt(i + 1)).equals("V")) {
                    return false;
                }

                if (xflag == 1) {
                    return false;
                }

                vflag += 1;
                i += 1;
                // System.out.println("I reached v");debug

                for (int j = i; j < astring.length(); j++) {

                    /**
                     * Check BLOCK2
                     */

                    switch (astring.charAt(j)) {

                        case 'M':
                            return false;

                        case 'D':
                            return false;

                        case 'C':
                            return false;

                        case 'L':
                            return false;

                        case 'X':
                            return false;
                    }

                }

                if (i == astring.length() - 1) {
                    return true;
                }

                if (Character.toString(astring.charAt(i + 1)).equals(" ")) {
                    return false;
                }
                continue;
            }
            /**
             * END BLOCK3
             */

            /**
             * This returns false when it hits none of these, meaning it is NOT valid
             */
            else {
                return false;
            }

            /**
             * END BLOCK1
             */

        }


        return false;
    }

}
