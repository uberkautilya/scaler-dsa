package low_level_design_two.design_pattterns.creational.factory.assignments.four.printer;

import low_level_design_two.design_pattterns.creational.factory.assignments.four.DocumentType;
import low_level_design_two.design_pattterns.creational.factory.assignments.four.processor.DocumentProcessor;

public class TextDocumentPrinter extends DocumentPrinter {

    public TextDocumentPrinter(DocumentProcessor processor) {
        super(processor);
    }

    public void printDocument() {
        // Print text document
    }

    @Override
    public DocumentType supportsType() {
        return DocumentType.TEXT;
    }
}