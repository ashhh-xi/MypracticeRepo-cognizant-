/**
 * Concrete WordDocument class
 * Extends Document and implements specific Word document functionality
 */
public class WordDocument extends Document {
    
    public WordDocument(String name) {
        super(name);
    }
    
    @Override
    public String getDocumentType() {
        return "Word Document (.docx)";
    }
    
    /**
     * Word-specific method for formatting
     */
    public void formatText() {
        System.out.println("Formatting text in Word document: " + name);
    }
    
    /**
     * Word-specific method for adding tables
     */
    public void addTable() {
        System.out.println("Adding table to Word document: " + name);
    }
    
    @Override
    public void save() {
        System.out.println("Saving Word document as .docx: " + name);
    }
} 