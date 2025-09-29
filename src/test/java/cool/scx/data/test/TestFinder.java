package cool.scx.data.test;

import cool.scx.data.Finder;
import cool.scx.data.exception.DataAccessException;
import cool.scx.function.Function1Void;

import java.util.List;
import java.util.Map;

public class TestFinder<T> implements Finder<T> {

    @Override
    public List<T> list() throws DataAccessException {
        return List.of();
    }

    @Override
    public <T1> List<T1> list(Class<T1> resultType) throws DataAccessException {
        return List.of();
    }

    @Override
    public List<Map<String, Object>> listMap() throws DataAccessException {
        return List.of();
    }

    @Override
    public <X extends Throwable> void forEach(Function1Void<T, X> entityConsumer) throws DataAccessException, X {

    }

    @Override
    public <T1, X extends Throwable> void forEach(Function1Void<T1, X> entityConsumer, Class<T1> resultType) throws DataAccessException, X {

    }

    @Override
    public <X extends Throwable> void forEachMap(Function1Void<Map<String, Object>, X> entityConsumer) throws DataAccessException, X {

    }

    @Override
    public T first() throws DataAccessException {
        return null;
    }

    @Override
    public <T1> T1 first(Class<T1> resultType) throws DataAccessException {
        return null;
    }

    @Override
    public Map<String, Object> firstMap() throws DataAccessException {
        return Map.of();
    }

    @Override
    public long count() throws DataAccessException {
        return 0;
    }

}
