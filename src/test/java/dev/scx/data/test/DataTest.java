package dev.scx.data.test;

import dev.scx.data.exception.DataAccessException;
import org.testng.annotations.Test;

import static dev.scx.data.query.QueryBuilder.eq;

public class DataTest {

    public static void main(String[] args) throws DataAccessException {
        test1();
    }

    @Test
    public static void test1() throws DataAccessException {
        var repo = new TestRepository<>();

        //方式1
        var m = new TestTransactionManager();
        m.withTransaction(tc1 -> {
            repo.find(eq("id", 1));
            repo.delete(eq("id", 1));
            tc1.commit();
        });

        //方式2
        m.autoTransaction(() -> {
            repo.find(eq("id", 1));
            repo.delete(eq("id", 1));
        });

    }

}
