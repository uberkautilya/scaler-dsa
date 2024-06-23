package low_level_design_two.design_pattterns.creational.factory.assignments.four.parser;

import low_level_design_two.design_pattterns.creational.factory.assignments.four.DocumentType;

public class SpreadsheetDocumentParser extends DocumentParser {

    public SpreadsheetDocumentParser(String path) {
        super(path);
    }

    public void parseDocument() {
        // Parse spreadsheet document
    }

    @Override
    public DocumentType supportsType() {
        return DocumentType.SPREAD_SHEET;
    }
}