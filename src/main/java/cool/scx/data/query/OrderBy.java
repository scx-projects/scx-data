package cool.scx.data.query;

/// OrderBy
///
/// @author scx567888
/// @version 0.0.1
public final class OrderBy extends QueryLike<OrderBy> {

    private final String selector;
    private final OrderByType orderByType;
    private final boolean useExpression;

    public OrderBy(String selector, OrderByType orderByType, boolean useExpression) {
        if (selector == null) {
            throw new NullPointerException("selector cannot be null");
        }
        if (orderByType == null) {
            throw new NullPointerException("orderByType cannot be null");
        }
        this.selector = selector;
        this.orderByType = orderByType;
        this.useExpression = useExpression;
    }

    public String selector() {
        return selector;
    }

    public OrderByType orderByType() {
        return orderByType;
    }

    public boolean useExpression() {
        return useExpression;
    }

    @Override
    protected QueryImpl toQuery() {
        return new QueryImpl().orderBys(this);
    }

}
