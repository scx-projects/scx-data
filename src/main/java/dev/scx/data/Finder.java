package dev.scx.data;

import dev.scx.data.exception.DataAccessException;
import dev.scx.exception.ScxWrappedException;
import dev.scx.function.Function1Void;

import java.util.List;
import java.util.Map;

/// Finder
///
/// @param <Entity> Entity
/// @author scx567888
/// @version 0.0.1
public interface Finder<Entity> {

    List<Entity> list() throws DataAccessException;

    <T> List<T> list(Class<T> resultType) throws DataAccessException;

    List<Map<String, Object>> listMap() throws DataAccessException;

    /// 当 entityConsumer 中发生 异常 时, 会抛出 [ScxWrappedException]
    void forEach(Function1Void<Entity, ?> entityConsumer) throws DataAccessException, ScxWrappedException;

    /// 当 entityConsumer 中发生 异常 时, 会抛出 [ScxWrappedException]
    <T> void forEach(Function1Void<T, ?> entityConsumer, Class<T> resultType) throws DataAccessException, ScxWrappedException;

    /// 当 entityConsumer 中发生 异常 时, 会抛出 [ScxWrappedException]
    void forEachMap(Function1Void<Map<String, Object>, ?> entityConsumer) throws DataAccessException, ScxWrappedException;

    /// 找不到 返回 null
    Entity first() throws DataAccessException;

    /// 找不到 返回 null
    <T> T first(Class<T> resultType) throws DataAccessException;

    /// 找不到 返回 null
    Map<String, Object> firstMap() throws DataAccessException;

    /// 忽略 offset 和 limit
    long count() throws DataAccessException;

}
