package cool.scx.data;

import cool.scx.data.exception.DataAccessException;
import cool.scx.functional.ScxConsumer;

import java.util.List;
import java.util.Map;

/// Aggregator
///
/// @author scx567888
/// @version 0.0.1
public interface Aggregator {

    <T> List<T> list(Class<T> resultType) throws DataAccessException;

    List<Map<String, Object>> list() throws DataAccessException;

    <T, E extends Throwable> void forEach(ScxConsumer<T, E> resultConsumer, Class<T> resultType) throws DataAccessException, E;

    <E extends Throwable> void forEach(ScxConsumer<Map<String, Object>, E> resultConsumer) throws DataAccessException, E;

    <T> T first(Class<T> resultType) throws DataAccessException;

    Map<String, Object> first() throws DataAccessException;

}
