package cool.scx.data;

import cool.scx.data.aggregation.Aggregation;
import cool.scx.data.exception.DataAccessException;
import cool.scx.data.query.Query;

import java.util.List;
import java.util.Map;

import static cool.scx.data.query.QueryBuilder.query;

/// AggregatableRepository
///
/// @param <Entity> Entity
/// @param <ID>     ID
/// @author scx567888
/// @version 0.0.1
public interface AggregatableRepository<Entity, ID> extends Repository<Entity, ID> {

    Aggregator aggregator(Query beforeAggregateQuery, Aggregation aggregation, Query afterAggregateQuery);

    default Aggregator aggregator(Aggregation aggregation, Query afterAggregateQuery) {
        return aggregator(query(), aggregation, afterAggregateQuery);
    }

    default Aggregator aggregator(Query beforeAggregateQuery, Aggregation aggregation) {
        return aggregator(beforeAggregateQuery, aggregation, query());
    }

    default Aggregator aggregator(Aggregation aggregation) {
        return aggregator(query(), aggregation, query());
    }

    default List<Map<String, Object>> aggregate(Query beforeAggregateQuery, Aggregation aggregation, Query afterAggregateQuery) throws DataAccessException {
        return aggregator(beforeAggregateQuery, aggregation, afterAggregateQuery).list();
    }

    default List<Map<String, Object>> aggregate(Aggregation aggregation, Query afterAggregateQuery) throws DataAccessException {
        return aggregator(aggregation, afterAggregateQuery).list();
    }

    default List<Map<String, Object>> aggregate(Query beforeAggregateQuery, Aggregation aggregation) throws DataAccessException {
        return aggregator(beforeAggregateQuery, aggregation).list();
    }

    default List<Map<String, Object>> aggregate(Aggregation aggregation) throws DataAccessException {
        return aggregator(aggregation).list();
    }

    default Map<String, Object> aggregateFirst(Query beforeAggregateQuery, Aggregation aggregation, Query afterAggregateQuery) throws DataAccessException {
        return aggregator(beforeAggregateQuery, aggregation, afterAggregateQuery).first();
    }

    default Map<String, Object> aggregateFirst(Aggregation aggregation, Query afterAggregateQuery) throws DataAccessException {
        return aggregator(aggregation, afterAggregateQuery).first();
    }

    default Map<String, Object> aggregateFirst(Query beforeAggregateQuery, Aggregation aggregation) throws DataAccessException {
        return aggregator(beforeAggregateQuery, aggregation).first();
    }

    default Map<String, Object> aggregateFirst(Aggregation aggregation) throws DataAccessException {
        return aggregator(aggregation).first();
    }

}
