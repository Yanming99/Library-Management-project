package hwdp;

public class GotBack implements LBState {
    private static GotBack instance = null;

    private GotBack() {}

    public static GotBack getInstance() {
        if (instance == null) {
            instance = new GotBack();
        }
        return instance;
    }

    @Override
    public void shelf(LibraryBook book) {
        LibraryLogger.getInstance().writeLine("Leaving State GotBack for State OnShelf");
        book.setState(OnShelf.getInstance());
        book.notifyObservers(); // Update for P3 
    }

    @Override
    public void issue(LibraryBook book) throws BadOperationException {
        throw new BadOperationException("issue not allowed in GotBack state");
    }

    @Override
    public void extend(LibraryBook book) throws BadOperationException {
        throw new BadOperationException("extend not allowed in GotBack state");
    }

    @Override
    public void returnIt(LibraryBook book) throws BadOperationException {
        // Since, already in GotBack state, thus do nothing
    }

    @Override
    public String toString() {
        return "GotBack";
    }
}