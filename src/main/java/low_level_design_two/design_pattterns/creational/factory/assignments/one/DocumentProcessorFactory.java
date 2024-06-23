package low_level_design_two.design_pattterns.creational.factory.assignments.one;

public class DocumentProcessorFactory {

    public static DocumentProcessor getDocumentProcessor(DocumentType docType, String documentName){
        if(docType == DocumentType.PRESENTATION){
            return new PresentationDocumentProcessor(documentName);
        } else if(docType == DocumentType.TEXT){
            return new TextDocumentProcessor(documentName);
        }else {
            return new SpreadsheetDocumentProcessor(documentName);
        }
    }
}