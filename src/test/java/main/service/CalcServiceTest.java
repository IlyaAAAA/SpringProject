package main.service;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CalcServiceTest extends TestCase {

    private final CalcService calcService = new CalcService();

    @Test
    public void testSumInts() {
        int a = 1049324;
        int b = 23143;

        int sum = a + b;


        Assert.assertEquals(sum, calcService.sumInts(a, b));
    }
}