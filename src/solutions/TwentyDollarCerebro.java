package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

public class TwentyDollarCerebro {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("cerebro.dat"));
        int noSets = scan.nextInt();
        int noConnections = scan.nextInt();
        LinkedHashMap<String, LinkedList<String>> connections = new LinkedHashMap<>();
        scan.nextLine();
        while(noConnections-- > 0) {
            String from = scan.next();
            String to = scan.next();
            if(!connections.containsKey(from)) connections.put(from, new LinkedList<>());
            LinkedList<String> connectionsList = connections.get(from);
            connectionsList.add(to);
            connections.put(from, connectionsList);
        }
        HashMap<String, Boolean> cache = new HashMap<>();
        Map.Entry<String, LinkedList<String>> firstConnections = connections.firstEntry();
        LinkedHashSet<String> e = traverse(cache, connections, firstConnections.getKey(), new LinkedHashSet<>());
        while(noSets-->0) {
            String to = scan.next();
            if(e.contains(to)) {
                System.out.println("Mutant Located.");
            } else {
                System.out.println("Nowhere to be found.");
            }
        }
    }
    public static LinkedHashSet<String> traverse(HashMap<String, Boolean> visits, LinkedHashMap<String, LinkedList<String>> map, String startPoint, LinkedHashSet<String> e) {
        LinkedList<String> i = map.get(startPoint);
        visits.put(startPoint, true);
        e.addAll(i);
        for(String name : i) {
            if(!visits.getOrDefault(name, false)) {
                LinkedHashSet<String> k = traverse(visits, map, name, e);
                System.out.println("Visiting " + name +" - " + k);
                e.addAll(i);
            }
            e.addAll(map.get(name));
        }
        return e;
    }
}
