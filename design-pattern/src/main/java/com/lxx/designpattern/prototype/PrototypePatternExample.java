package com.lxx.designpattern.prototype;


/**
 * 原型模式是一种创建型设计模式，它通过复制现有对象来创建新的对象，而无需知道对象的具体类型。原型模式适用于以下场景：
 *
 * 对象创建成本较高：当创建一个对象的成本较高时，例如需要进行复杂的计算或与外部资源交互，使用原型模式可以通过复制已有的对象来避免重复这些操作，从而提高性能。
 * 对象结构复杂：当对象的结构比较复杂时，使用原型模式可以通过复制已有对象来创建新的对象，而无需重新创建整个对象，从而减少了对象创建的复杂性。
 * 需要动态创建对象：当需要动态创建对象时，例如根据用户输入或配置文件创建对象，使用原型模式可以通过复制已有对象来创建新的对象，从而提高了灵活性和可扩展性。
 * 对象的某些属性需要在运行时动态设置：当对象的某些属性需要在运行时动态设置时，例如根据用户输入或配置文件设置对象的属性，使用原型模式可以通过复制已有对象并设置其属性来创建新的对象，从而提高了灵活性和可扩展性。
 *
 * 总之，原型模式适用于需要创建大量相似对象或需要动态创建对象的场景，它可以提高性能、减少对象创建的复杂性、提高灵活性和可扩展性。
 *
 * 原型模式不依赖于clone 也可以通过 序列化 反序列化 对象的拷贝构造函数 第三方库或框架 来实现
 */
import java.util.HashMap;
import java.util.Map;

// 敌人原型接口
interface EnemyPrototype {
    EnemyPrototype clone();
    void attack();
}

// 具体敌人类
class Enemy implements EnemyPrototype {
    private String name;
    private int health;

    public Enemy(String name, int health) {
        this.name = name;
        this.health = health;
    }

    @Override
    public EnemyPrototype clone() {
        return new Enemy(name, health);
    }

    @Override
    public void attack() {
        System.out.println(name + " attacks with " + health + " health.");
    }
}

public class PrototypePatternExample {
    public static void main(String[] args) {
        // 创建敌人原型
        EnemyPrototype enemyPrototype = new Enemy("Goblin", 100);

        // 克隆敌人原型创建新的敌人对象
        EnemyPrototype enemy1 = enemyPrototype.clone();
        EnemyPrototype enemy2 = enemyPrototype.clone();

        // 调用攻击方法
        enemy1.attack();
        enemy2.attack();
    }
}
