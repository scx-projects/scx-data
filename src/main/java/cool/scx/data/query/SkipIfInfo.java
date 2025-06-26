package cool.scx.data.query;

import java.lang.reflect.Array;
import java.util.Collection;

/// SkipIfInfo
///
/// @author scx567888
/// @version 0.0.1
public record SkipIfInfo(boolean skipIfNull,
                         boolean skipIfEmptyList,
                         boolean skipIfEmptyString,
                         boolean skipIfBlankString) {

    public static SkipIfInfo ofSkipIfInfo(BuildControl... controls) {
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
            }
        }
        return new SkipIfInfo(skipIfNull, skipIfEmptyList, skipIfEmptyString, skipIfBlankString);
    }

    public boolean shouldSkip(Object value1) {
        if (value1 == null) {
            return skipIfNull;
        }

        if (value1 instanceof Collection<?> collection) {
            return skipIfEmptyList && collection.isEmpty();
        }

        if (value1.getClass().isArray()) {
            return skipIfEmptyList && Array.getLength(value1) == 0;
        }

        if (value1 instanceof String s) {
            if (skipIfEmptyString && s.isEmpty()) {
                return true;
            }
            return skipIfBlankString && s.trim().isEmpty();
        }

        return false;
    }

    public boolean shouldSkip(Object value1, Object value2) {
        return shouldSkip(value1) || shouldSkip(value2);
    }

}
