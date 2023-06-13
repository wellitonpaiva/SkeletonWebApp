package com.develogical;

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

  private static String multiplyString(String query) {
    String s = query.replace("What is ", "").replace("?", "");
    String[] numbers = s.split(" multiplied by ", 0);
    int sum = Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]);
    return String.valueOf(sum);
  }
}
