package cool.scx.data.test;

import cool.scx.data.context.TransactionManager;
import cool.scx.data.exception.DataAccessException;
import cool.scx.function.Function0;
import cool.scx.function.Function0Void;
import cool.scx.function.Function1;
import cool.scx.function.Function1Void;

public class TestTransactionManager implements TransactionManager<TestTransactionContext> {

    @Override
    public <T, X extends Throwable> T withTransaction(Function1<TestTransactionContext, T, X> handler) throws DataAccessException, X {
        return null;
    }

    @Override
    public <X extends Throwable> void withTransaction(Function1Void<TestTransactionContext, X> handler) throws DataAccessException, X {

    }

    @Override
    public <T, X extends Throwable> T autoTransaction(Function0<T, X> handler) throws DataAccessException, X {
        return null;
    }

    @Override
    public <X extends Throwable> void autoTransaction(Function0Void<X> handler) throws DataAccessException, X {

    }

    @Override
    public <V, X extends Throwable> V autoContext(Function0<V, X> handler) throws DataAccessException, X {
        return null;
    }

    @Override
    public <X extends Throwable> void autoContext(Function0Void<X> handler) throws DataAccessException, X {

    }

}
