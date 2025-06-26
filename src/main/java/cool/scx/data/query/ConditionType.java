package cool.scx.data.query;

/// ConditionType
///
/// @author scx567888
/// @version 0.0.1
public enum ConditionType {

    /// 等于 == (支持 null 比较)
    EQ,

    /// 不等于 != (支持 null 比较)
    NE,

    /// 小于 <
    LT,

    /// 小于等于 <=
    LTE,

    /// 大于 >
    GT,

    /// 大于等于 >=
    GTE,

    /// 双端模糊匹配
    LIKE,

    /// NOT 双端模糊匹配
    NOT_LIKE,

    /// 正则表达式匹配
    LIKE_REGEX,

    /// NOT 正则表达式匹配
    NOT_LIKE_REGEX,

    /// 在集合内 (集合元素中 null 也是合法匹配项, 空集合则表示不匹配任何项)
    IN,

    /// 不在集合内 (集合元素中 null 也是合法匹配项, 空集合则表示不匹配任何项)
    NOT_IN,

    /// 在范围内 (low <= field <= high)
    BETWEEN,

    /// 不在范围内 (field < low 或 field > high)
    NOT_BETWEEN,

}
