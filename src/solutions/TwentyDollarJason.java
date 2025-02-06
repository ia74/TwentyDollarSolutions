package solutions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TwentyDollarJason {
    public static class Month {
        int len;
        ArrayList<Double> rain;
        public Month(int len) {
            this.len = len;
            rain = new ArrayList<>();
        }
        public void addToRain(double len) {
            rain.add(len);
        }
        public int average() {
            double c = 0;
            for (Double aDouble : rain) {
                c += aDouble;
            }
            c /= rain.size();
            return (int) Math.ceil(c);
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("judging/uil_a_2025/jason.dat"));
        Month[] months = new Month[] {
                new Month(31),
                new Month(28),
                new Month(31),
                new Month(30),
                new Month(31),
                new Month(30),
                new Month(31),
                new Month(31),
                new Month(30),
                new Month(31),
                new Month(30),
                new Month(31),
        };
        int height = 1;
        for(Month month : months) {
            for(int i = 0; i < month.len; i++) {
                double rainRain = scan.nextDouble();
                month.addToRain(rainRain);
            }
            int avg = month.average();
            if(height < avg) height = avg;
        }
        int space = 0;
        for(int i = 0; i < height; i++) {
            double avg = 0;
             for(Month month : months) {
                 avg = month.average();
                 for(int j = 0; j<avg;j++) {
                    System.out.print("##### ");
                    if(space++ >= 12) {
                        System.out.println();
                        space = 0;
                    } ;
                 }
             }
        }
    }
}