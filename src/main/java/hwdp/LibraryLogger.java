package hwdp;
import java.util.ArrayList;
import java.util.List;

public class LibraryLogger {
    private static LibraryLogger instance;
    private List<String> logLines;

    private LibraryLogger() {
        logLines = new ArrayList<>();
        ExpensiveComputeToy.performExpensiveLogSetup();  // Called once during instance creation
    }
    
    public void writeLine(String line) {
        System.out.println("LibraryLogger: " + line);  // Output to standard out
        logLines.add(line);  // Store the line without the "LibraryLogger:" prefix
    }

    public String[] getWrittenLines() {
        return logLines.toArray(new String[0]);
    }

    public void clearWriteLog() {
        logLines.clear();
    }
    
    public static LibraryLogger getInstance() {
        if (instance == null) {
            instance = new LibraryLogger();  // Lazy initialization
        }
        return instance;
    }

}

