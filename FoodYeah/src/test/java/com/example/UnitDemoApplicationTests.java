package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    public void test_doubleANumber() {
        assertEquals(6, product.doubleANumber(3));
    }
 
    @Ignore
    public void test_not_executed() {
        fail("It should not executed");
    }
 
    @Test
    public void test_returnBooleanFoo_false() {
        boolean shouldReturnFalse = product.returnABoolean("NA");
        assertFalse(shouldReturnFalse);
    }
 
    @Test
    public void test_returnBooleanFoo_true() {
        boolean shouldReturnTrue = product.returnABoolean("Save");
        assertTrue(shouldReturnTrue);
    }
 
    @Test
    public void test_voidFoo() throws IllegalAccessException {
        try {
            product.voidFoo("OK");
        } catch (Exception e) {
            fail("Should not throw exception");
        }
    }

}
