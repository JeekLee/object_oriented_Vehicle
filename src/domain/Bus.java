package domain;

public class Bus extends Vehicle{
    // field
    private int fare;

    // constructor
    public Bus(int number){
        super();
        this.setNumber(number);
        this.setFare(1000);
        this.setStatus(true);
        this.setMaxPassenger(30);
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }
}
