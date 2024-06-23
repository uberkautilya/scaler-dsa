package low_level_design_two.design_pattterns.creational.factory.assignments.four.processor;

import low_level_design_two.design_pattterns.creational.factory.assignments.four.DocumentType;

public abstract class DocumentProcessor {
    private String documentName;

    public DocumentProcessor(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentName() {
        return documentName;
    }

    public abstract void processDocument();

    public abstract DocumentType supportsType();

}