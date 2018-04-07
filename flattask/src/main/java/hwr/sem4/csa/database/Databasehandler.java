package hwr.sem4.csa.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Databasehandler {
    static Databasehandler thisDBHandler = new Databasehandler();
    private EntityManagerFactory emFactory;

    private Databasehandler() {    }

    static public Databasehandler instanceOf() {
        return thisDBHandler;
    }

    public void initUsersDBConnection(){
        emFactory = Persistence.createEntityManagerFactory("User");
    }

    public EntityManager getEntityManager() {
        return emFactory.createEntityManager();
    }

    public void close() {
        emFactory.close();
    }

    /* DB Management
     * Methods to insert into Users Table of FT DB
     * TODO: implement
     */


}
