/**
 * Abstract DocumentFactory class
 * Defines the Factory Method pattern for creating different types of documents
 */
public abstract class DocumentFactory {
    
    /**
     * Abstract factory method that must be implemented by concrete factories
     * @param name The name of the document to create
     * @return A Document instance
     */
    public abstract Document createDocument(String name);
    
    /**
     * Template method that uses the factory method
     * @param name The name of the document to create
     * @return A Document instance
     */
    public Document getDocument(String name) {
        Document document = createDocument(name);
        // Common initialization logic can be added here
        System.out.println("Creating document: " + name);
        return document;
    }
    
    /**
     * Method to get the factory type
     * @return String representation of the factory type
     */
    public abstract String getFactoryType();
} 