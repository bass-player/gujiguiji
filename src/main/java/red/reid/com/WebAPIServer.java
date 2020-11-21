package red.reid.com;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static spark.Spark.*;

public class WebAPIServer {

    private static final Logger logger = LogManager.getLogger(WebAPIServer.class.getName());

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public WebAPIServer() {
        port(10001);
        logger.info("Service started");
    }

    public void buildRoutes() {

        before("/*", (q, a) -> logger.info("Received api call"));

        get("/hello", (q, a) -> "Hello World");

        get("/hello/:name", (q, a) -> {
            return "Hello:" + q.params("name");
        });

        get("/user/:id", (q, a) -> {

            String id = q.params("id");
            String query = q.queryParams("query");

            a.type("application/json");
            return gson.toJson(ImmutableMap.of("id", id, "query", query, "port", port()));

        });
    }

    public static void main(String[] args) {

        new WebAPIServer().buildRoutes();
    }
}
