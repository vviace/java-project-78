package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema required() {
        addChecks(o -> o instanceof String str && !str.isEmpty());
        return this;
    }

    public StringSchema minLength(int value) {
        addChecks(o -> ((String) o).length() >= value);
        return this;
    }

    public StringSchema contains(String value) {
        addChecks(o -> ((String) o).contains(value.toLowerCase()));
        return this;
    }

}

