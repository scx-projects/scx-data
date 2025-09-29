package cool.scx.data.query;

import static cool.scx.data.query.BuildControl.checkUseExpression;
import static cool.scx.data.query.BuildControl.checkUseExpressionValue;
import static cool.scx.data.query.ConditionType.*;
import static cool.scx.data.query.OrderByType.ASC;
import static cool.scx.data.query.OrderByType.DESC;
import static cool.scx.data.query.SkipIfInfo.ofSkipIfInfo;

/// QueryBuilder
///
/// @author scx567888
/// @version 0.0.1
public final class QueryBuilder {

    public static Query query() {
        return new QueryImpl();
    }

    public static Query query(Query oldQuery) {
        return new QueryImpl(oldQuery);
    }

    public static Query where(Where where) {
        return new QueryImpl().where(where);
    }

    public static Query orderBys(OrderBy... orderBys) {
        return new QueryImpl().orderBys(orderBys);
    }

    public static Query offset(long offset) {
        return new QueryImpl().offset(offset);
    }

    public static Query limit(long limit) {
        return new QueryImpl().limit(limit);
    }

    public static Junction and(Where... clauses) {
        return new And().add(clauses);
    }

    public static Junction or(Where... clauses) {
        return new Or().add(clauses);
    }

    public static Not not(Where clause) {
        return new Not(clause);
    }

    public static WhereClause whereClause(String expression, Object... params) {
        return new WhereClause(expression, params);
    }

    public static Condition condition(String fieldName, ConditionType conditionType, Object value, BuildControl... controls) {
        var useExpression = checkUseExpression(controls);
        var useExpressionValue = checkUseExpressionValue(controls);
        var skipIfInfo = ofSkipIfInfo(controls);
        return new Condition(fieldName, conditionType, value, null, useExpression, useExpressionValue, skipIfInfo);
    }

    public static Condition condition(String fieldName, ConditionType conditionType, Object value1, Object value2, BuildControl... controls) {
        var useExpression = checkUseExpression(controls);
        var useExpressionValue = checkUseExpressionValue(controls);
        var skipIfInfo = ofSkipIfInfo(controls);
        return new Condition(fieldName, conditionType, value1, value2, useExpression, useExpressionValue, skipIfInfo);
    }

    public static OrderBy orderBy(String selector, OrderByType orderByType, BuildControl... controls) {
        var useExpression = checkUseExpression(controls);
        return new OrderBy(selector, orderByType, useExpression);
    }

    public static OrderBy asc(String selector, BuildControl... controls) {
        return orderBy(selector, ASC, controls);
    }

    public static OrderBy desc(String selector, BuildControl... controls) {
        return orderBy(selector, DESC, controls);
    }

    public static Condition eq(String fieldName, Object value, BuildControl... controls) {
        return condition(fieldName, EQ, value, controls);
    }

    public static Condition ne(String fieldName, Object value, BuildControl... controls) {
        return condition(fieldName, NE, value, controls);
    }

    public static Condition lt(String fieldName, Object value, BuildControl... controls) {
        return condition(fieldName, LT, value, controls);
    }

    public static Condition lte(String fieldName, Object value, BuildControl... controls) {
        return condition(fieldName, LTE, value, controls);
    }

    public static Condition gt(String fieldName, Object value, BuildControl... controls) {
        return condition(fieldName, GT, value, controls);
    }

    public static Condition gte(String fieldName, Object value, BuildControl... controls) {
        return condition(fieldName, GTE, value, controls);
    }

    public static Condition like(String fieldName, Object value, BuildControl... controls) {
        return condition(fieldName, LIKE, value, controls);
    }

    public static Condition notLike(String fieldName, Object value, BuildControl... controls) {
        return condition(fieldName, NOT_LIKE, value, controls);
    }

    public static Condition likeRegex(String fieldName, String value, BuildControl... controls) {
        return condition(fieldName, LIKE_REGEX, value, controls);
    }

    public static Condition notLikeRegex(String fieldName, String value, BuildControl... controls) {
        return condition(fieldName, NOT_LIKE_REGEX, value, controls);
    }

    public static Condition in(String fieldName, Object value, BuildControl... controls) {
        return condition(fieldName, IN, value, controls);
    }

    public static Condition notIn(String fieldName, Object value, BuildControl... controls) {
        return condition(fieldName, NOT_IN, value, controls);
    }

    public static Condition between(String fieldName, Object value1, Object value2, BuildControl... controls) {
        return condition(fieldName, BETWEEN, value1, value2, controls);
    }

    public static Condition notBetween(String fieldName, Object value1, Object value2, BuildControl... controls) {
        return condition(fieldName, NOT_BETWEEN, value1, value2, controls);
    }

}
