package hwr.sem4.csa;

import hwr.sem4.csa.database.DatabasehandlerRe;
import hwr.sem4.csa.util.Participator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class ReviewADemo {

    @BeforeAll
    public static void runBeforeAll(){
        DatabasehandlerRe.instanceOf().initObjectDBConnection();
    }

    @AfterAll
    public static void runAfterAll(){
        DatabasehandlerRe.instanceOf().clearAll();
        DatabasehandlerRe.instanceOf().close();
    }

    @Test
    public void basicDemonstration(){
        Participator newParticipator = new Participator();
        newParticipator.setFirstName("Max");
        newParticipator.setLastName("Mustermann");
        newParticipator.setUsername("max.mustermann");
        newParticipator.setPassword("maxPasswort");
        newParticipator.setHistory("");
        newParticipator.setBalance(100);
        newParticipator.setRole("user");
        newParticipator.setCreationTime(LocalDateTime.now().toString());
        newParticipator.setCommunityId("BesteWG");

        DatabasehandlerRe.instanceOf().insert(newParticipator);
        Assertions.assertNotNull(DatabasehandlerRe.instanceOf().getParticipatorByLogin("max.mustermann","maxPasswort"));
    }
}
