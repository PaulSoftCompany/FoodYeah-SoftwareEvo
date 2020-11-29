package com.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources")
public class CucumberIntegrationTest {
    
    private Card cardTesteo = new Card();

    @Rule
    public Card card = new Card();
 
    @Before
    public void setup() {
        cardTesteo = new Card();
        System.out.println("Start " + card.getMethodName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_voidFoo_exception() throws IllegalAccessException {
        cardTesteo.voidFoo("NA");
    }
     
    @Test(timeout = 1)
    public void test_timeout() {
        cardTesteo.doubleANumber(9999);
    }

}
