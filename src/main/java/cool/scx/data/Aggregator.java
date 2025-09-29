package cool.scx.data;

import cool.scx.data.exception.DataAccessException;
import cool.scx.function.Function1Void;

import java.util.List;
import java.util.Map;

/// Aggregator
///
/// @author scx567888
/// @version 0.0.1
public interface Aggregator {

    <T> List<T> list(Class<T> resultType) throws DataAccessException;

    List<Map<String, Object>> list() throws DataAccessException;

    <T, X extends Throwable> void forEach(Function1Void<T, X> resultConsumer, Class<T> resultType) throws DataAccessException, X;

    <X extends Throwable> void forEach(Function1Void<Map<String, Object>, X> resultConsumer) throws DataAccessException, X;

    <T> T first(Class<T> resultType) throws DataAccessException;

    Map<String, Object> first() throws DataAccessException;

}
