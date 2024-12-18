package hwdp;

public class Borrowed implements LBState {
    private static Borrowed instance = null;

    private Borrowed() {}

    public static Borrowed getInstance() {
        if (instance == null) {
            instance = new Borrowed();
        }
        return instance;
    }

    @Override
    public void shelf(LibraryBook book) throws BadOperationException {
        throw new BadOperationException("shelf not allowed in Borrowed state");
    }

    @Override
    public void issue(LibraryBook book) throws BadOperationException {
        throw new BadOperationException("issue not allowed in Borrowed state");
    }

    @Override
    public void extend(LibraryBook book) {
        LibraryLogger.getInstance().writeLine("Leaving State Borrowed for State Borrowed");  
        book.notifyObservers();  
    }


    @Override

    public void returnIt(LibraryBook book) {
        LibraryLogger.getInstance().writeLine("Leaving State Borrowed for State GotBack");
        book.setState(GotBack.getInstance());
        book.notifyObservers(); 
    }

    @Override
    public String toString() {
        return "Borrowed";
    }
}