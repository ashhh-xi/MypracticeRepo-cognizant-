/**
 * Concrete WordDocumentFactory class
 * Extends DocumentFactory and creates WordDocument instances
 */
public class WordDocumentFactory extends DocumentFactory {
    
    @Override
    public Document createDocument(String name) {
        return new WordDocument(name);
    }
    
    @Override
    public String getFactoryType() {
        return "Word Document Factory";
    }
} 