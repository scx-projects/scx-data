package cool.scx.data;

import cool.scx.data.exception.DataAccessException;
import cool.scx.function.Function1Void;

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

    <X extends Throwable> void forEach(Function1Void<Entity, X> entityConsumer) throws DataAccessException, X;

    <T, X extends Throwable> void forEach(Function1Void<T, X> entityConsumer, Class<T> resultType) throws DataAccessException, X;

    <X extends Throwable> void forEachMap(Function1Void<Map<String, Object>, X> entityConsumer) throws DataAccessException, X;

    Entity first() throws DataAccessException;

    <T> T first(Class<T> resultType) throws DataAccessException;

    Map<String, Object> firstMap() throws DataAccessException;

    long count() throws DataAccessException;

}
