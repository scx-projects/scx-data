package cool.scx.data.field_policy;

import static cool.scx.data.field_policy.FilterMode.EXCLUDED;
import static cool.scx.data.field_policy.FilterMode.INCLUDED;

/// FieldPolicyBuilder
///
/// @author scx567888
/// @version 0.0.1
public final class FieldPolicyBuilder {

    public static FieldPolicy includeAll() {
        return new FieldPolicyImpl(EXCLUDED);
    }

    public static FieldPolicy excludeAll() {
        return new FieldPolicyImpl(INCLUDED);
    }

    public static FieldPolicy include(String... fieldNames) {
        return excludeAll().include(fieldNames);
    }

    public static FieldPolicy exclude(String... fieldNames) {
        return includeAll().exclude(fieldNames);
    }

    /// 默认包含所有
    public static FieldPolicy ignoreNull(boolean ignoreNull) {
        return includeAll().ignoreNull(ignoreNull);
    }

    /// 默认包含所有
    public static FieldPolicy ignoreNull(String fieldName, boolean ignoreNull) {
        return includeAll().ignoreNull(fieldName, ignoreNull);
    }

    /// 默认包含所有
    public static AssignField assignField(String fieldName, String expression) {
        return new AssignField(fieldName, expression);
    }

    /// 默认包含所有
    public static VirtualField virtualField(String virtualFieldName, String expression) {
        return new VirtualField(virtualFieldName, expression);
    }

}
