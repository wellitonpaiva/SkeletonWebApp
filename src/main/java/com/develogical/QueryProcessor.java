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
        } else if (query.toLowerCase().contains("what is") && query.toLowerCase().contains("to the power of")) {
          return pawarString(query);
        } else if (query.toLowerCase().contains("which of the following numbers is both a square and a cube:")) {
          return findCubeAndSquare(query);
        } else if (query.toLowerCase().contains("which of the following numbers are primes:")) {
          return findPrimes(query);
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

  private static String pawarString(String query) {
        //What is 13 to the power of 97?
    String s = query.replace("What is ", "").replace("?", "");
    String[] numbers = s.split(" to the power of ", 0);
    Double sum = Math.pow(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
    return String.valueOf(sum);
  }

  private static String findPrimes(String query) {
  List<Integer> expectedAnswers = Arrays.asList(2,3,5,7,11,13,17,19,23,
          29,31,37,41,43,47,53,59,61,67,
          71,73,79,83,89,97,101,103,107,109,
          113,127,131,137,139,149,151,157,163,167,
          173,179,181,191,193,197,199,211,223,227,
          229,233,239,241,251,257,263,269,271,277,
          281,283,293,307,311,313,317,331,337,347,
          349,353,359,367,373,379,383,389,397,401,
          409,419,421,431,433,439,443,449,457,461,
          463,467,479,487,491,499,503,509,521,523,
          541,547,557,563,569,571,577,587,593,599,
          601,607,613,617,619,631,641,643,647,653,
          659,661,673,677,683,691,701,709,719,727,
          733,739,743,751,757,761,769,773,787,797,
          809,811,821,823,827,829,839,853,857,859,
          863,877,881,883,887,907,911,919,929,937,
          941,947,953,967,971,977,983,991,997);
      String s = query.replace("Which of the following numbers are primes: ", "").replace("?", "");
      String[] numbers = s.split(", ", 0);
      List<Integer> valid = new java.util.ArrayList<>(Collections.emptyList());
      for (String number : numbers) {
          if(expectedAnswers.contains(Integer.parseInt(number))) {
              valid.add(Integer.valueOf(number));
          }
      }
      if (valid.isEmpty())
          return "";
      else
          return valid.stream().map(Object::toString).collect(Collectors.joining());
  }

  private static String findCubeAndSquare(String query) {
    List<Integer> expectedAnswers = Arrays.asList(1, 64, 729, 4096, 15625, 46656, 117649, 262144, 531441, 1000000, 1771561, 2985984, 4826809, 7529536, 11390625, 16777216, 24137569);
    //Which of the following numbers is both a square and a cube: 4541, 3375, 1089, 4096, 4885, 59, 1362?
    String s = query.replace("Which of the following numbers is both a square and a cube: ", "").replace("?", "");
      String[] numbers = s.split(", ", 0);
      List<Integer> valid = new java.util.ArrayList<>(Collections.emptyList());
      for (String number : numbers) {
          if(expectedAnswers.contains(Integer.parseInt(number))) {
              valid.add(Integer.valueOf(number));
          }
      }
      if (valid.isEmpty())
          return "";
      else
          return valid.stream().map(Object::toString).collect(Collectors.joining());
  }



}
