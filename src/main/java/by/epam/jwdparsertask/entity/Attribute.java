package by.epam.jwdparsertask.entity;

import java.util.Objects;

public class Attribute {

    private String name;
    private String value;

    public Attribute() { }

    public Attribute(String nameAndValue) {
        this.name = parseName(nameAndValue);
        this.value = parseValue(nameAndValue);
    }

    public Attribute(String name, String value) {
        this.name = name;
        this.value = value;
    }

    private String parseName(String nameAndValue) {
        return nameAndValue.substring(0, nameAndValue.indexOf('='));
    }

    private String parseValue(String nameAndValue) {
        return nameAndValue.substring(nameAndValue.indexOf('=') + 1);
    }


    @Override
    public String toString() {
        return name + "=" + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Attribute attribute = (Attribute) o;

        return Objects.equals(name, attribute.name)
                && Objects.equals(value, attribute.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
