package cool.scx.data.aggregation;

/// ExpressionGroupBy
///
/// @author scx567888
/// @version 0.0.1
public final class ExpressionGroupBy extends GroupBy {

    private final String alias;
    private final String expression;

    public ExpressionGroupBy(String alias, String expression) {
        if (alias == null) {
            throw new NullPointerException("alias cannot be null");
        }
        if (expression == null) {
            throw new NullPointerException("expression cannot be null");
        }
        this.alias = alias;
        this.expression = expression;
    }

    public String alias() {
        return alias;
    }

    public String expression() {
        return expression;
    }

}
