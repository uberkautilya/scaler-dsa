package low_level_design_two.design_pattterns.creational.factory.assignments.four;

import low_level_design_two.design_pattterns.creational.factory.assignments.four.parser.DocumentParser;
import low_level_design_two.design_pattterns.creational.factory.assignments.four.parser.SpreadsheetDocumentParser;
import low_level_design_two.design_pattterns.creational.factory.assignments.four.printer.DocumentPrinter;
import low_level_design_two.design_pattterns.creational.factory.assignments.four.printer.SpreadsheetDocumentPrinter;
import low_level_design_two.design_pattterns.creational.factory.assignments.four.processor.DocumentProcessor;
import low_level_design_two.design_pattterns.creational.factory.assignments.four.processor.SpreadsheetDocumentProcessor;

public class SpreadsheetDocumentFactory extends DocumentFactory {
    @Override
    public DocumentType supportsType() {
        return DocumentType.SPREAD_SHEET;
    }

    public DocumentParser createParser(String path){
        return new SpreadsheetDocumentParser(path);
    }
    public DocumentPrinter createPrinter(DocumentProcessor processor){
        return new SpreadsheetDocumentPrinter(processor);
    }
    public DocumentProcessor createProcessor(String documentName){
        return new SpreadsheetDocumentProcessor(documentName);
    }
}