package edu.escuealing.arep.service;

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

    public void agregar(String contenido){
        Document test = new Document("_id", UUID.randomUUID().toString())
                .append("contenido",contenido)
                .append("fecha",String.valueOf(new Date()));
        feedCollection.insertOne(test);
    }
}
