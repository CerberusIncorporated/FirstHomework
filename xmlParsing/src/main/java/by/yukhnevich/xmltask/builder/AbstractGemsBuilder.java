package by.yukhnevich.xmltask.builder;

import by.yukhnevich.xmltask.entity.Gem;
import by.yukhnevich.xmltask.exception.GemException;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractGemsBuilder {
    protected Set<Gem> gems;

    public AbstractGemsBuilder(){
        gems = new HashSet<>();
    }

    public AbstractGemsBuilder(Set<Gem> gems){
        this.gems = gems;
    }

    public Set<Gem> getGems() {
        return gems;
    }

    public abstract void buildSetGems(String filename) throws GemException;
}
