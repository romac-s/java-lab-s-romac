package com.romac;
//import java.awt.Color;


public class ColorConverter {
    public static void main(String[] args) {
        String hexColor = "0x1FF0FF";
        Color c = Color.decode(hexColor);
        float[] hsbCode = new float[3];
        float[] cymkCode = new float[4];
        float[] hslCode = new float[3];
        Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), hsbCode);
        Color.RGBtoCYMK(c.getRed(), c.getGreen(), c.getBlue(), cymkCode);
        Color.RGBtoHSl(c.getRed(), c.getGreen(), c.getBlue(), hslCode);
        System.out.println("Boja u HEX formatu: 0x" +
                Integer.toHexString(c.getRGB() & 0x00FFFFFF));
        System.out.println("Boja u RGB formatu: " + c.getRed() + ", " +
                c.getGreen() + ", " + c.getBlue());
        System.out.println("Boja u HSB formatu: " + hsbCode[0] * 360 + "°, " +
                hsbCode[1] * 100 + "%, " + hsbCode[2] * 100 + "%");
        System.out.println("Boja u CYMK formatu: " + cymkCode[0] * 100 + "°, " +
                cymkCode[1] * 100 + "%, " + cymkCode[2] * 100 + "%" +",  " + cymkCode[3] * 100 + "%");
        System.out.println("Boja u HSl formatu: " + hslCode[0] + "°, " +
                hslCode[1] * 100 + "%, " + hslCode[2] * 100 + "%");
    }
}
