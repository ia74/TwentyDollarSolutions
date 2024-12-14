package solutions;

import com.sun.source.tree.Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TwentyDollarRoommates {
    public static class Person {
        String name;
        Set<String> categories;
        public Person(String name, Set<String> categories) {
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
            TreeSet<String> total = new TreeSet<>();
            while(num --> 0) {
                Set<String> categories = new TreeSet<>();
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
            boolean pass = true;
            for(int i = 0; i < people.size() -1;i +=2) {
                Person person = people.get(i);
                Person personTwo = people.get(i+1);
                pass = shareCommon(person, personTwo);
                break;
            }
            System.out.println(pass ? "YES" : "NO");
        }
    }
    static boolean shareCommon(Person person1, Person person2) {
        for(String category : person1.categories) {
            for(String category2 : person2.categories) {
                if(category.equals(category2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
