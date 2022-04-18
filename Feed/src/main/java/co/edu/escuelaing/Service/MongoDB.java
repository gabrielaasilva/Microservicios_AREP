package co.edu.escuelaing.Service;

import com.mongodb.client.*;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.*;

public class MongoDB {
    //Sabemos que esto no se debe hacer, pero es con fines académicos xd
    MongoClient client = MongoClients.create("mongodb+srv://JuankAREP:AREP0323@cluster0.9cn0l.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
    MongoDatabase database = client.getDatabase("ECI-Twitter");
    MongoCollection<Document> feedCollection = database.getCollection("feed");

    public List<String> getLast20Post(){
        List<String> feedList = new ArrayList<>();

        Bson projectionFields = Projections.fields(
                Projections.include("contenido","fecha"),
                Projections.excludeId());

        MongoCursor<Document> cursor = feedCollection.find().projection(projectionFields).sort(Sorts.descending("fecha")).limit(-20).iterator();

        try {
            while (cursor.hasNext()){
                feedList.add(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }

        //System.out.println(feedList);
        return feedList;
    }
}
