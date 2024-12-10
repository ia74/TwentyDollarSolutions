package solutions;

import com.sun.source.tree.Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TwentyDollarRoommates {
    public static class Person {
        String name;
        ArrayList<String> categories;
        public Person(String name, ArrayList<String> categories) {
            this.name = name;
            this.categories = categories;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", categories=" + categories +
                    '}';
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("roommates.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            int num = scan.nextInt();
            scan.nextLine();
            ArrayList<Person> people = new ArrayList<>();
            TreeMap<String, Integer> rooms = new TreeMap<>();
            TreeSet<String> total = new TreeSet<>();
            while(num --> 0) {
                ArrayList<String> categories = new ArrayList<>();
                String username = "";
                String ln = scan.nextLine();
                username = ln.split(" ")[0];
                ln = ln.replace(username, "");
                Scanner odd = new Scanner(ln);
                while(odd.hasNext()) {
                    String next = odd.next();
                    categories.add(next);
                    total.add(next);
                }
                people.add(new Person(username, categories));
            }
            for(int i = 0; i < people.size(); i ++) {
                Person person = people.get(i);
                for(int j = 0; j < people.size(); j++) {
                    Person personTwo = people.get(j);
                    if(person == personTwo) continue;
                    for(String category : person.categories) {
                        for(String categoryTwo : personTwo.categories) {
                            if(category.equals(categoryTwo)) {
                                if(!rooms.containsKey(category)) rooms.put(category, 0);
                                if(rooms.get(category) == 2) continue;
                                rooms.put(category, rooms.get(category) + 1);
                                break;
                            }
                        }
                    }
                }
            }
            boolean pass = true;
            if(rooms.size() != total.size()) pass = false;
            for(int i = 0; i < rooms.size(); i++) {
                if(total.toArray()[i] != rooms.keySet().toArray()[i]) {
                    pass = false;
                    break;
                }
            }
            System.out.println(pass ? "YES" : "NO");
        }
    }
}
