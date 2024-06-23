package low_level_design_two.design_pattterns.creational.factory.assignments.one;

public class PresentationDocumentProcessor extends DocumentProcessor {

    public PresentationDocumentProcessor(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentName() {
        return documentName;
    }

    public DocumentType supportsType() {
        return DocumentType.PRESENTATION;
    }

    @Override
    public void processDocument() {
        // Implement presentation document processing logic
        System.out.println("Processing a presentation document: " + getDocumentName());
        // Additional logic for presentation document processing
    }

    public void addSlide() {
        System.out.println("Adding a slide to the presentation.");
    }
}