package banheirounissex;

public class Producer extends Thread {
    private Bathroom bathroom;
    private Person person;

    public Producer (Person person, Bathroom bathroom) {
        this.person = person;
        this.bathroom = bathroom;
    }

    @Override
    public void run() {
        bathroom.insert(person);
    }    
}
