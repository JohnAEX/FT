package hwr.sem4.csa;

import hwr.sem4.csa.database.Databasehandler;
import hwr.sem4.csa.database.DatabasehandlerRe;
import hwr.sem4.csa.util.Community;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DatabasehandlerStressTest {

    @BeforeAll
    public static void runBeforeAll(){
        Databasehandler.instanceOf().initObjectDBConnection();
        DatabasehandlerRe.instanceOf().initObjectDBConnection();
        //Databasehandler.instanceOf().clearAll();
    }

    @AfterAll
    public static void runAfterAll(){
        //Databasehandler.instanceOf().clearAll();
        Databasehandler.instanceOf().close();
        DatabasehandlerRe.instanceOf().close();
    }

    @Test
    public void stressExceptionHandler(){
        Community testCommunity = new Community();
        testCommunity.setCreationTime("12.04.2018");
        testCommunity.setId("TESTCOMMUNITYID2");
        testCommunity.setDotosList(null);
        testCommunity.setTaskList(null);
        Databasehandler.instanceOf().insert(testCommunity);
        long beginTime = System.nanoTime();
        for(int n = 0; n < 100; n++){
            Databasehandler.instanceOf().getCommunityById("TESTCOMMUNITYID2");
        }
        long endTime = System.nanoTime();
        System.out.println("\t> Stress Exception: " + (endTime-beginTime));
    }

    @Test
    public void stressResultListHandler(){
        Community testCommunity = new Community();
        testCommunity.setCreationTime("12.04.2018");
        testCommunity.setId("TESTCOMMUNITYID3");
        testCommunity.setDotosList(null);
        testCommunity.setTaskList(null);
        DatabasehandlerRe.instanceOf().insert(testCommunity);

        long beginTime = System.nanoTime();
        for(int n = 0; n < 100; n++){
            DatabasehandlerRe.instanceOf().getCommunityById("TESTCOMMUNITYID3");
        }
        long endTime = System.nanoTime();
        System.out.println("\t> Stress ResultList: " + (endTime-beginTime));
    }
}
