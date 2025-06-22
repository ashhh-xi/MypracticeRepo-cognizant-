/**
 * Test class to demonstrate Factory Method Pattern implementation
 * Shows creation of different document types using their respective factories
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        System.out.println("=== Factory Method Pattern Test ===\n");
        
        // Test 1: Word Document Factory
        System.out.println("Test 1: Word Document Factory");
        System.out.println("=================================");
        DocumentFactory wordFactory = new WordDocumentFactory();
        System.out.println("Factory Type: " + wordFactory.getFactoryType());
        
        Document wordDoc = wordFactory.getDocument("Sample_Report.docx");
        wordDoc.addContent("This is a sample Word document content.");
        wordDoc.addContent("It contains multiple paragraphs.");
        wordDoc.display();
        
        // Use Word-specific methods
        WordDocument wordDocument = (WordDocument) wordDoc;
        wordDocument.formatText();
        wordDocument.addTable();
        wordDocument.save();
        
        System.out.println();
        
        // Test 2: PDF Document Factory
        System.out.println("Test 2: PDF Document Factory");
        System.out.println("=============================");
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        System.out.println("Factory Type: " + pdfFactory.getFactoryType());
        
        Document pdfDoc = pdfFactory.getDocument("Technical_Specification.pdf");
        pdfDoc.addContent("This is a technical specification document.");
        pdfDoc.addContent("It contains detailed technical information.");
        pdfDoc.display();
        
        // Use PDF-specific methods
        PdfDocument pdfDocument = (PdfDocument) pdfDoc;
        pdfDocument.setPageSize("A4");
        pdfDocument.addBookmark("Introduction");
        pdfDocument.setSecurity(true);
        pdfDocument.save();
        
        System.out.println();
        
        // Test 3: Excel Document Factory
        System.out.println("Test 3: Excel Document Factory");
        System.out.println("===============================");
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        System.out.println("Factory Type: " + excelFactory.getFactoryType());
        
        Document excelDoc = excelFactory.getDocument("Financial_Report.xlsx");
        excelDoc.addContent("This is a financial report spreadsheet.");
        excelDoc.display();
        
        // Use Excel-specific methods
        ExcelDocument excelDocument = (ExcelDocument) excelDoc;
        excelDocument.addWorksheet("Q1 Data");
        excelDocument.addWorksheet("Q2 Data");
        excelDocument.setCellValue("A1", "Revenue");
        excelDocument.setCellValue("B1", "1000000");
        excelDocument.applyFormula("C1", "=B1*0.1");
        excelDocument.createChart("Bar Chart");
        excelDocument.save();
        
        System.out.println();
        
        // Test 4: Polymorphic behavior demonstration
        System.out.println("Test 4: Polymorphic Behavior");
        System.out.println("=============================");
        DocumentFactory[] factories = {
            new WordDocumentFactory(),
            new PdfDocumentFactory(),
            new ExcelDocumentFactory()
        };
        
        String[] documentNames = {
            "Polymorphic_Word.docx",
            "Polymorphic_PDF.pdf",
            "Polymorphic_Excel.xlsx"
        };
        
        for (int i = 0; i < factories.length; i++) {
            Document doc = factories[i].getDocument(documentNames[i]);
            doc.addContent("This document was created using " + factories[i].getFactoryType());
            doc.open();
            doc.save();
            System.out.println();
        }
        
        System.out.println("=== Factory Method Pattern Test Complete ===");
        System.out.println("✓ All document types created successfully using their respective factories!");
        System.out.println("✓ Factory Method pattern is working correctly!");
    }
} 