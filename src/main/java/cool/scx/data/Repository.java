package cool.scx.data;

import cool.scx.data.exception.DataAccessException;
import cool.scx.data.field_policy.FieldPolicy;
import cool.scx.data.query.Query;

import java.util.Collection;
import java.util.List;

import static cool.scx.data.field_policy.FieldPolicyBuilder.includeAll;
import static cool.scx.data.query.QueryBuilder.query;

/// Repository
///
/// @param <Entity> Entity
/// @param <ID>     ID
/// @author scx567888
/// @version 0.0.1
public interface Repository<Entity, ID> {

    /// 添加数据
    ///
    /// 若 entity 为 null, 则使用 fieldPolicy 进行纯表达式添加
    ///
    /// @param entity      待添加的数据 (可为 null)
    /// @param fieldPolicy 字段策略
    /// @return 主键 ID (若数据没有主键, 则为 null)
    ID add(Entity entity, FieldPolicy fieldPolicy) throws DataAccessException;

    /// 添加多条数据
    ///
    /// 由于无法对 entityList 中每个成员进行单独判断, 字段将由 fieldPolicy 统一控制
    ///
    /// @param entityList  待插入的数据列表 (成员可为 null)
    /// @param fieldPolicy 字段策略
    /// @return 主键 ID 列表 (若数据没有主键, 则为 null 列表)
    List<ID> add(Collection<Entity> entityList, FieldPolicy fieldPolicy) throws DataAccessException;

    /// 创建 Finder
    ///
    /// @param query       查询条件
    /// @param fieldPolicy 字段策略
    /// @return Finder
    Finder<Entity> finder(Query query, FieldPolicy fieldPolicy);

    /// 更新数据
    ///
    /// 若 entity 为 null, 则使用 fieldPolicy 进行纯表达式更新, 此时要求 fieldPolicy 至少包含一个字段表达式
    ///
    /// @param entity      待更新的数据 (可为 null)
    /// @param fieldPolicy 字段策略
    /// @param query       查询条件
    /// @return 更新的数据条数
    long update(Entity entity, FieldPolicy fieldPolicy, Query query) throws DataAccessException;

    /// 删除数据
    ///
    /// @param query 查询条件
    /// @return 删除的数据条数
    long delete(Query query) throws DataAccessException;

    /// 清空所有数据
    void clear() throws DataAccessException;

    default ID add(Entity entity) throws DataAccessException {
        return add(entity, includeAll());
    }

    default ID add(FieldPolicy fieldPolicy) throws DataAccessException {
        return add((Entity) null, fieldPolicy);
    }

    default List<ID> add(Collection<Entity> entityList) throws DataAccessException {
        return add(entityList, includeAll());
    }

    default Finder<Entity> finder(Query query) {
        return finder(query, includeAll());
    }

    default Finder<Entity> finder(FieldPolicy fieldPolicy) {
        return finder(query(), fieldPolicy);
    }

    default Finder<Entity> finder() {
        return finder(query(), includeAll());
    }

    default List<Entity> find(Query query, FieldPolicy fieldPolicy) throws DataAccessException {
        return finder(query, fieldPolicy).list();
    }

    default List<Entity> find(Query query) throws DataAccessException {
        return finder(query).list();
    }

    default List<Entity> find(FieldPolicy fieldPolicy) throws DataAccessException {
        return finder(fieldPolicy).list();
    }

    default List<Entity> find() throws DataAccessException {
        return finder().list();
    }

    default Entity findFirst(Query query, FieldPolicy fieldPolicy) throws DataAccessException {
        return finder(query, fieldPolicy).first();
    }

    default Entity findFirst(Query query) throws DataAccessException {
        return finder(query).first();
    }

    default long update(Entity entity, Query query) throws DataAccessException {
        return update(entity, includeAll(), query);
    }

    default long update(FieldPolicy fieldPolicy, Query query) throws DataAccessException {
        return update(null, fieldPolicy, query);
    }

    default long count(Query query) throws DataAccessException {
        return finder(query).count();
    }

    default long count() throws DataAccessException {
        return finder().count();
    }

}
