package edu.escuelaing.arep;

import static spark.Spark.get;
import static spark.Spark.*;

public class App 
{
    public static void main( String[] args )
    {
        port(getPort());

        staticFileLocation("/");

        get("/", (req, res) -> {
            res.redirect("/index.html");
            res.status(200);
            return null;
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
