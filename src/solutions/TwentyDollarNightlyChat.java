package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TwentyDollarNightlyChat {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("nightlychat.dat"));
        while(scan.hasNextLine()) {
            String lnOne = scan.nextLine();
            String lnTwo = scan.nextLine();

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("k:mm");

            LocalTime open = LocalTime.parse(lnOne,fmt);
            LocalTime close = LocalTime.parse(lnTwo,fmt);
            LocalTime wrong = LocalTime.now();

            LocalTime[] openTimesP = new LocalTime[] {
                    open.minusHours(1),
                    open.minusHours(3),
                    open.minusHours(9),
                    wrong
            }; // 0: madrid , 1: moscow , 2: tokyo

            LocalTime[] closeTimesP = new LocalTime[] {
                    close.minusHours(1),
                    close.minusHours(3),
                    close.minusHours(9),
                    wrong
            }; // 0: madrid , 1: moscow , 2: tokyo


            LocalTime biggestCloseTime = closeTimesP[3];
            LocalTime biggestOpenTime = openTimesP[3];

            out:
            for(int i = 0; i < openTimesP.length - 1; i++) {
                LocalTime currentOpenTime = openTimesP[i];

                for(int j = 0; j < closeTimesP.length - 1; j++) {
                    LocalTime currentCloseTime = closeTimesP[j];

                    if(currentCloseTime.isAfter(currentOpenTime)) {
                        biggestCloseTime = currentCloseTime;
                        break out;
                    }

                    if(currentCloseTime.isBefore(currentOpenTime)) {
                        biggestOpenTime = currentOpenTime;
                    }
                }
            }

            for (LocalTime currentOpenTime : openTimesP) {
                for (int j = 0; j < closeTimesP.length - 1; j++) {
                    LocalTime currentCloseTime = closeTimesP[j];

                    if (biggestCloseTime.isBefore(currentCloseTime)) {
                        biggestCloseTime = wrong;
                    }
                    if (biggestOpenTime.isBefore(currentOpenTime)) {
                        biggestOpenTime = wrong;
                    }
                }
            }

            if(biggestCloseTime == wrong || biggestOpenTime == wrong) {
                System.out.println("CANNOT FIND A SLOT");
            } else {
                System.out.println(
                        (biggestOpenTime)
                                +" to " +
                                (biggestCloseTime)
                                +" GMT");
            }
        }
    }

}
