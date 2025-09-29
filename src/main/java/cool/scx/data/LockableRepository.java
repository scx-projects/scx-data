package cool.scx.data;

import cool.scx.data.exception.DataAccessException;
import cool.scx.data.field_policy.FieldPolicy;
import cool.scx.data.query.Query;

import java.util.List;

import static cool.scx.data.field_policy.FieldPolicyBuilder.includeAll;
import static cool.scx.data.query.QueryBuilder.query;

/// LockableRepository
///
/// @param <Entity> Entity
/// @param <ID>     ID
/// @author scx567888
/// @version 0.0.1
public interface LockableRepository<Entity, ID> extends Repository<Entity, ID> {

    Finder<Entity> finder(Query query, FieldPolicy fieldPolicy, LockMode lockMode);

    default Finder<Entity> finder(Query query, LockMode lockMode) {
        return finder(query, includeAll(), lockMode);
    }

    default Finder<Entity> finder(FieldPolicy fieldPolicy, LockMode lockMode) {
        return finder(query(), fieldPolicy, lockMode);
    }

    default Finder<Entity> finder(LockMode lockMode) {
        return finder(query(), includeAll(), lockMode);
    }

    default List<Entity> find(Query query, FieldPolicy fieldPolicy, LockMode lockMode) throws DataAccessException {
        return finder(query, fieldPolicy, lockMode).list();
    }

    default List<Entity> find(Query query, LockMode lockMode) throws DataAccessException {
        return finder(query, lockMode).list();
    }

    default List<Entity> find(FieldPolicy fieldPolicy, LockMode lockMode) throws DataAccessException {
        return finder(fieldPolicy, lockMode).list();
    }

    default List<Entity> find(LockMode lockMode) throws DataAccessException {
        return finder(lockMode).list();
    }

    default Entity findFirst(Query query, FieldPolicy fieldPolicy, LockMode lockMode) throws DataAccessException {
        return finder(query, fieldPolicy, lockMode).first();
    }

    default Entity findFirst(Query query, LockMode lockMode) throws DataAccessException {
        return finder(query, lockMode).first();
    }

}
