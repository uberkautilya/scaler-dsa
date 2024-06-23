package low_level_design_two.design_pattterns.creational.factory.assignments.one;

public class TextDocumentProcessor extends DocumentProcessor {

    public TextDocumentProcessor(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentName() {
        return documentName;
    }

    public DocumentType supportsType() {
        return DocumentType.TEXT;
    }

    @Override
    public void processDocument() {
        // Implement text document processing logic
        System.out.println("Processing a text document: " + getDocumentName());
        // Additional logic for text document processing
    }
}