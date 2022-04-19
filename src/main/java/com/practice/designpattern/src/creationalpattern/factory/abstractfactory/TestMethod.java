package creationalpattern.factory.abstractfactory;

import creationalpattern.factory.abstractfactory.factory.abstractfactory.Farm;
import creationalpattern.factory.product.abstractproduct.Animal;
import creationalpattern.factory.product.abstractproduct.Plant;
import utils.ReadXML;

public class TestMethod {

    public static void main(String[] args) {
        try {
            Farm farm = (Farm) ReadXML.getObject("abstractfactory.xml");
            Animal animal = farm.getAnimal();
            Plant plant = farm.getPlant();
            animal.show();
            plant.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
