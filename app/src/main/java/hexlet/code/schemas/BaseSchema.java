package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {
    private List<Predicate> checks = new ArrayList<>();
    public boolean isValid(Object obj) {
        // #TODO stream api allMatch
        boolean result;
        result = checks.stream()
                .noneMatch(o -> !o.test(obj));
//        for(Predicate p: this.checks) {
//           if(!p.test(obj)) {
//               return false;
//           }
//        }
//        return true;
        return result;
    }
    protected void addChecks(Predicate p) {
        this.checks.add(p);
    }
}
