package dev.scx.data.query;

/// BuildControl
///
/// @author scx567888
/// @version 0.0.1
public enum BuildControl {

    // ********************* DSL 控制 *********************

    /// 如果参数值为 null 则跳过
    SKIP_IF_NULL,

    /// 如果参数值为 空列表 (如 List 或 Array) 则跳过
    SKIP_IF_EMPTY_LIST,

    /// 如果参数值为 空字符串 "" 则跳过
    SKIP_IF_EMPTY_STRING,

    /// 如果参数值为 空白字符串 "    " 则跳过
    SKIP_IF_BLANK_STRING,

    // ********************* 字段控制 *********************

    /// 使用表达式 (不进行转换)
    USE_EXPRESSION,

    /// 使用表达式值 (不进行转换)
    USE_EXPRESSION_VALUE;

    /// null 项会被忽略.
    public static SkipIfInfo toSkipIfInfo(BuildControl... controls) {
        if (controls == null) {
            throw new NullPointerException("controls cannot be null");
        }
        var skipIfNull = false;
        var skipIfEmptyList = false;
        var skipIfEmptyString = false;
        var skipIfBlankString = false;
        for (var c : controls) {
            switch (c) {
                case SKIP_IF_NULL -> skipIfNull = true;
                case SKIP_IF_EMPTY_LIST -> skipIfEmptyList = true;
                case SKIP_IF_EMPTY_STRING -> skipIfEmptyString = true;
                case SKIP_IF_BLANK_STRING -> skipIfBlankString = true;
                case USE_EXPRESSION, USE_EXPRESSION_VALUE -> {
                    // 跳过
                }
                case null -> {
                    // 跳过
                }
            }
        }
        return new SkipIfInfo(skipIfNull, skipIfEmptyList, skipIfEmptyString, skipIfBlankString);
    }

    /// null 项会被忽略.
    public static boolean toUseExpression(BuildControl... controls) {
        if (controls == null) {
            throw new NullPointerException("controls cannot be null");
        }
        for (var control : controls) {
            if (control == BuildControl.USE_EXPRESSION) {
                return true;
            }
        }
        return false;
    }

    /// null 项会被忽略.
    public static boolean toUseExpressionValue(BuildControl... controls) {
        if (controls == null) {
            throw new NullPointerException("controls cannot be null");
        }
        for (var control : controls) {
            if (control == BuildControl.USE_EXPRESSION_VALUE) {
                return true;
            }
        }
        return false;
    }

}
