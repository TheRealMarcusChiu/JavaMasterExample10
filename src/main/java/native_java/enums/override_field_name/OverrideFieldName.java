package native_java.enums.override_field_name;

import java.lang.reflect.Field;

public enum OverrideFieldName {
    EP ("DOM.EP"); // Expedited Parcel

    private final String cpString;

    OverrideFieldName(String cpString) {
        this.cpString = cpString;

        try {
            Field fieldName = getClass().getSuperclass().getDeclaredField("name");
            fieldName.setAccessible(true);
            fieldName.set(this, cpString);
            fieldName.setAccessible(false);
        } catch (Exception e) {

        }
    }
}
