package low_level_design_two.design_pattterns.creational.factory.assignments.one;

public class SpreadsheetDocumentProcessor extends DocumentProcessor{

    public SpreadsheetDocumentProcessor(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentName() {
        return documentName;
    }

    public DocumentType supportsType() {
        return DocumentType.SPREAD_SHEET;
    }

    @Override
    public void processDocument() {
        // Implement spreadsheet document processing logic
        System.out.println("Processing a spreadsheet document: " + getDocumentName());
        // Additional logic for spreadsheet document processing
    }

    public void performDataAnalysis() {
        System.out.println("Performing data analysis on the spreadsheet.");
    }
}