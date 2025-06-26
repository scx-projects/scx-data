package cool.scx.data;

import cool.scx.data.exception.DataAccessException;
import cool.scx.functional.ScxConsumer;

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

    <E extends Throwable> void forEach(ScxConsumer<Entity, E> entityConsumer) throws DataAccessException, E;

    <T, E extends Throwable> void forEach(ScxConsumer<T, E> entityConsumer, Class<T> resultType) throws DataAccessException, E;

    <E extends Throwable> void forEachMap(ScxConsumer<Map<String, Object>, E> entityConsumer) throws DataAccessException, E;

    Entity first() throws DataAccessException;

    <T> T first(Class<T> resultType) throws DataAccessException;

    Map<String, Object> firstMap() throws DataAccessException;

    long count() throws DataAccessException;

}
