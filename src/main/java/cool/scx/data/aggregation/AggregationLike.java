package cool.scx.data.aggregation;

///  AggregationLike
///
/// @param <AL> AL
/// @author scx567888
/// @version 0.0.1
@SuppressWarnings("unchecked")
public abstract class AggregationLike<AL extends AggregationLike<AL>> implements Aggregation {

    private AggregationImpl aggregation;

    private AggregationImpl aggregation() {
        if (aggregation == null) {
            aggregation = toAggregation();
        }
        return aggregation;
    }

    @Override
    public AL groupBys(GroupBy... groupBys) {
        aggregation().groupBys(groupBys);
        return (AL) this;
    }

    @Override
    public AL aggs(Agg... aggs) {
        aggregation().aggs(aggs);
        return (AL) this;
    }

    @Override
    public GroupBy[] getGroupBys() {
        return aggregation().getGroupBys();
    }

    @Override
    public Agg[] getAggs() {
        return aggregation().getAggs();
    }

    @Override
    public AL clearGroupBys() {
        aggregation().clearGroupBys();
        return (AL) this;
    }

    @Override
    public AL clearAggs() {
        aggregation().clearAggs();
        return (AL) this;
    }

    @Override
    public AL groupBy(String fieldName) {
        aggregation().groupBy(fieldName);
        return (AL) this;
    }

    @Override
    public AL groupBy(String alias, String expression) {
        aggregation().groupBy(alias, expression);
        return (AL) this;
    }

    @Override
    public AL agg(String alias, String expression) {
        aggregation().agg(alias, expression);
        return (AL) this;
    }

    protected abstract AggregationImpl toAggregation();

}
