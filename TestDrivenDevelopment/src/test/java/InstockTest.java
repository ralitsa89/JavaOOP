import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class InstockTest {
    private ProductStock stock;

    @Before
    public void setUp() {
        this.stock = new Instock();
    }

    @Test
    public void testContainsAndAdd() {
        Product product = new Product("water", 1.20, 2);
        Assert.assertFalse(this.stock.contains(product));
        this.stock.add(product);
        Assert.assertTrue(this.stock.contains(product));
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(0, this.stock.getCount());
        fillStock();
//        this.stock.add(product1);
//        this.stock.add(product2);
        Assert.assertEquals(3, this.stock.getCount());
    }

    @Test
    public void testFindReturnCorrectProduct() {
        fillStock();

        Product fondProduct = this.stock.find(2);

        Assert.assertEquals(fondProduct.getLabel(), "cheese");
        Assert.assertEquals(fondProduct.getQuantity(), 5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindThrowExceptionIndexGreater() {
        fillStock();
        this.stock.find(4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindThrowExceptionIndexNegative() {
        fillStock();
        this.stock.find(-1);
    }

    private void fillStock() {
        Product product1 = new Product("water", 1.20, 2);
        Product product2 = new Product("bread", 2.90, 3);
        Product product3 = new Product("cheese", 3.90, 5);
        this.stock.add(product1);
        this.stock.add(product2);
        this.stock.add(product3);
    }

    @Test
    public void testChangeQuantitySuccessfulUpdate() {
        fillStock();
        Product productBread = this.stock.find(1);
        this.stock.changeQuantity("bread", 9);

        Assert.assertEquals(productBread.getQuantity(), 9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityTrowInvalidProduct() {
        fillStock();
        this.stock.changeQuantity("wine", 8);
    }

    @Test
    public void testFindByLabelReturnCorrectProduct() {
        fillStock();

        Product expectedProduct = this.stock.find(0);
        Product returnedProduct = this.stock.findByLabel("water");
        Assert.assertEquals(expectedProduct.getLabel(), returnedProduct.getLabel());
        Assert.assertEquals(expectedProduct.getQuantity(), returnedProduct.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelThrowInvalidProduct() {
        fillStock();
        this.stock.findByLabel("potato");
    }

    @Test
    public void testFindByAlphabeticalOrderCorrectCountProducts() {
        fillStock();
        Iterable<Product> iterable = this.stock.findFirstByAlphabeticalOrder(2);
        int countGetProducts = 0;
        for (Product product : iterable) {
            countGetProducts++;
        }
        Assert.assertEquals(2, countGetProducts);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderCorrectlySorted() {
        List<String> expectedProductLabels = new ArrayList<>();
        Product product1 = new Product("water", 1.20, 2);
        Product product2 = new Product("bread", 1.90, 3);
        Product product3 = new Product("cheese", 3.40, 5);
        this.stock.add(product1);
        expectedProductLabels.add(product1.getLabel());
        this.stock.add(product2);
        expectedProductLabels.add(product2.getLabel());
        this.stock.add(product3);
        expectedProductLabels.add(product3.getLabel());

        expectedProductLabels = expectedProductLabels
                .stream()
                .sorted()
                .collect(Collectors.toList());

        Iterable<Product> iterable = this.stock.findFirstByAlphabeticalOrder(3);
        List<String> returnedProductLabels = new ArrayList<>();

        for (Product product : iterable) {
            returnedProductLabels.add(product.getLabel());
        }
        Assert.assertEquals(expectedProductLabels, returnedProductLabels);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderThrowInvalidCount() {
        fillStock();

        Iterable<Product> iterable = this.stock.findFirstByAlphabeticalOrder(5);
        List<Product> returnedProducts = getProductsFromIterable(iterable);
        Assert.assertTrue(returnedProducts.isEmpty());
    }

    @Test
    public void testFindAllInPriceRange() {
        fillStock();
        Iterable<Product> returnedProducts = this.stock.findAllInRange(1.10, 3.50);
        int countReturnedProducts = 0;
        for (Product product : returnedProducts) {
            countReturnedProducts++;
        }
        Assert.assertEquals(2, countReturnedProducts);
    }
    @Test
    public void testFindAllInPriceRangeCorrectOrder(){
        fillStock();
        Iterable<Product> iterable = this.stock.findAllInRange(1.10, 2.95);

        List<Product> returnedProducts = getProductsFromIterable(iterable);
        Assert.assertEquals("bread", returnedProducts.get(0).getLabel());
        Assert.assertEquals("water", returnedProducts.get(1).getLabel());
    }
    @Test
    public void testFindAllInPriceRangeNoneMatch(){
        Iterable<Product> iterable = this.stock.findAllInRange(10, 20);
        Assert.assertFalse(iterable.iterator().hasNext());
    }
    @Test
    public void testFindAllByPriceCorrectProducts(){
        fillStock();
        Iterable<Product> iterable = this.stock.findAllByPrice(3.90);
        List<Product> returnedProducts = getProductsFromIterable(iterable);
        Assert.assertEquals(1, returnedProducts.size());
        Assert.assertEquals("cheese", returnedProducts.get(0).getLabel());
    }

    private List<Product> getProductsFromIterable(Iterable<Product> iterable) {
        List<Product> returnedProducts = new ArrayList<>();
        for (Product product : iterable) {
            returnedProducts.add(product);
        }
        return returnedProducts;
    }

    @Test
    public void testFindAllByPriceEmptyProducts(){
        Iterable<Product> iterable = this.stock.findAllByPrice(13.90);
        Assert.assertFalse(iterable.iterator().hasNext());
    }
    //TODO: findFirstMostExpensiveProducts
    //TODO: findAllByQuantity

    @Test
    public void testIterator(){
        fillStock();
        Iterator<Product>iterator = this.stock.iterator();
        List<Product> returnedProducts = new ArrayList<>();
        while (iterator.hasNext()){
            returnedProducts.add(iterator.next());
        }
    }
    //TODO: returnedProducts са същите като добавените във fillStock
}