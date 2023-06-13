package com.develogical;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class QueryProcessor {

    public String process(String query) {

        System.out.println("Received query:" + query);

        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an "
                    + "English poet, playwright, and actor, widely regarded as the greatest "
                    + "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.toLowerCase().contains("what is your name?")) {
            return "Team Learning eXPerience";
        } else if (query.toLowerCase().contains("which of the following numbers is the largest:")) {
          return findMax(query);
        } else if (query.toLowerCase().contains("what is") && query.toLowerCase().contains("plus")) {
            return addStrings(query);
        } else if (query.toLowerCase().contains("what is") && query.toLowerCase().contains("minus")) {
          return subStrings(query);
        } else if (query.toLowerCase().contains("what is") && query.toLowerCase().contains("multiplied by")) {
          return multiplyString(query);
        }

        return "";
    }

  private static String findMax(String query) {
    String s = query.replace("Which of the following numbers is the largest: ", "").replace("?", "");
    String[] numbers = s.split(", ", 0);
    int max = 0;
    for (String number : numbers) {
        int current = Integer.parseInt(number);
        if (max < current) max = current;
    }
    return String.valueOf(max);
  }

  private static String addStrings(String query) {
    String s = query.replace("What is ", "").replace("?", "");
    String[] numbers = s.split(" plus ", 0);
    int sum = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
    return String.valueOf(sum);
  }

  private static String subStrings(String query) {
    String s = query.replace("What is ", "").replace("?", "");
    String[] numbers = s.split(" minus ", 0);
    int sum = Integer.parseInt(numbers[0]) - Integer.parseInt(numbers[1]);
    return String.valueOf(sum);
  }

  private static String multiplyString(String query) {
    String s = query.replace("What is ", "").replace("?", "");
    String[] numbers = s.split(" multiplied by ", 0);
    int sum = Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]);
    return String.valueOf(sum);
  }

  private static String findCubeAndSquare(String query) {
    List<Integer> expectedAnswers = Arrays.asList(1, 64, 729, 4096, 15625, 46656, 117649, 262144, 531441, 1000000, 1771561, 2985984, 4826809, 7529536, 11390625, 16777216, 24137569);
    //Which of the following numbers is both a square and a cube: 4541, 3375, 1089, 4096, 4885, 59, 1362?
    String s = query.replace("Which of the following numbers is both a square and a cube: ", "").replace("?", "");
    String[] numbers = s.split(",", 0);
    List<Integer> valid = new java.util.ArrayList<>(Collections.emptyList());
    for (String number : numbers) {
      if(expectedAnswers.contains(number)) {
          valid.add(Integer.valueOf(number));
      }
    }
    if (valid.isEmpty())
        return "";
    else
        return valid.stream().map(Object::toString).collect(Collectors.joining());
  }



}
