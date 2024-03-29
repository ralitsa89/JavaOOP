import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ChainblockImplTest {
    private Chainblock database;
    private List<Transaction> transactions;

    @Before
    public void setUp() {
        this.database = new ChainblockImpl();
        this.transactions = new ArrayList<>();
        prepareTransactionForTests();
    }

    private void prepareTransactionForTests() {
        Transaction transaction = new TransactionImpl(1, TransactionStatus.SUCCESSFUL,
                "Desi", "Zahari", 150.50);
        Transaction transaction1 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL,
                "Desi", "Emil", 120.50);
        Transaction transaction2 = new TransactionImpl(3, TransactionStatus.FAILED,
                "Petar", "Emil", 100.50);
        this.transactions.add(transaction);
        this.transactions.add(transaction1);
        this.transactions.add(transaction2);
    }

    @Test
    public void testAddCorrectTransaction() {


        Assert.assertEquals(0, this.database.getCount());

        this.database.add(this.transactions.get(0));
        Assert.assertEquals(1, this.database.getCount());
    }

    @Test
    public void testAddExistingTransaction() {


        Assert.assertEquals(0, this.database.getCount());
        this.database.add(this.transactions.get(0));
        Assert.assertEquals(1, this.database.getCount());
        this.database.add(this.transactions.get(0));
        Assert.assertEquals(1, this.database.getCount());
    }

    @Test
    public void testContains() {

        Assert.assertFalse(this.database.contains(this.transactions.get(0)));
        Assert.assertFalse(this.database.contains(this.transactions.get(0).getId()));

        this.database.add(this.transactions.get(0));
        Assert.assertTrue(this.database.contains(this.transactions.get(0)));
        Assert.assertTrue(this.database.contains(this.transactions.get(0).getId()));
    }

    @Test
    public void testChangeTransactionStatus() {

        this.database.add(this.transactions.get(0));
        Assert.assertEquals(1, this.database.getCount());
        this.database.changeTransactionStatus(1, TransactionStatus.ABORTED);
        Assert.assertEquals(TransactionStatus.ABORTED, this.transactions.get(0).getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTransactionStatusInvalidId() {

        this.database.add(this.transactions.get(0));
        Assert.assertEquals(1, this.database.getCount());
        this.database.changeTransactionStatus(2, TransactionStatus.ABORTED);
    }

    @Test
    public void testRemoveTransactionById() {
        this.database.add(this.transactions.get(0));
        this.database.add(this.transactions.get(1));
        Assert.assertEquals(2, this.database.getCount());

        int id = this.transactions.get(0).getId();
        this.database.removeTransactionById(id);

        Assert.assertEquals(1, this.database.getCount());
        Assert.assertFalse(this.database.contains(id));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionByIdThrowInvalidId() {
        this.database.add(this.transactions.get(0));
        this.database.removeTransactionById(5);
    }

    @Test
    public void testGetById() {
        Transaction transaction = this.transactions.get(0);
        this.database.add(transaction);

        Transaction returnedTransaction = this.database.getById(transaction.getId());

        Assert.assertEquals(transaction.getId(), returnedTransaction.getId());
        Assert.assertEquals(transaction.getStatus(), returnedTransaction.getStatus());
        Assert.assertEquals(transaction.getFrom(), returnedTransaction.getFrom());
        Assert.assertEquals(transaction.getTo(), returnedTransaction.getTo());
        Assert.assertEquals(transaction.getAmount(), returnedTransaction.getAmount(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdThrowInvalidId() {
        this.database.add(this.transactions.get(0));
        this.database.getById(5);
    }

    @Test
    public void testGetByTransactionStatus() {
        List<Transaction> expectedTransactions = this.transactions
                .stream()
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .collect(Collectors.toList());

        fillDatabaseWithTransaction();

        Iterable<Transaction> result = this.database.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<Transaction> returnedTransactions = new ArrayList<>();
        result.forEach(returnedTransactions::add);

        Assert.assertEquals(expectedTransactions.size(), returnedTransactions.size());

        returnedTransactions.forEach(t -> Assert.assertEquals(TransactionStatus.SUCCESSFUL, t.getStatus()));

        Assert.assertEquals(expectedTransactions, returnedTransactions);
    }

    private void fillDatabaseWithTransaction() {
        this.database.add(this.transactions.get(2));
        this.database.add(this.transactions.get(1));
        this.database.add(this.transactions.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusInvalidStatus() {
        fillDatabaseWithTransaction();

        this.database.getByTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void testGetAllSendersWithTransactionStatus() {
        fillDatabaseWithTransaction();
        this.database.add(new TransactionImpl(4, TransactionStatus.SUCCESSFUL,
                "Petar", "Desi", 980.40));

        Iterable<String> result = this.database.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<String> returnedSenders = new ArrayList<>();
        result.forEach(returnedSenders::add);
        Assert.assertEquals(3, returnedSenders.size());
        Assert.assertEquals("Petar", returnedSenders.get(0));
        Assert.assertEquals("Desi", returnedSenders.get(1));
        Assert.assertEquals("Desi", returnedSenders.get(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionStatusTrowInvalidStatus() {
        fillDatabaseWithTransaction();
        this.database.getAllSendersWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    //TODO: getAllReceiversWithTransactionStatus

    @Test
    public void testGetAllOrderedByAmountDescendingThenById() {
        fillDatabaseWithTransaction();

        Iterable<Transaction> result = this.database.getAllOrderedByAmountDescendingThenById();
        List<Transaction> returned = new ArrayList<>();
        result.forEach(returned::add);

        List<Transaction> expected = this.transactions
                .stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        Assert.assertEquals(expected, returned);
    }

   //TODO:
}