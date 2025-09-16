import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public class UsuarioOperations {

    public static void incluir(MongoDBConnection connection) {

        try {

            System.out.println("Incluir dados");
            MongoCollection<Document> collection = connection.getDatabase().getCollection("usuario");

            Usuario usr = new Usuario("Alice", 25);
            System.out.println("Incluir dados Alice");
            collection.insertOne(usr.toDocument());

            Usuario usr1 = new Usuario("Bob", 30);
            System.out.println("Incluir dados Bob");
            collection.insertOne(usr1.toDocument());

            Usuario usr2 = new Usuario("Charlie", 35);
            System.out.println("Incluir dados Charlie");
            collection.insertOne(usr2.toDocument());

        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
            System.out.println("Erro " + e.getCause());
        }

    }

    public static void consultar(MongoDBConnection connection) {

        MongoCollection<Document> collection = connection.getDatabase().getCollection("usuario");
        System.out.println("Consultar dados");
        for (Document doc : collection.find()) {
            System.out.println(doc.toJson());
        }

        // return null;
    }

    public static void alterar(MongoDBConnection connection) {

        Bson filter = Filters.eq("nome", "Bob");
        Bson update = Updates.set("idade", "32");
        connection.getDatabase().getCollection("usuario").updateOne(filter, update);
    }

    public static void excluir(MongoDBConnection connection) {

            Document filterOne = new Document("nome", "Charlie"); // Substitua "nome" e "Exemplo" pelos seus critérios
            connection.getDatabase().getCollection("usuario").deleteOne(filterOne);

    }

}
