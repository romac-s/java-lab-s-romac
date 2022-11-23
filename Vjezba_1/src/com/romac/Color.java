package com.romac;

public class Color {
    int red;
    int green;
    int blue;

    public Color(int red, int green, int blue) {
        this.setRed(red);
        this.setGreen(green);
        this.setBlue(blue);
    }

    public void setRed(int red) {
        this.red = red;
    }
    public void setGreen(int green) {
        this.green = green;
    }
    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getRed(){
        return red;
    }
    public int getGreen(){
        return green;
    }
    public int getBlue(){
        return blue;
    }

    public static Color decode(String nm) throws NumberFormatException {
        Integer intval = Integer.decode(nm);
        int i = intval.intValue();
        return new Color(i >> 16 & 255, i >> 8 & 255, i & 255);
    }

    public int getRGB() {
        return 0x00000000 | this.red << 16 | this.green << 8 | this.blue;
    }

    public static float[] RGBtoHSB(int red, int green, int blue, float[] hsbvals) {
        float Cmax = (red > green) ? ((red > blue) ? red : blue) : ((green > blue) ? green : blue);
        float Cmin = (red < green) ? ((red < blue) ? red : blue) : ((green < blue) ? green : blue);
        float delta = Cmax - Cmin;
        float hue, saturation, brightness;

        if (delta == 0)
            hue = 0;

        else if (Cmax == (float)red)
            hue = (((float) (green - blue)) / delta) % 6;

        else if (Cmax == (float)green)
            hue = (((float) (blue - red)) / delta) + 2;

        else {
            hue = (((float) (red - green)) / delta) + 4;
        }
        hue *= 60f;

        if (Cmax == 0)
            saturation = 0;
        else
            saturation = delta / Cmax;

        brightness = Cmax;

        hsbvals[0] = hue/360f;
        hsbvals[1] = saturation;
        hsbvals[2] = brightness/255;
        return hsbvals;
    }

    public static float[] RGBtoCYMK(int r, int g, int b, float[] cymkvals) {
        float rr =(float) r / 255f;
        float gg =(float) g / 255f;
        float bb =(float) b / 255f;
        float C, Y, M, K;

        float Cmax = Math.max(Math.max(rr, gg), bb);
        K = 1f -Cmax;
        C = (1f - rr - K) / (1f - K);
        M = (1f - gg - K) / (1f - K);
        Y = (1f -bb - K) / (1f - K);

        cymkvals[0] = C;
        cymkvals[1] = Y;
        cymkvals[2] = M;
        cymkvals[3] = K;
        return cymkvals;
    }
    public static float[] RGBtoHSl(int r, int g, int b, float[] hslvals) {
        float rr =(float) r / 255f;
        float gg =(float) g / 255f;
        float bb =(float) b / 255f;
        float Cmax = Math.max(Math.max(rr, gg), bb);
        float Cmin = Math.min(Math.min(rr, gg), bb);
        float delta = Cmax - Cmin;
        float H, S, L;

        L = (Cmax + Cmin) / 2f;
        if (delta == 0f){
            S = 0f;
        }
        else {
            S = delta / (1f - (Math.abs(2f*L - 1f)));
        }
        if(delta == 0f)
            H = 0f;
        else if(Cmax == rr){
            H =  ((gg - bb) / delta) % 6;
        }
        else if ( Cmax == gg){
            H = ((bb - rr) / delta) + 2f;
        }
        else {
            H = ((rr - gg) / delta) + 4f;
        }
        H *= 60f;
        hslvals[0] = H;
        hslvals[1] = S;
        hslvals[2] = L;
        return hslvals;
    }
}
