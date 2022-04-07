package by.yukhnevich.compositechain.parser;

import by.yukhnevich.compositechain.entity.ComplexTextComponent;
import by.yukhnevich.compositechain.entity.SimpleTextComponent;
import by.yukhnevich.compositechain.entity.TextComponent;
import by.yukhnevich.compositechain.entity.TextComponentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordParser extends AbstractParserHandler {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void handleParse(TextComponent component, String strToParse) {
        ComplexTextComponent word = (ComplexTextComponent) component;

        logger.debug("Start parsing word");
        for (char symbol : strToParse.toCharArray()) {
            word.addComponent(new SimpleTextComponent(TextComponentType.SYMBOL, Character.toString(symbol)));
        }
        logger.debug("Finished parsing word");
    }
}
