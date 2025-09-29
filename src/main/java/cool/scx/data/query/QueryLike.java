package cool.scx.data.query;

/// QueryLike
///
/// @param <QL> QL
/// @author scx567888
/// @version 0.0.1
@SuppressWarnings("unchecked")
public abstract class QueryLike<QL extends QueryLike<QL>> implements Query {

    private QueryImpl query;

    private QueryImpl query() {
        if (query == null) {
            query = toQuery();
        }
        return query;
    }

    @Override
    public QL where(Where where) {
        query().where(where);
        return (QL) this;
    }

    @Override
    public QL orderBys(OrderBy... orderBys) {
        query().orderBys(orderBys);
        return (QL) this;
    }

    @Override
    public QL offset(long offset) {
        query().offset(offset);
        return (QL) this;
    }

    @Override
    public QL limit(long limit) {
        query().limit(limit);
        return (QL) this;
    }

    @Override
    public Where getWhere() {
        return query().getWhere();
    }

    @Override
    public OrderBy[] getOrderBys() {
        return query().getOrderBys();
    }

    @Override
    public Long getOffset() {
        return query().getOffset();
    }

    @Override
    public Long getLimit() {
        return query().getLimit();
    }

    @Override
    public QL clearWhere() {
        query().clearWhere();
        return (QL) this;
    }

    @Override
    public QL clearOrderBys() {
        query().clearOrderBys();
        return (QL) this;
    }

    @Override
    public QL clearOffset() {
        query().clearOffset();
        return (QL) this;
    }

    @Override
    public QL clearLimit() {
        query().clearLimit();
        return (QL) this;
    }

    @Override
    public QL orderBy(OrderBy... orderBys) {
        query().orderBy(orderBys);
        return (QL) this;
    }

    @Override
    public QL asc(String selector, BuildControl... controls) {
        query().asc(selector, controls);
        return (QL) this;
    }

    @Override
    public QL desc(String selector, BuildControl... controls) {
        query().desc(selector, controls);
        return (QL) this;
    }

    protected abstract QueryImpl toQuery();

}
