package dev.scx.data.test;

import dev.scx.data.Finder;
import dev.scx.data.exception.DataAccessException;
import dev.scx.exception.ScxWrappedException;
import dev.scx.function.Function1Void;

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
    public void forEach(Function1Void<T, ?> entityConsumer) throws DataAccessException, ScxWrappedException {

    }

    @Override
    public <T1> void forEach(Function1Void<T1, ?> entityConsumer, Class<T1> resultType) throws DataAccessException, ScxWrappedException {

    }

    @Override
    public void forEachMap(Function1Void<Map<String, Object>, ?> entityConsumer) throws DataAccessException, ScxWrappedException {

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
