package cool.scx.data.aggregation;

/// Aggregation
///
/// @author scx567888
/// @version 0.0.1
public interface Aggregation {

    /// 设置 分组
    Aggregation groupBys(GroupBy... groupBys);

    /// 设置 聚合列
    Aggregation aggs(Agg... aggs);

    /// 获取 分组
    GroupBy[] getGroupBys();

    /// 获取 聚合列
    Agg[] getAggs();

    /// 清除 所有分组
    Aggregation clearGroupBys();

    /// 清除 所有聚合列
    Aggregation clearAggs();

    /// 追加 分组
    Aggregation groupBy(String fieldName);

    /// 追加 分组
    Aggregation groupBy(String alias, String expression);

    /// 追加 聚合
    Aggregation agg(String alias, String expression);

}
