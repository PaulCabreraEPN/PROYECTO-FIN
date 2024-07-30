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

         //actualizar
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("miBaseDeDatos");
            MongoCollection<Document> collection = database.getCollection("miColeccion");
            Document filtro = new Document("nombre", "Juan");
            DeleteResult resultado = collection.deleteOne(filtro);
            System.out.println("Documentos borrados: " + resultado.getDeletedCount());
        }

        **/

    }
}




