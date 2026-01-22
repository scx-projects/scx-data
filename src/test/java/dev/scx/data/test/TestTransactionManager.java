package dev.scx.data.test;

import dev.scx.data.context.TransactionManager;
import dev.scx.data.exception.DataAccessException;
import dev.scx.exception.ScxWrappedException;
import dev.scx.function.Function0;
import dev.scx.function.Function0Void;
import dev.scx.function.Function1;
import dev.scx.function.Function1Void;

public class TestTransactionManager implements TransactionManager<TestTransactionContext> {

    @Override
    public <T> T withTransaction(Function1<TestTransactionContext, T, ?> handler) throws DataAccessException, ScxWrappedException {
        return null;
    }

    @Override
    public void withTransaction(Function1Void<TestTransactionContext, ?> handler) throws DataAccessException, ScxWrappedException {

    }

    @Override
    public <T> T autoTransaction(Function0<T, ?> handler) throws DataAccessException, ScxWrappedException {
        return null;
    }

    @Override
    public void autoTransaction(Function0Void<?> handler) throws DataAccessException, ScxWrappedException {

    }

    @Override
    public <V> V autoContext(Function0<V, ?> handler) throws DataAccessException, ScxWrappedException {
        return null;
    }

    @Override
    public void autoContext(Function0Void<?> handler) throws DataAccessException, ScxWrappedException {

    }

}
