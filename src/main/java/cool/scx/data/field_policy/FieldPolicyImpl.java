package cool.scx.data.field_policy;

import java.util.*;

import static java.util.Collections.addAll;

/// FieldPolicyImpl
///
/// @author scx567888
/// @version 0.0.1
public final class FieldPolicyImpl implements FieldPolicy {

    private final FilterMode filterMode;
    private final Set<String> fieldNames;
    private final Map<String, Boolean> ignoreNulls;
    private List<VirtualField> virtualFields;
    private List<AssignField> assignFields;
    private boolean ignoreNull;

    public FieldPolicyImpl(FilterMode filterMode) {
        this.filterMode = filterMode;
        this.fieldNames = new HashSet<>();
        this.virtualFields = new ArrayList<>();
        this.assignFields = new ArrayList<>();
        this.ignoreNulls = new LinkedHashMap<>();//保证顺序很重要
        this.ignoreNull = true;
    }

    @Override
    public FieldPolicyImpl include(String... fieldNames) {
        return switch (filterMode) {
            case INCLUDED -> addFieldNames(fieldNames);
            case EXCLUDED -> removeFieldNames(fieldNames);
        };
    }

    @Override
    public FieldPolicyImpl exclude(String... fieldNames) {
        return switch (filterMode) {
            case EXCLUDED -> addFieldNames(fieldNames);
            case INCLUDED -> removeFieldNames(fieldNames);
        };
    }

    @Override
    public FilterMode getFilterMode() {
        return filterMode;
    }

    @Override
    public String[] getFieldNames() {
        return fieldNames.toArray(String[]::new);
    }

    @Override
    public FieldPolicyImpl clearFieldNames() {
        fieldNames.clear();
        return this;
    }

    @Override
    public FieldPolicyImpl virtualFields(VirtualField... virtualFields) {
        this.virtualFields = new ArrayList<>(List.of(virtualFields));
        return this;
    }

    @Override
    public VirtualField[] getVirtualFields() {
        return virtualFields.toArray(VirtualField[]::new);
    }

    @Override
    public FieldPolicyImpl clearVirtualFields() {
        this.virtualFields.clear();
        return this;
    }

    @Override
    public FieldPolicyImpl virtualField(String virtualFieldName, String expression) {
        this.virtualFields.add(new VirtualField(virtualFieldName, expression));
        return this;
    }

    @Override
    public FieldPolicyImpl ignoreNull(boolean ignoreNull) {
        this.ignoreNull = ignoreNull;
        return this;
    }

    @Override
    public FieldPolicyImpl ignoreNull(String fieldName, boolean ignoreNull) {
        this.ignoreNulls.put(fieldName, ignoreNull);
        return this;
    }

    @Override
    public FieldPolicyImpl assignFields(AssignField... assignFields) {
        this.assignFields = new ArrayList<>(List.of(assignFields));
        return this;
    }

    @Override
    public boolean getIgnoreNull() {
        return ignoreNull;
    }

    @Override
    public Map<String, Boolean> getIgnoreNulls() {
        return ignoreNulls;
    }

    @Override
    public AssignField[] getAssignFields() {
        return assignFields.toArray(AssignField[]::new);
    }

    @Override
    public FieldPolicyImpl clearIgnoreNulls() {
        ignoreNulls.clear();
        return this;
    }

    @Override
    public FieldPolicyImpl clearAssignFields() {
        assignFields.clear();
        return this;
    }

    @Override
    public FieldPolicyImpl removeIgnoreNull(String fieldName) {
        ignoreNulls.remove(fieldName);
        return this;
    }

    @Override
    public FieldPolicyImpl assignField(String fieldName, String expression) {
        this.assignFields.add(new AssignField(fieldName, expression));
        return this;
    }

    private FieldPolicyImpl addFieldNames(String... fieldNames) {
        addAll(this.fieldNames, fieldNames);
        return this;
    }

    private FieldPolicyImpl removeFieldNames(String... fieldNames) {
        for (var fieldName : fieldNames) {
            this.fieldNames.remove(fieldName);
        }
        return this;
    }

}
