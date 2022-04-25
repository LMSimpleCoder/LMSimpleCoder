package creationalpattern.factory.factorymethod;

import creationalpattern.factory.factorymethod.factory.abstractfactory.Farm;
import creationalpattern.factory.product.abstractproduct.Animal;
import utils.ReadXML;

public class TestMethod {

    public static void main(String[] args) {
        try {
            Farm farm = (Farm) ReadXML.getObject("factorymethod.xml");
            Animal animal = farm.getAnimal();
            animal.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
