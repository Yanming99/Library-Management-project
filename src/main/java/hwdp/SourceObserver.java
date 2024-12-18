package hwdp;

import java.util.HashMap;

public class SourceObserver implements Observer {
    private String name;
    private HashMap<Subject, String> subjectToPastStateName;  // Keep to tracks the last known state for each subjects

    public SourceObserver(String n) {
        this.name = n;
        this.subjectToPastStateName = new HashMap<>(); 
    }

    @Override
    public void update(Subject subject) { // Second time check -> is functional work
        if (subject instanceof LibraryBook) {
            LibraryBook book = (LibraryBook) subject;
            String lastState = subjectToPastStateName.getOrDefault(subject, "UNOBSERVED");
            LibraryLogger.getInstance().writeLine(name + " OBSERVED " + book.getName() + " LEAVING STATE: " + lastState);
            subjectToPastStateName.put(subject, book.getStateName()); // getStateName() has issues. -> Fixed it as Second time -> P2
        }
    }

    @Override
    public String toString() {
        return name;
    }
}