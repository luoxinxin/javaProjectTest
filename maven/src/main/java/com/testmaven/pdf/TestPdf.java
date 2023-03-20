package com.testmaven.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class TestPdf {
    private static long a = 1;
    private static final ListNode b= null;
    //private final long c = 3;
    public static void main(String[] args) throws DocumentException, IOException {
        File file = new File("D:\\test.pdf");
        file.delete();
        final ListNode c = new ListNode();
        a = 4;
        c.val=1;
        //b = 5;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c.val);
//        String pdfRoute = "";
//        Map<String, String> data = new HashMap<String, String>();
//        data.put("EKEY","一轮圆月");
//        data.put("ID","一轮圆月");
//        data.put("UNAME","一轮圆月");
//        data.put("STOCK_CODE","一轮圆月");
//        data.put("START_DATE","一轮圆月");
//        data.put("START_TIME","一轮圆月");
//        data.put("TITLE","一轮圆月");
//        data.put("roadshowSite","https://www.baidu.com/s?ie=UTF-8&wd=Error%//r//n3A%20EBUSY%3A%20re/nsou");
//        data.put("modeId","模式4：第三方转流直播+中小投资者网络文字");
//        data.put("LOCATION_ID","上证路演中心南方基地（广州）");
//        data.put("CONTACT_NAME","一轮圆月");
//        data.put("CONTACT_MOBILE","16969877896");
//        data.put("CONTACT_MAIL","16969877896@qq.com");
//        data.put("CRT_TIME","一轮圆月");
//        data.put("APPFORM_CON_TIME","2020.01.01 03:06:09");
//
//        pdfUtil(pdfRoute,data);
    }

    public static void pdfUtil(String pdfRoute,Map<String, String> data) throws DocumentException, IOException{
        BaseFont baseFont = BaseFont.createFont("C://windows/Fonts/仿宋_GB2312.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        PdfReader pdfReader = new PdfReader("C:/Users/user/Desktop/rsn (1).pdf");
        PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("C:/temp/rs21.pdf"));
        AcroFields form = pdfStamper.getAcroFields();
        form.addSubstitutionFont(baseFont);
        //写入数据
        //key对应模板数据域的名称，同是也是查询出来的数据属性名
        for (String key : data.keySet()) {
            String value = data.get(key).toString();
            //form.setField()
            form.setField(key, value);
        }
        pdfStamper.close();
    }


    /*public static void main(String[] args) throws IOException, DocumentException {

        *//* example inspired from "iText in action" (2006), chapter 2 *//*

        PdfReader reader = new PdfReader("C:/temp/Bubi.pdf"); // input PDF
        PdfStamper stamper = new PdfStamper(reader,
                new FileOutputStream("C:/temp/Bubi_modified.pdf")); // output PDF
        BaseFont bf = BaseFont.createFont(
                BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED); // set font

        //loop on pages (1-based)
        for (int i=1; i<=reader.getNumberOfPages(); i++){

            // get object for writing over the existing content;
            // you can also use getUnderContent for writing in the bottom layer
            PdfContentByte over = stamper.getOverContent(i);

            // write text
            over.beginText();
            over.setFontAndSize(bf, 10);    // set font and size
            over.setTextMatrix(107, 740);   // set x,y position (0,0 is at the bottom left)
            over.showText("I can write at page " + i);  // set text
            over.endText();

            // draw a red circle
            over.setRGBColorStroke(0xFF, 0x00, 0x00);
            over.setLineWidth(5f);
            over.ellipse(250, 450, 350, 550);
            over.stroke();
        }

        stamper.close();

    }*/
}
