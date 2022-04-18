package co.edu.escuelaing;

import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        port(getport());
        get("/feed", (request,response) -> "Aqui va el feed");
        System.out.println( "Hello World!" );
    }

    private static int getport(){
        if (System.getenv("PORT") != null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4568;
    }
}
