package com.example.springboot;

import com.couchbase.client.java.Cluster;

public class CouchbaseAdapter {
  /*
   * host, user, password, logLevel, cluster, theInstance
   * host(), user(), password(), logLevel(), cluster(), 
   * init(), destroy(), theInstance(), CouchbaseAdapter()
   * query()
   */

  private Cluster cluster;
   
  private String host;

  private String logLevel;

  private String password;

  private static CouchbaseAdapter theInstance;

  private String user;

  private CouchbaseAdapter() {
    super();
  }

  private Cluster cluster() {
    return null;
  }

  public static void destroy() {
    return;
  }

  public static void init() {
    return;
  }
  
  public static CouchbaseAdapter theInstance() {
    return null;
  }

}
