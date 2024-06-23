package low_level_design_two.design_pattterns.creational.factory.assignments.four;

import low_level_design_two.design_pattterns.creational.factory.assignments.four.parser.DocumentParser;
import low_level_design_two.design_pattterns.creational.factory.assignments.four.parser.TextDocumentParser;
import low_level_design_two.design_pattterns.creational.factory.assignments.four.printer.DocumentPrinter;
import low_level_design_two.design_pattterns.creational.factory.assignments.four.printer.TextDocumentPrinter;
import low_level_design_two.design_pattterns.creational.factory.assignments.four.processor.DocumentProcessor;
import low_level_design_two.design_pattterns.creational.factory.assignments.four.processor.TextDocumentProcessor;

public class TextDocumentFactory extends DocumentFactory {
    public DocumentParser createParser(String path){
        return new TextDocumentParser(path);
    }

    @Override
    public DocumentType supportsType() {
        return DocumentType.TEXT;
    }

    public DocumentPrinter createPrinter(DocumentProcessor processor){
        return new TextDocumentPrinter(processor);
    }
    public DocumentProcessor createProcessor(String documentName){
        return new TextDocumentProcessor(documentName);
    }
}