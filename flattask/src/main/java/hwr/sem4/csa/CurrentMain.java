package hwr.sem4.csa;

import hwr.sem4.csa.database.Databasehandler;
import hwr.sem4.csa.util.Participator;
import hwr.sem4.csa.util.*;

import javax.persistence.EntityManager;
import java.util.ArrayList;

public class CurrentMain {

    public static void main(String[] args){
        /*
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
        */

        /*
        Databasehandler.instanceOf().initCommunitiesDBConnection();
        Community testCommunity = new Community();
        testCommunity.setId("1A");
        testCommunity.setCreationTime("10.04.2018");
        ArrayList<String> testPIDs = new ArrayList<String>();
        testPIDs.add("P1");
        testPIDs.add("P2");
        testCommunity.setParticipatorIDs(testPIDs);
        ArrayList<Task> testTasks = new ArrayList<Task>();
        testTasks.add(new Task());
        testCommunity.setTaskList(testTasks);
        ArrayList<ToDo> testToDos = new ArrayList<ToDo>();
        testToDos.add(new ToDo());
        testCommunity.setToDoList(testToDos);

        EntityManager em = Databasehandler.instanceOf().getEntityManager();
        em.getTransaction().begin();
        em.persist(testCommunity);
        em.getTransaction().commit();
        em.close();

        Databasehandler.instanceOf().close();*/

        /*
        Databasehandler.instanceOf().initParticipatorsDBConnection();
        Participator testParticipator = new Participator();
        testParticipator.setCreationTime("10.04.2018");
        testParticipator.setRole("user");
        testParticipator.setUsername("TestPart1");
        testParticipator.setPassword("TestPass1");
        testParticipator.setBalance(100);
        testParticipator.setFirstName("TestFirst");
        testParticipator.setLastName("TestLast");
        testParticipator.setHistory("");

        EntityManager em = Databasehandler.instanceOf().getEntityManager();
        em.getTransaction().begin();
        em.persist(testParticipator);
        em.getTransaction().commit();
        em.close();

        Databasehandler.instanceOf().close(); */

        Databasehandler.instanceOf().initObjectDBConnection();
        Participator testParticipator = new Participator();
        testParticipator.setCreationTime("10.04.2018");
        testParticipator.setRole("user");
        testParticipator.setUsername("TestPart1");
        testParticipator.setPassword("TestPass1");
        testParticipator.setBalance(100);
        testParticipator.setFirstName("TestFirst");
        testParticipator.setLastName("TestLast");
        testParticipator.setHistory("");

        EntityManager em = Databasehandler.instanceOf().getEntityManager();
        em.getTransaction().begin();
        em.persist(testParticipator);
        em.getTransaction().commit();
        em.close();

        Databasehandler.instanceOf().close();


    }
}
