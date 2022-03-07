package by.yukhnevich.xmltask.entity;

import java.time.YearMonth;

public class SemiPreciousGem extends Gem {
    private String implementation;

    public SemiPreciousGem() {
        implementation = "";
    }

    public SemiPreciousGem(String id,
                           String name,
                           GemOrigin origin,
                           YearMonth extractionTime,
                           String color,
                           int transparency,
                           int facets,
                           double mass,
                           String implementation) {
        super(id, name, origin, extractionTime, color, transparency, facets, mass);
        this.implementation = (implementation == null ? "" : implementation);
    }

    public String getImplementation() {
        return implementation;
    }

    public void setImplementation(String implementation) {
        this.implementation = (implementation == null ? "" : implementation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SemiPreciousGem that = (SemiPreciousGem) o;

        return implementation != null ? implementation.equals(that.implementation) : that.implementation == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (implementation != null ? implementation.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SemiPreciousGem{");
        sb.append("id='").append(getId()).append('\'');
        sb.append(", name='").append(getName()).append('\'');
        sb.append(", origin=").append(getOrigin());
        sb.append(", extractionTime=").append(getExtractionTime());
        sb.append(", color='").append(getColor()).append('\'');
        sb.append(", transparency=").append(getTransparency());
        sb.append(", facets=").append(getFacets());
        sb.append(", mass=").append(getMass());
        sb.append(", implementation='").append(implementation).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
