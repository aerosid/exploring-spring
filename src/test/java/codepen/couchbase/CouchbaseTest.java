package codepen.couchbase;

import com.couchbase.client.core.env.LoggerConfig;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.ClusterOptions;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.env.ClusterEnvironment;
import com.couchbase.client.java.json.JsonObject;
import com.couchbase.client.java.kv.ExistsResult;
import com.couchbase.client.java.kv.GetResult;
import com.couchbase.client.java.query.QueryResult;
import java.util.logging.Level;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;

public class CouchbaseTest {

  private static Bucket bucket;

  private static Cluster cluster;

  private static Collection collection;

  private static JsonObject doc;

  private static ClusterOptions options;

  private static ClusterEnvironment environment;

  private static String host = "localhost";

  private static String key = "key::101";

  private static String user = "Administrator";

  private static String password = "password";

  public CouchbaseTest() {
    super();
  }

  //@AfterAll
  public static void afterAll() throws Throwable {
    delete();
    cluster.disconnect();
    cluster.close();
    environment.shutdown();
    return;
  }

  //@BeforeAll
  public static void beforeAll() throws Throwable {
    environment = ClusterEnvironment
        .builder()
        .loggerConfig(LoggerConfig
            .fallbackToConsole(true)
            .disableSlf4J(true)
            .consoleLogLevel(Level.SEVERE))
        .build();
    options = ClusterOptions
        .clusterOptions(user, password)
        .environment(environment);
    cluster = Cluster.connect(host, options);
    bucket = cluster.bucket("default");
    collection = bucket.defaultCollection();
    key = "key::101";
    //{"cardNo":"0000","clientId":"101","ip":"127.0.0.1","yyyymmdd":"19700101"}
    doc = JsonObject.create()
        .put("cardNo", "0000")
        .put("clientId", "101")
        .put("ip", "127.0.0.1")
        .put("yyyymmdd", "19700101");
    insert();
    return;
  }

  private static void delete() throws Throwable {
    ExistsResult result = collection.exists(key);
    if (result.exists()) {
      collection.remove(key);
    }
    return;
  }

  private static void insert() throws Throwable {
    ExistsResult result = collection.exists(key);
    if (!result.exists()) {
      collection.insert(key, doc);
    }
    return;
  }

  //@Test
  public void query() {
    String query = new StringBuilder()
        .append("select min(d0.yyyymmdd) as earliest ")
        .append("    from ( ")
        .append("        select d1.yyyymmdd, d1.ip ")
        .append("        from `default` d1 ")
        .append("        where d1.cardNo in ( ")
        .append("            select raw d2.cardNo ")
        .append("            from `default` d2 ")
        .append("            where d2.clientId = \"5\") ")
        .append("    ) d0 ")
        .append("    where d0.ip in ( ")
        .append("            select raw d3.ip ")
        .append("            from `default` d3 ")
        .append("            where d3.clientId = \"5\");")
        .toString();
    QueryResult result = cluster.query(query);
    System.out.println(result.rowsAsObject());

    return;
  }

  //@Test
  public void select() {
    GetResult result = collection.get(key);
    System.out.println(result.contentAsObject().toString());
    return;
  }

  //@Test
  public void upsert() {
    collection.upsert(key, doc);
    return;
  }
}
