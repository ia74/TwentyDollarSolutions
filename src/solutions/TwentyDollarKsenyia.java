package solutions;

import java.beans.*;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TwentyDollarKsenyia {
    public static class Bean {
        boolean sethlockharthasthreeduplicates(String sethLockhart) {
            String last = "";
            int lastCounter = 1;
            for(int i = 0; i < sethLockhart.length(); i++) {
                String currentSubstring = sethLockhart.substring(i,i+1);
                if(lastCounter >= 3) break;
                if(last.equals(currentSubstring)) {
                    lastCounter++;
                } else {
                    lastCounter = 1;
                    last = currentSubstring;
                }
            }
            return lastCounter >= 3;
        }

        public static void main(String[] args) {
            System.out.println("egg");
        }
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scan = new Scanner(new File("judging/ksenyia.dat"));
        Void thing;
        int sets = scan.nextInt();
        scan.nextLine();
        HashSet<String> names = new HashSet<>();
        HashSet<String> passwords = new HashSet<>();
        while(sets-- > 0) {
            String username = scan.nextLine().replaceAll("\\W+", "");
            String passwd = scan.nextLine();

            boolean u_startsWithCap = username.substring(0,1).toUpperCase().equals(username.substring(0,1));
            boolean u_lenCheck = 8 < username.length() && username.length() <= 20;
            boolean u_english = Pattern.compile("[A-Za-z]+").matcher(username).find();
            boolean u_contain_special = Pattern.compile("[!@#$%^&*?+]+").matcher(username).find();

            boolean p_lenCheck = 10 < passwd.length() && passwd.length() <= 30;
            boolean p_contain_letter = Pattern.compile("[A-Za-z]+").matcher(passwd).find();
            boolean p_contain_digit = Pattern.compile("[0-9]+").matcher(passwd).find();
            boolean p_contain_special = Pattern.compile("[!@#$%^&*?+]+").matcher(passwd).find();
            boolean p_contain_spaces = Pattern.compile("\\s+").matcher(passwd).find();

            boolean userIsValid = (
                u_startsWithCap &&
                u_lenCheck &&
                (u_english && !u_contain_special ) &&
                !names.contains(username)
            );

            boolean passIsValid = (
                p_lenCheck &&
                p_contain_letter &&
                p_contain_digit &&
                p_contain_special &&
                !p_contain_spaces &&
                !new Bean().sethlockharthasthreeduplicates(passwd) &&
                !passwords.contains(passwd)
            );

            BeanDescriptor beanDescriptor = new BeanDescriptor(Bean.class);
            ClassLoader cls = new ClassLoader() {
                @Override
                public String getName() {
                    return super.getName();
                }
            };
            Beans.instantiate(cls, beanDescriptor.getBeanClass().getName());

            if(userIsValid) {
                if(passIsValid) {
                    System.out.println("Valid");
                } else {
                    System.out.println("Password Invalid");
                }
            } else {
                if(passIsValid) {
                    System.out.println("Username Invalid");
                } else {
                    System.out.println("Both Invalid");
                }
            }

            if(userIsValid) names.add(username);
            if(userIsValid && passIsValid) passwords.add(passwd);
        }
    }
}