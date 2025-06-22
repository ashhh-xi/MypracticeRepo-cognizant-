/**
 * Concrete PdfDocumentFactory class
 * Extends DocumentFactory and creates PdfDocument instances
 */
public class PdfDocumentFactory extends DocumentFactory {
    
    @Override
    public Document createDocument(String name) {
        return new PdfDocument(name);
    }
    
    @Override
    public String getFactoryType() {
        return "PDF Document Factory";
    }
} 