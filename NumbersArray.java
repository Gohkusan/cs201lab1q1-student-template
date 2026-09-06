import java.util.*;

public class NumbersArray {
    public static void main(String[] args) {
        Integer[] input = {1,2,3,4,1,5};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input)));       
        
        System.out.println();

        input = new Integer[] {1,2,3,4,1,2,5,3};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input))); 
    }
    

    // Write your methods here
    public static int findMax(Integer[]input) {
        // 0 1 2 boundary
        int max = 0;
        for (int n : input) {
            if (n > max) max = n;
        }
        return max;
    }
    public static Integer[] findDuplicates(Integer[] input) {
        ArrayList<Integer> seen = new ArrayList<>();
        TreeSet<Integer> duplicates = new TreeSet<>();
        for (int n: input) {
            if (!seen.contains(n)) {
                seen.add(n);
                continue;
            }
            if (seen.contains(n)) {
                duplicates.add(n);
            }
        }
        return duplicates.toArray(new Integer[0]);
    }
    public static Integer[] findUnique(Integer[]input) {
        ArrayList<Integer> seen = new ArrayList<>();
        ArrayList<Integer> unique = new ArrayList<>(); 
        for (int n : input) {
            if (!seen.contains(n)) {
                seen.add(n);
                unique.add(n);
                continue;
            }
            if(seen.contains(n)) {
                // unique.remove(n);
                // this removes by index
                unique.remove(Integer.valueOf(n));
            }
        }
        return unique.toArray(new Integer[0]);
    }
    
}

