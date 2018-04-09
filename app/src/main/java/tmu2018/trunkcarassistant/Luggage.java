package tmu2018.trunkcarassistant;

import java.io.Serializable;

/**
 * Created by Marcin on 13.03.2018.
 */

public class Luggage implements Serializable {

    public Luggage(String name,float width,float length,float height,boolean usercreated)
    {
        this.name=name;
        this.width=width;
        this.length=length;
        this.height=height;
        this.usercreated=usercreated;
        this.isActive = true;
        this.isNew = true;
        this.isPicked = false;
    }

    public Luggage()
    {}

    private String name;
    private float width;
    private float length;
    private float height;
    private boolean usercreated;
    private boolean isPicked;


    //Variables to draw luggages
    private float heightScale,widthScale,lengthScale;
    private boolean isActive = false;
    private boolean isNew = false;
    private float refHeight,refWidth,refLength;



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

    //Methods to draw luggages
    public float getHeightScale() {
        return heightScale;
    }

    public void setHeightScale(float heightScale) {
        this.heightScale = heightScale;
    }

    public float getWidthScale() {
        return widthScale;
    }

    public void setWidthScale(float widthScale) {
        this.widthScale = widthScale;
    }

    public float getLengthScale() {
        return lengthScale;
    }

    public void setLengthScale(float lengthScale) {
        this.lengthScale = lengthScale;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public float getRefHeight() {
        return refHeight;
    }

    public void setRefHeight(float refHeight) {
        this.refHeight = refHeight;
    }

    public float getRefWidth() {
        return refWidth;
    }

    public void setRefWidth(float refWeight) {
        this.refWidth = refWeight;
    }

    public float getRefLength() {
        return refLength;
    }

    public void setRefLength(float refLength) {
        this.refLength = refLength;
    }

    public void setPicked(boolean set) {
        isPicked = set;
    }

    public boolean isPicked() {
        return isPicked;
    }

    public void info()
    {
        //System.out.println("refH: "+refHeight+"_refW: "+refWidth+"_refD: "+refLength);
        System.out.println("refH: "+height+"_refW: "+width+"_refD: "+length);
    }

}
