package tmu2018.trunkcarassistant;

/**
 * Created by Marcin on 13.03.2018.
 */

public class Luggage {

    public Luggage(String name,float width,float length,float height,boolean usercreated)
    {
        this.name=name;
        this.width=width;
        this.length=length;
        this.height=height;
        this.usercreated=usercreated;
    }

    public Luggage()
    {}

    private String name;
    private float width;
    private float length;
    private float height;
    private boolean usercreated;

    public String getName() {
        return name;
    }

    public float getWidth() {
        return width;
    }

    public float getLength() {
        return length;
    }

    public float getHeight() {
        return height;
    }

    public boolean isUsercreated() {
        return usercreated;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setUsercreated(boolean usercreated) {
        this.usercreated = usercreated;
    }
}
