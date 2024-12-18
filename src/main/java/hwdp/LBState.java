package hwdp;

public interface LBState {
    void shelf(LibraryBook book) throws BadOperationException;
    void issue(LibraryBook book) throws BadOperationException;
    void extend(LibraryBook book) throws BadOperationException;
    void returnIt(LibraryBook book) throws BadOperationException;
}