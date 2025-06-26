package cool.scx.data.aggregation;

/// AggregationBuilder
///
/// @author scx567888
/// @version 0.0.1
public final class AggregationBuilder {

    public static AggregationImpl aggregation() {
        return new AggregationImpl();
    }

    public static GroupBy groupBy(String fieldName) {
        return new FieldGroupBy(fieldName);
    }

    public static GroupBy groupBy(String alias, String expression) {
        return new ExpressionGroupBy(alias, expression);
    }

    public static Agg agg(String alias, String expression) {
        return new Agg(alias, expression);
    }

}
