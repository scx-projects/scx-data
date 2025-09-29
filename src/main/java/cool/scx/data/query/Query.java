package cool.scx.data.query;

/// Query
///
/// @author scx567888
/// @version 0.0.1
public interface Query {

    /// 设置 过滤条件
    Query where(Where where);

    /// 设置 排序列表
    Query orderBys(OrderBy... orderBys);

    /// 设置 偏移量
    Query offset(long offset);

    /// 设置 limit
    Query limit(long limit);

    /// 获取 过滤条件
    Where getWhere();

    /// 获取 排序列表
    OrderBy[] getOrderBys();

    /// 获取 偏移量
    Long getOffset();

    /// 获取 limit
    Long getLimit();

    /// 清除 过滤条件
    Query clearWhere();

    /// 清除 排序列表
    Query clearOrderBys();

    /// 清除 偏移量
    Query clearOffset();

    /// 清除 limit
    Query clearLimit();

    /// 追加 排序
    Query orderBy(OrderBy... orderBys);

    /// 追加 正序
    Query asc(String selector, BuildControl... controls);

    /// 追加 倒序
    Query desc(String selector, BuildControl... controls);

}
