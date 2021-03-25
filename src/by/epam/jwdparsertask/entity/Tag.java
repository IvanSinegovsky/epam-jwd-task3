package by.epam.jwdparsertask.entity;

import java.util.List;
import java.util.Objects;

public class Tag {

    private String tagContent;
    private String name;

    public Tag() {
    }

    public Tag(String tagContent) {
        this.tagContent = tagContent;
        this.name = getNameFromTag(tagContent);
    }

    private int attributesQuantity() {
        int attributesQuantity = 0;

        for (int i = 0; i < tagContent.length(); i++) {
            if (tagContent.charAt(i) == '=') {
                attributesQuantity++;
            }
        }

        return attributesQuantity;
    }

    private Attribute getAttribute(String tagPart) {
        String attributeName = tagPart.substring(0, '=');
        String attributeValue = tagPart.substring(attributeName.length() + 1, tagPart.length() - 1);

        Attribute attribute = new Attribute(attributeName, attributeValue);

        return attribute;
    }

    public String getNameFromTag(String tagContent) {
        return null;
    }

    public boolean isEndTag() {
        if (tagContent.contains("</")) {
            return true;
        }

        return false;
    }

    public List<Attribute> getAttributesFromTag() {
        return null;
    }

    public String getName() {
        return name;
    }



    public String getTagContent() {
        return tagContent;
    }

    public void setTagContent(String tagContent) {
        this.tagContent = tagContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Tag tag = (Tag) o;

        return Objects.equals(tagContent, tag.tagContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagContent);
    }

    @Override
    public String toString() {
        return  tagContent;
    }
}