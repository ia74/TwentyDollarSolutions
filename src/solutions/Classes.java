package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Classes {
    public static class SigmaTime {
        double hour;
        double minute;
        public SigmaTime(double hour, double minute) {
            this.hour = hour;
            this.minute = minute;
        }
        public static SigmaTime fromString(String s) {
            String[] parts = s.split(":");
            int[] times = new int[2];
            for(int i = 0; i < parts.length; i++) {
                times[i] = Integer.parseInt(parts[i]);
            }
            return new SigmaTime(times[0], times[1]);
        }

        @Override
        public String toString() {
            return padTo(String.valueOf((int) this.hour), 2) + ":" + padTo(String.valueOf((int) this.minute), 2);
        }
        String padTo(String pad, int to) {
            for(int i = 0; i < to - pad.length(); i++) {
                pad = "0" + pad;
            }
            return pad;
        }
        boolean equals(SigmaTime time) {
            return this.hour == time.hour && this.minute == time.minute;
        }
    }
    public static class SkibidiSigma {
        String code;
        String title;
        double creditHours;
        String subject;
        double professorRating;
        SigmaTime classTime;
        String[] prerequisites;
        public SkibidiSigma(String code, String title, double creditHours, String subject, double professorRating, String classTime, String prerequisites) {
            this.code = code;
            this.title = title;
            this.creditHours = creditHours;
            this.subject = subject;
            this.professorRating = professorRating;
            this.classTime = SigmaTime.fromString(classTime);
            this.prerequisites = prerequisites.split(", ");
        }
        public SkibidiSigma(String[] spaces) {
            this(spaces[0], spaces[1], Double.parseDouble(spaces[2]), spaces[3], Double.parseDouble(spaces[4]), spaces[5], spaces[6]);
        }

        @Override
        public String toString() {
            return "SkibidiSigma{" +
                    "code='" + code + '\'' +
                    ", title='" + title + '\'' +
                    ", creditHours=" + creditHours +
                    ", subject='" + subject + '\'' +
                    ", professorRating=" + professorRating +
                    ", classTime='" + classTime + '\'' +
                    ", prerequisites=" + Arrays.toString(prerequisites) +
                    '}';
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("classes.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        String[] creditFor = scan.nextLine().split(" ");

        ArrayList<String> haveCreditFor = new ArrayList<>();
        for(String c : creditFor) haveCreditFor.add(c);

        ArrayList<SkibidiSigma> sigmese = new ArrayList<>();
        while(noSets-- > 0) {
            String classLine = scan.nextLine();
            String[] spaces = classLine.split("\\|");
            SkibidiSigma classThing = new SkibidiSigma(spaces);
            boolean add = true;
            for(String k : classThing.prerequisites) {
                if(!haveCreditFor.contains(k)) {
                    add = false;
                    break;
                }
            }
            if(add) sigmese.add(classThing);
        }

        HashMap<String, Integer> subjectMap = new HashMap<>();
        subjectMap.put("writing", 1);
        subjectMap.put("lighting", 2);
        subjectMap.put("sound-design", 3);
        subjectMap.put("casting", 4);
        subjectMap.put("set-design", 5);

        Comparator<SkibidiSigma> bySubject = (a, b) -> {
            int place = subjectMap.get(a.subject.toLowerCase());
            int otherPlace = subjectMap.get(b.subject.toLowerCase());
            return place - otherPlace;
        };

        Comparator<SkibidiSigma> byRating = (a, b) -> (int) (b.professorRating * 100 - a.professorRating * 100);

        Comparator<SkibidiSigma> byClassTime = (a, b) -> {
            int ahour = -1;
            int bhour = -1;
            if(11 <= a.classTime.hour && a.classTime.hour < 15) {
                ahour = 1;
            } else if(15 <= a.classTime.hour && a.classTime.hour < 18) {
                ahour = 2;
            } else if(9 <= a.classTime.hour && a.classTime.hour < 11) {
                ahour = 3;
            } else if(18 <= a.classTime.hour && a.classTime.hour < 20) {
                ahour = 4;
            } else if(7 <= a.classTime.hour && a.classTime.hour < 9) {
                ahour = 5;
            } else {
                ahour = 5;
            }

            if(11 <= b.classTime.hour && b.classTime.hour < 15) {
                bhour = 1;
            } else if(15 <= b.classTime.hour && b.classTime.hour < 18) {
                bhour = 2;
            } else if(9 <= b.classTime.hour && b.classTime.hour < 11) {
                bhour = 3;
            } else if(18 <= b.classTime.hour && b.classTime.hour < 20) {
                bhour = 4;
            } else if(7 <= b.classTime.hour && b.classTime.hour < 9) {
                bhour = 5;
            } else {
                bhour = 5;
            }
            return ahour - bhour;
        };

        Comparator<SkibidiSigma> byCreditHours = (a, b) -> (int) (b.creditHours * 1000 - a.creditHours * 1000);

        Comparator<SkibidiSigma> byClassCode = (a, b) -> {
            int prio = bySubject.thenComparing(byRating).thenComparing(byClassTime).thenComparing(byCreditHours).compare(a, b);
            if(prio == 0) {
                return a.code.compareToIgnoreCase(b.code);
            } else return 1;
        };

        sigmese.sort(byClassTime);
        sigmese.sort(byRating);
        sigmese.sort(byCreditHours);
        sigmese.sort(bySubject);
        sigmese.sort(byClassCode);

        double currentHours = 0;
        int count = 0;

        for(SkibidiSigma k : sigmese) {
            count++;
            currentHours += k.creditHours;
            if(currentHours >= 21) break;
            System.out.println(k.code +": " + k.title);
            if(count == 20) break;
        }
    }
}
