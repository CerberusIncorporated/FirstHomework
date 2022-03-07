package by.yukhnevich.xmltask.factory;

import by.yukhnevich.xmltask.creator.GemType;
import by.yukhnevich.xmltask.entity.Gem;
import by.yukhnevich.xmltask.entity.PreciousGem;
import by.yukhnevich.xmltask.entity.SemiPreciousGem;

public class GemFactory {
    private GemFactory() {
    }

    public static Gem createGem(GemType type) {
        switch (type) {

            case PRECIOUS -> {
                return new PreciousGem();
            }
            case SEMI_PRECIOUS -> {
                return new SemiPreciousGem();
            }
            default -> throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }

    public static Gem createGem(String typeName) {
        GemType type = GemType.typeValueOf(typeName);
        switch (type) {

            case PRECIOUS -> {
                return new PreciousGem();
            }
            case SEMI_PRECIOUS -> {
                return new SemiPreciousGem();
            }
            default -> throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }

}
