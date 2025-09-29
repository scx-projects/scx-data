package cool.scx.data.query;

/// BuildControl
///
/// @author scx567888
/// @version 0.0.1
public enum BuildControl {

    //**************** DSL 控制 *********************

    /// 如果参数值为 null 则跳过添加
    SKIP_IF_NULL,

    /// 如果参数值为 空列表 (如 List 或 Array) 则跳过添加
    SKIP_IF_EMPTY_LIST,

    /// 如果参数值为 空字符串 "" 则跳过添加
    SKIP_IF_EMPTY_STRING,

    /// 如果参数值为 空白字符串 "    " 则跳过添加
    SKIP_IF_BLANK_STRING,

    //*************** 字段控制 **********************   

    /// 使用表达式 (不进行转换)
    USE_EXPRESSION,

    /// 使用表达式值 (不进行转换)
    USE_EXPRESSION_VALUE;

    public static boolean checkUseExpression(BuildControl... controls) {
        for (var control : controls) {
            if (control == BuildControl.USE_EXPRESSION) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkUseExpressionValue(BuildControl... controls) {
        for (var control : controls) {
            if (control == BuildControl.USE_EXPRESSION_VALUE) {
                return true;
            }
        }
        return false;
    }

}
