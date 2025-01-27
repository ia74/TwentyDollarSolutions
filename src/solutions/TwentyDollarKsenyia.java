package solutions;

import java.beans.*;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class TwentyDollarKsenyia {
    public static class Bean {
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scan = new Scanner(new File("ksenyia.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        HashSet<String> names = new HashSet<>();
        while(sets-- > 0) {
            String username = scan.nextLine().replaceAll("\\W+", "");
            String passwd = scan.nextLine();
            System.out.println(username + ":" + passwd);

            boolean u_startsWithCap = username.substring(0,1).toUpperCase().equals(username.substring(0,1));
            boolean u_lenCheck = 8 < username.length() && username.length() <= 20;

            boolean p_contain_letter = passwd.matches("\\w+");
            boolean p_contain_special = passwd.matches("[!@#$%^&*?+]+");
            boolean p_contain = p_contain_letter && p_contain_special;

            BeanDescriptor beanDescriptor = new BeanDescriptor(Bean.class);
            ClassLoader cls = new ClassLoader() {
                @Override
                public String getName() {
                    return super.getName();
                }
            };
            Beans.instantiate(cls, beanDescriptor.getBeanClass().getName());

            System.out.println(
                    (u_startsWithCap && u_lenCheck && !names.contains(username))?
                    (p_contain)
                            ? "Valid"
                            : "Password Invalid"
                            : "Username Invalid");
            names.add(username);
        }
    }
}