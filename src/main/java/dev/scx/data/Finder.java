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

    /// 当 entityConsumer 中发生 DataAccessException 时, 为了防止混淆 会抛出 ScxWrappedException
    <X extends Throwable> void forEach(Function1Void<Entity, X> entityConsumer) throws DataAccessException, X, ScxWrappedException;

    /// 当 entityConsumer 中发生 DataAccessException 时, 为了防止混淆 会抛出 ScxWrappedException
    <T, X extends Throwable> void forEach(Function1Void<T, X> entityConsumer, Class<T> resultType) throws DataAccessException, X, ScxWrappedException;

    /// 当 entityConsumer 中发生 DataAccessException 时, 为了防止混淆 会抛出 ScxWrappedException
    <X extends Throwable> void forEachMap(Function1Void<Map<String, Object>, X> entityConsumer) throws DataAccessException, X, ScxWrappedException;

    Entity first() throws DataAccessException;

    <T> T first(Class<T> resultType) throws DataAccessException;

    Map<String, Object> firstMap() throws DataAccessException;

    long count() throws DataAccessException;

}
