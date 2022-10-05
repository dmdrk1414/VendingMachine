package vendingmachine.controllor;

import vendingmachine.model.Manager;
import vendingmachine.model.Person;
import vendingmachine.model.VendingMachine;

public class ObjectManager {
    private Manager manager;
    private Person person;
    private VendingMachine machine;

    public ObjectManager() {
        this.manager = new Manager();
        this.person = new Person();
        this.machine = new VendingMachine();
    }

    public Manager getManager() {
        return manager;
    }

    public Person getPerson() {
        return person;
    }

    public VendingMachine getMachine() {
        return machine;
    }
}
