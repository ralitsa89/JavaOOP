package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class IteratorTest {
    private ListIterator listIterator;
    private static final String[] NAMES = {"Pesho", "Tosho", "Gosho"};

    @Before
    public void prepare() throws OperationNotSupportedException {
        listIterator = new ListIterator(NAMES);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWithNull() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testConstructorShouldCreate() throws OperationNotSupportedException {
        new ListIterator(NAMES);
    }

    @Test
    public void testHasNext(){
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void testMove(){
        Assert.assertTrue(listIterator.move());
        Assert.assertTrue(listIterator.move());
        Assert.assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintShouldThrowWithEmptyIterator() throws IllegalStateException, OperationNotSupportedException {
        ListIterator emptyIterator = new ListIterator();
        emptyIterator.print();
    }

    @Test
    public void testPrintShouldReturn(){
        Assert.assertEquals(NAMES[0], listIterator.print());
        listIterator.move();
        Assert.assertEquals(NAMES[1], listIterator.print());
    }
}
