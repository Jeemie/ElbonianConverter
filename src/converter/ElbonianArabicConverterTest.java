package converter;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by Jimmy on 4/12/2016.
 */
public class ElbonianArabicConverterTest {

    private ElbonianArabicConverter mainclass;
    private ElbonianArabicConverter maxclass;
    private ElbonianArabicConverter badclass;
    private Legality legalcheck;


    private ElbonianArabicConverter numClass;
    private ElbonianArabicConverter numBadClass;
    private ElbonianArabicConverter numClass2;


    @org.junit.Before
    public void setUp() throws Exception {

        mainclass = new ElbonianArabicConverter("MM");
        maxclass = new ElbonianArabicConverter("MMMDCCCLXXXVIII");
        legalcheck = new Legality();
        badclass = new ElbonianArabicConverter("MmMm");
        numClass = new ElbonianArabicConverter("4887");


    }

    @org.junit.After
    public void tearDown() throws Exception {

    }


    /**
     * START TESTELBONIAN
     * These test Elbonian methods
     *
     */


    @Test
    public void toArabic1() throws Exception {

        int answer = mainclass.toArabic();
        Assert.assertEquals(answer, 2000);

    }

    @Test
    public void tooManyOfOneLetter() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MMMM"), false);
        Assert.assertEquals(legalcheck.eLegal("CCCC"), false);
        Assert.assertEquals(legalcheck.eLegal("XXXX"), false);
        Assert.assertEquals(legalcheck.eLegal("IIII"), false);

    }

    @Test
    public void threeLetters() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MMM"), true);
        Assert.assertEquals(legalcheck.eLegal("CCC"), true);
        Assert.assertEquals(legalcheck.eLegal("XXX"), true);
        Assert.assertEquals(legalcheck.eLegal("III"), true);



    }

    @Test
    public void avalidOne() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MMMDCLXVI"), true);

    }

    @Test
    public void avalidOne2() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MMMmMcCxX"), true);

    }

    @Test
    public void anotherValidOne() throws Exception{

        Assert.assertEquals(legalcheck.eLegal("MMdDClLXvV"), true);

    }


    @Test
    public void notAValidOne() throws Exception {
        Assert.assertEquals(legalcheck.eLegal("mMdDcClLxXvVI"), false);

    }


    @Test
    public void consecLower() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("Mmm"), false);
        Assert.assertEquals(legalcheck.eLegal("dd"), false);
        Assert.assertEquals(legalcheck.eLegal("CccC"), false);
        Assert.assertEquals(legalcheck.eLegal("ll"), false);
        Assert.assertEquals(legalcheck.eLegal("Xxx"), false);
        Assert.assertEquals(legalcheck.eLegal("vv"), false);

    }

    @Test
    public void consecLower2() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MMdDccC"), false);


    }


    @Test
    public void multiLowerCase() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MmMm"), false);
        Assert.assertEquals(legalcheck.eLegal("cCcC"), false);
        Assert.assertEquals(legalcheck.eLegal("xXxX"), false);

    }

    @Test
    public void singleLetterAllowed() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("DD"), false);
        Assert.assertEquals(legalcheck.eLegal("VV"), false);
        Assert.assertEquals(legalcheck.eLegal("LL"), false);



    }


    @Test
    public void singleLetterAllowed2() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MMmMCCcCXXVV"), false);


    }

    @Test
    public void inOrder() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MMMXXV"), true);


    }

    @Test
    public void inOrder2() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MlLvVI"), true);


    }

    @Test
    public void outOfOrder() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("DM"), false);


    }

    @Test
    public void outOfOrder2() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MMMDVX"), false);


    }

    @Test
    public void outOfOrder3() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MMmMDvVX"), false);


    }

    @Test
    public void outOfOrderWithLowerCase() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MMDm"), false);
        Assert.assertEquals(legalcheck.eLegal("lLvVX"), false);


    }

    @Test
    public void wrongLetterAfterLower() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MmD"), false);
        Assert.assertEquals(legalcheck.eLegal("DxV"), false);
        Assert.assertEquals(legalcheck.eLegal("cL"), false);
        Assert.assertEquals(legalcheck.eLegal("lX"), false);


    }

    @Test
    public void singleLower() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("m"), false);
        Assert.assertEquals(legalcheck.eLegal("d"), false);
        Assert.assertEquals(legalcheck.eLegal("c"), false);
        Assert.assertEquals(legalcheck.eLegal("l"), false);
        Assert.assertEquals(legalcheck.eLegal("x"), false);
        Assert.assertEquals(legalcheck.eLegal("v"), false);
        Assert.assertEquals(legalcheck.eLegal("i"), false);



    }


    @Test
    public void maxIs4887() throws Exception {

        maxclass = new ElbonianArabicConverter("MMMmMDCCCcCLXXXxXVIII");
        Assert.assertEquals(maxclass.toArabic(), 4887);

    }

    @Test(expected = MalformedNumberException.class)
    public void badLetterExceptionTest() throws Exception {

        badclass.toArabic();

    }

    @Test
    public void noRepeatCapAfterLower() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MmMM"), false);
        Assert.assertEquals(legalcheck.eLegal("lLL"), false);

    }


    @Test
    public void noRepeatCapAfterLower2() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MMMDCCCLxXX"), false);

    }

    @Test
    public void whiteSpaces() throws Exception {

        Assert.assertEquals(legalcheck.eLegal(" M mM "), false);
        Assert.assertEquals(legalcheck.eLegal(" C cC "), false);
        Assert.assertEquals(legalcheck.eLegal(" Xx X "), false);
        Assert.assertEquals(legalcheck.eLegal(" I I I "), false);
        Assert.assertEquals(legalcheck.eLegal(" D "), true);
        Assert.assertEquals(legalcheck.eLegal(" vV"), true);

    }


    @Test
    public void negativeSignInEldonian() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("-MMM"), false);
        Assert.assertEquals(legalcheck.eLegal("CC-C"), false);
        Assert.assertEquals(legalcheck.eLegal("X-XX"), false);
        Assert.assertEquals(legalcheck.eLegal("III-"), false);

    }

    @Test
    public void badLetter() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MMA"), false);
        Assert.assertEquals(legalcheck.eLegal("ACC"), false);
        Assert.assertEquals(legalcheck.eLegal("DAX"), false);

    }

    @Test
    public void lowerCaseI() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("i"), false);

    }

    @Test
    public void onlyI() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("I"), true);

    }

    @Test
    public void elbodianToArabicAndBack() throws Exception {

        mainclass = new ElbonianArabicConverter("dDlLvV");

        int answer = mainclass.toArabic();

        String answer2 = Integer.toString(answer);

        ElbonianArabicConverter mainclass2 = new ElbonianArabicConverter(answer2);

        String answer3 = mainclass2.toElbonian();

        Assert.assertEquals(answer3, "dDlLvV");

    }


/**
     *END TESTELBONIAN
     */



/**
 * ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
 * ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
 * ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
 * ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
 * ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
 */



/**
     * START TESTARABIC
     * These test ARABIC methods
     *
     */


    @Test(expected = ValueOutOfBoundsException.class)
    public void numTooHighExceptionTest() throws Exception {
        numBadClass = new ElbonianArabicConverter("4888");
        numBadClass.toElbonian();

    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void numTooLowExceptionTest() throws Exception {
        numBadClass = new ElbonianArabicConverter("0");
        numBadClass.toElbonian();

    }



    @Test
    public void onlyNumbers() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("123"), true);
        Assert.assertEquals(legalcheck.eLegal("12A3"), false);
        Assert.assertEquals(legalcheck.eLegal("12.3"), false);
        Assert.assertEquals(legalcheck.eLegal("-123"), false);
        Assert.assertEquals(legalcheck.eLegal("123456789"), true);
        Assert.assertEquals(legalcheck.eLegal("1M23"), false);


    }


    @Test
    public void valid1() throws Exception {

        numClass = new ElbonianArabicConverter("3888");
        Assert.assertEquals(numClass.toElbonian(), "MMMDCCCLXXXVIII");
        ElbonianArabicConverter aclass = new ElbonianArabicConverter("13");
        Assert.assertEquals(aclass.toElbonian(), "XIII");
        ElbonianArabicConverter bclass = new ElbonianArabicConverter("1443");
        Assert.assertEquals(bclass.toElbonian(), "MdDlLIII");

    }



    @Test
    public void elbodianFromArabicAndBack() throws Exception {

        mainclass = new ElbonianArabicConverter("444");

        String answer = mainclass.toElbonian();

        ElbonianArabicConverter mainclass2 = new ElbonianArabicConverter(answer);

        int answer2 = mainclass2.toArabic();

        String answer3 = Integer.toString(answer2);
        Assert.assertEquals(answer3, "444");

    }

    @Test
    public void maxToElbonian() throws Exception {


        Assert.assertEquals(numClass.toElbonian(), "MMMmMDCCCcCLXXXxXVIII" );


    }

    /**
     * END TESTARABIC
     */
}