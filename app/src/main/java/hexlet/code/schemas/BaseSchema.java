package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {
    private List<Predicate> checks = new ArrayList<>();
    public boolean isValid(Object obj) {
        boolean result = checks.stream()
                .allMatch(o -> o.test(obj));
        return result;
    }
    protected void addChecks(Predicate p) {
        this.checks.add(p);
    }
}
