package com.lxx.designpattern.factory.method;

// 产品接口
interface Product {
    void doSomething();
}

// 具体产品类 1
class ConcreteProduct1 implements Product {
    @Override
    public void doSomething() {
        System.out.println("ConcreteProduct1 is doing something...");
    }
}

// 具体产品类 2
class ConcreteProduct2 implements Product {
    @Override
    public void doSomething() {
        System.out.println("ConcreteProduct2 is doing something...");
    }
}

// 抽象工厂类

/**
 * 工厂方法模式相较于简单工厂模式有以下几个提升：
 *
 * 1. **灵活性**：工厂方法模式将产品的创建延迟到子类中，使得系统可以在不修改工厂类的情况下引入新的产品类型。每个具体工厂类只负责创建对应的产品，增加新的产品只需添加相应的具体工厂类即可，提高了系统的灵活性和可扩展性。
 * 2. **封装性**：工厂方法模式将产品的创建封装在具体工厂类中，隐藏了产品创建的细节，客户端只需要与抽象工厂类交互，不需要关心具体产品的创建过程，提高了系统的封装性。
 * 3. **符合开闭原则**：开闭原则是指软件实体（类、模块、函数等）应该对扩展开放，对修改关闭。工厂方法模式通过引入抽象工厂类和具体工厂类，使得在增加新的产品类型时，不需要修改现有代码，只需要添加新的具体工厂类，符合开闭原则。
 * 4. **更清晰的结构**：工厂方法模式将产品的创建逻辑从工厂类中分离出来，使得工厂类的职责更加单一，结构更加清晰。每个具体工厂类只负责创建一种产品，降低了工厂类的复杂度。
 *
 * 总的来说，工厂方法模式在灵活性、封装性、可扩展性和遵循开闭原则方面相较于简单工厂模式有了显著的提升，更适合于复杂的系统和需要频繁扩展的场景。然而，工厂方法模式也增加了系统中类的数量，可能会带来一定的复杂性。在实际应用中，需要根据具体情况权衡使用哪种模式。
 */
abstract class Factory {
    // 工厂方法，用于创建产品
    abstract Product createProduct();
}

// 具体工厂类 1
class ConcreteFactory1 extends Factory {
    @Override
    Product createProduct() {
        return new ConcreteProduct1();
    }
}

// 具体工厂类 2
class ConcreteFactory2 extends Factory {
    @Override
    Product createProduct() {
        return new ConcreteProduct2();
    }
}

public class FactoryMethodDemo {
    public static void main(String[] args) {
        // 创建具体工厂对象
        Factory factory1 = new ConcreteFactory1();
        Factory factory2 = new ConcreteFactory2();

        // 通过工厂创建产品
        Product product1 = factory1.createProduct();
        Product product2 = factory2.createProduct();

        // 执行产品的方法
        product1.doSomething();
        product2.doSomething();
    }
}
