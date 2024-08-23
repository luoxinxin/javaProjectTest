package com.lxx.designpattern.builder.guidemo1;

import javax.swing.*;
import java.awt.*;

/**
 * 使用建造者模式构建复杂的图形界面（GUI）
 */
class GUIBuilder {
    public void buildWindow() {
        JFrame frame = new JFrame("Builder Pattern Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JLabel label = new JLabel("Enter your name:");
        JTextField textField = new JTextField();
        JButton button = new JButton("Submit");

        panel.add(label);
        panel.add(textField);
        panel.add(button);

        frame.add(panel);
        frame.setVisible(true);
    }
}

// 客户端代码
public class BuilderPatternDemo {
    public static void main(String[] args) {
        GUIBuilder builder = new GUIBuilder();
        builder.buildWindow();
    }
}
