package com.lxx.designpattern.factory.abs;

// 抽象产品类 1
abstract class AbstractProductA {
    abstract void doSomething();
}

// 抽象产品类 2
abstract class AbstractProductB {
    abstract void doSomething();
}

// 具体产品类 1A，继承自抽象产品类 1
class ConcreteProduct1A extends AbstractProductA {
    @Override
    void doSomething() {
        System.out.println("ConcreteProduct1A is doing something...");
    }
}

// 具体产品类 1B，继承自抽象产品类 2
class ConcreteProduct1B extends AbstractProductB {
    @Override
    void doSomething() {
        System.out.println("ConcreteProduct1B is doing something...");
    }
}

// 具体产品类 2A，继承自抽象产品类 1
class ConcreteProduct2A extends AbstractProductA {
    @Override
    void doSomething() {
        System.out.println("ConcreteProduct2A is doing something...");
    }
}

// 具体产品类 2B，继承自抽象产品类 2
class ConcreteProduct2B extends AbstractProductB {
    @Override
    void doSomething() {
        System.out.println("ConcreteProduct2B is doing something...");
    }
}

// 抽象工厂类
abstract class AbstractFactory {
    // 抽象方法，用于创建抽象产品类 1
    abstract AbstractProductA createProductA();

    // 抽象方法，用于创建抽象产品类 2
    abstract AbstractProductB createProductB();
}

// 具体工厂类 1，继承自抽象工厂类
class ConcreteFactory1 extends AbstractFactory {
    @Override
    AbstractProductA createProductA() {
        return new ConcreteProduct1A();
    }

    @Override
    AbstractProductB createProductB() {
        return new ConcreteProduct1B();
    }
}

// 具体工厂类 2，继承自抽象工厂类
class ConcreteFactory2 extends AbstractFactory {
    @Override
    AbstractProductA createProductA() {
        return new ConcreteProduct2A();
    }

    @Override
    AbstractProductB createProductB() {
        return new ConcreteProduct2B();
    }
}

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        // 创建具体工厂对象 1
        AbstractFactory factory1 = new ConcreteFactory1();

        // 创建具体工厂对象 2
        AbstractFactory factory2 = new ConcreteFactory2();

        // 通过工厂创建产品
        AbstractProductA productA1 = factory1.createProductA();
        AbstractProductB productB1 = factory1.createProductB();

        AbstractProductA productA2 = factory2.createProductA();
        AbstractProductB productB2 = factory2.createProductB();

        // 执行产品的方法
        productA1.doSomething();
        productB1.doSomething();

        productA2.doSomething();
        productB2.doSomething();
    }
}
