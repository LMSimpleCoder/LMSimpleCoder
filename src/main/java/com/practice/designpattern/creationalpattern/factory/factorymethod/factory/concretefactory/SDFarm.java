package creationalpattern.factory.factorymethod.factory.concretefactory;

import creationalpattern.factory.factorymethod.factory.abstractfactory.Farm;
import creationalpattern.factory.product.abstractproduct.Animal;
import creationalpattern.factory.product.concreteproduct.Cattle;


public class SDFarm implements Farm {
    String lx = "抽象工厂模式测试";
    @Override
    public Animal getAnimal() {
        System.out.println("新牛出生！");
        return new Cattle(lx);
    }
}
