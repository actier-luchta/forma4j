package io.luchta.forma4j.writer.engine.model.cell.value;

import java.time.LocalDateTime;

public class DateTime implements XlsxCellValue {
    LocalDateTime value;

    public DateTime() {
    }

    public DateTime(LocalDateTime value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if (value == null) return "";
        return value.toString();
    }
}
