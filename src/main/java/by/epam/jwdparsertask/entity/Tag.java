package by.epam.jwdparsertask.entity;

import by.epam.jwdparsertask.exception.InvalidXmlFileException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tag {
    private String name;
    private List<Attribute> attributes = new ArrayList<>();
    private boolean isEndTag;

    private static final String TAG_NAME_PATTERN = "\\w+";
    private static final String ATTRIBUTES_PATTERN = "\\s\\S+=\\S+";
    private static final String TAG_PATTERN = "<\\/?\\w*\\:*[^>]*>";

    public Tag() { }

    public Tag(String wholeTag) {
        this.name = parseName(wholeTag);
        this.attributes = getAttributesFromTag(wholeTag);
        this.isEndTag = isEndTag(wholeTag);
    }

    public Tag(String name, List<Attribute> attributes, boolean isEndTag) {
        this.name = name;
        this.attributes = attributes;
        this.isEndTag = isEndTag;
    }

    public static List<Tag> parseTags(String line) {
        List<Tag> tags = new ArrayList<>();

        Pattern tagPattern = Pattern.compile(Tag.TAG_PATTERN);
        Matcher tagMatcher = tagPattern.matcher(line);

        while (tagMatcher.find()) {
            tags.add(new Tag(tagMatcher.group()));
        }

        return tags;
    }

    private String parseName(String wholeTag) {
        Pattern tagNamePattern = Pattern.compile(TAG_NAME_PATTERN);
        Matcher matcher = tagNamePattern.matcher(wholeTag);

        if (!matcher.find()) {
            throw new InvalidXmlFileException("Invalid tags syntax");
        }

        return matcher.group();
    }

    private boolean isEndTag(String wholeTag) {
        if (wholeTag.contains("</")) {
            return true;
        }

        return false;
    }

    private List<Attribute> getAttributesFromTag(String wholeTag) {
        List<Attribute> attributesFromTag = new ArrayList<>();
        Pattern attributesPattern = Pattern.compile(ATTRIBUTES_PATTERN);
        Matcher matcher = attributesPattern.matcher(wholeTag);

        while (matcher.find()) {
            attributesFromTag.add(new Attribute(matcher.group()));
        }

        return attributesFromTag;
    }

    public boolean getIsEndTag() {
        return isEndTag;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public String getName() {
        return name;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "name='" + name + '\'' +
                ", attributes=" + attributes +
                ", isEndTag=" + isEndTag +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return isEndTag == tag.isEndTag && Objects.equals(name, tag.name) && Objects.equals(attributes, tag.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, attributes, isEndTag);
    }
}