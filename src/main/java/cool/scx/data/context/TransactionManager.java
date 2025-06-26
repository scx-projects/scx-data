package cool.scx.data.context;

import cool.scx.data.exception.DataAccessException;
import cool.scx.functional.ScxCallable;
import cool.scx.functional.ScxConsumer;
import cool.scx.functional.ScxFunction;
import cool.scx.functional.ScxRunnable;

/// TransactionManager
///
/// @param <C>
/// @author scx567888
/// @version 0.0.1
public interface TransactionManager<C extends TransactionContext> extends ContextManager {

    /// 需手动处理事务
    <T, E extends Throwable> T withTransaction(ScxFunction<C, T, E> handler) throws DataAccessException, E;

    /// 需手动处理事务
    <E extends Throwable> void withTransaction(ScxConsumer<C, E> handler) throws DataAccessException, E;

    /// 无异常自动提交 异常自动回滚
    <T, E extends Throwable> T autoTransaction(ScxCallable<T, E> handler) throws DataAccessException, E;

    /// 无异常自动提交 异常自动回滚
    <E extends Throwable> void autoTransaction(ScxRunnable<E> handler) throws DataAccessException, E;

}
