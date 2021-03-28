package by.epam.jwdparsertask.entity;

import by.epam.jwdparsertask.exception.InvalidXmlFileException;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tag {

    private String wholeTag;
    private String name;
    private List<Attribute> attributes;

    public Tag() {
    }

    public Tag(String wholeTag) {
        this.wholeTag = wholeTag;
        parseName();
    }

    private int attributesQuantity() {
        int attributesQuantity = 0;

        for (int i = 0; i < wholeTag.length(); i++) {
            if (wholeTag.charAt(i) == '=') {
                attributesQuantity++;
            }
        }

        return attributesQuantity;
    }

    private void parseName() {
        Pattern tagNamePattern = Pattern.compile("\\w+");
        Matcher matcher = tagNamePattern.matcher(wholeTag);

        if (!matcher.find()) {
            throw new InvalidXmlFileException("Invalid tags syntax");
        }

        this.name =  matcher.group();
    }

    public boolean isEndTag() {
        if (wholeTag.contains("</")) {
            return true;
        }

        return false;
    }

    public void getAttributesFromTag() {
        //TODO TEST THIS METHOD
        Pattern tagNamePattern = Pattern.compile("(^\\s+|=)");
        Matcher matcher = tagNamePattern.matcher(wholeTag);

        while (matcher.find()) {
            attributes.add(new Attribute(matcher.group()));
        }

        if (attributes.isEmpty()) {
            throw new InvalidXmlFileException("Invalid attributes syntax");
        }
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public String getName() {
        return name;
    }

    public String getWholeTag() {
        return wholeTag;
    }

    public void setWholeTag(String wholeTag) {
        this.wholeTag = wholeTag;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(wholeTag, tag.wholeTag) && Objects.equals(name, tag.name) && Objects.equals(attributes, tag.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wholeTag, name, attributes);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "wholeTag='" + wholeTag + '\'' +
                ", name='" + name + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}