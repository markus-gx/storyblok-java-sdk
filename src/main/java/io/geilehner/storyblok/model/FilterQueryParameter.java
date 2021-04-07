package io.geilehner.storyblok.model;

import io.geilehner.storyblok.model.content.FilterOperation;

import java.util.Objects;

public class FilterQueryParameter {
    private String attribute;
    private FilterOperation filterOperation;
    private String value;

    public FilterQueryParameter(String attribute, FilterOperation filterOperation, String value) {
        this.attribute = attribute;
        this.filterOperation = filterOperation;
        this.value = value;
    }

    public static FilterQueryParameter of(String attribute, FilterOperation filterOperation, String value){
        return new FilterQueryParameter(attribute,filterOperation,value);
    }

    public String build(){
        return String.format("filter_query[%s][%s]=%s",attribute,filterOperation.name(),value);
    }

    @Override
    public String toString() {
        return build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilterQueryParameter that = (FilterQueryParameter) o;

        if (!Objects.equals(attribute, that.attribute)) return false;
        if (filterOperation != that.filterOperation) return false;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        int result = attribute != null ? attribute.hashCode() : 0;
        result = 31 * result + (filterOperation != null ? filterOperation.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
