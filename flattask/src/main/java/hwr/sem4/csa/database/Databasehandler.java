package hwr.sem4.csa.database;

import hwr.sem4.csa.util.Community;
import hwr.sem4.csa.util.Participator;

import javax.persistence.*;

public class Databasehandler {
    static Databasehandler thisDBHandler = new Databasehandler();
    private EntityManagerFactory emFactory;

    private Databasehandler() {    }

    static public Databasehandler instanceOf() {
        return thisDBHandler;
    }

    public void initObjectDBConnection(){
        emFactory = Persistence.createEntityManagerFactory("objectdb:" +
                "//ec2-54-85-66-232.compute-1.amazonaws.com:6136/test.odb;user=admin;password=admin");
    }

    public EntityManager getEntityManager() {
        return emFactory.createEntityManager();
    }

    public void close() {
        emFactory.close();
    }

    /* DB Management
     * Methods: insert, getBy, update, remove
     * TODO: implement DB Methods
     */

    //Inserts passed Object into ODB; no checks are made
    public void insert(Object toInsert){
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(toInsert);
        em.getTransaction().commit();
        em.close();
    }

    //Clears DB, currently needed for JUNIT
    public void clearAll(){
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Community").executeUpdate();
        em.createQuery("DELETE FROM Participator").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    //Tries to grab exactly one community by ID, if more than one/or none with the id exist -> throws error
    public Community getCommunityById(String id){
        EntityManager em = emFactory.createEntityManager();
        TypedQuery<Community> typedResultQuery = em.createQuery("SELECT c FROM Community c WHERE c.id = :id",Community.class);
        try{
            Community resultCommunity = typedResultQuery.setParameter("id",id).getSingleResult();
            return resultCommunity;
        }catch(Exception e){
            //System.out.println("Error in Method: getCommunityById");
            //e.printStackTrace();
            return null;
        }
    }

    //Tries to grab exactly one participator by username, if more than one/or none with the id exist -> throws error
    public Participator getParticipatorByUsername(String username){
        EntityManager em = emFactory.createEntityManager();
        TypedQuery<Participator> typedResultQuery = em.createQuery("SELECT p FROM Participator p WHERE p.username = :username", Participator.class);
        try{
            Participator resultParticipator = typedResultQuery.setParameter("username",username).getSingleResult();
            return resultParticipator;
        }catch(Exception e){
            System.out.println("Error in Method: getParticipatorByUsername");
            e.printStackTrace();
            return null;
        }
    }

    //special login-method to prevent any false-login attempts
    public Participator getParticipatorByLogin(String username, String password){
        EntityManager em = emFactory.createEntityManager();
        TypedQuery<Participator> typedResultQuery = em.createQuery("SELECT p FROM Participator p WHERE " +
                "p.username = :username AND p.password = :password",Participator.class);
        try{
            Participator resultParticipator = typedResultQuery.setParameter("username",username)
                    .setParameter("password", password).getSingleResult();
            return resultParticipator;
        }catch(Exception e){
            System.out.println("Error in Method: getParticipatorByLogin" +
                    "\nEither this User & Password combination is invalid or" +
                    "more than one user was falsely found!");
            e.printStackTrace();
            return null;
        }

    }




}
