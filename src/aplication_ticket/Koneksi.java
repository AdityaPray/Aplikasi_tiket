package aplication_ticket;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import javax.swing.JOptionPane;


public class Koneksi {

    private static MongoClient mongoClient;
    private static MongoDatabase database;

    public static MongoDatabase getKoneksi() {
        if (mongoClient == null) {
            try {
                // Koneksi ke MongoDB (default: localhost:27017)
                mongoClient = MongoClients.create("mongodb://localhost:27017");
                
                // Pilih database: kereta_api
                database = mongoClient.getDatabase("Kereta_Api");
                
                System.out.println("Koneksi MongoDB Berhasil");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Koneksi MongoDB Gagal: " + ex.getMessage());
                System.out.println("Koneksi MongoDB Gagal: " + ex.getMessage());
            }
        }
        return database;
    }
    public static void main(String[] args) {
    MongoDatabase db = getKoneksi();
    if (db != null) {
        System.out.println("Terkoneksi ke database: " + db.getName());
    }
}

}

