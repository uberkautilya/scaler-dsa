package low_level_design_two.design_pattterns.creational.factory.assignments.four.parser;

import low_level_design_two.design_pattterns.creational.factory.assignments.four.DocumentType;

public class TextDocumentParser extends DocumentParser {

    public TextDocumentParser(String path) {
        super(path);
    }

    public void parseDocument() {
        // Parse text document
    }

    @Override
    public DocumentType supportsType() {
        return DocumentType.TEXT;
    }
}