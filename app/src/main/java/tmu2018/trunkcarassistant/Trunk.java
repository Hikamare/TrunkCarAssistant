package tmu2018.trunkcarassistant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 13.03.2018.
 */

public class Trunk implements Serializable {

    public Trunk(String name,float width,float length,float height,boolean usercreated)
    {
        this.name=name;
        this.width=width;
        this.length=length;
        this.height=height;
        this.usercreated=usercreated;
        this.isAcvite = true;
    }

    public Trunk()
    { this.name = ""; }

    private String name;
    private float width;
    private float length;
    private float height;
    private boolean usercreated;

    //Variables to draw Trunk
    private float heightScale,widthScale,lengthScale;
    private boolean isAcvite = false;
    private boolean isP = false;
    //private Luggage[] luggages;// <- We use array for luggages
    private List<Luggage> luggages = new ArrayList<Luggage>(); // We use List for luggages


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

    //Methods to draw trunk:

    public boolean isP() {
        return isP;
    }

    public boolean isAcvite() {
        return isAcvite;
    }


    // This method scale all luggages
    public void scaleLuggages(float h, float w, float l)
    {
        for(int i=0;i<luggages.size();i++)
        {
            heightScale =h;
            widthScale = w;
            lengthScale = l;

            luggages.get(i).setHeightScale(luggages.get(i).getHeight() * heightScale/height);
            luggages.get(i).setWidthScale(luggages.get(i).getWidth() * widthScale /width);
            luggages.get(i).setLengthScale(luggages.get(i).getLength() * lengthScale /length);
        }
    }



    //This method add luggages to trunk ( form list)
        public void addLuggages(List<Luggage> lg)
    {
        luggages.clear();
        for(int i=0;i<lg.size();i++)
        {
            luggages.add(i,lg.get(i));
        }
        isP = true;
    }

    //This method add one luggage to trunk
    public void addLuggage(Luggage lg)
    {
        luggages.add(lg);
        isP = true;
    }

    public void isntNew()
    {
        for(int i=0;i<luggages.size();i++)
        {
            luggages.get(i).setNew(false);
        }
    }

    //This method return luggage from trunk
    public Luggage getLuggage(int i) {
        return luggages.get(i);
    }

    //This method return size luggages
    public int howLuggages()
    {
        return luggages.size();
    }

    //This method return info about luggages
    public void info(){
        for(int i =0;i<luggages.size();i++)
            luggages.get(i).info();
    }
}