package cool.scx.data.aggregation;

/// GroupBy
///
/// @author scx567888
/// @version 0.0.1
public abstract sealed class GroupBy extends AggregationLike<GroupBy> permits ExpressionGroupBy, FieldGroupBy {

    @Override
    protected AggregationImpl toAggregation() {
        return new AggregationImpl().groupBys(this);
    }

}
