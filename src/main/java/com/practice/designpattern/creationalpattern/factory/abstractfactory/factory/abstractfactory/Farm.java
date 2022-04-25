package creationalpattern.factory.abstractfactory.factory.abstractfactory;


import creationalpattern.factory.product.abstractproduct.Animal;
import creationalpattern.factory.product.abstractproduct.Plant;

public interface Farm {

    Animal getAnimal();

    Plant getPlant();
}
