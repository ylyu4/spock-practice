public class MessagePersister {

    private boolean persistable;


    public boolean isPersistable() {
        return persistable;
    }

    public void receive(String string) {
        if (isPersistable()) {
            persist(string);
        }

        return;
    }

    public void persist(String string) {
        System.out.println("persist " + string);
    }
}
