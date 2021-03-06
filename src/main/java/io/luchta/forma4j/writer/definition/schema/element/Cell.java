package io.luchta.forma4j.writer.definition.schema.element;

import io.luchta.forma4j.writer.definition.schema.Element;
import io.luchta.forma4j.writer.definition.schema.ElementList;
import io.luchta.forma4j.writer.definition.schema.ElementType;
import io.luchta.forma4j.writer.definition.schema.attribute.Style;
import io.luchta.forma4j.writer.definition.schema.attribute.Text;
import io.luchta.forma4j.writer.definition.schema.attribute.index.ColumnIndex;
import io.luchta.forma4j.writer.definition.schema.attribute.index.RowIndex;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlValue;

@XmlRootElement
public class Cell implements Element {
    public static final String ELEMENT_NAME = "cell";

    @XmlAttribute
    ColumnIndex columnIndex = new ColumnIndex();
    @XmlAttribute
    RowIndex rowIndex = new RowIndex();
    @XmlAttribute
    Style style = new Style();
    @XmlValue
    Text text = new Text();

    public ColumnIndex columnIndex() {
        return columnIndex;
    }

    public RowIndex rowIndex() {
        return rowIndex;
    }
    
    public Style style() {
    	return style;
    }

    public Text text() {
        return text;
    }

    @Override
    public ElementType type() {
        return ElementType.CELL;
    }

    @Override
    public ElementList children() {
        return new ElementList();
    }

    @Override
    public boolean hasChildren() {
        return false;
    }
}
