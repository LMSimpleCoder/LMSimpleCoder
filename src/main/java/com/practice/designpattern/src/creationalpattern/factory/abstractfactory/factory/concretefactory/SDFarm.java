package creationalpattern.factory.abstractfactory.factory.concretefactory;

import creationalpattern.factory.abstractfactory.factory.abstractfactory.Farm;
import creationalpattern.factory.product.abstractproduct.Animal;
import creationalpattern.factory.product.abstractproduct.Plant;
import creationalpattern.factory.product.concreteproduct.Cattle;
import creationalpattern.factory.product.concreteproduct.Vegetables;


public class SDFarm implements Farm {
    String lx = "抽象工厂模式测试";
    @Override
    public Animal getAnimal() {
        System.out.println("新牛出生！");
        return new Cattle(lx);
    }

    @Override
    public Plant getPlant() {
        System.out.println("蔬菜长成！");
        return new Vegetables(lx);
    }
}
