package dev.scx.data.context;

import dev.scx.data.exception.DataAccessException;
import dev.scx.exception.ScxWrappedException;
import dev.scx.function.Function0;
import dev.scx.function.Function0Void;

/// ContextManager
///
/// @author scx567888
/// @version 0.0.1
public interface ContextManager {

    /// 在自动管理的上下文中执行
    /// 当 handler 中发生 DataAccessException 时, 为了防止混淆 会抛出 ScxWrappedException
    <V, X extends Throwable> V autoContext(Function0<V, X> handler) throws DataAccessException, X, ScxWrappedException;

    /// 在自动管理的上下文中执行
    /// 当 handler 中发生 DataAccessException 时, 为了防止混淆 会抛出 ScxWrappedException
    <X extends Throwable> void autoContext(Function0Void<X> handler) throws DataAccessException, X, ScxWrappedException;

}
