package hwdp;

public class DestObserver implements Observer {
    private String name;

    public DestObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Subject subject) {
        if (subject instanceof LibraryBook) {
            LibraryBook book = (LibraryBook) subject;
            LibraryLogger.getInstance().writeLine(name + " OBSERVED " + book.getName() + " REACHING STATE: " + book.getStateName());
        }
    }

    @Override
    public String toString() {
        return name;
    }
}