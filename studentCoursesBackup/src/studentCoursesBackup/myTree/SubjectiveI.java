package studentCoursesBackup.myTree;

public interface SubjectiveI {
	
	public void registerObserver(ObserverI o);
    public void unregisterObserver(ObserverI o);
    public void notifyObservers();
}
