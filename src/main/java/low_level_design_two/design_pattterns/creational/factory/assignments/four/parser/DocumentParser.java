package low_level_design_two.design_pattterns.creational.factory.assignments.four.parser;

import low_level_design_two.design_pattterns.creational.factory.assignments.four.DocumentType;

public abstract class DocumentParser {

    private final String path;

    public DocumentParser(String path) {
        this.path = path;
    }

    public abstract void parseDocument();

    public String getPath() {
        return path;
    }

    public abstract DocumentType supportsType();

}