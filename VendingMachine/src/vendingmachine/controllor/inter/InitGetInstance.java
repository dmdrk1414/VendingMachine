package vendingmachine.controllor.inter;

import vendingmachine.controllor.vendingmachine.VendingMachineActableImpl;
import vendingmachine.model.Manager;
import vendingmachine.model.Person;
import vendingmachine.model.VendingMachine;

public class InitGetInstance {
    Manager manager;
    VendingMachine machine;
    VendingMachineActableImpl machineAction;
    Person person;

    public InitGetInstance() {
    }

    public static Manager newInstenceManager() {
        return new Manager();
    }

    public static VendingMachine newInstenceMachine() {
        return new VendingMachine();
    }

    public static VendingMachineActableImpl newInstenceMachineActableImpl() {
        return new VendingMachineActableImpl();
    }

    public static Person newInstencePerson() {
        return new Person();
    }
}
