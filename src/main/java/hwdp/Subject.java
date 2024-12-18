package hwdp;

public interface Subject {
	void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
    String getStateName();
	String getName();
}