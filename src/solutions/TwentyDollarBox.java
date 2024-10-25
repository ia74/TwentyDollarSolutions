package solutions;

public class TwentyDollarBox {
    public static void main(String[] args) {
        String str = "";
        for(int i = 1; i < 21; i++) {
            str += "##" + i + "##---##" + (21 - i) + "##---##" + i +"##\n";
        }
        System.out.println(str);
    }
}
