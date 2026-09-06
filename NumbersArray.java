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

    // findMax method - returns maximum value in an array 
    public static int findMax(Integer[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // findDuplicates method - returns an array (Integer[]) containing the duplicate values in the array
    public static Integer[] findDuplicates(Integer[] arr) {
        Integer[] duplicates_arr = new Integer[arr.length];
        int j = 0;
        int k = 0;
        int counter = 0;
        HashSet<Integer> duplicate_checker = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (duplicate_checker.contains(arr[i])) {
                duplicates_arr[j++] = arr[i];
                counter++;
                continue;
            }
            duplicate_checker.add(arr[k++]);
        }
        Integer[] trimmed = Arrays.copyOf(duplicates_arr, counter);
        return trimmed;
    }

    // findUnique - returns an array (Integer[]) containing the unique values in the array 
    public static Integer[] findUnique(Integer[] arr) {
        HashMap<Integer, Integer> unique_checker = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            unique_checker.merge(arr[i], 1, Integer::sum);
        }
        Integer[] unique_arr = new Integer[arr.length];
        int i = 0;
        int counter = 0;
        for (Integer key : unique_checker.keySet()) {
            if (unique_checker.get(key) == 1) {
                unique_arr[i++] = key;
                counter++;
            }
        }
        Integer[] trimmed = Arrays.copyOf(unique_arr, counter);
        return trimmed;
    }
}

