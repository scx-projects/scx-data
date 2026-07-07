package dev.scx.data.query;

/// WhereClause
///
/// 原始条件片段, expression 和 params 的具体语义由底层实现解释.
///
/// @author scx567888
public final class WhereClause extends QueryLike<WhereClause> implements Where {

    private final String expression;
    private final Object[] params;

    /// expression 和 params 原样保存.
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
