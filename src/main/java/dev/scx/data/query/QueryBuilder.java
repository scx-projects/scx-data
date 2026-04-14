package dev.scx.data.query;

import static dev.scx.data.query.BuildControl.checkUseExpression;
import static dev.scx.data.query.BuildControl.checkUseExpressionValue;
import static dev.scx.data.query.ConditionType.*;
import static dev.scx.data.query.OrderByType.ASC;
import static dev.scx.data.query.OrderByType.DESC;
import static dev.scx.data.query.SkipIfInfo.ofSkipIfInfo;

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

    public static Condition condition(String selector, ConditionType conditionType, Object value, BuildControl... controls) {
        var useExpression = checkUseExpression(controls);
        var useExpressionValue = checkUseExpressionValue(controls);
        var skipIfInfo = ofSkipIfInfo(controls);
        return new Condition(selector, conditionType, value, null, useExpression, useExpressionValue, skipIfInfo);
    }

    public static Condition condition(String selector, ConditionType conditionType, Object value1, Object value2, BuildControl... controls) {
        var useExpression = checkUseExpression(controls);
        var useExpressionValue = checkUseExpressionValue(controls);
        var skipIfInfo = ofSkipIfInfo(controls);
        return new Condition(selector, conditionType, value1, value2, useExpression, useExpressionValue, skipIfInfo);
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

    public static Condition eq(String selector, Object value, BuildControl... controls) {
        return condition(selector, EQ, value, controls);
    }

    public static Condition ne(String selector, Object value, BuildControl... controls) {
        return condition(selector, NE, value, controls);
    }

    public static Condition lt(String selector, Object value, BuildControl... controls) {
        return condition(selector, LT, value, controls);
    }

    public static Condition lte(String selector, Object value, BuildControl... controls) {
        return condition(selector, LTE, value, controls);
    }

    public static Condition gt(String selector, Object value, BuildControl... controls) {
        return condition(selector, GT, value, controls);
    }

    public static Condition gte(String selector, Object value, BuildControl... controls) {
        return condition(selector, GTE, value, controls);
    }

    public static Condition like(String selector, Object value, BuildControl... controls) {
        return condition(selector, LIKE, value, controls);
    }

    public static Condition notLike(String selector, Object value, BuildControl... controls) {
        return condition(selector, NOT_LIKE, value, controls);
    }

    public static Condition likeRegex(String selector, String value, BuildControl... controls) {
        return condition(selector, LIKE_REGEX, value, controls);
    }

    public static Condition notLikeRegex(String selector, String value, BuildControl... controls) {
        return condition(selector, NOT_LIKE_REGEX, value, controls);
    }

    public static Condition in(String selector, Object value, BuildControl... controls) {
        return condition(selector, IN, value, controls);
    }

    public static Condition notIn(String selector, Object value, BuildControl... controls) {
        return condition(selector, NOT_IN, value, controls);
    }

    public static Condition between(String selector, Object value1, Object value2, BuildControl... controls) {
        return condition(selector, BETWEEN, value1, value2, controls);
    }

    public static Condition notBetween(String selector, Object value1, Object value2, BuildControl... controls) {
        return condition(selector, NOT_BETWEEN, value1, value2, controls);
    }

}
