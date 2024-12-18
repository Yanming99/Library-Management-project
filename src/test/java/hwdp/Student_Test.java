package hwdp;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Student_Test {

    @BeforeEach
    public void resetLog() {
        LibraryLogger.getInstance().clearWriteLog();
    }

    @Test
    public void testOnShelfToBorrowedTransition() {
        // Create a new LibraryBook instance in the OnShelf state
        LibraryBook book = new LibraryBook("Test Book");

        // Assert that the initial state is OnShelf
        assertEquals(OnShelf.getInstance(), book.getState(), "Initial state should be OnShelf");

        // Issue the book to transition it to the Borrowed state
        book.issue();

        // Verify that the state has changed to Borrowed
        assertEquals(Borrowed.getInstance(), book.getState(), "State should be Borrowed after issuing");

        // Check that the log contains the correct transition message
        String[] expectedLog = {
            "Leaving State OnShelf for State Borrowed"
        };
        assertArrayEquals(expectedLog, LibraryLogger.getInstance().getWrittenLines(), "Log should record OnShelf to Borrowed transition");
    }
}
