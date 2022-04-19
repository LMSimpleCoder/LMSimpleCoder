package creationalpattern.factory.factorymethod.factory.concretefactory;


import creationalpattern.factory.factorymethod.factory.abstractfactory.Farm;
import creationalpattern.factory.product.abstractproduct.Animal;
import creationalpattern.factory.product.concreteproduct.Horse;

public class SXFarm implements Farm {
    String lx = "工厂方法模式测试";
    @Override
    public Animal getAnimal() {
        System.out.println("新马出生！");
        return new Horse(lx);
    }

}
