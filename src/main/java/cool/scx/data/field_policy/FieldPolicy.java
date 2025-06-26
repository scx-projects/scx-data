package cool.scx.data.field_policy;

import java.util.Map;

/// 字段策略
///
/// @author scx567888
/// @version 0.0.1
public interface FieldPolicy {

    /// 设置 包含
    FieldPolicy include(String... fieldNames);

    /// 设置 排除
    FieldPolicy exclude(String... fieldNames);

    /// 获取 当前模式
    FilterMode getFilterMode();

    /// 获取 FieldName
    String[] getFieldNames();

    /// 清除 fieldNames
    FieldPolicy clearFieldNames();

    //************** 查询 专用 ******************

    /// 设置 虚拟列
    FieldPolicy virtualFields(VirtualField... virtualFields);

    /// 获取 虚拟列
    VirtualField[] getVirtualFields();

    /// 清除 所有虚拟列
    FieldPolicy clearVirtualFields();

    /// 追加 虚拟列 (用于查询)
    FieldPolicy virtualField(String virtualFieldName, String expression);

    //***************** 插入/更新 专用 *****************

    /// 设置 全局 忽略空值
    FieldPolicy ignoreNull(boolean ignoreNull);

    /// 设置 忽略空值
    FieldPolicy ignoreNull(String fieldName, boolean ignoreNull);

    /// 设置 字段表达式 (用于插入和更新)
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
