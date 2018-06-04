package tmu2018.trunkcarassistant.database;

import java.io.IOException;
import java.util.List;

import tmu2018.trunkcarassistant.objects.Luggage;
import tmu2018.trunkcarassistant.objects.Trunk;

/**
 * Created by Marcin on 13.03.2018.
 * TODO: Add a database to handle cars (models and brands.
 */

public interface Database {

    //add new luggage to db, name must be unique, if not throws exc
    public void addLuggage(Luggage luggage) throws IllegalArgumentException;

    //read luggage with given name, throws exception if name does not exist
    public Luggage readLuggage(String name) throws IllegalArgumentException;

    //read all luggages, list is empty if there are none
    public List<Luggage> readAllLuggages();

    //update luggage, take name from oldLuggage and apply newLuggage to it(even change in name)
    public void updateLuggage(Luggage oldLuggage, Luggage newLuggage) throws IllegalArgumentException;

    //delete luggage(laggages if there are multiple, there should be none), with given name
    public void deleteLuggage(Luggage luggage);



    //add new trunk to db, name must be unique, if not throws exc
    public void addTrunk(Trunk trunk) throws IllegalArgumentException;

    //read luggage with given name, throws exception if name does not exist
    public Trunk readTrunk(String name) throws IllegalArgumentException;

    //read all trunks, list is empty if there are none
    public List<Trunk> readAllTrunks();

    //update trunk, take name from oldLuggage and apply newLuggage to it(even change in name),
    //throws exception if there is no oldluggage, or name from new luggage exist
    public void updateTrunk(Trunk oldTrunk,Trunk newTrunk) throws IllegalArgumentException;

    //delete trunk(trunks if there are multiple, there should be none), with given name
    public void deleteTrunk(Trunk trunk);

    //get all brands from db
    public List<String> readAllCarBrands() throws IOException;

    //get all models with given brand, returns empty if there is none
    public List<String> readAllModels(String brand) throws IOException;

}
