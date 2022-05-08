package ee.ut.library.domain.entity;

import ee.ut.library.domain.enums.Category;

import javax.persistence.AttributeConverter;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CategoryListToStringConverter implements AttributeConverter<List<Category>, String> {
    @Override
    public String convertToDatabaseColumn(List<Category> attributes) {
        return attributes == null ? null : attributes.stream().map(Category::name).collect(joining(","));
    }

    @Override
    public List<Category> convertToEntityAttribute(String dbData) {
        return dbData == null ? List.of() : Stream.of(dbData.split(",")).map(Category::valueOf).collect(toList());
    }
}
