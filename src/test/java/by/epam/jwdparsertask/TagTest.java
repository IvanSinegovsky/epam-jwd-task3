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
        boolean actualResult = tag.getIsEndTag();
        boolean expectedResult = false;
        Assertions.assertEquals(expectedResult, actualResult);

        tag = new Tag("</note>");
        actualResult = tag.getIsEndTag();
        expectedResult = true;
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
