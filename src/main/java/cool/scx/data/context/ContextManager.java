package cool.scx.data.context;

import cool.scx.data.exception.DataAccessException;
import cool.scx.functional.ScxCallable;
import cool.scx.functional.ScxRunnable;

/// ContextManager
///
/// @author scx567888
/// @version 0.0.1
public interface ContextManager {

    /// 在自动管理的上下文中执行
    <T, E extends Throwable> T autoContext(ScxCallable<T, E> handler) throws DataAccessException, E;

    /// 在自动管理的上下文中执行
    <E extends Throwable> void autoContext(ScxRunnable<E> handler) throws DataAccessException, E;

}
