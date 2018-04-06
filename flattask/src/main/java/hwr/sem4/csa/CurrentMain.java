package hwr.sem4.csa;

import hwr.sem4.csa.database.Databasehandler;
import hwr.sem4.csa.util.User;

import javax.persistence.EntityManager;

public class CurrentMain {

    public static void main(String[] args){

        Databasehandler.instanceOf().initUsersDBConnection();

        User testUser = new User();
        testUser.setUsername("TestUsername1");
        testUser.setUserPassword("TestPassword1");
        testUser.setRole("Tester1");

        EntityManager em = Databasehandler.instanceOf().getEntityManager();
        em.getTransaction().begin();
        em.persist(testUser);
        em.getTransaction().commit();
        em.close();

        Databasehandler.instanceOf().close();
    }
}
