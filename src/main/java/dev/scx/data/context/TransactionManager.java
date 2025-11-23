package dev.scx.data.context;

import dev.scx.data.exception.DataAccessException;
import dev.scx.exception.ScxWrappedException;
import dev.scx.function.Function0;
import dev.scx.function.Function0Void;
import dev.scx.function.Function1;
import dev.scx.function.Function1Void;

/// TransactionManager
///
/// @param <C>
/// @author scx567888
/// @version 0.0.1
public interface TransactionManager<C extends TransactionContext> extends ContextManager {

    /// 需手动处理事务
    /// 当 handler 中发生 DataAccessException 时, 为了防止混淆 会抛出 ScxWrappedException
    <T, X extends Throwable> T withTransaction(Function1<C, T, X> handler) throws DataAccessException, X, ScxWrappedException;

    /// 需手动处理事务
    /// 当 handler 中发生 DataAccessException 时, 为了防止混淆 会抛出 ScxWrappedException
    <X extends Throwable> void withTransaction(Function1Void<C, X> handler) throws DataAccessException, X, ScxWrappedException;

    /// 无异常自动提交 异常自动回滚
    /// 当 handler 中发生 DataAccessException 时, 为了防止混淆 会抛出 ScxWrappedException
    <T, X extends Throwable> T autoTransaction(Function0<T, X> handler) throws DataAccessException, X, ScxWrappedException;

    /// 无异常自动提交 异常自动回滚
    /// 当 handler 中发生 DataAccessException 时, 为了防止混淆 会抛出 ScxWrappedException
    <X extends Throwable> void autoTransaction(Function0Void<X> handler) throws DataAccessException, X, ScxWrappedException;

}
