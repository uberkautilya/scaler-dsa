package low_level_design_two.design_pattterns.creational.factory.assignments.four.printer;

import low_level_design_two.design_pattterns.creational.factory.assignments.four.DocumentType;
import low_level_design_two.design_pattterns.creational.factory.assignments.four.processor.DocumentProcessor;

public abstract class DocumentPrinter {

    private final DocumentProcessor processor;

    public DocumentPrinter(DocumentProcessor processor) {
        this.processor = processor;
    }

    public DocumentProcessor getProcessor() {
        return processor;
    }

    public abstract void printDocument();

    public abstract DocumentType supportsType();

}