package org.example.util;

import org.w3c.dom.*;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.springframework.core.io.ClassPathResource;

public class XMLReader {
    public static Map<String, Integer> parseFileFromClasspath(String resourcePath) {
        Map<String, Integer> result = new HashMap<>();
        try (InputStream is = new ClassPathResource(resourcePath).getInputStream()) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(is));
            NodeList rows = doc.getElementsByTagName("row");
            for (int i = 0; i < rows.getLength(); i++) {
                Element row = (Element) rows.item(i);
                String region = getTagText(row, "region_name");
                String valueText = getTagText(row, "value");
                if (region != null && valueText != null) {
                    int value = Integer.parseInt(valueText.trim());
                    result.merge(region.trim(), value, Integer::sum);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse XML: " + resourcePath, e);
        }
        return result;
    }

    private static String getTagText(Element parent, String tagName) {
        NodeList list = parent.getElementsByTagName(tagName);
        if (list.getLength() == 0) return null;
        return list.item(0).getTextContent();
    }
}
