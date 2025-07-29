package cool.scx.data.test;

import cool.scx.data.context.TransactionManager;
import cool.scx.data.exception.DataAccessException;
import cool.scx.function.CallableX;
import cool.scx.function.ConsumerX;
import cool.scx.function.FunctionX;
import cool.scx.function.RunnableX;

public class TestTransactionManager implements TransactionManager<TestTransactionContext> {

    @Override
    public <T, X extends Throwable> T withTransaction(FunctionX<TestTransactionContext, T, X> handler) throws DataAccessException, X {
        return null;
    }

    @Override
    public <X extends Throwable> void withTransaction(ConsumerX<TestTransactionContext, X> handler) throws DataAccessException, X {

    }

    @Override
    public <T, X extends Throwable> T autoTransaction(CallableX<T, X> handler) throws DataAccessException, X {
        return null;
    }

    @Override
    public <X extends Throwable> void autoTransaction(RunnableX<X> handler) throws DataAccessException, X {

    }

    @Override
    public <V, X extends Throwable> V autoContext(CallableX<V, X> handler) throws DataAccessException, X {
        return null;
    }

    @Override
    public <X extends Throwable> void autoContext(RunnableX<X> handler) throws DataAccessException, X {

    }

}
