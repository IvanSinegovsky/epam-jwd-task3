package by.epam.jwdparsertask;

import by.epam.jwdparsertask.entity.Attribute;
import by.epam.jwdparsertask.entity.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TagTest {
    @Test
    void isEndTag() {
        Tag tag = new Tag("<note>");
        boolean actualResult = tag.isEndTag();
        boolean expectedResult = false;
        Assertions.assertEquals(expectedResult, actualResult);

        tag = new Tag("</note>");
        actualResult = tag.isEndTag();
        expectedResult = true;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void getAttributesFromTag() {
        Tag tag = new Tag("<note id=\"1\">");
        tag.getAttributesFromTag();
        List<Attribute> expectedResult = tag.getAttributes();
        List<Attribute> actualResult = new ArrayList<>();
        actualResult.add(new Attribute("id=\"1\""));
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void getName() {
        Tag tag = new Tag("<note id=\"1\">");
        String expectedResult = tag.getName();
        String actualResult = "note";
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
