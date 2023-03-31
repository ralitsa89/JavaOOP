package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {

    CustomLinkedList<String> list;

    @Before
    public void prepare(){
        list = new CustomLinkedList<>();
        list.add("Pesho");
        list.add("Gosho");
        list.add("Tosho");
    }

    @Test
    public void testAddShouldAdd(){
        int previousSize = list.getCount();
        list.add("Andrei");
        int currentSize = list.getCount();
        assertEquals(previousSize + 1 , currentSize);
        assertEquals(list.getCount() - 1, list.indexOf("Andrei"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetShouldThrowWhitNegativeIndex(){
        list.get(-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetShouldThrowWhitBigIndex(){
        list.get(list.getCount() + 1);
    }

    @Test
    public void testGetShouldGet(){
        assertEquals("Gosho", list.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetShouldThrowWhitNegativeIndex(){
        list.set(-2, "Toshko");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetShouldThrowWhitBigIndex(){
        list.set(list.getCount() + 1, "Andrei");
    }

    @Test
    public void testSetShouldSet(){
        list.set(1, "Ivan");
        assertEquals("Ivan", list.get(1));
    }

    @Test
    public void testIndexOfShouldFindIndex(){
        assertEquals(1, list.indexOf("Gosho"));
    }
    @Test
    public void testIndexOfShouldNotFindIndex(){
        assertEquals(-1, list.indexOf("Evgeni"));
    }
    @Test
    public void testContainsShouldReturnTrue(){
        assertTrue(list.contains("Gosho"));
    }
    @Test
    public void testContainsShouldReturnFalse(){
        assertFalse(list.contains("Dimo"));
    }
    @Test
    public void testRemoveWithMissingElement(){
        assertEquals(-1, list.remove("Trayan"));
    }
    @Test
    public void testRemoveShouldRemoveElement(){
        int countBeforeRemove = list.getCount();
        assertEquals(1, list.remove("Gosho"));
        int countAfterRemove = list.getCount();
        assertEquals(countBeforeRemove - 1, countAfterRemove);
        assertEquals( - 1, list.indexOf("Gosho"));
    }
    @Test
    public void testRemoveAtIndexShouldRemove(){
        int countBeforeRemove = list.getCount();
        assertEquals("Gosho", list.removeAt(1));
        int countAfterRemove = list.getCount();
        assertEquals(countBeforeRemove - 1, countAfterRemove);
    }
}
