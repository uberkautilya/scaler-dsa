package low_level_design_two.design_pattterns.creational.factory.assignments.four;

import low_level_design_two.design_pattterns.creational.factory.assignments.four.parser.DocumentParser;
import low_level_design_two.design_pattterns.creational.factory.assignments.four.printer.DocumentPrinter;
import low_level_design_two.design_pattterns.creational.factory.assignments.four.processor.DocumentProcessor;


public abstract class DocumentFactory {
    public abstract DocumentType supportsType();
    public abstract DocumentParser createParser(String path);
    public abstract DocumentPrinter createPrinter(DocumentProcessor processor);
    public abstract DocumentProcessor createProcessor(String documentName);
}