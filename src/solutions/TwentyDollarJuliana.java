package solutions;

import java.beans.BeanDescriptor;
import java.beans.Beans;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class TwentyDollarJuliana {
    public static class Person {
        String firstName;
        String lastName;
        String name;
        int yearsOfExperience;
        String major;
        String field;
        List<Person> connections;
        boolean qualified = false;
        public Person(String fn, String ln, String yn, String mj, String fi) {
            this.firstName = fn;
            this.lastName = ln;
            this.yearsOfExperience = Integer.parseInt(yn);
            this.major = mj;
            this.field = fi;
            this.connections = new ArrayList<>();
            this.name = fn +" " + ln;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", yearsOfExperience=" + yearsOfExperience +
                    ", major='" + major + '\'' +
                    ", field='" + field + '\'' +
                    ", connections=" + connections +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scan = new Scanner(new File("juliana.dat")); //TODO: change to "ksenyia.dat"
        int testCases = scan.nextInt();
        int people = scan.nextInt();
        scan.nextLine();
        HashMap<String, Person> identities = new HashMap<>();
        HashMap<String, ArrayList<Person>> majFieldToPeople = new HashMap<>();
        while(people-- > 0) {
            //listing of a person on LinkedIn in the following format [without parentheses and brackets]:
            // FirstName LastName: (years of experience) (major) (field) [0 or more Full Names denoting everyone they are
            //connected to]. Following these e lines, the n test cases will follow. Each test case will consist of two lines. The first will
            //contain a first and la
            String ln = scan.nextLine();
            String firstName = ln.split(":")[0].split(" ")[0];
            String lastName = ln.split(":")[0].split(" ")[1];
            String yearsOfExp = ln.split(" ")[2];
            String maj = ln.split(" ")[3];
            String field = ln.split(" ")[4];
            Person person = new Person(firstName, lastName, yearsOfExp, maj, field);
            ArrayList<Person> majors = majFieldToPeople.getOrDefault(maj, new ArrayList<>());
            ArrayList<Person> fields = majFieldToPeople.getOrDefault(field, new ArrayList<>());
            majors.add(person);
            fields.add(person);
            majFieldToPeople.put(maj, majors);
            majFieldToPeople.put(field, fields);
            identities.put(person.name, person);
            if(ln.lastIndexOf(field) + field.length() == ln.length()) {

            } else {
                String connections = ln.substring(ln.lastIndexOf(field) + field.length() + 1);
                String[] cn = connections.split(" ");
                for(int i = 0; i < connections.split(" ").length; i+=2) {
                    String name = cn[i] + " " + cn[i+1];
                    person.connections.add(identities.get(name));
                }
            }
        }
        while(testCases-->0) {
            String name = scan.nextLine().trim();
            String[] requirements = scan.nextLine().trim().split(" ");
            Person person = identities.get(name);

            int yearsWanted = Integer.parseInt(requirements[0]);
            String field = requirements[1];

            ArrayList<Person> qualified = new ArrayList<>();
            for(Person id :person.connections) {
                if(id == null) continue;
                id.qualified = candidateIsQualified(id, field, yearsWanted);
            }
            person.qualified = candidateIsQualified(person, field, yearsWanted);
            Comparator<Person> sorter = (a, b) -> a.name.compareToIgnoreCase(b.name);
//            qualified.sort(sorter);
//            qualified.forEach((p, s) -> {
//                if(s)System.out.print(p.name +" ");
//            });
            System.out.println();
        }
    }
    public static boolean candidateIsQualified(Person id, String field, int yearsWanted) {
        if(id.major.equals(field) || id.field.equals(field)) {
            return id.yearsOfExperience >= yearsWanted;
        }
        return false;
    }
}