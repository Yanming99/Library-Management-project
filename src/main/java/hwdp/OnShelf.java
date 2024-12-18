package hwdp;

public class OnShelf implements LBState {
    private static OnShelf instance = null;


    public static OnShelf getInstance() {
        if (instance == null) {
            instance = new OnShelf();
        }
        return instance;
    }

    @Override
    public void shelf(LibraryBook book) throws BadOperationException {
        throw new BadOperationException("Can't use shelf in OnShelf state");
    }

    @Override
    public void issue(LibraryBook book) {
        LibraryLogger.getInstance().writeLine("Leaving State OnShelf for State Borrowed"); 
        book.setState(Borrowed.getInstance()); 
        book.notifyObservers();  // Update for the P3 -> Since After the Leaving State OnShelf need ScrObserverfoo function called
    }


    @Override
    public void extend(LibraryBook book) throws BadOperationException {
        throw new BadOperationException("Can't use extend in OnShelf state");
    }

    @Override
    public void returnIt(LibraryBook book) throws BadOperationException {
        throw new BadOperationException("Can't use returnIt in OnShelf state");
    }

    @Override
    public String toString() {
        return "OnShelf";
    }
}