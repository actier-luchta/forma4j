package jp.co.actier.luchta.forma4j.reader.config.element;

import jp.co.actier.luchta.forma4j.reader.config.element.property.ElementName;

public class FVerticalFor extends Element {
    
    private ElementName name;
    
    public FVerticalFor() {}
    
    public FVerticalFor(ElementName name) {
        this.name = name;
    }
    
    @Override
    public ElementName getName() {
        return this.name;
    }
}