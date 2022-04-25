package creationalpattern.factory.abstractfactory.factory.concretefactory;


import creationalpattern.factory.abstractfactory.factory.abstractfactory.Farm;
import creationalpattern.factory.product.abstractproduct.Animal;
import creationalpattern.factory.product.abstractproduct.Plant;
import creationalpattern.factory.product.concreteproduct.Fruitage;
import creationalpattern.factory.product.concreteproduct.Horse;

public class SXFarm implements Farm {
    String lx = "抽象工厂模式测试";
    @Override
    public Animal getAnimal() {
        System.out.println("新马出生！");
        return new Horse(lx);
    }

    @Override
    public Plant getPlant() {
        System.out.println("水果长成！");
        return new Fruitage(lx);
    }
}
