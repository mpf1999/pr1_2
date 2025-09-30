package edu.uoc.ds.adt;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PR1StackTest {

    PR1Stack pr1s;

    private boolean isPrime(int n) {
        if(n <= 1) return false;
        if(n == 2) return true;

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void fillStack() {
        for(int c = 0; this.pr1s.getStack().size() < this.pr1s.CAPACITY; c++){
            if(isPrime(c)) {
                pr1s.push(c);
            }
        }
    }

    @Before
    public void setUp() {
        this.pr1s = new PR1Stack();

        assertNotNull(this.pr1s.getStack());
        this.fillStack();

    }

    @After
    public void release() {
        this.pr1s = null;
    }


    @org.junit.Test
    public void stackTest() {

        assertEquals(this.pr1s.CAPACITY, this.pr1s.getStack().size());
        Assert.assertEquals((Integer)47, pr1s.pop());
        Assert.assertEquals((Integer)43, pr1s.pop());
        Assert.assertEquals((Integer)41, pr1s.pop());
        Assert.assertEquals((Integer)37, pr1s.pop());
        Assert.assertEquals((Integer)31, pr1s.pop());
        Assert.assertEquals((Integer)29, pr1s.pop());
        Assert.assertEquals((Integer)23, pr1s.pop());
        Assert.assertEquals((Integer)19, pr1s.pop());
        Assert.assertEquals((Integer)17, pr1s.pop());
        Assert.assertEquals((Integer)13, pr1s.pop());
        Assert.assertEquals((Integer)11, pr1s.pop());
        Assert.assertEquals((Integer)7, pr1s.pop());
        Assert.assertEquals((Integer)5, pr1s.pop());
        Assert.assertEquals((Integer)3, pr1s.pop());
        Assert.assertEquals((Integer)2, pr1s.pop());

        assertEquals(0, this.pr1s.getStack().size());
    }
}
