package vendingmachine.controllor.inter;

import vendingmachine.controllor.manager.ManagerControllor;
import vendingmachine.controllor.person.PersonControllor;
import vendingmachine.controllor.vendingmachine.VendingMachineActableImpl;
import vendingmachine.model.Manager;
import vendingmachine.model.Person;
import vendingmachine.model.VendingMachine;

public class InitGetInstance {
    public InitGetInstance() {
    }

    public static VendingMachine newInstenceMachine() {
        return new VendingMachine();
    }

    public static Person newInstencePerson() {
        return new Person();
    }

    public static PersonControllor newInstencePersonControllor(Person user, VendingMachine machine,
            VendingMachineActableImpl machineAction) {
        return new PersonControllor(user, machine, machineAction);
    }

    public static Manager newInstenceManager() {
        return new Manager();
    }

    public static ManagerControllor newInstenceManagerControllor(Manager manager, VendingMachine machine,
            VendingMachineActableImpl machineAction) {
        return new ManagerControllor(manager, machine, machineAction);
    }
}
