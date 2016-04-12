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
        badclass = new ElbonianArabicConverter("MmMm");
        legalcheck = new Legality();

        numClass = new ElbonianArabicConverter("3888");
        numBadClass = new ElbonianArabicConverter("4000");

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
    public void normal() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MMM"), true);


    }

    @Test
    public void normal1() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MMMDCLXVI"), true);


    }

    @Test
    public void normal2() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MMdDClLXvV"), true);


    }

    @Test
    public void consecLower() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("Mmm"), false);


    }

    @Test
    public void multiLower() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MmMm"), false);


    }

    @Test
    public void singleLetterAllowed() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("DD"), false);


    }

    @Test
    public void inOrder() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MMM"), true);


    }

    @Test
    public void outOfOrder() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("DDM"), false);


    }

    @Test
    public void outOfOrderWithLowerCase() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MMDm"), false);


    }

    @Test
    public void wrongLetterAfterLower() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MmD"), false);


    }

    @Test
    public void singleLower() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("m"), false);


    }

    @Test
    public void maxIs3888() throws Exception {

        Assert.assertEquals(maxclass.toArabic(), 3888);

    }

    @Test(expected = MalformedNumberException.class)
    public void badLetterExceptionTest() throws Exception {

        badclass.toArabic();

    }

    @Test
    public void noRepeatCapAfterLower() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MmMM"), false);

    }

    @Test
    public void whiteSpaces() throws Exception {

        Assert.assertEquals(legalcheck.eLegal(" M mM "), false);

    }


    @Test
    public void negativeSignInEldonian() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("-MMM"), false);

    }

    @Test
    public void badLetter() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MMA"), false);

    }

    @Test
    public void badLetter2() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MAM"), false);

    }

    @Test
    public void badLetter3() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("AMM"), false);

    }

    @Test
    public void lowerCaseI() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("i"), false);

    }

    @Test
    public void onlyI() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("I"), true);

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

        numBadClass.toElbonian();

    }



    @Test
    public void onlyNumbers() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("123"), true);

    }

    @Test
    public void norm1() throws Exception {

        Assert.assertEquals(numClass.toElbonian(), "I");



    }

    @Test
    public void numAndLetter() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("123m"), false);

    }

    @Test
    public void negativeSign() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("-123"), false);

    }

    /**
     * END TESTARABIC
     */
}