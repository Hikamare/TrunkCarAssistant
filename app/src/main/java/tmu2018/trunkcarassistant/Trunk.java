package tmu2018.trunkcarassistant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 13.03.2018.
 */

public class Trunk {

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
    {}

    private String name;
    private float width;
    private float length;
    private float height;
    private boolean usercreated;

    //Variables to draw Trunk
    private float heightScale,widthScale,lengthScale;
    private boolean isAcvite = false;
    private boolean isntP = false;
    private Luggage[] luggages;// <- We use array for luggages
    //private List<Luggage> luggages = new ArrayList<Luggage>(); // We use List for luggages



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

    public boolean isIsntP() {
        return isntP;
    }

    public boolean isAcvite() {
        return isAcvite;
    }

    //Methods for array

    public void isntNew()
    {
        for(int i=0;i<luggages.length;i++)
        {
            luggages[i].setNew(false);
        }
    }

    // This method scale all luggages
    public void scaleLuggages(float h, float w, float l)
    {


        for(int i=0;i<luggages.length;i++)
        {
            if(luggages[i].isNew() == true)
            {
                heightScale = h;
                widthScale = w;
                lengthScale = l;
                luggages[i].setHeightScale(luggages[i].getHeight() * heightScale / height);

                System.out.println("szerokosc: "+luggages[i].getWidth()+"szerokosc bagaznika w skali: "+widthScale+ "szerokosc bagaznika"+ width);
                float a = luggages[i].getWidth() * widthScale / width;
                luggages[i].setWidthScale(luggages[i].getWidth() * widthScale / width);
                System.out.println(a+ " ZAL!");
                luggages[i].setLengthScale(luggages[i].getLength() * lengthScale / length);
            }
        }

    }

    //This method add luggage to trunk ( form array)
    public void addLuggages(Luggage[] lg)
    {
        luggages = new Luggage[lg.length];
        for(int i=0;i<lg.length;i++)
        {
            luggages[i] = new Luggage();
            luggages[i] = lg[i];
        }
        isntP = true;
    }
    //This method return luggage form trunk. i -> index in array
    public Luggage getLuggage(int i) {
        return luggages[i];
    }

    //This method return "How many luggages is in array?"
    public int howLuggages()
    {
        return luggages.length;
    }

    //This method return info about all luggages, but this info is write in Logcat
    public void info(){
        for(int i =0;i<luggages.length;i++)
            luggages[i].info();
    }

    //Metods for List

    /*
    // This method scale all luggages
    public void scaleBaggage(float h, float w, float l)
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
        for(int i=0;i<lg.size();i++)
        {
            luggages.add(i,lg.get(i));
        }
    }

    //This method add one luggage to trunk
    public void addLuggage(Luggage lg)
    {
        luggages.add(lg);
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
    //This method return "How many luggages is in list?"

    public int howLuggages()
    {
        return luggages.size();
    }
    */
}