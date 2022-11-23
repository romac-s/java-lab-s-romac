package com.romac;

import junit.framework.TestCase;
import org.junit.Test;

public class ColorTest extends TestCase {

    public void testDecode() {
        Color act = Color.decode("0x1FF0FF");
        //Color exp = new Color(31, 240, 255);
        assertEquals(31, act.getRed());
        assertEquals(240, act.getGreen());
        assertEquals(255, act.getBlue());
    }

    @Test
    public void testGetRGB() {
        Color c = Color.decode("0x1FF0FF");
        assertEquals(2093311, c.getRGB());
    }

    @Test
    public void testRGBtoHSB() {
        float[] hsbval = new float[3];
        Color.RGBtoHSB(31, 240, 255, hsbval);
        assertEquals(184.01787f, hsbval[0]*360);
        assertEquals(0.8784314, hsbval[0]*360);
        assertEquals(184.01787f, hsbval[0]*360);
    }



    @Test
    public void testRGBtoCYMK() {
        float[] hsbval = new float[3];
    }

    @Test
    public void testRGBtoHSl() {
    }
}