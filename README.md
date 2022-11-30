## Hexlet tests and linter status:
[![Actions Status](https://github.com/vviace/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/vviace/java-project-78/actions)

[![Test Coverage](https://api.codeclimate.com/v1/badges/3021a54e5fb6c0410277/test_coverage)](https://codeclimate.com/github/vviace/java-project-78/test_coverage)

[![Maintainability](https://api.codeclimate.com/v1/badges/3021a54e5fb6c0410277/maintainability)](https://codeclimate.com/github/vviace/java-project-78/maintainability)

## Data Validator project
### This project support data types as: 
 * __String__ 
 * __Numeric__
 * __Maps__ 

## Quick Start
### The entry point with this lib is`Validator v = new Validator();`

## > String
```
`StringSchema schema = v.string();`

schema.isValid(""); // true
// Пока на вызван метод required(), null считается валидным
schema.isValid(null); // true

schema.required();

schema.isValid("what does the fox say"); // true
schema.isValid("hexlet"); // true
schema.isValid(null); // false
schema.isValid(5); // false
schema.isValid(""); // false

schema.contains("wh").isValid("what does the fox say"); // true
schema.contains("what").isValid("what does the fox say"); // true
schema.contains("whatthe").isValid("what does the fox say"); // false

schema.isValid("what does the fox say"); // false
// уже false, так как добавлена ещё одна проверка contains("whatthe")
```
## > Integer
```
NumberSchema schema = v.number();

// Пока не вызван метод required(), null считается валидным
schema.isValid(null); // true
schema.positive().isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(10) // true
schema.isValid("5"); // false
schema.isValid(-10); // false
//  Ноль - не положительное число
schema.isValid(0); // false

schema.range(5, 10);

schema.isValid(5); // true
schema.isValid(10); // true
schema.isValid(4); // false
schema.isValid(11); // false
```
## > Map
```

MapSchema schema = v.map();

Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());
schema.shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "Maya");
human2.put("age", null);
schema.isValid(human2); // true

Map<String, Object> human3 = new HashMap<>();
human3.put("name", "");
human3.put("age", null);
schema.isValid(human3); // false

Map<String, Object> human4 = new HashMap<>();
human4.put("name", "Valya");
human4.put("age", -5);
schema.isValid(human4); // false
```