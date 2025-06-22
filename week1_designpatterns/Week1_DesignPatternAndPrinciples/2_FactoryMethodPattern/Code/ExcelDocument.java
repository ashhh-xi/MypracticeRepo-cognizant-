/**
 * Concrete ExcelDocument class
 * Extends Document and implements specific Excel document functionality
 */
public class ExcelDocument extends Document {
    
    public ExcelDocument(String name) {
        super(name);
    }
    
    @Override
    public String getDocumentType() {
        return "Excel Document (.xlsx)";
    }
    
    /**
     * Excel-specific method for adding worksheet
     */
    public void addWorksheet(String sheetName) {
        System.out.println("Adding worksheet '" + sheetName + "' to Excel: " + name);
    }
    
    /**
     * Excel-specific method for creating charts
     */
    public void createChart(String chartType) {
        System.out.println("Creating " + chartType + " chart in Excel: " + name);
    }
    
    /**
     * Excel-specific method for applying formulas
     */
    public void applyFormula(String cell, String formula) {
        System.out.println("Applying formula '" + formula + "' to cell " + cell + " in Excel: " + name);
    }
    
    /**
     * Excel-specific method for setting cell value
     */
    public void setCellValue(String cell, String value) {
        System.out.println("Setting cell " + cell + " to '" + value + "' in Excel: " + name);
    }
    
    @Override
    public void save() {
        System.out.println("Saving Excel document as .xlsx: " + name);
    }
} 