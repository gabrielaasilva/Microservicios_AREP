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
