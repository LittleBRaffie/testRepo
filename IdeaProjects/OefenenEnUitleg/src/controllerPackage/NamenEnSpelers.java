package controllerPackage;

import java.util.Scanner;

public class NamenEnSpelers { //oefening dia 9 dagdeel 6
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

            final int AANTAL_SPELERS = 4;

            int[] scores = new int[AANTAL_SPELERS];
            String[] namen = new String[AANTAL_SPELERS];

            for (int i = 0; i < AANTAL_SPELERS; i++) {
                //naam
                System.out.println("Naam speler " + (i + 1) + ":");
                String naam = scanner.next();

                //score
                System.out.println("Score speler " + (i + 1) + ":");
                int score = scanner.nextInt();

                //bewaren in arrays
                namen[i] = naam;
                scores[i] = score;
            }

            System.out.println(namen);
            System.out.println(scores);

            for (int i = 0; i < AANTAL_SPELERS; i++) {
                System.out.println(namen[i] + " " + scores[i]);
            }

            int maxScore = -1;
            int welkeSpelerHeeftHighScore = -1;
            for (int i = 0; i < AANTAL_SPELERS; i++) {
                if (scores[i] > maxScore) {
                    maxScore = scores[i];
                    welkeSpelerHeeftHighScore = i;
                }
            }

            System.out.println("Highscore = " + scores[welkeSpelerHeeftHighScore] + " behaald door " + namen[welkeSpelerHeeftHighScore]);
        }
    }
