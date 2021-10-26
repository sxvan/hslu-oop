package ch.hslu.sw06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DemoTest {

    @Test
    public void maxInt_twoFiveThree_returnsFive() {
        int a = 2;
        int b = 5;
        int c = 3;
        var demo = new Demo();

        int result = demo.maxInt(a, b, c);

        assertEquals(b, result);
    }


}