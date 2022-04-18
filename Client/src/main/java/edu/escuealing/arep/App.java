package edu.escuealing.arep;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import edu.escuealing.arep.model.Post;
import edu.escuealing.arep.service.MongoDB;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App
{
    static MongoDB mongoDB = new MongoDB();
    public static void main( String[] args )
    {
        port(getPort());
        staticFileLocation("/");

        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        get("/", (req, res) -> {
            res.redirect("post.html");
            res.status(200);
            return null;
        });

        post("/post", (req, res) -> {
            res.type("application/json");
            Post post = (new Gson()).fromJson(req.body(), Post.class);
            System.out.println(post.getPost());

            if (post.getPost() != null) {
                mongoDB.agregar(post.getPost());
            }

            return validatePost(post);
        });

        get("/hello", (req, res) -> "Hello World");
    }

    private static JsonObject validatePost(Post post){
        String r1 = "";
        String r2 = "";
        JsonObject res = new JsonObject();
        if (r1.equals(r2)) {
            res.addProperty("status",202);
            res.addProperty("result", "OK");
            res.addProperty("server", "Se posteo correctamente");
            System.out.println(res.toString());
            return res;
        }

        res.addProperty("status",406);
        res.addProperty("result", "Not Acceptable");
        res.addProperty("server", "No se logro hacer el post");
        System.out.println(res.toString());
        return res;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4569;
    }
}
