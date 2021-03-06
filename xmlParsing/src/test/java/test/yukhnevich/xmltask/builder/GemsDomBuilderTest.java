package test.yukhnevich.xmltask.builder;

import by.yukhnevich.xmltask.builder.AbstractGemsBuilder;
import by.yukhnevich.xmltask.creator.GemsBuilderFactory;
import by.yukhnevich.xmltask.creator.ParserType;
import by.yukhnevich.xmltask.entity.*;
import by.yukhnevich.xmltask.exception.GemException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.YearMonth;
import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class GemsDomBuilderTest {

    private static final String GEM_XML_FIE = "data/gem_2.xml";

    private Set<Gem> expected;

    @BeforeClass
    public void setUp() {

        expected = new HashSet<>();

        expected.add(new PreciousGem("A-000002",
                "Esmeralda",
                GemOrigin.NORTH_AMERICA,
                YearMonth.parse("2022-02"),
                "green",
                90,
                8,
                12.2,
                PreciousType.EMERALD));
        expected.add(new SemiPreciousGem("B-000001",
                "Quartz",
                GemOrigin.ASIA,
                YearMonth.parse("2017-03"),
                "rose",
                45,
                19,
                23,
                ""));
        expected.add(new SemiPreciousGem("B-000003",
                null,
                GemOrigin.ASIA,
                YearMonth.parse("2017-03"),
                "rose",
                45,
                19,
                19,
                "jewelry"));
    }

    @Test
    public void testBuildSetGems() {
        AbstractGemsBuilder builder = null;
        try {
            builder = GemsBuilderFactory.createGemsBuilder(ParserType.DOM);
            ClassLoader loader = getClass().getClassLoader();
            URL resource = loader.getResource(GEM_XML_FIE);
            builder.buildSetGems(resource.getFile());
        } catch (GemException e) {
            fail(e.getMessage(), e);
        }

        Set<Gem> actual = builder.getGems();

        assertEquals(actual, expected);
    }
}