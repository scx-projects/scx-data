package cool.scx.data.field_policy;

import static cool.scx.data.field_policy.FilterMode.EXCLUDED;

/// AssignField
///
/// @author scx567888
/// @version 0.0.1
public final class AssignField extends FieldPolicyLike<AssignField> {

    private final String fieldName;
    private final String expression;

    public AssignField(String fieldName, String expression) {
        if (fieldName == null) {
            throw new NullPointerException("fieldName cannot be null");
        }
        if (expression == null) {
            throw new NullPointerException("expression cannot be null");
        }
        this.fieldName = fieldName;
        this.expression = expression;
    }

    public String fieldName() {
        return fieldName;
    }

    public String expression() {
        return expression;
    }

    @Override
    protected FieldPolicyImpl toFieldPolicy() {
        //排除 0 个 就是包含所有
        return new FieldPolicyImpl(EXCLUDED).assignFields(this);
    }

}
