import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution8 {

    static long marcsCakewalk(int[] calorie) {
        // Complete this function
    	long miles = 0;
    	for (int i = 3; i > 0; i--) {
				miles = miles + (i * (long) Math.pow(2, i));
				System.out.println(i);
				System.out.println(miles);
		}
    	return miles;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] calorie = new int[n];
        for(int calorie_i = 0; calorie_i < n; calorie_i++){
            calorie[calorie_i] = in.nextInt();
        }
        long result = marcsCakewalk(calorie);
        System.out.println(result);
        in.close();
    }
}
