package com.lxx.spb2hotdev.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.FileOutputStream;

public class CreateWordDocument {
    public static void main(String[] args) {
        try {
            // 创建一个新的Word文档
            XWPFDocument document = new XWPFDocument();

            // 创建一个新表格，指定表格列数
            int numRows = 5; // 例如，创建5行
            int numCols = 3; // 3列
            XWPFTable table = document.createTable(numRows, numCols);

            // 循环逐行添加数据
            for (int row = 0; row < numRows; row++) {
                XWPFTableRow tableRow = table.getRow(row);

                // 循环逐列添加数据
                for (int col = 0; col < numCols; col++) {
                    XWPFTableCell tableCell = tableRow.getCell(col);
                    XWPFParagraph paragraph = tableCell.addParagraph();
                    paragraph.createRun().setText("Row " + (row + 1) + ", Column " + (col + 1));
                }
            }

            // 保存Word文档
            FileOutputStream outputStream = new FileOutputStream("C:\\Users\\25389\\IdeaProjects\\javaProjectTest\\spb2-hotdev\\src\\main\\java\\com\\lxx\\spb2hotdev\\util\\sample.docx");
            document.write(outputStream);
            outputStream.close();

            System.out.println("Word document created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

