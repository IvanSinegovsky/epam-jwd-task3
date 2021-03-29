package by.epam.jwdparsertask;

import by.epam.jwdparsertask.entity.Attribute;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AttributeTest {
    @Test
    void nameAndValue() {
        Attribute attribute = new Attribute("name=value");
        String expectedResult = "name=value";
        String actualResult = attribute.toString();
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
