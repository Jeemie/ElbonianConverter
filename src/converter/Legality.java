package converter;

/**
 * Created by Jimmy on 4/12/2016.
 */
public class Legality {

    public Legality() {

    }


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
    int i = 0;

    public boolean eLegal(String astring) {

        astring = astring.replaceAll("^\\s+", "");
        astring = astring.replaceAll("\\s+$", "");
        for (int i = 0; i < astring.length(); i++) {


            if (Character.toString(astring.charAt(i)).equals(".")) {
                return false;
            }

            if (Character.toString(astring.charAt(i)).equals("-")) {
                return false;
            }


            if (astring.matches("[0-9]+") && astring.length() > 0) {

                return true;

            }


            if (Character.toString(astring.charAt(i)).equals("M") && Mflag < 4) {

                System.out.println("I reached M");


                if (mflag == 1) {
                    return false;
                }
                Mflag += 1;


                if (i == astring.length() - 1) {
                    return true;
                }

                if (Character.toString(astring.charAt(i + 1)).equals(" ")) {
                    return false;
                }

                continue;
            }
            if (Character.toString(astring.charAt(i)).equals("D") && Dflag < 1) {

                Dflag += 1;
                System.out.println("I reached D");


                for (int j = i; j < astring.length(); j++) {

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
            if (Character.toString(astring.charAt(i)).equals("C") && Cflag < 4) {

                Cflag += 1;
                System.out.println("I reached C");

                for (int j = i; j < astring.length(); j++) {

                    if (Character.toString(astring.charAt(j)).equals("M")) {
                        return false;
                    }

                    if (Character.toString(astring.charAt(j)).equals("D")) {
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

                Lflag += 1;
                System.out.println("I reached L");

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

                if (i == astring.length() - 1) {
                    return true;
                }

                if (Character.toString(astring.charAt(i + 1)).equals(" ")) {
                    return false;
                }

                continue;
            }
            if (Character.toString(astring.charAt(i)).equals("X") && Xflag < 4) {

                Xflag += 1;
                System.out.println("I reached X");

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

                if (i == astring.length() - 1) {
                    return true;
                }

                if (Character.toString(astring.charAt(i + 1)).equals(" ")) {
                    return false;
                }

                continue;
            }
            if (Character.toString(astring.charAt(i)).equals("V") && Vflag < 1) {

                Vflag += 1;
                System.out.println("I reached V");

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


                if (i == astring.length() - 1) {
                    return true;
                }

                if (Character.toString(astring.charAt(i + 1)).equals(" ")) {
                    return false;
                }

                continue;
            }
            if (Character.toString(astring.charAt(i)).equals("I") && Iflag < 4) {

                Iflag += 1;
                System.out.println("I reached I");

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

                if (i == astring.length() - 1) {
                    return true;
                }

                if (Character.toString(astring.charAt(i + 1)).equals(" ")) {
                    return false;
                }

                continue;
            }


            if (Character.toString(astring.charAt(i)).equals("m") && mflag < 1) {

                if (i == astring.length() - 1) {
                    return false;
                }
                if (!Character.toString(astring.charAt(i + 1)).equals("M")) {
                    return false;
                }


                mflag += 1;
                i += 1;
                System.out.println("I reached m");
                if (i == astring.length() - 1) {
                    return true;
                }

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

                dflag += 1;
                i += 1;
                System.out.println("I reached d");
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
                System.out.println("I reached c");
                if (i == astring.length() - 1) {
                    return true;
                }
                if (Character.toString(astring.charAt(i + 1)).equals(" ")) {
                    return false;
                }

                continue;
            }
            if (Character.toString(astring.charAt(i)).equals("l") && Lflag < 1) {

                if (i == astring.length() - 1) {
                    return false;
                }
                if (!Character.toString(astring.charAt(i + 1)).equals("L")) {
                    return false;
                }

                lflag += 1;
                i += 1;
                System.out.println("I reached l");
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
                System.out.println("I reached x");
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

                vflag += 1;
                i += 1;
                System.out.println("I reached v");
                if (i == astring.length() - 1) {
                    return true;
                }

                if (Character.toString(astring.charAt(i + 1)).equals(" ")) {
                    return false;
                }
                continue;
            }
            else{
                return false;
            }


        }


        return false;
    }

}
