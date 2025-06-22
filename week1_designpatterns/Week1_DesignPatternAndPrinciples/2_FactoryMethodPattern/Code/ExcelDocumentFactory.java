/**
 * Concrete ExcelDocumentFactory class
 * Extends DocumentFactory and creates ExcelDocument instances
 */
public class ExcelDocumentFactory extends DocumentFactory {
    
    @Override
    public Document createDocument(String name) {
        return new ExcelDocument(name);
    }
    
    @Override
    public String getFactoryType() {
        return "Excel Document Factory";
    }
} 