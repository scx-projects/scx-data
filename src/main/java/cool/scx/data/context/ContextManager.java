package cool.scx.data.context;

import cool.scx.data.exception.DataAccessException;
import cool.scx.function.Function0;
import cool.scx.function.Function0Void;

/// ContextManager
///
/// @author scx567888
/// @version 0.0.1
public interface ContextManager {

    /// 在自动管理的上下文中执行
    <V, X extends Throwable> V autoContext(Function0<V, X> handler) throws DataAccessException, X;

    /// 在自动管理的上下文中执行
    <X extends Throwable> void autoContext(Function0Void<X> handler) throws DataAccessException, X;

}
