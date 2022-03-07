package by.yukhnevich.xmltask.creator;

import by.yukhnevich.xmltask.builder.AbstractGemsBuilder;
import by.yukhnevich.xmltask.builder.GemsDomBuilder;
import by.yukhnevich.xmltask.builder.GemsSaxBuilder;
import by.yukhnevich.xmltask.builder.GemsStaxBuilder;
import by.yukhnevich.xmltask.exception.GemException;

public class GemsBuilderFactory {
    private GemsBuilderFactory(){};

    public static AbstractGemsBuilder createGemsBuilder(ParserType type) throws GemException {
        switch (type){

            case SAX -> {
                return new GemsSaxBuilder();
            }
            case STAX -> {
                return new GemsStaxBuilder();
            }
            case DOM -> {
                return new GemsDomBuilder();
            }
            default -> throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }
}
