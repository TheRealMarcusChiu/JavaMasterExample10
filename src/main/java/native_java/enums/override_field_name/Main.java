package native_java.enums.override_field_name;

import org.apache.commons.lang3.EnumUtils;
import org.junit.Assert;
import org.junit.Test;

public class Main {

    @Test
    public void testOverrideFieldName() {
        Assert.assertTrue(EnumUtils.isValidEnum(OverrideFieldName.class, "DOM.EP"));
    }
}
