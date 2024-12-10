package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TwentyDollarPr153MealPlannerSortableLebronJamesLetterCounterArrayListMachineSingletonCollectorConcreteClassListStackHandlerManagerCreatorBuilderHelperClassTypeGenericInferDynamic {
    public static class Food {
        String food;
        int fat;
        int protein;
        int carbs;
        public Food(String f, int fat, int protein, int carbs) {
            this.food = f;
            this.fat = fat;
            this.protein = protein;
            this.carbs = carbs;
        }
    }
    public static class Range {
        int min;
        int max;
        public Range(int min, int max) {
            this.min = min;
            this.max = max;
        }
        static Range fromStr(String str) {
            String[] e = str.split("-");
            return new Range(Integer.parseInt(e[0]), Integer.parseInt(e[1]));
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("pr153.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            String[] ranges = scan.nextLine().split(" ");
            Range fat = Range.fromStr(ranges[0]);
            Range protein = Range.fromStr(ranges[1]);
            Range carbs = Range.fromStr(ranges[2]);

            int nextFoods = scan.nextInt();
            scan.nextLine();
            ArrayList<Food> yum = new ArrayList<>();
            for(int i = 0; i < nextFoods; i++) {
                String[] ln = scan.nextLine().split(" ");
                yum.add(new Food(ln[0], Integer.parseInt(ln[1]), Integer.parseInt(ln[2]), Integer.parseInt(ln[3])));
            }

            int count = 0;
            int count2 = 0;
            int count3 = 0;
            for(Food food : yum) {
                int curr = fat.max;
                while(curr > fat.min) {
                    if(food.fat == 0) break;
                    curr -= food.fat;
                    count++;
                    System.out.println(count +" - " + curr + " - " + food.fat);
                }
                curr = protein.max;
                while(curr > protein.min) {
                    if(food.protein == 0) break;
                    curr -= food.protein;
                    count2++;
                }
                curr = carbs.max;
                while(curr > carbs.min) {
                    if(food.carbs == 0) break;
                    curr -= food.carbs;
                    count3++;
                }
            }
            System.out.println(count);
            System.out.println(count2);
            System.out.println(count3);
        }
    }
}
