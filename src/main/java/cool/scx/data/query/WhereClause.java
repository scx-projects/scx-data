package cool.scx.data.query;

/// WhereClause
///
/// @author scx567888
/// @version 0.0.1
public final class WhereClause extends QueryLike<WhereClause> implements Where {

    private final String expression;
    private final Object[] params;

    public WhereClause(String expression, Object... params) {
        this.expression = expression;
        this.params = params;
    }

    public String expression() {
        return expression;
    }

    public Object[] params() {
        return params;
    }

    @Override
    public boolean isEmpty() {
        return (expression == null || expression.isEmpty()) && (params == null || params.length == 0);
    }

    @Override
    protected QueryImpl toQuery() {
        return new QueryImpl().where(this);
    }

}
