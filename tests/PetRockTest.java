import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class PetRockTest {

    private PetRock rocky;

    // Timeout Rule:
//    @Rule
//    public Timeout globalTimeout = Timeout.seconds(10); // 10 seconds max

    @Before
    public void myTestSetUp() throws Exception {
        rocky = new PetRock("Rocky");
    }

    // BeforeClass - Only runs once for entire test (ex. create a database)
    // After - Runs after test finished (ex. close a file)
    // AfterClass - See above

    @Test
    public void getName() {
        assertEquals("Rocky", rocky.getName());
    }

    @Test
    public void testUnhappyToStart() {
        assertFalse(rocky.isHappy());
    }

    @Test
    public void testHappyAfterPlay() {
        rocky.playWithRock();
        assertTrue(rocky.isHappy());
    }

    @Ignore("Exception throwing not yet defined")
    @Test (expected = IllegalStateException.class)
    public void nameFail() {
        rocky.getHappyMessage();
    }

    @Test
    public void name() {
        rocky.playWithRock();
        String msg = rocky.getHappyMessage();
        assertEquals("I'm happy!", msg);
    }

    @Test
    public void testFavNum() {
        assertEquals(42, rocky.getFavNumber());
    }

    @Test (expected = IllegalArgumentException.class)
    public void emptyNameFail() {
        new PetRock("");
    }

    @Test (timeout = 100) // in ms
    public void waitForHappyTimeout() {
        rocky.waitTillHappy();
    }
}