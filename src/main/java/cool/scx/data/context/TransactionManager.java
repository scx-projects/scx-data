package cool.scx.data.context;

import cool.scx.data.exception.DataAccessException;
import cool.scx.function.CallableX;
import cool.scx.function.ConsumerX;
import cool.scx.function.FunctionX;
import cool.scx.function.RunnableX;

/// TransactionManager
///
/// @param <C>
/// @author scx567888
/// @version 0.0.1
public interface TransactionManager<C extends TransactionContext> extends ContextManager {

    /// 需手动处理事务
    <T, X extends Throwable> T withTransaction(FunctionX<C, T, X> handler) throws DataAccessException, X;

    /// 需手动处理事务
    <X extends Throwable> void withTransaction(ConsumerX<C, X> handler) throws DataAccessException, X;

    /// 无异常自动提交 异常自动回滚
    <T, X extends Throwable> T autoTransaction(CallableX<T, X> handler) throws DataAccessException, X;

    /// 无异常自动提交 异常自动回滚
    <X extends Throwable> void autoTransaction(RunnableX<X> handler) throws DataAccessException, X;

}
