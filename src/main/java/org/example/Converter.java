package org.example;

public class Converter {

    public float convertFtoC(float f){
        float c =(f -32) * 5/9;
        return c;
    }

    public float convertCtoF(float c){
        float f =(c * 9/5) + 32;
        return f;
    }
}
