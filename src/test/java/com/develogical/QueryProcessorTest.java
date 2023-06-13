package com.develogical;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class QueryProcessorTest {

  QueryProcessor queryProcessor = new QueryProcessor();

  @Test
  public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
    assertThat(queryProcessor.process("test"), is(""));
  }

  @Test
  public void knowsAboutShakespeare() throws Exception {
    assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
  }


  @Test
  public void whatIsYourName() throws Exception {
    assertThat(queryProcessor.process("What is your name?"), containsString("Team Learning eXPerience"));
  }

  @Test
  public void largestNumber() throws Exception {
    assertThat(queryProcessor.process("Which of the following numbers is the largest: 20, 28, 80?"),
            is("80"));
    assertThat(queryProcessor.process("Which of the following numbers is the largest: 62, 59, 68?"),
            is("68"));
  }

  @Test
  public void addNums() {
    assertThat(queryProcessor.process("What is 98 plus 57?"), is("155"));
  }

  @Test
  public void subNums() {
    assertThat(queryProcessor.process("What is 20 minus 61?"), is("-41"));
  }

  @Test
  public void multiplyNums() {
    assertThat(queryProcessor.process("What is 70 multiplied by 2?"), is("140"));
  }

  
  public void squareAndCube() {
    assertThat(queryProcessor.process("Which of the following numbers is both a square and a cube: 4541, 3375, 1089, 4096, 4885, 59, 1362?"),
            is("4096"));

  }

/*  @Test
  public void asdasda() {
    List<Integer> squares = new java.util.ArrayList<>(Collections.emptyList());
    List<Integer> cubes = new java.util.ArrayList<>(Collections.emptyList());
    for(int i = 0; i <= 5000; i++) {
      squares.add(i * i);
      cubes.add(i * i * i);
    }

    System.out.println(squares.stream().filter(cubes::contains).collect(Collectors.toList()));

  }*/
}
