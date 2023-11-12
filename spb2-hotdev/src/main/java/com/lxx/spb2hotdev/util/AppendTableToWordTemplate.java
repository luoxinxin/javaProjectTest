package com.lxx.spb2hotdev.util;

import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class AppendTableToWordTemplate {
    public static void main(String[] args) {
        try {
            // 读取现有的Word模板文件
            FileInputStream templateFile = new FileInputStream("C:\\Users\\25389\\IdeaProjects\\javaProjectTest\\spb2-hotdev\\src\\main\\java\\com\\lxx\\spb2hotdev\\util\\sample.docx");
            XWPFDocument document = new XWPFDocument(templateFile);

            boolean foundMatch = false; // 用于标记是否找到匹配的行

            List<String> originalContent = new ArrayList<>(); // 用于保存原有文本内容

            // 遍历文档中的段落
            for (int i = 0; i < document.getParagraphs().size(); i++) {
                XWPFParagraph paragraph = document.getParagraphs().get(i);
                String text = paragraph.getText();

                if (text != null && text.contains("你好")) {
                    foundMatch = true; // 标记已找到匹配的行

                    // 在匹配行的下一行追加一个表格
                    XWPFParagraph newParagraph = document.createParagraph();
                    XWPFRun run = newParagraph.createRun();
                    run.addBreak(); // 换行
                    XWPFTable table = document.createTable(5, 2); // 创建一个5行2列的表格

                    // 循环逐行添加数据
                    for (int row = 0; row < 5; row++) {
                        XWPFTableRow tableRow = table.getRow(row);

                        // 循环逐列添加数据
                        for (int col = 0; col < 2; col++) {
                            XWPFTableCell tableCell = tableRow.getCell(col);
                            XWPFParagraph cellParagraph = tableCell.addParagraph();
                            cellParagraph.createRun().setText("Row " + (row + 1) + ", Column " + (col + 1));
                        }
                    }
                } else if (foundMatch) {
                    // 如果找到匹配的行后，继续填充模板的原有内容
                    // 这里示例中是在匹配行下面的所有段落继续填充，可以根据需要修改
                    XWPFRun run = paragraph.createRun();
                    run.setText("继续填充模板原有内容...");
                }
            }

            // 将修改后的文档保存到新文件中
            FileOutputStream outputFile = new FileOutputStream("C:\\Users\\25389\\IdeaProjects\\javaProjectTest\\spb2-hotdev\\src\\main\\java\\com\\lxx\\spb2hotdev\\util\\output.docx");
            document.write(outputFile);
            outputFile.close();

            System.out.println("Table appended to the Word template.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
