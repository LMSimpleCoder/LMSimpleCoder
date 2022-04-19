package utils;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ReadXML {

    public static Object getObject(String fileName) {
        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("src/source/xml/" + fileName));
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = nl.item(0).getFirstChild();
            String cName = classNode.getNodeValue();
            System.out.println("新类名：" + classNode.getNodeValue());
            Class<?> c = Class.forName(cName);
            return c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
