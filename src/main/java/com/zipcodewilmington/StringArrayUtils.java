package com.zipcodewilmington;

import sun.security.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {

        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {

        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {

        return Arrays.asList(array).contains(value);
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            String answer = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = answer;
        }

        return array;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            if (!array[i].equals(array[array.length - 1 - i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {

        boolean answer = false;

        StringBuilder stringBuilder = new StringBuilder();

        for (String x : array) {
            stringBuilder.append(x);
        }
        String s = "";
        s = stringBuilder.toString();
        for (char i = 'A'; i <= 'Z'; i++) {
            if ((s.indexOf(i) < 0) && (s.indexOf((char) i + 32) < 0)) {
                answer = false;
            } else {
                answer = true;
            }
        }
        return answer;

//        String alphabet = "abc";
//
//        for (int i = 0; i > 26; i++) {
//            if (alphabet.charAt(i) != alphabet.charAt(i)) {
//                return false;
//            }
//        }
//        return true;
   }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                count++;
            }
        }

        return count;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {

        int count = 0;
        int contents = getNumberOfOccurrences(array, valueToRemove);
        String[] answer = new String[array.length - contents];
        for (String s : array) {
            if (s != valueToRemove) {
                answer[count] = s;
                count++;
            }
        }
        return answer;

    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {

        String[] arr = new String[array.length];
        int answer = 0;

        arr[answer] = array[0];

        answer++;
        for (int i = 1; i < array.length; i++) {
            if (!(arr[answer - 1]).equals(array[i])) {
                arr[answer] = array[i];
                answer++;
            }

        }
        String[] newArray = new String[answer];
        System.arraycopy(arr, 0, newArray, 0, answer);
        return newArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        ArrayList<String> newArray = new ArrayList<String>();
        StringBuilder word = new StringBuilder();
        int i=1;
        word.append(array[0]);
        while (i<(array.length)){
            if (array[i].equals(array[i-1])){
                word.append(array[i]);
            } else {
                newArray.add(word.toString());
                word.setLength(0);
                word.append(array[i]);
            }
            i++;
        }
        newArray.add(word.toString());
        String[] strArr = newArray.toArray(new String[0]);
        return strArr;
    }

}