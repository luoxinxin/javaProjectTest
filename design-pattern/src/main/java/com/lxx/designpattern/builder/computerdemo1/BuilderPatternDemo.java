package com.lxx.designpattern.builder.computerdemo1;

/**
 * 构建具有不同配置的电脑
 */

// 产品类
class Computer {
    private String CPU;
    private String RAM;
    private String storage;

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + "]";
    }
}

// 抽象建造者
abstract class ComputerBuilder {
    protected Computer computer;

    public Computer getComputer() {
        return computer;
    }

    public void createNewComputer() {
        computer = new Computer();
    }

    public abstract void buildCPU();
    public abstract void buildRAM();
    public abstract void buildStorage();
}

// 具体建造者 - 高端配置
class HighEndComputerBuilder extends ComputerBuilder {
    @Override
    public void buildCPU() {
        computer.setCPU("Intel i9");
    }

    @Override
    public void buildRAM() {
        computer.setRAM("32GB");
    }

    @Override
    public void buildStorage() {
        computer.setStorage("1TB SSD");
    }
}

// 具体建造者 - 低端配置
class LowEndComputerBuilder extends ComputerBuilder {
    @Override
    public void buildCPU() {
        computer.setCPU("Intel i3");
    }

    @Override
    public void buildRAM() {
        computer.setRAM("8GB");
    }

    @Override
    public void buildStorage() {
        computer.setStorage("256GB SSD");
    }
}

// 指导者
class ComputerDirector {
    private ComputerBuilder computerBuilder;

    public void setComputerBuilder(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    public Computer getComputer() {
        return computerBuilder.getComputer();
    }

    public void constructComputer() {
        computerBuilder.createNewComputer();
        computerBuilder.buildCPU();
        computerBuilder.buildRAM();
        computerBuilder.buildStorage();
    }
}

// 客户端代码
public class BuilderPatternDemo {
    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();

        ComputerBuilder highEndBuilder = new HighEndComputerBuilder();
        director.setComputerBuilder(highEndBuilder);
        director.constructComputer();
        Computer highEndComputer = director.getComputer();
        System.out.println(highEndComputer);

        ComputerBuilder lowEndBuilder = new LowEndComputerBuilder();
        director.setComputerBuilder(lowEndBuilder);
        director.constructComputer();
        Computer lowEndComputer = director.getComputer();
        System.out.println(lowEndComputer);
    }
}
