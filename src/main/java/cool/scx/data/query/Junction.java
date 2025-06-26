package cool.scx.data.query;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.addAll;

/// Junction
///
/// @author scx567888
/// @version 0.0.1
public abstract sealed class Junction extends QueryLike<Junction> implements Where permits And, Or {

    private final List<Where> clauses;

    protected Junction() {
        this.clauses = new ArrayList<>();
    }

    public Where[] clauses() {
        return clauses.toArray(Where[]::new);
    }

    public Junction add(Where... wheres) {
        addAll(clauses, wheres);
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
