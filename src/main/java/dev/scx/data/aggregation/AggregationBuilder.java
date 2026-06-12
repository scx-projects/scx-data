package dev.scx.data.aggregation;

/// AggregationBuilder
///
/// @author scx567888
/// @version 0.0.1
public final class AggregationBuilder {

    public static Aggregation aggregation() {
        return new AggregationImpl();
    }

    public static Aggregation groupBys(GroupBy... groupBys) {
        return new AggregationImpl().groupBys(groupBys);
    }

    public static Aggregation aggs(Agg... aggs) {
        return new AggregationImpl().aggs(aggs);
    }

    public static FieldGroupBy groupBy(String fieldName) {
        return new FieldGroupBy(fieldName);
    }

    public static ExpressionGroupBy groupBy(String alias, String expression) {
        return new ExpressionGroupBy(alias, expression);
    }

    public static Agg agg(String alias, String expression) {
        return new Agg(alias, expression);
    }

}
