package by.yukhnevich.compositechain.parser;

import by.yukhnevich.compositechain.entity.ComplexTextComponent;
import by.yukhnevich.compositechain.entity.TextComponent;
import by.yukhnevich.compositechain.entity.TextComponentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextParser extends AbstractParserHandler {

    private static final Logger logger = LogManager.getLogger();

    private static final String PARAGRAPH_DELIMITER = "\\t";

    public TextParser() {
        super(new ParagraphParser());
    }

    @Override
    public void handleParse(TextComponent component, String strToParse) {

        ComplexTextComponent text = (ComplexTextComponent) component;
        ComplexTextComponent paragraph;

        logger.debug("Start parsing text");
        String[] paragraphStrs = strToParse.trim().split(PARAGRAPH_DELIMITER);

        for (String paragraphStr : paragraphStrs) {

            paragraph = new ComplexTextComponent(TextComponentType.PARAGRAPH);
            successor.handleParse(paragraph, paragraphStr.strip());
            text.addComponent(paragraph);
        }
        logger.debug("Finish parsing text");
    }
}
