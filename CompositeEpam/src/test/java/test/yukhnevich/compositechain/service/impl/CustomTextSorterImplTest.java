package test.yukhnevich.compositechain.service.impl;

import by.yukhnevich.compositechain.entity.ComplexTextComponent;
import by.yukhnevich.compositechain.entity.TextComponent;
import by.yukhnevich.compositechain.entity.TextComponentType;
import by.yukhnevich.compositechain.exception.CustomTextException;
import by.yukhnevich.compositechain.parser.TextParser;
import by.yukhnevich.compositechain.reader.TextReader;
import by.yukhnevich.compositechain.reader.impl.TextReaderImpl;
import by.yukhnevich.compositechain.service.CustomTextSorter;
import by.yukhnevich.compositechain.service.impl.CustomTextSorterImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class CustomTextSorterImplTest {

    private static final String TEXT_PATH = "testtexts/service_1.txt";
    private ComplexTextComponent defaultText;

    private CustomTextSorter sorter;

    @BeforeClass
    public void setUp() {

        sorter = new CustomTextSorterImpl();

        TextParser parser = new TextParser();
        TextReader reader = new TextReaderImpl();

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            URL resource = classLoader.getResource(TEXT_PATH);
            File file = new File(resource.toURI());
            String textStr = reader.readTextFromFile(file.getAbsolutePath());

            defaultText = new ComplexTextComponent(TextComponentType.TEXT);
            parser.handleParse(defaultText, textStr);
        } catch (URISyntaxException | CustomTextException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testSort() {
        List<TextComponent> expected = List.of(
                defaultText.getComponents().get(2),
                defaultText.getComponents().get(0),
                defaultText.getComponents().get(1),
                defaultText.getComponents().get(3));

        try {
            sorter.sort(defaultText);
            List<TextComponent> actual = defaultText.getComponents();

            assertEquals(actual, expected);
        } catch (CustomTextException e) {
            fail(e.getMessage());
        }
    }
}
