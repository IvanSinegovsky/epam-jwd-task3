package by.epam.jwdparsertask.model;

import java.util.List;
import java.util.Objects;

public class Tag {

    private String tagContent;

    public String getNameFromTag() {
        return null;
    }

    public boolean isEndTag() {
        if (tagContent.contains("/>")) {
            return true;
        }

        return false;
    }

    public List<Attribute> getAttributesFromTag() {
        return null;
    }


    public String getTagContent() {
        return tagContent;
    }

    public void setTagContent(String tagContent) {
        this.tagContent = tagContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(tagContent, tag.tagContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagContent);
    }
}