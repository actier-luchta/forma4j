package io.luchta.forma4j.reader;

import io.luchta.forma4j.context.databind.json.JsonNode;
import io.luchta.forma4j.context.databind.json.JsonNodes;
import io.luchta.forma4j.context.databind.json.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.FileInputStream;
import java.io.InputStream;

public class FormaReaderTest {

    @ParameterizedTest
    @CsvSource({
            "reader/simple_cell_read_test.xml, reader/FormaReaderTest.xlsx"
    })
    public void simple_cell_read_test(String configPath, String excelPath) throws Exception {
        try (InputStream config = new FileInputStream(this.getClass().getClassLoader().getResource(configPath).getPath());
             InputStream excel = new FileInputStream(this.getClass().getClassLoader().getResource(excelPath).getPath());) {
            FormaReader formaReader = new FormaReader();
            JsonObject obj = formaReader.read(config, excel);

            Object root = obj.getValue();
            Assertions.assertEquals(true, root instanceof JsonNode);

            JsonObject sheet = ((JsonNode) root).getVar("forma-reader");
            Assertions.assertEquals(true, sheet.getValue() instanceof JsonNode);

            JsonObject cell = ((JsonNode) sheet.getValue()).getVar("data");
            Assertions.assertEquals(true, cell.getValue() instanceof JsonNode);

            JsonObject value = ((JsonNode) cell.getValue()).getVar("title");
            Assertions.assertEquals(true, value.getValue() instanceof String);
            Assertions.assertEquals("サンプル帳票", value.toString());
        }
    }

    @ParameterizedTest
    @CsvSource({
            "reader/simple_vfor_test.xml, reader/FormaReaderTest.xlsx"
    })
    public void simple_vfor_test(String configPath, String excelPath) throws Exception {
        try (InputStream config = new FileInputStream(this.getClass().getClassLoader().getResource(configPath).getPath());
             InputStream excel = new FileInputStream(this.getClass().getClassLoader().getResource(excelPath).getPath());) {
            FormaReader formaReader = new FormaReader();
            JsonObject obj = formaReader.read(config, excel);

            Object root = obj.getValue();
            Assertions.assertEquals(true, root instanceof JsonNode);

            JsonObject sheet = ((JsonNode) root).getVar("forma-reader");
            Assertions.assertEquals(true, sheet.getValue() instanceof JsonNode);

            JsonObject cell = ((JsonNode) sheet.getValue()).getVar("data");
            Assertions.assertEquals(true, cell.getValue() instanceof JsonNode);

            JsonObject value = ((JsonNode) cell.getValue()).getVar("employee");
            Assertions.assertEquals(true, value.getValue() instanceof JsonNodes);
            JsonNodes employeeNodes = (JsonNodes) value.getValue();
            Assertions.assertEquals(5, employeeNodes.size());

            JsonNode node1 = employeeNodes.get(0);
            Assertions.assertEquals("0001", node1.getVar("employeeCode").toString());
            Assertions.assertEquals("山田", node1.getVar("lastName").toString());
            Assertions.assertEquals("太郎", node1.getVar("firstName").toString());

            JsonNode node2 = employeeNodes.get(1);
            Assertions.assertEquals("0002", node2.getVar("employeeCode").toString());
            Assertions.assertEquals("山田", node2.getVar("lastName").toString());
            Assertions.assertEquals("二郎", node2.getVar("firstName").toString());

            JsonNode node3 = employeeNodes.get(2);
            Assertions.assertEquals("0003", node3.getVar("employeeCode").toString());
            Assertions.assertEquals("山田", node3.getVar("lastName").toString());
            Assertions.assertEquals("三郎", node3.getVar("firstName").toString());

            JsonNode node4 = employeeNodes.get(3);
            Assertions.assertEquals("0004", node4.getVar("employeeCode").toString());
            Assertions.assertEquals("山田", node4.getVar("lastName").toString());
            Assertions.assertEquals("四郎", node4.getVar("firstName").toString());

            JsonNode node5 = employeeNodes.get(4);
            Assertions.assertEquals("0005", node5.getVar("employeeCode").toString());
            Assertions.assertEquals("山田", node5.getVar("lastName").toString());
            Assertions.assertEquals("五郎", node5.getVar("firstName").toString());
        }
    }

    @ParameterizedTest
    @CsvSource({
            "reader/simple_hfor_test.xml, reader/FormaReaderTest.xlsx"
    })
    public void simple_hfor_test(String configPath, String excelPath) throws Exception {
        try (InputStream config = new FileInputStream(this.getClass().getClassLoader().getResource(configPath).getPath());
             InputStream excel = new FileInputStream(this.getClass().getClassLoader().getResource(excelPath).getPath());) {
            FormaReader formaReader = new FormaReader();
            JsonObject obj = formaReader.read(config, excel);

            Object root = obj.getValue();
            Assertions.assertEquals(true, root instanceof JsonNode);

            JsonObject sheet = ((JsonNode) root).getVar("forma-reader");
            Assertions.assertEquals(true, sheet.getValue() instanceof JsonNode);

            JsonObject cell = ((JsonNode) sheet.getValue()).getVar("data");
            Assertions.assertEquals(true, cell.getValue() instanceof JsonNode);

            JsonObject value = ((JsonNode) cell.getValue()).getVar("hfor");
            Assertions.assertEquals(true, value.getValue() instanceof JsonNode);
            JsonNode valueNode = (JsonNode) value.getValue();
            Assertions.assertEquals(13, valueNode.size());

            JsonObject obj1 = valueNode.getVar("value1");
            Assertions.assertEquals("社員コード", obj1.toString());

            JsonObject obj2 = valueNode.getVar("value2");
            Assertions.assertEquals("氏", obj2.toString());

            JsonObject obj3 = valueNode.getVar("value3");
            Assertions.assertEquals("名", obj3.toString());

            JsonObject obj4 = valueNode.getVar("value4");
            Assertions.assertEquals("不定１", obj4.toString());

            JsonObject obj5 = valueNode.getVar("value5");
            Assertions.assertEquals("不定２", obj5.toString());

            JsonObject obj6 = valueNode.getVar("value6");
            Assertions.assertEquals("不定３", obj6.toString());

            JsonObject obj7 = valueNode.getVar("value7");
            Assertions.assertEquals("不定４", obj7.toString());

            JsonObject obj8 = valueNode.getVar("value8");
            Assertions.assertEquals("不定５", obj8.toString());

            JsonObject obj9 = valueNode.getVar("value9");
            Assertions.assertEquals("不定６", obj9.toString());

            JsonObject obj10 = valueNode.getVar("value10");
            Assertions.assertEquals("不定７", obj10.toString());

            JsonObject obj11 = valueNode.getVar("value11");
            Assertions.assertEquals("不定８", obj11.toString());

            JsonObject obj12 = valueNode.getVar("value12");
            Assertions.assertEquals("不定９", obj12.toString());

            JsonObject obj13 = valueNode.getVar("value13");
            Assertions.assertEquals("不定１０", obj13.toString());
        }
    }

    @ParameterizedTest
    @CsvSource({
            "reader/simple_vfor_hfor_test.xml, reader/FormaReaderTest.xlsx"
    })
    public void simple_vfor_hfor_test(String configPath, String excelPath) throws Exception {
        try (InputStream config = new FileInputStream(this.getClass().getClassLoader().getResource(configPath).getPath());
             InputStream excel = new FileInputStream(this.getClass().getClassLoader().getResource(excelPath).getPath());) {
            FormaReader formaReader = new FormaReader();
            JsonObject obj = formaReader.read(config, excel);

            Object root = obj.getValue();
            Assertions.assertEquals(true, root instanceof JsonNode);

            JsonObject sheet = ((JsonNode) root).getVar("forma-reader");
            Assertions.assertEquals(true, sheet.getValue() instanceof JsonNode);

            JsonObject cell = ((JsonNode) sheet.getValue()).getVar("data");
            Assertions.assertEquals(true, cell.getValue() instanceof JsonNode);

            JsonObject value = ((JsonNode) cell.getValue()).getVar("employee");
            Assertions.assertEquals(true, value.getValue() instanceof JsonNodes);
            JsonNodes employeeNodes = (JsonNodes) value.getValue();
            Assertions.assertEquals(5, employeeNodes.size());

            JsonNode node1 = employeeNodes.get(0);
            Assertions.assertEquals(4, node1.size());
            JsonNode node1HFor = (JsonNode) node1.getVar("hfor").getValue();
            Assertions.assertEquals(10, node1HFor.size());

            JsonNode node2 = employeeNodes.get(1);
            Assertions.assertEquals(4, node1.size());
            JsonNode node2HFor = (JsonNode) node2.getVar("hfor").getValue();
            Assertions.assertEquals(4, node2HFor.size());

            JsonNode node3 = employeeNodes.get(2);
            Assertions.assertEquals(4, node3.size());
            JsonNode node3HFor = (JsonNode) node3.getVar("hfor").getValue();
            Assertions.assertEquals(0, node3HFor.size());

            JsonNode node4 = employeeNodes.get(3);
            Assertions.assertEquals(4, node4.size());
            JsonNode node4HFor = (JsonNode) node4.getVar("hfor").getValue();
            Assertions.assertEquals(2, node4HFor.size());

            JsonNode node5 = employeeNodes.get(4);
            Assertions.assertEquals(4, node5.size());
            JsonNode node5HFor = (JsonNode) node5.getVar("hfor").getValue();
            Assertions.assertEquals(10, node5HFor.size());
        }
    }

    @ParameterizedTest
    @CsvSource({
            "reader/simple_list_read_test.xml, reader/FormaReaderTest.xlsx"
    })
    public void simple_list_test(String configPath, String excelPath) throws Exception {
        try (InputStream config = new FileInputStream(this.getClass().getClassLoader().getResource(configPath).getPath());
             InputStream excel = new FileInputStream(this.getClass().getClassLoader().getResource(excelPath).getPath());) {
            FormaReader formaReader = new FormaReader();
            JsonObject obj = formaReader.read(config, excel);

            Object root = obj.getValue();
            Assertions.assertEquals(true, root instanceof JsonNode);

            JsonObject sheet = ((JsonNode) root).getVar("forma-reader");
            Assertions.assertEquals(true, sheet.getValue() instanceof JsonNode);

            JsonObject list = ((JsonNode) sheet.getValue()).getVar("data");
            Assertions.assertEquals(true, list.getValue() instanceof JsonNodes);

            JsonNodes nodes = (JsonNodes) list.getValue();
            Assertions.assertEquals(5, nodes.size());

            JsonNode node1 = nodes.get(0);
            Assertions.assertEquals("0001", node1.getVar("社員コード").getValue());
            Assertions.assertEquals("山田", node1.getVar("氏").getValue());
            Assertions.assertEquals("太郎", node1.getVar("名").getValue());
            Assertions.assertEquals(1.05, node1.getVar("不定１").getValue());
            Assertions.assertEquals(2.0, node1.getVar("不定２").getValue());
            Assertions.assertEquals(3.0, node1.getVar("不定３").getValue());
            Assertions.assertEquals(4.0, node1.getVar("不定４").getValue());
            Assertions.assertEquals(5.0, node1.getVar("不定５").getValue());
            Assertions.assertEquals(6.0, node1.getVar("不定６").getValue());
            Assertions.assertEquals("", node1.getVar("不定７").getValue());
            Assertions.assertEquals("", node1.getVar("不定８").getValue());
            Assertions.assertEquals("", node1.getVar("不定９").getValue());
            Assertions.assertEquals("", node1.getVar("不定１０").getValue());

            JsonNode node2 = nodes.get(1);
            Assertions.assertEquals("0002", node2.getVar("社員コード").getValue());
            Assertions.assertEquals("山田", node2.getVar("氏").getValue());
            Assertions.assertEquals("二郎", node2.getVar("名").getValue());
            Assertions.assertEquals(7.0, node2.getVar("不定１").getValue());
            Assertions.assertEquals(8.0, node2.getVar("不定２").getValue());
            Assertions.assertEquals(9.0, node2.getVar("不定３").getValue());
            Assertions.assertEquals(10.0, node2.getVar("不定４").getValue());
            Assertions.assertEquals("", node2.getVar("不定５").getValue());
            Assertions.assertEquals("", node2.getVar("不定６").getValue());
            Assertions.assertEquals("", node2.getVar("不定７").getValue());
            Assertions.assertEquals("", node2.getVar("不定８").getValue());
            Assertions.assertEquals("", node2.getVar("不定９").getValue());
            Assertions.assertEquals("", node2.getVar("不定１０").getValue());

            JsonNode node3 = nodes.get(2);
            Assertions.assertEquals("0003", node3.getVar("社員コード").getValue());
            Assertions.assertEquals("山田", node3.getVar("氏").getValue());
            Assertions.assertEquals("三郎", node3.getVar("名").getValue());
            Assertions.assertEquals("", node3.getVar("不定１").getValue());
            Assertions.assertEquals("", node3.getVar("不定２").getValue());
            Assertions.assertEquals("", node3.getVar("不定３").getValue());
            Assertions.assertEquals("", node3.getVar("不定４").getValue());
            Assertions.assertEquals("", node3.getVar("不定５").getValue());
            Assertions.assertEquals("", node3.getVar("不定６").getValue());
            Assertions.assertEquals("", node3.getVar("不定７").getValue());
            Assertions.assertEquals("", node3.getVar("不定８").getValue());
            Assertions.assertEquals("", node3.getVar("不定９").getValue());
            Assertions.assertEquals("", node3.getVar("不定１０").getValue());

            JsonNode node4 = nodes.get(3);
            Assertions.assertEquals("0004", node4.getVar("社員コード").getValue());
            Assertions.assertEquals("山田", node4.getVar("氏").getValue());
            Assertions.assertEquals("四郎", node4.getVar("名").getValue());
            Assertions.assertEquals(11.0, node4.getVar("不定１").getValue());
            Assertions.assertEquals(12.0, node4.getVar("不定２").getValue());
            Assertions.assertEquals("", node4.getVar("不定３").getValue());
            Assertions.assertEquals("", node4.getVar("不定４").getValue());
            Assertions.assertEquals("", node4.getVar("不定５").getValue());
            Assertions.assertEquals("", node4.getVar("不定６").getValue());
            Assertions.assertEquals("", node4.getVar("不定７").getValue());
            Assertions.assertEquals("", node4.getVar("不定８").getValue());
            Assertions.assertEquals("", node4.getVar("不定９").getValue());
            Assertions.assertEquals("", node4.getVar("不定１０").getValue());

            JsonNode node5 = nodes.get(4);
            Assertions.assertEquals("0005", node5.getVar("社員コード").getValue());
            Assertions.assertEquals("山田", node5.getVar("氏").getValue());
            Assertions.assertEquals("五郎", node5.getVar("名").getValue());
            Assertions.assertEquals(13.0, node5.getVar("不定１").getValue());
            Assertions.assertEquals(14.0, node5.getVar("不定２").getValue());
            Assertions.assertEquals(15.0, node5.getVar("不定３").getValue());
            Assertions.assertEquals(16.0, node5.getVar("不定４").getValue());
            Assertions.assertEquals(17.0, node5.getVar("不定５").getValue());
            Assertions.assertEquals(18.0, node5.getVar("不定６").getValue());
            Assertions.assertEquals(19.0, node5.getVar("不定７").getValue());
            Assertions.assertEquals(20.0, node5.getVar("不定８").getValue());
            Assertions.assertEquals(21.0, node5.getVar("不定９").getValue());
            Assertions.assertEquals(22.0, node5.getVar("不定１０").getValue());
        }
    }

    @ParameterizedTest
    @CsvSource({
            "reader/FormaReaderDefaultTest.xlsx"
    })
    public void simple_default_test(String excelPath) throws Exception {
        try (InputStream excel = new FileInputStream(this.getClass().getClassLoader().getResource(excelPath).getPath());) {
            FormaReader formaReader = new FormaReader();
            JsonObject obj = formaReader.read(excel);

            Object root = obj.getValue();
            Assertions.assertEquals(true, root instanceof JsonNode);

            JsonObject sheet = ((JsonNode) root).getVar("forma-reader");
            Assertions.assertEquals(true, sheet.getValue() instanceof JsonNode);

            JsonObject list = ((JsonNode) sheet.getValue()).getVar("data");
            Assertions.assertEquals(true, list.getValue() instanceof JsonNodes);

            JsonNodes nodes = (JsonNodes) list.getValue();
            Assertions.assertEquals(5, nodes.size());

            JsonNode node1 = nodes.get(0);
            Assertions.assertEquals("0001", node1.getVar("社員コード").getValue());
            Assertions.assertEquals("山田", node1.getVar("氏").getValue());
            Assertions.assertEquals("太郎", node1.getVar("名").getValue());
            Assertions.assertEquals(1.05, node1.getVar("不定１").getValue());
            Assertions.assertEquals(2.0, node1.getVar("不定２").getValue());
            Assertions.assertEquals(3.0, node1.getVar("不定３").getValue());
            Assertions.assertEquals(4.0, node1.getVar("不定４").getValue());
            Assertions.assertEquals(5.0, node1.getVar("不定５").getValue());
            Assertions.assertEquals(6.0, node1.getVar("不定６").getValue());
            Assertions.assertEquals("", node1.getVar("不定７").getValue());
            Assertions.assertEquals("", node1.getVar("不定８").getValue());
            Assertions.assertEquals("", node1.getVar("不定９").getValue());
            Assertions.assertEquals("", node1.getVar("不定１０").getValue());

            JsonNode node2 = nodes.get(1);
            Assertions.assertEquals("0002", node2.getVar("社員コード").getValue());
            Assertions.assertEquals("山田", node2.getVar("氏").getValue());
            Assertions.assertEquals("二郎", node2.getVar("名").getValue());
            Assertions.assertEquals(7.0, node2.getVar("不定１").getValue());
            Assertions.assertEquals(8.0, node2.getVar("不定２").getValue());
            Assertions.assertEquals(9.0, node2.getVar("不定３").getValue());
            Assertions.assertEquals(10.0, node2.getVar("不定４").getValue());
            Assertions.assertEquals("", node2.getVar("不定５").getValue());
            Assertions.assertEquals("", node2.getVar("不定６").getValue());
            Assertions.assertEquals("", node2.getVar("不定７").getValue());
            Assertions.assertEquals("", node2.getVar("不定８").getValue());
            Assertions.assertEquals("", node2.getVar("不定９").getValue());
            Assertions.assertEquals("", node2.getVar("不定１０").getValue());

            JsonNode node3 = nodes.get(2);
            Assertions.assertEquals("0003", node3.getVar("社員コード").getValue());
            Assertions.assertEquals("山田", node3.getVar("氏").getValue());
            Assertions.assertEquals("三郎", node3.getVar("名").getValue());
            Assertions.assertEquals("", node3.getVar("不定１").getValue());
            Assertions.assertEquals("", node3.getVar("不定２").getValue());
            Assertions.assertEquals("", node3.getVar("不定３").getValue());
            Assertions.assertEquals("", node3.getVar("不定４").getValue());
            Assertions.assertEquals("", node3.getVar("不定５").getValue());
            Assertions.assertEquals("", node3.getVar("不定６").getValue());
            Assertions.assertEquals("", node3.getVar("不定７").getValue());
            Assertions.assertEquals("", node3.getVar("不定８").getValue());
            Assertions.assertEquals("", node3.getVar("不定９").getValue());
            Assertions.assertEquals("", node3.getVar("不定１０").getValue());

            JsonNode node4 = nodes.get(3);
            Assertions.assertEquals("0004", node4.getVar("社員コード").getValue());
            Assertions.assertEquals("山田", node4.getVar("氏").getValue());
            Assertions.assertEquals("四郎", node4.getVar("名").getValue());
            Assertions.assertEquals(11.0, node4.getVar("不定１").getValue());
            Assertions.assertEquals(12.0, node4.getVar("不定２").getValue());
            Assertions.assertEquals("", node4.getVar("不定３").getValue());
            Assertions.assertEquals("", node4.getVar("不定４").getValue());
            Assertions.assertEquals("", node4.getVar("不定５").getValue());
            Assertions.assertEquals("", node4.getVar("不定６").getValue());
            Assertions.assertEquals("", node4.getVar("不定７").getValue());
            Assertions.assertEquals("", node4.getVar("不定８").getValue());
            Assertions.assertEquals("", node4.getVar("不定９").getValue());
            Assertions.assertEquals("", node4.getVar("不定１０").getValue());

            JsonNode node5 = nodes.get(4);
            Assertions.assertEquals("0005", node5.getVar("社員コード").getValue());
            Assertions.assertEquals("山田", node5.getVar("氏").getValue());
            Assertions.assertEquals("五郎", node5.getVar("名").getValue());
            Assertions.assertEquals(13.0, node5.getVar("不定１").getValue());
            Assertions.assertEquals(14.0, node5.getVar("不定２").getValue());
            Assertions.assertEquals(15.0, node5.getVar("不定３").getValue());
            Assertions.assertEquals(16.0, node5.getVar("不定４").getValue());
            Assertions.assertEquals(17.0, node5.getVar("不定５").getValue());
            Assertions.assertEquals(18.0, node5.getVar("不定６").getValue());
            Assertions.assertEquals(19.0, node5.getVar("不定７").getValue());
            Assertions.assertEquals(20.0, node5.getVar("不定８").getValue());
            Assertions.assertEquals(21.0, node5.getVar("不定９").getValue());
            Assertions.assertEquals(22.0, node5.getVar("不定１０").getValue());
        }
    }
}
