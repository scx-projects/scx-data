package dev.scx.data.query;

import java.util.ArrayList;
import java.util.List;

/// Junction
///
/// @author scx567888
public abstract sealed class Junction extends QueryLike<Junction> implements Where permits And, Or {

    private final List<Where> clauses;

    protected Junction() {
        this.clauses = new ArrayList<>();
    }

    public Where[] clauses() {
        return clauses.toArray(Where[]::new);
    }

    /// null 项会被忽略.
    public Junction add(Where... clauses) {
        if (clauses == null) {
            throw new NullPointerException("clauses cannot be null");
        }
        // 这里不忽略 瞬时态 isEmpty() == true 的 项,
        // 因为我们不能确定这个项, 未来是否还是 isEmpty() == true.
        for (var clause : clauses) {
            if (clause != null) {
                this.clauses.add(clause);
            }
        }
        return this;
    }

    public Junction clear() {
        clauses.clear();
        return this;
    }

    public final Junction and(Where... clauses) {
        return add(new And().add(clauses));
    }

    public final Junction or(Where... clauses) {
        return add(new Or().add(clauses));
    }

    public final Junction not(Where clause) {
        return add(new Not(clause));
    }

    public final Junction whereClause(String expression, Object... params) {
        return add(new WhereClause(expression, params));
    }

    public final Junction eq(String selector, Object value, BuildControl... controls) {
        return add(QueryBuilder.eq(selector, value, controls));
    }

    public final Junction ne(String selector, Object value, BuildControl... controls) {
        return add(QueryBuilder.ne(selector, value, controls));
    }

    public final Junction lt(String selector, Object value, BuildControl... controls) {
        return add(QueryBuilder.lt(selector, value, controls));
    }

    public final Junction lte(String selector, Object value, BuildControl... controls) {
        return add(QueryBuilder.lte(selector, value, controls));
    }

    public final Junction gt(String selector, Object value, BuildControl... controls) {
        return add(QueryBuilder.gt(selector, value, controls));
    }

    public final Junction gte(String selector, Object value, BuildControl... controls) {
        return add(QueryBuilder.gte(selector, value, controls));
    }

    public final Junction like(String selector, Object value, BuildControl... controls) {
        return add(QueryBuilder.like(selector, value, controls));
    }

    public final Junction notLike(String selector, Object value, BuildControl... controls) {
        return add(QueryBuilder.notLike(selector, value, controls));
    }

    public final Junction likeRegex(String selector, String value, BuildControl... controls) {
        return add(QueryBuilder.likeRegex(selector, value, controls));
    }

    public final Junction notLikeRegex(String selector, String value, BuildControl... controls) {
        return add(QueryBuilder.notLikeRegex(selector, value, controls));
    }

    public final Junction in(String selector, Object value, BuildControl... controls) {
        return add(QueryBuilder.in(selector, value, controls));
    }

    public final Junction notIn(String selector, Object value, BuildControl... controls) {
        return add(QueryBuilder.notIn(selector, value, controls));
    }

    public final Junction between(String selector, Object value1, Object value2, BuildControl... controls) {
        return add(QueryBuilder.between(selector, value1, value2, controls));
    }

    public final Junction notBetween(String selector, Object value1, Object value2, BuildControl... controls) {
        return add(QueryBuilder.notBetween(selector, value1, value2, controls));
    }

    @Override
    public boolean isEmpty() {
        for (var clause : clauses) {
            if (clause != null && !clause.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected QueryImpl toQuery() {
        return new QueryImpl().where(this);
    }

}
