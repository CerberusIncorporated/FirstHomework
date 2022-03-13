package by.yukhnevich.xmltask.entity;

import java.time.YearMonth;

public abstract class Gem {
    public static final String NAME_DEFAULT = "Gem stone";

    private String id;
    private String name;
    private GemOrigin origin;
    private YearMonth extractionTime;
    private String color;
    private int transparency;
    private int facets;
    private double mass;

    public Gem() {
        name = NAME_DEFAULT;
    }

    public Gem(String id,
               String name,
               GemOrigin origin,
               YearMonth extractionTime,
               String color,
               int transparency,
               int facets,
               double mass) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.extractionTime = extractionTime;
        this.color = color;
        this.transparency = transparency;
        this.facets = facets;
        this.mass = mass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GemOrigin getOrigin() {
        return origin;
    }

    public void setOrigin(GemOrigin origin) {
        this.origin = origin;
    }

    public YearMonth getExtractionTime() {
        return extractionTime;
    }

    public void setExtractionTime(YearMonth extractionTime) {
        this.extractionTime = extractionTime;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTransparency() {
        return transparency;
    }

    public void setTransparency(int transparency) {
        this.transparency = transparency;
    }

    public int getFacets() {
        return facets;
    }

    public void setFacets(int facets) {
        this.facets = facets;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gem gem = (Gem) o;

        if (transparency != gem.transparency) return false;
        if (facets != gem.facets) return false;
        if (Double.compare(gem.mass, mass) != 0) return false;
        if (id != null ? !id.equals(gem.id) : gem.id != null) return false;
        if (name != null ? !name.equals(gem.name) : gem.name != null) return false;
        if (origin != gem.origin) return false;
        if (extractionTime != null ? !extractionTime.equals(gem.extractionTime) : gem.extractionTime != null)
            return false;
        return color != null ? color.equals(gem.color) : gem.color == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        result = 31 * result + (extractionTime != null ? extractionTime.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + transparency;
        result = 31 * result + facets;
        temp = Double.doubleToLongBits(mass);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Gem{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", origin=").append(origin);
        sb.append(", extractionTime=").append(extractionTime);
        sb.append(", color='").append(color).append('\'');
        sb.append(", transparency=").append(transparency);
        sb.append(", facets=").append(facets);
        sb.append(", mass=").append(mass);
        sb.append('}');
        return sb.toString();
    }
}
