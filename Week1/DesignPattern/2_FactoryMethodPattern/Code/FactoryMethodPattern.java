

interface Document {
    void open();
}


class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println(" Word Document is opened.");
    }
}

class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println(" PDF Document is opened.");
    }
}

class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println(" Excel Document is opened.");
    }
}


abstract class DocumentFactory {
    public abstract Document createDocument();
}


class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}


public class FactoryMethodPattern{
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        Document word = wordFactory.createDocument();
        Document pdf = pdfFactory.createDocument();
        Document excel = excelFactory.createDocument();

        word.open();
        pdf.open();
        excel.open();
    }
}
