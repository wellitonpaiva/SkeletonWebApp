package com.develogical;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

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
}
