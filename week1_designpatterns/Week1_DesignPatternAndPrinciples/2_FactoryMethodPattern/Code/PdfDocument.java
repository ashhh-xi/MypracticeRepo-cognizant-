/**
 * Concrete PdfDocument class
 * Extends Document and implements specific PDF document functionality
 */
public class PdfDocument extends Document {
    
    public PdfDocument(String name) {
        super(name);
    }
    
    @Override
    public String getDocumentType() {
        return "PDF Document (.pdf)";
    }
    
    /**
     * PDF-specific method for setting page size
     */
    public void setPageSize(String size) {
        System.out.println("Setting page size to " + size + " for PDF: " + name);
    }
    
    /**
     * PDF-specific method for adding bookmarks
     */
    public void addBookmark(String bookmarkName) {
        System.out.println("Adding bookmark '" + bookmarkName + "' to PDF: " + name);
    }
    
    /**
     * PDF-specific method for setting security
     */
    public void setSecurity(boolean passwordProtected) {
        if (passwordProtected) {
            System.out.println("Setting password protection for PDF: " + name);
        } else {
            System.out.println("Removing password protection from PDF: " + name);
        }
    }
    
    @Override
    public void save() {
        System.out.println("Saving PDF document as .pdf: " + name);
    }
} 