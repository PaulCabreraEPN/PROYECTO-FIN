package org.example;

import javax.swing.*;

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