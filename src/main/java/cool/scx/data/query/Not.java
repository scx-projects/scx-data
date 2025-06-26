package cool.scx.data.query;

/// Not
///
/// @author scx567888
/// @version 0.0.1
public final class Not extends QueryLike<Not> implements Where {

    private final Where clause;

    public Not(Where clause) {
        this.clause = clause;
    }

    public Where clause() {
        return clause;
    }

    @Override
    public boolean isEmpty() {
        return clause == null || clause.isEmpty();
    }

    @Override
    protected QueryImpl toQuery() {
        return new QueryImpl().where(this);
    }

}
