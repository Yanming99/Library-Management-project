package hwdp;
import java.util.ArrayList;
import java.util.List;

public class LibraryBook implements Subject {
    private String name;
    private LBState currentState;
    private List<Observer> observers = new ArrayList<>();

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            LibraryLogger.getInstance().writeLine(observer + " is now watching " + name);
        } else {
            LibraryLogger.getInstance().writeLine(observer + " is already attached to " + name);
    }
    }


    @Override
    public void detach(Observer observer) {
        if (observers.remove(observer)) {
            LibraryLogger.getInstance().writeLine(observer + " is no longer watching " + name);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public String getStateName() {
        return currentState.toString();
    }

    public LibraryBook(String name) {
        this.name = name;
        this.currentState = OnShelf.getInstance();  // Initial state is OnShelf
    }

    public LBState getState() {
        return currentState;
    }

    void setState(LBState state) {
        this.currentState = state;
        // Update this parts 
        // Second update -> No Error
    }


    public void shelf() {
        try {
            currentState.shelf(this);
        } catch (BadOperationException e) {
            LibraryLogger.getInstance().writeLine("BadOperationException - Can't use shelf in " + currentState.toString() + " state");
        }
    }

    public void issue() {
        try {
            currentState.issue(this);
        } catch (BadOperationException e) {
            LibraryLogger.getInstance().writeLine("BadOperationException - Can't use issue in " + currentState.toString() + " state");
        }
    }

    public void extend() {
        try {
            currentState.extend(this);
        } catch (BadOperationException e) {
            LibraryLogger.getInstance().writeLine("BadOperationException - Can't use extend in " + currentState.toString() + " state");
        }
    }

    public void returnIt() {
        try {
            currentState.returnIt(this);
        } catch (BadOperationException e) {
            LibraryLogger.getInstance().writeLine("BadOperationException - Can't use returnIt in " + currentState.toString() + " state");
        }
    }    

    @Override
    public String toString() {
        return "LibraryBook: " + name + " is currently in state: " + currentState.toString();
    }
}