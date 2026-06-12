package dev.scx.data.field_policy;

import java.util.Map;

/// FieldPolicy
///
/// @author scx567888
/// @version 0.0.1
public interface FieldPolicy {

    /// 标记 包含, null 项会被忽略.
    FieldPolicy include(String... fieldNames);

    /// 标记 排除, null 项会被忽略.
    FieldPolicy exclude(String... fieldNames);

    /// 获取 当前模式
    FilterMode getFilterMode();

    /// 获取 fieldName 列表
    String[] getFieldNames();

    /// 清除 fieldName 列表
    FieldPolicy clearFieldNames();

    // ****************** 查询 专用 ******************

    /// 设置 虚拟列, null 项会被忽略.
    FieldPolicy virtualFields(VirtualField... virtualFields);

    /// 获取 虚拟列
    VirtualField[] getVirtualFields();

    /// 清除 所有虚拟列
    FieldPolicy clearVirtualFields();

    /// 追加 虚拟列
    FieldPolicy virtualField(String virtualFieldName, String expression);

    // ****************** 添加/更新 专用 ******************

    /// 设置 全局 忽略空值
    FieldPolicy ignoreNull(boolean ignoreNull);

    /// 设置 忽略空值
    FieldPolicy ignoreNull(String fieldName, boolean ignoreNull);

    /// 设置 字段表达式, null 项会被忽略.
    FieldPolicy assignFields(AssignField... assignFields);

    /// 获取 全局是否忽略 空值
    boolean getIgnoreNull();

    /// 获取 忽略 空值
    Map<String, Boolean> getIgnoreNulls();

    /// 获取 字段表达式
    AssignField[] getAssignFields();

    /// 清除 所有忽略空值
    FieldPolicy clearIgnoreNulls();

    /// 清除 所有表达式
    FieldPolicy clearAssignFields();

    /// 移除 是否忽略 空值
    FieldPolicy removeIgnoreNull(String fieldName);

    /// 追加 表达式
    FieldPolicy assignField(String fieldName, String expression);

}
