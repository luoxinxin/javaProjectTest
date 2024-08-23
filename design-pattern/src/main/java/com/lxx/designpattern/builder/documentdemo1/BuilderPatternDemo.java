package com.lxx.designpattern.builder.documentdemo1;

/**
 * 构建复杂的文档格式（如HTML、PDF、XML）时，建造者模式可以用来将对象的构建和表示分离
 */

// 产品类
class Document {
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}

// 抽象建造者
abstract class DocumentBuilder {
    protected Document document;

    public Document getDocument() {
        return document;
    }

    public void createNewDocument() {
        document = new Document();
    }

    public abstract void buildContent();
}

// 具体建造者 - HTML
class HTMLDocumentBuilder extends DocumentBuilder {
    @Override
    public void buildContent() {
        document.setContent("<html><body><h1>Hello, World!</h1></body></html>");
    }
}

// 具体建造者 - PDF
class PDFDocumentBuilder extends DocumentBuilder {
    @Override
    public void buildContent() {
        document.setContent("PDF Content: Hello, World!");
    }
}

// 指导者
class DocumentDirector {
    private DocumentBuilder documentBuilder;

    public void setDocumentBuilder(DocumentBuilder documentBuilder) {
        this.documentBuilder = documentBuilder;
    }

    public Document getDocument() {
        return documentBuilder.getDocument();
    }

    public void constructDocument() {
        documentBuilder.createNewDocument();
        documentBuilder.buildContent();
    }
}

// 客户端代码
public class BuilderPatternDemo {
    public static void main(String[] args) {
        DocumentDirector director = new DocumentDirector();

        DocumentBuilder htmlBuilder = new HTMLDocumentBuilder();
        director.setDocumentBuilder(htmlBuilder);
        director.constructDocument();
        Document htmlDocument = director.getDocument();
        System.out.println(htmlDocument);

        DocumentBuilder pdfBuilder = new PDFDocumentBuilder();
        director.setDocumentBuilder(pdfBuilder);
        director.constructDocument();
        Document pdfDocument = director.getDocument();
        System.out.println(pdfDocument);
    }
}
