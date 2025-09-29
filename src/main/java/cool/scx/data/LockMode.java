package cool.scx.data;

/// LockMode
///
/// @author scx567888
/// @version 0.0.1
public enum LockMode {

    /// 共享锁, 允许多个读取, 阻止写入
    SHARED,

    /// 排他锁, 阻止读取和写入
    EXCLUSIVE

}
