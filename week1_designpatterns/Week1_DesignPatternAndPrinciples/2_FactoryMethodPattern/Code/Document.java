/**
 * Abstract Document class - base class for all document types
 * Part of Factory Method Pattern implementation
 */
public abstract class Document {
    protected String name;
    protected String content;
    
    public Document(String name) {
        this.name = name;
        this.content = "";
    }
    
    /**
     * Abstract method that must be implemented by concrete document classes
     * @return String representation of the document type
     */
    public abstract String getDocumentType();
    
    /**
     * Method to add content to the document
     * @param content The content to add
     */
    public void addContent(String content) {
        this.content += content + "\n";
    }
    
    /**
     * Method to display document information
     */
    public void display() {
        System.out.println("Document Type: " + getDocumentType());
        System.out.println("Name: " + name);
        System.out.println("Content: " + content);
        System.out.println("---");
    }
    
    /**
     * Method to save the document (simulated)
     */
    public void save() {
        System.out.println("Saving " + getDocumentType() + " document: " + name);
    }
    
    /**
     * Method to open the document (simulated)
     */
    public void open() {
        System.out.println("Opening " + getDocumentType() + " document: " + name);
    }
} 