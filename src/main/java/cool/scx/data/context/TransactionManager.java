package cool.scx.data.context;

import cool.scx.data.exception.DataAccessException;
import cool.scx.function.Function0;
import cool.scx.function.Function0Void;
import cool.scx.function.Function1;
import cool.scx.function.Function1Void;

/// TransactionManager
///
/// @param <C>
/// @author scx567888
/// @version 0.0.1
public interface TransactionManager<C extends TransactionContext> extends ContextManager {

    /// 需手动处理事务
    <T, X extends Throwable> T withTransaction(Function1<C, T, X> handler) throws DataAccessException, X;

    /// 需手动处理事务
    <X extends Throwable> void withTransaction(Function1Void<C, X> handler) throws DataAccessException, X;

    /// 无异常自动提交 异常自动回滚
    <T, X extends Throwable> T autoTransaction(Function0<T, X> handler) throws DataAccessException, X;

    /// 无异常自动提交 异常自动回滚
    <X extends Throwable> void autoTransaction(Function0Void<X> handler) throws DataAccessException, X;

}
