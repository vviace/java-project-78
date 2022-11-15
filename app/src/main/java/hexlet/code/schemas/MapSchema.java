package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {
    public MapSchema required() {
        addChecks(map -> {
            return (map instanceof Map);
        });
        return this;
    }
    public MapSchema sizeof(int size) {
        addChecks(map -> ((Map) map).size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        for (Map.Entry<String, BaseSchema> entry : schemas.entrySet()) {
            addChecks(map -> entry.getValue().isValid(((Map) map).get(entry.getKey())));
        }
        return this;
    }
}
