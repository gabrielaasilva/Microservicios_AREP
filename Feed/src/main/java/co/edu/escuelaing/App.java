package co.edu.escuelaing;

import co.edu.escuelaing.Service.MongoDB;

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
        port(getport());
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

        path("/feed", () -> {
            get("/20", (request,response) -> {
                response.type("application/json");

                return mongoDB.getLast20Post();
            });
        });
        get("/hello", (request,response) -> "Aquí va el feed");
    }

    private static int getport(){
        if (System.getenv("PORT") != null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4568;
    }
}
