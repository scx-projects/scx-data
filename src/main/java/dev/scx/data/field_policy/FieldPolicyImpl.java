package dev.scx.data.field_policy;

import java.util.*;

/// FieldPolicyImpl
///
/// @author scx567888
public final class FieldPolicyImpl implements FieldPolicy {

    private final FilterMode filterMode;
    private final Set<String> fieldNames;
    private final Map<String, Boolean> ignoreNulls;
    private List<VirtualField> virtualFields;
    private List<AssignField> assignFields;
    private boolean ignoreNull;

    public FieldPolicyImpl(FilterMode filterMode) {
        if (filterMode == null) {
            throw new NullPointerException("filterMode cannot be null");
        }
        this.filterMode = filterMode;
        this.fieldNames = new LinkedHashSet<>(); // 需要保证顺序
        this.virtualFields = new ArrayList<>();
        this.assignFields = new ArrayList<>();
        this.ignoreNulls = new LinkedHashMap<>(); // 需要保证顺序
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
        if (virtualFields == null) {
            throw new NullPointerException("virtualFields cannot be null");
        }
        var newVirtualFields = new ArrayList<VirtualField>();
        for (var virtualField : virtualFields) {
            if (virtualField != null) {
                newVirtualFields.add(virtualField);
            }
        }
        this.virtualFields = newVirtualFields;
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
        if (fieldName == null) {
            throw new NullPointerException("fieldName cannot be null");
        }
        this.ignoreNulls.put(fieldName, ignoreNull);
        return this;
    }

    @Override
    public FieldPolicyImpl assignFields(AssignField... assignFields) {
        if (assignFields == null) {
            throw new NullPointerException("assignFields cannot be null");
        }
        var newAssignFields = new ArrayList<AssignField>();
        for (var assignField : assignFields) {
            if (assignField != null) {
                newAssignFields.add(assignField);
            }
        }
        this.assignFields = newAssignFields;
        return this;
    }

    @Override
    public boolean getIgnoreNull() {
        return ignoreNull;
    }

    @Override
    public Map<String, Boolean> getIgnoreNulls() {
        return new LinkedHashMap<>(ignoreNulls);
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
        if (fieldName == null) {
            throw new NullPointerException("fieldName cannot be null");
        }
        ignoreNulls.remove(fieldName);
        return this;
    }

    @Override
    public FieldPolicyImpl assignField(String fieldName, String expression) {
        this.assignFields.add(new AssignField(fieldName, expression));
        return this;
    }

    private FieldPolicyImpl addFieldNames(String... fieldNames) {
        if (fieldNames == null) {
            throw new NullPointerException("fieldNames cannot be null");
        }
        for (var fieldName : fieldNames) {
            if (fieldName != null) {
                this.fieldNames.add(fieldName);
            }
        }
        return this;
    }

    private FieldPolicyImpl removeFieldNames(String... fieldNames) {
        if (fieldNames == null) {
            throw new NullPointerException("fieldNames cannot be null");
        }
        for (var fieldName : fieldNames) {
            if (fieldName != null) {
                this.fieldNames.remove(fieldName);
            }
        }
        return this;
    }

}
