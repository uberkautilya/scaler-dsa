package low_level_design_two.design_pattterns.creational.factory.assignments.one;

public abstract class DocumentProcessor {
    protected String documentName;
    public abstract DocumentType supportsType();

    public static DocumentProcessor getDocumentProcessor(DocumentType docType, String documentName){
        return DocumentProcessorFactory.getDocumentProcessor(docType, documentName);
    }
    public abstract void processDocument();
}