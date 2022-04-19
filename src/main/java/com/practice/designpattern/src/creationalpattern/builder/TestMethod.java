package creationalpattern.builder;

import utils.ReadXML;

public class TestMethod {

    public static void main(String[] args) {
        try {
            Decorator d;
            d = (Decorator) ReadXML.getObject("creationalpattern.builder.xml");
            ProjectManager m = new ProjectManager(d);
            Parlour p = m.decorate();
            p.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
