package cool.scx.data.test;

import cool.scx.data.Finder;
import cool.scx.data.exception.DataAccessException;
import cool.scx.functional.ScxConsumer;

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
    public <E extends Throwable> void forEach(ScxConsumer<T, E> entityConsumer) throws DataAccessException, E {

    }

    @Override
    public <T1, E extends Throwable> void forEach(ScxConsumer<T1, E> entityConsumer, Class<T1> resultType) throws DataAccessException, E {

    }

    @Override
    public <E extends Throwable> void forEachMap(ScxConsumer<Map<String, Object>, E> entityConsumer) throws DataAccessException, E {

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
