import java.util.ArrayList;
import java.util.Random;

/**
 * Name: Tiffany Davidson
 * Course: CSD420
 * Module: 3.2
 * Assignment: Remove Duplicates from an ArrayList
 *
 * Description:
 * This program creates an ArrayList with 50 random integer values
 * between 1 and 20. It then uses a generic static method named
 * removeDuplicates to return a new ArrayList containing the original
 * values with all duplicates removed.
 */
public class Davidson_Mod3_CSD420 {

    /**
     * Generic method that removes duplicate values from an ArrayList.
     *
     * @param list the original ArrayList
     * @param <E> the type of elements in the ArrayList
     * @return a new ArrayList containing only unique values
     */
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> uniqueList = new ArrayList<>();

        for (E element : list) {
            if (!uniqueList.contains(element)) {
                uniqueList.add(element);
            }
        }

        return uniqueList;
    }

    /**
     * Main method that creates an ArrayList of 50 random integers
     * from 1 to 20, displays the original list, removes duplicates,
     * and displays the new list.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> originalList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            originalList.add(random.nextInt(20) + 1);
        }

        ArrayList<Integer> uniqueList = removeDuplicates(originalList);

        System.out.println("Original ArrayList:");
        System.out.println(originalList);

        System.out.println("\nArrayList after removing duplicates:");
        System.out.println(uniqueList);
    }
}