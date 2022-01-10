package controllerPackage;

import java.util.Random;
import java.util.Scanner;

public class OefeningArrays {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static final int AANTAL_GETALLEN = 25;

    public static void main(String[] args) {
        // doel: 10 random int getallen worden gemaakt en in een array gestopt. Daarna toont het scherm het hoogste, laagste en gemiddelde getal.

        // input
        int[] getallenReeks = new int[AANTAL_GETALLEN];
        int totaalGetal;
        int hoogsteGetal;
        int laagsteGetal;
        double gemiddelde;

        // verwerking
        getallenReeks = genereerAantalGetallen();
        totaalGetal = berekenTotaalGetal(getallenReeks);
        hoogsteGetal = berekenHoogsteGetal(getallenReeks);
        laagsteGetal = berekenLaagsteGetal(getallenReeks);
        gemiddelde = (double) totaalGetal / AANTAL_GETALLEN;

        // output
        System.out.println("Het totaal is : "+totaalGetal+"\nHoogste getal : "+hoogsteGetal+"\nLaagste getal : "+laagsteGetal+"\nGemiddelde is : "+gemiddelde);
    }

    public static int berekenTotaalGetal(int[] array){
        // input
        int totaalGetal = 0;

        // verwerking
        for (int i = 0; i < AANTAL_GETALLEN; i++) {
            totaalGetal = totaalGetal + array[i];
        }

        // output
        System.out.println(totaalGetal);
        return totaalGetal;
    }

    public static int berekenHoogsteGetal(int[] array){
        int hoogsteGetal = 0;

        for (int i = 0; i < AANTAL_GETALLEN; i++) {
            if (array[i] > hoogsteGetal){
                hoogsteGetal = array[i];
            }
        }
        System.out.println(hoogsteGetal);
        return hoogsteGetal;
    }

    public static int berekenLaagsteGetal(int[] array){
        int laagsteGetal = AANTAL_GETALLEN+1;

        for (int i = AANTAL_GETALLEN-1; i > -1; i--) {
            if (array[i] < laagsteGetal){
                laagsteGetal = array[i];
            }
        }
        System.out.println(laagsteGetal);
        return laagsteGetal;
    }

    public static int[] genereerAantalGetallen() {
        // doel: genereer 10 getallen via Random

        // input
        int[] arrayGetallen = new int[AANTAL_GETALLEN];
        String getallenOpRij = "";

        // verwerking
        for (int i = 0; i < AANTAL_GETALLEN; i++) {
            arrayGetallen[i] = random.nextInt(10)+1;
            getallenOpRij = getallenOpRij + arrayGetallen[i] + "\t";
            //System.out.println(arrayGetallen[i]);
        }

        // output
        System.out.println(getallenOpRij);
        return arrayGetallen;
    }

}

/* VOORBEELD CODE JAN
package com.company;

import java.util.Random;

public class ArrayDemo2 {
    public static void main(String[] args) {
        final int AANTAL_GETALLEN = 3;
        final int MAX_GETAL = 10; //inclusive

        Random random = new Random();
        int[] getallen = new int[AANTAL_GETALLEN];

        for (int i = 0; i < AANTAL_GETALLEN; i++) {
            getallen[i] = random.nextInt(MAX_GETAL + 1);
            System.out.println(getallen[i]);
        }

        //manier 1 minimum bepalen
        int min;
        min = getallen[0];
        for (int i = 1; i < AANTAL_GETALLEN; i++) { //vanaf 2e element beginnen!!
            if (getallen[i] < min) min = getallen[i];
        }

        //manier 2 minimum bepalen
        min = Integer.MAX_VALUE;
        for (int i = 0; i < AANTAL_GETALLEN; i++) { //vanaf begin beginnen
            if (getallen[i] < min) min = getallen[i];
        }

        int max = getallen[0];
        for (int i = 1; i < AANTAL_GETALLEN; i++) {//vanaf 2e element beginnen!!
            if (getallen[i] > max) max = getallen[i];
        }

        int sum = 0;
        for (int i = 0; i < AANTAL_GETALLEN; i++) { //Let op: hier vanaf element 0!!!
            sum += getallen[i];
        }
        double avg = (double) sum / AANTAL_GETALLEN;


        //Andere manieren:
        // http://zparacha.com/minimum-maximum-array-value-java
        // https://www.geeksforgeeks.org/find-max-min-value-array-primitives-using-java/


        System.out.println(getMinValue(getallen));
        System.out.println(getMaxValue(getallen));

        System.out.println(min);
        System.out.println(max);
        System.out.println(avg);
    }

    public static int getMaxValue(int[] numbers){
        int maxValue = numbers[0];
        for(int i=1;i < numbers.length;i++){
            if(numbers[i] > maxValue){
                maxValue = numbers[i];
            }
        }
        return maxValue;
    }

    public static int getMinValue(int[] numbers){
        int minValue = numbers[0];
        for(int i=1;i<numbers.length;i++){
            if(numbers[i] < minValue){
                minValue = numbers[i];
            }
        }
        return minValue;
    }
}
 */