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

    /// 当 resultConsumer 中发生 异常 时, 会抛出 [ScxWrappedException]
    <T> void forEach(Function1Void<T, ?> resultConsumer, Class<T> resultType) throws DataAccessException, ScxWrappedException;

    /// 当 resultConsumer 中发生 异常 时, 会抛出 [ScxWrappedException]
    void forEach(Function1Void<Map<String, Object>, ?> resultConsumer) throws DataAccessException, ScxWrappedException;

    <T> T first(Class<T> resultType) throws DataAccessException;

    Map<String, Object> first() throws DataAccessException;

}
