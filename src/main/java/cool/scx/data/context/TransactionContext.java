package cool.scx.data.context;

import cool.scx.data.exception.DataAccessException;

/// TransactionContext
///
/// @author scx567888
/// @version 0.0.1
public interface TransactionContext {

    /// 提交事务
    void commit() throws DataAccessException;

    /// 回滚事务
    void rollback() throws DataAccessException;

}
