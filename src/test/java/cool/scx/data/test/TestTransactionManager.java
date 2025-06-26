package cool.scx.data.test;

import cool.scx.data.context.TransactionManager;
import cool.scx.data.exception.DataAccessException;
import cool.scx.functional.ScxCallable;
import cool.scx.functional.ScxConsumer;
import cool.scx.functional.ScxFunction;
import cool.scx.functional.ScxRunnable;

public class TestTransactionManager implements TransactionManager<TestTransactionContext> {

    @Override
    public <T, E extends Throwable> T withTransaction(ScxFunction<TestTransactionContext, T, E> handler) throws DataAccessException, E {
        return null;
    }

    @Override
    public <E extends Throwable> void withTransaction(ScxConsumer<TestTransactionContext, E> handler) throws DataAccessException, E {

    }

    @Override
    public <T, E extends Throwable> T autoTransaction(ScxCallable<T, E> handler) throws DataAccessException, E {
        return null;
    }

    @Override
    public <E extends Throwable> void autoTransaction(ScxRunnable<E> handler) throws DataAccessException, E {

    }

    @Override
    public <T, E extends Throwable> T autoContext(ScxCallable<T, E> handler) throws DataAccessException, E {
        return null;
    }

    @Override
    public <E extends Throwable> void autoContext(ScxRunnable<E> handler) throws DataAccessException, E {

    }

}
