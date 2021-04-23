package jp.co.actier.luchta.forma4j.reader.config.element.property;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

public class ColNumber implements Serializable, Comparable<ColNumber> {
    
    private static final long serialVersionUID = 1L;
    
    private Integer value;
    
    public ColNumber() {
        this.value = null;
    }
    
    public ColNumber(Integer value) {
        this.value = value;
    }
    
    public boolean isEmpty() {
        return this.value == null;
    }
    
    public int intValue() {
        return this.value.intValue();
    }

    @Override
    public int compareTo(ColNumber o) {
        return Objects.compare(this.value, o.value, Comparator.nullsLast(Comparator.naturalOrder()));
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColNumber colNumber = (ColNumber) o;
        return this.value == colNumber.value;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }
    
    @Override
    public String toString() {
        return this.value.toString();
    }
}