package cool.scx.data.test;

import cool.scx.data.context.TransactionContext;
import cool.scx.data.exception.DataAccessException;

public class TestTransactionContext implements TransactionContext {

    @Override
    public void commit() throws DataAccessException {

    }

    @Override
    public void rollback() throws DataAccessException {

    }

}
