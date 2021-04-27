package io.luchta.forma4j.writer.definition.schema.element;

import io.luchta.forma4j.writer.definition.schema.Element;
import io.luchta.forma4j.writer.definition.schema.ElementList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "luchta")
public class Root {
    @XmlElements({
            @XmlElement(name = Sheet.ELEMENT_NAME, type = Sheet.class),
    })
    List<Element> children = new ArrayList<>();

    public ElementList children() {
        return new ElementList(children);
    }
}