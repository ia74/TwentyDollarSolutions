package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TwentyDollarNoah {
    public static class Car {
        String make;
        String model;
        int year;
        public Car(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("noah.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        ArrayList<Car> cars = new ArrayList<>();
        TreeMap<String, Integer> makeBreakdown = new TreeMap<>();
        TreeMap<String, Integer> modelBreakdown = new TreeMap<>();
        TreeMap<String, Integer> yearBreakdown = new TreeMap<>();
        Comparator<Car> drink1 = (a, b) -> {
            return a.make.compareToIgnoreCase(b.make);
        };
        Comparator<Car> drink2 = (a, b) -> {
            return a.model.compareToIgnoreCase(b.model);
        };
        while(noSets-- > 0) {
            String ln = scan.nextLine();
            String[] spaces = ln.split(",");
            String make = spaces[0];
            String model = spaces[1];
            int year = Integer.parseInt(spaces[2]);
            Car cup = new Car(make, model, year);
            cars.add(cup);
            cars.sort(drink1.thenComparing(drink2));
            increment(makeBreakdown, cup.make);
            increment(modelBreakdown, cup.model);
            increment(yearBreakdown, String.valueOf(cup.year));
        }
        System.out.println("---Data Sorted---");
        cars.forEach((a) -> {
            System.out.println(a.make + " " + a.model + " " + a.year);
        });
        System.out.println("\n---Make Breakdown---");
        makeBreakdown.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("\n---Model Breakdown---");
        modelBreakdown.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("\n---Year Breakdown---");
        yearBreakdown.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    public static void increment(TreeMap<String, Integer> map, String key) {
        if(!map.containsKey(key)) map.put(key, 0);
        map.put(key, map.get(key) + 1);
    }
}
