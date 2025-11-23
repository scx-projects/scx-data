package dev.scx.data.test;

import dev.scx.data.context.TransactionContext;
import dev.scx.data.exception.DataAccessException;

public class TestTransactionContext implements TransactionContext {

    @Override
    public void commit() throws DataAccessException {

    }

    @Override
    public void rollback() throws DataAccessException {

    }

}
