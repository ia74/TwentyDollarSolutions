package solutions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwentyDollarBaseMall {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr51.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            String line = scan.nextLine();
            String regex = "\\d+";

            Matcher m = Pattern.compile(regex).matcher(line);

            ArrayList<String> matches = new ArrayList<>();
            while (m.find()) {
                if(matches.contains(m.group(0))) {
                    break;
                }
                matches.add(m.group(0));
            }

            if(matches.isEmpty()) {
                System.out.println(line);
                continue;
            }

            if(matches.size() > 1) {
                double average = Double.parseDouble(matches.get(0)) / Double.parseDouble(matches.get(1));
                String avg = " (" + String.format("%.3f", average) + ")";
                System.out.println(line.replace(matches.get(1), matches.get(1) + avg));
            } else {
                int count = 0;
                String wanted = matches.get(0);
                StringBuilder finalOut = new StringBuilder();
                for(int i = 0; i < line.length(); i++) {
                    String biggie = line.substring(i, i + wanted.length());
                    if(biggie.equals(wanted)) {
                        if(count ==1) {
                            finalOut.append(biggie)
                                    .append(" (1.000)");
                            finalOut.append(
                                    line, i+wanted.length(), line.length()
                            );
                            break;
                        }
                        count++;
                    }
                    finalOut.append(line.charAt(i));
                }
                System.out.println(finalOut);
            }
        }
    }
}