package jp.co.actier.luchta.forma4j.writer.definition.schema.element;

import jp.co.actier.luchta.forma4j.writer.definition.schema.Element;
import jp.co.actier.luchta.forma4j.writer.definition.schema.ElementList;
import jp.co.actier.luchta.forma4j.writer.definition.schema.ElementType;
import jp.co.actier.luchta.forma4j.writer.definition.schema.attribute.index.ColumnIndex;
import jp.co.actier.luchta.forma4j.writer.definition.schema.attribute.index.RowIndex;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Column implements Element {
    public static final String ELEMENT_NAME = "column";

    @XmlAttribute
    RowIndex startRowIndex = new RowIndex();
    @XmlAttribute
    ColumnIndex columnIndex = new ColumnIndex();

    @XmlElements({
            @XmlElement(name = Cell.ELEMENT_NAME, type = Cell.class),
            @XmlElement(name = HorizontalFor.ELEMENT_NAME, type = HorizontalFor.class),
            @XmlElement(name = VerticalFor.ELEMENT_NAME, type = VerticalFor.class),
    })
    List<Element> children = new ArrayList<>();

    public RowIndex startRowIndex() {
        return startRowIndex;
    }

    public ColumnIndex columnIndex() {
        return columnIndex;
    }

    @Override
    public ElementType type() {
        return ElementType.COLUMN;
    }

    @Override
    public ElementList children() {
        return new ElementList(children);
    }

    @Override
    public boolean hasChildren() {
        return !children.isEmpty();
    }
}