package org.example;

import javax.swing.*;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.result.DeleteResult;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setContentPane( new Login().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);


        /*
        String connectionString = "mongodb+srv://cabrerasebastian2904:27326460pOl@cluster0.ootv4pb.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
        //insertar
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("CinePoli");
            MongoCollection<Document> collection = database.getCollection("miColeccion");
            Document documento = new Document("nombre", "Pedro")
                    .append("apellido", "Perez")
                    .append("edad", 25);
            collection.insertOne(documento);
            System.out.println("Documento insertado con éxito");
        }*/

    }
}