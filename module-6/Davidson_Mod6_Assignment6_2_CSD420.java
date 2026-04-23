/*
 * Name: Tiffany Davidson
 * Course: CSD 420
 * Module: 6.2
 * Assignment: Generic Bubble Sort Using Comparable and Comparator
 * Date: April 22, 2026
 *
 * Description:
 * This program demonstrates two generic bubble sort methods.
 * The first method sorts elements using the Comparable interface.
 * The second method sorts elements using the Comparator interface.
 *
 * The program also includes test code to verify that both methods
 * work correctly with different types of data.
 */

import java.util.Arrays;
import java.util.Comparator;

public class Davidson_Mod6_Assignment6_2_CSD420 {

    /*
     * Generic bubble sort method using Comparable.
     * This method sorts the array in ascending order based on
     * the natural ordering of the elements.
     */
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean swapped;
        int n = list.length;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    /*
     * Generic bubble sort method using Comparator.
     * This method sorts the array based on the comparison rules
     * provided by the Comparator object.
     */
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean swapped;
        int n = list.length;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    /*
     * Student class used for testing Comparator based sorting.
     */
    static class Student {
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        @Override
        public String toString() {
            return name + " (" + score + ")";
        }
    }

    public static void main(String[] args) {

        // Test 1: Comparable with Integer array
        Integer[] numbers = {42, 7, 19, 88, 3, 25};
        System.out.println("Original Integer array:");
        System.out.println(Arrays.toString(numbers));

        bubbleSort(numbers);

        System.out.println("Sorted Integer array using Comparable:");
        System.out.println(Arrays.toString(numbers));
        System.out.println();

        // Test 2: Comparable with String array
        String[] words = {"pear", "apple", "orange", "banana", "grape"};
        System.out.println("Original String array:");
        System.out.println(Arrays.toString(words));

        bubbleSort(words);

        System.out.println("Sorted String array using Comparable:");
        System.out.println(Arrays.toString(words));
        System.out.println();

        // Test 3: Comparator with Student array, sort by score
        Student[] students = {
            new Student("Tiffany", 92),
            new Student("James", 85),
            new Student("Maria", 97),
            new Student("Chris", 88)
        };

        System.out.println("Original Student array:");
        System.out.println(Arrays.toString(students));

        Comparator<Student> byScore = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.getScore(), s2.getScore());
            }
        };

        bubbleSort(students, byScore);

        System.out.println("Sorted Student array by score using Comparator:");
        System.out.println(Arrays.toString(students));
        System.out.println();

        // Test 4: Comparator with Student array, sort by name
        Student[] studentsByName = {
            new Student("Tiffany", 92),
            new Student("James", 85),
            new Student("Maria", 97),
            new Student("Chris", 88)
        };

        System.out.println("Original Student array:");
        System.out.println(Arrays.toString(studentsByName));

        Comparator<Student> byName = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        };

        bubbleSort(studentsByName, byName);

        System.out.println("Sorted Student array by name using Comparator:");
        System.out.println(Arrays.toString(studentsByName));
    }
}