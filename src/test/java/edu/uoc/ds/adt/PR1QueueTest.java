package edu.uoc.ds.adt;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PR1QueueTest {
    PR1Queue pr1q;

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
    private void fillQueue() {
        for (int c = 0; this.pr1q.getQueue().size() < this.pr1q.CAPACITY; c++) {
            if(isPrime(c)) {
                pr1q.add(c);
            }
        }
    }
    @Before
    public void setUp() {
        this.pr1q = new PR1Queue();

        assertNotNull(this.pr1q.getQueue());
        fillQueue();
    }

    @After
    public void release() {
        this.pr1q = null;
    }


    @org.junit.Test
    public void queueTest() {
        assertEquals(this.pr1q.CAPACITY, this.pr1q.getQueue().size());
        Assert.assertEquals((Integer)2, pr1q.poll());
        Assert.assertEquals((Integer)3, pr1q.poll());
        Assert.assertEquals((Integer)5, pr1q.poll());
        Assert.assertEquals((Integer)7, pr1q.poll());
        Assert.assertEquals((Integer)11, pr1q.poll());
        Assert.assertEquals((Integer)13, pr1q.poll());
        Assert.assertEquals((Integer)17, pr1q.poll());
        Assert.assertEquals((Integer)19, pr1q.poll());
        Assert.assertEquals((Integer)23, pr1q.poll());
        Assert.assertEquals((Integer)29, pr1q.poll());
        Assert.assertEquals((Integer)31, pr1q.poll());
        Assert.assertEquals((Integer)37, pr1q.poll());
        Assert.assertEquals((Integer)41, pr1q.poll());
        Assert.assertEquals((Integer)43, pr1q.poll());
        Assert.assertEquals((Integer)47, pr1q.poll());
        assertEquals(0, this.pr1q.getQueue().size());
    }

}
