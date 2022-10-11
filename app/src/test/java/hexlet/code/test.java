package hexlet.code;
import hexlet.code.schemas.StringSchema;

import static org.assertj.core.api.Assertions.assertThat;

public class test {
    @org.junit.jupiter.api.Test
    void testValidate() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        System.out.println(schema.isValid(""));
        schema.required();
        System.out.println(schema.contains("wh").isValid("what does the fox say"));
    }
}
