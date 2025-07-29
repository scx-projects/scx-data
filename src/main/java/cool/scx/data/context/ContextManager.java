package cool.scx.data.context;

import cool.scx.data.exception.DataAccessException;
import cool.scx.function.CallableX;
import cool.scx.function.RunnableX;

/// ContextManager
///
/// @author scx567888
/// @version 0.0.1
public interface ContextManager {

    /// 在自动管理的上下文中执行
    <V, X extends Throwable> V autoContext(CallableX<V, X> handler) throws DataAccessException, X;

    /// 在自动管理的上下文中执行
    <X extends Throwable> void autoContext(RunnableX<X> handler) throws DataAccessException, X;

}
