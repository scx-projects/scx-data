package dev.scx.data;

import dev.scx.data.exception.DataAccessException;
import dev.scx.exception.ScxWrappedException;
import dev.scx.function.Function1Void;

import java.util.List;
import java.util.Map;

/// Aggregator
///
/// @author scx567888
/// @version 0.0.1
public interface Aggregator {

    <T> List<T> list(Class<T> resultType) throws DataAccessException;

    List<Map<String, Object>> list() throws DataAccessException;

    /// 当 resultConsumer 中发生 DataAccessException 时, 为了防止混淆 会抛出 ScxWrappedException
    <T, X extends Throwable> void forEach(Function1Void<T, X> resultConsumer, Class<T> resultType) throws DataAccessException, X, ScxWrappedException;

    /// 当 resultConsumer 中发生 DataAccessException 时, 为了防止混淆 会抛出 ScxWrappedException
    <X extends Throwable> void forEach(Function1Void<Map<String, Object>, X> resultConsumer) throws DataAccessException, X, ScxWrappedException;

    <T> T first(Class<T> resultType) throws DataAccessException;

    Map<String, Object> first() throws DataAccessException;

}
