package dev.scx.data.query;

import java.util.ArrayList;
import java.util.List;

/// QueryImpl
///
/// @author scx567888
public final class QueryImpl implements Query {

    private Where where;
    private List<OrderBy> orderBys;
    private Long offset;
    private Long limit;

    public QueryImpl() {
        this.where = null;
        this.orderBys = new ArrayList<>();
        this.offset = null;
        this.limit = null;
    }

    @Override
    public QueryImpl where(Where where) {
        this.where = where;
        return this;
    }

    @Override
    public QueryImpl orderBys(OrderBy... orderBys) {
        if (orderBys == null) {
            throw new NullPointerException("orderBys cannot be null");
        }
        var newOrderBys = new ArrayList<OrderBy>();
        for (var orderBy : orderBys) {
            if (orderBy != null) {
                newOrderBys.add(orderBy);
            }
        }
        this.orderBys = newOrderBys;
        return this;
    }

    @Override
    public QueryImpl offset(long offset) {
        if (offset < 0) {
            throw new IllegalArgumentException("offset must be >= 0");
        }
        this.offset = offset;
        return this;
    }

    @Override
    public QueryImpl limit(long limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("limit must be >= 0");
        }
        this.limit = limit;
        return this;
    }

    @Override
    public Where getWhere() {
        return where;
    }

    @Override
    public OrderBy[] getOrderBys() {
        return orderBys.toArray(OrderBy[]::new);
    }

    @Override
    public Long getOffset() {
        return offset;
    }

    @Override
    public Long getLimit() {
        return limit;
    }

    @Override
    public QueryImpl clearWhere() {
        where = null;
        return this;
    }

    @Override
    public QueryImpl clearOrderBys() {
        orderBys.clear();
        return this;
    }

    @Override
    public QueryImpl clearOffset() {
        offset = null;
        return this;
    }

    @Override
    public QueryImpl clearLimit() {
        limit = null;
        return this;
    }

    @Override
    public QueryImpl orderBy(OrderBy... orderBys) {
        if (orderBys == null) {
            throw new NullPointerException("orderBys cannot be null");
        }
        for (var orderBy : orderBys) {
            if (orderBy != null) {
                this.orderBys.add(orderBy);
            }
        }
        return this;
    }

    @Override
    public QueryImpl asc(String selector, BuildControl... controls) {
        orderBy(QueryBuilder.asc(selector, controls));
        return this;
    }

    @Override
    public QueryImpl desc(String selector, BuildControl... controls) {
        orderBy(QueryBuilder.desc(selector, controls));
        return this;
    }

}
