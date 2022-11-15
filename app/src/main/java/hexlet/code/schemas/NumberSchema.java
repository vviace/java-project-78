package hexlet.code.schemas;
public final class NumberSchema extends BaseSchema {
    public NumberSchema required() {
        addChecks(number -> {
            return (number instanceof Integer);
        });
        return this;
    }
    public NumberSchema positive() {
        //addChecks(o -> (Integer) o == null || (o instanceof Integer && (Integer) o > 0));
        addChecks(object -> object == null || (object instanceof Integer integer && integer > 0));
        return this;
    }

    public NumberSchema range(int begin, int end) {
        addChecks(o -> ((int) o >= begin) && ((int) o <= end));
        return this;
    }
}
