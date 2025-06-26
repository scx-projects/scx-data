package cool.scx.data.field_policy;

import static cool.scx.data.field_policy.FilterMode.EXCLUDED;

/// VirtualField
///
/// @author scx567888
/// @version 0.0.1
public final class VirtualField extends FieldPolicyLike<VirtualField> {

    private final String virtualFieldName;
    private final String expression;

    public VirtualField(String virtualFieldName, String expression) {
        if (virtualFieldName == null) {
            throw new NullPointerException("virtualFieldName cannot be null");
        }
        if (expression == null) {
            throw new NullPointerException("expression cannot be null");
        }
        this.virtualFieldName = virtualFieldName;
        this.expression = expression;
    }

    public String virtualFieldName() {
        return virtualFieldName;
    }

    public String expression() {
        return expression;
    }

    @Override
    protected FieldPolicyImpl toFieldPolicy() {
        //排除 0 个 就是包含所有
        return new FieldPolicyImpl(EXCLUDED).virtualFields(this);
    }

}
