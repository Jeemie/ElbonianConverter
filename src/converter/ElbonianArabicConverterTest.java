package converter;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jimmy on 4/12/2016.
 */
public class ElbonianArabicConverterTest {

    private ElbonianArabicConverter mainclass;
    private ElbonianArabicConverter maxclass;
    private Legality legalcheck;

    @org.junit.Before
    public void setUp() throws Exception {

        mainclass = new ElbonianArabicConverter("MM");
        maxclass = new ElbonianArabicConverter("MMMDCCCLXXXVIII");
        legalcheck = new Legality();

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

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

    @Test
    public void noRepeatCapAfterLower() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("MmMM"), false);

    }

        @Test
    public void whiteSpaces() throws Exception {

        Assert.assertEquals(legalcheck.eLegal(" M mM "), false);

    }

    @Test
    public void onlyNumbers() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("123"), true);

    }


    @Test
    public void numAndLetter() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("123m"), false);

    }

    @Test
    public void negativeSign() throws Exception {

        Assert.assertEquals(legalcheck.eLegal("-123"), false);

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





    @org.junit.Test
    public void toElbonian() throws Exception {

    }

}