package tmu2018.trunkcarassistant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Created by Marcin on 06.04.2018.
 */

public class PackingAlgorithm {

    List<Luggage> luggage;
    int dimensionX,dimensionY,dimensionZ;
    List<Integer> dimensions;

    //boolean is whether it is possible according to algorithm to pack luggages into trunk
    //changes luggages inside given trunk
    public boolean PackIt(Trunk trunk)
    {
        System.out.println("packing..");

        luggage = trunk.getLuggages();
        dimensionX = (int) trunk.getLength();
        dimensionY = (int) trunk.getWidth();
        dimensionZ = (int) trunk.getHeight();
        dimensions = new ArrayList<>();
        dimensions.add(dimensionX);
        dimensions.add(dimensionY);
        dimensions.add(dimensionZ);
        Collections.sort(dimensions);


        if(luggage.isEmpty())
        {
            System.out.println("Exception? There is no luggage");
            return false;
        }

        //every luggage is unified
        //height is longest dimension
        //width is medium dimension
        //length is shortest dimension
        for(Luggage lug : luggage)
        {
            List<Integer> values = new ArrayList<>();
            values.add((int)lug.getWidth());
            values.add((int)lug.getLength());
            values.add((int)lug.getHeight());
            Collections.sort(values);
            lug.setHeight(values.get(2));
            lug.setWidth(values.get(1));
            lug.setLength(values.get(0));
        }

        //sort in descending order of biggest dimension
        Collections.sort(luggage, new Comparator<Luggage>() {
            @Override
            public int compare(Luggage o1, Luggage o2) {

                if(Math.abs(o1.getHeight()-o2.getHeight())<0.0001) {
                    if(Math.abs(o1.getWidth()-o2.getWidth())<0.0001)
                        return (int) (o1.getLength()-o2.getLength());
                    return (int) (o1.getWidth()-o2.getWidth());
                }
                return (int) (o1.getHeight() - o2.getHeight());
            }
        });
        Collections.reverse(luggage);

        //debug purposes
        for(Luggage lug : luggage)
        {
            System.out.print(lug.getHeight()+" "+lug.getWidth()+" "+lug.getLength()+" ");
            System.out.println(lug.getName());
        }

        //check if largest luggage fit into trunk
        if(luggage.get(0).getHeight() > dimensions.get(2) ||
                luggage.get(0).getWidth() > dimensions.get(1) ||
                luggage.get(0).getLength() > dimensions.get(0)
                )
        {
            System.out.println("Exception? Luggage is bigger than trunk");
            return false;
        }

        //early attempt to algorithm
        if(LineAllign() == true) {

            //debug onl
            System.out.println("Coordinates for print");
            for(Luggage lug : luggage) {
                System.out.print(" X: "+lug.getRefLength());
                System.out.print(" Y: "+lug.getRefWidth());
                System.out.print(" Z: "+lug.getRefHeight());
                System.out.println("");
            }

            return true;
        }



        //no attempts were successful
        return false;
    }

    private void PurgeLuggageRef()
    {
        for(Luggage lug : luggage)
        {
            lug.setRefHeight(0);
            lug.setRefWidth(0);
            lug.setRefLength(0);
        }
    }

    private boolean LineAllign()
    {
        int x=0,y=0,z=0;

        for(Luggage lug : luggage)
        {
            if(lug.getHeight() > dimensionZ || lug.getLength() > dimensionX || lug.getWidth() > dimensionY - y)
                return false;

            lug.setRefHeight(z);
            lug.setRefWidth(y);
            lug.setRefLength(x);
            y += lug.getWidth();

        }

        return true;
    }









}
