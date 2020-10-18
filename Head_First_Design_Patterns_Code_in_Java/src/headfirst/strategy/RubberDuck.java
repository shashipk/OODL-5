package headfirst.strategy;

public class RubberDuck extends Duck {

	public RubberDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Squeak();
	}

	public void display() {
		System.out.println("I'm a rubber duckie");
	}
}


class Memento {
    private int tmp;

    public Memento(int  tmp) {
        this.state = state;
    }

    public int getState() {
        return tmp;
    }
}

class Originator { // AC
    private int tmp; // state
    private int humidity;
  //  Date date = new date();
   /* lots of memory consumptive private data that is not necessary to define the
    * state and should thus not be saved. Hence the small memento object. */

    public void setState(int tmp) {
        System.out.println("Originator: Setting state to " + state);
        this.state = state;
    }

    public Memento save() { //
        System.out.println("Originator: Saving to Memento.");
        return new Memento(tmp);
    }
    public void restore(Memento m) {
        state = m.getState();
        System.out.println("Originator: State after restoring from Memento: " + state);
    }
}

class Caretaker {
    private ArrayList<Memento> mementos = new ArrayList<>(); // O(n) --> O(1)

    public void addMemento(Memento m) {
        mementos.add(m);
    }

    public Memento getMemento() {
        return mementos.get(1);
    }
}

public class MementoDemo {
    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator(); // AC
        originator.setState("State1");
        originator.setState("State2");
        caretaker.addMemento( originator.save() );
        originator.setState("State3");
        caretaker.addMemento( originator.save() );
        originator.setState("State4");
        originator.restore( caretaker.getMemento() );
    }
}
