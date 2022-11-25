package domain;

public class Taxi extends Vehicle{
    // field
    private String destination;
    private int distanceToDestination;
    private int basicFare;
    private int basicDistance;
    private int distanceFare;
    private int AccumulatedFare;



    // constructor
    public Taxi(int number){
        super();
        this.setMaxPassenger(4);
        this.setBasicFare(3000);
        this.setDistanceFare(1000);
        this.setBasicDistance(1);
        this.setNumber(number);
        this.setAccumulatedFare(0);
        this.setStatus(true);
    }

    // getter and setter
    public int getAccumulatedFare() {
        return AccumulatedFare;
    }

    public void setAccumulatedFare(int accumulatedFare) {
        AccumulatedFare = accumulatedFare;
    }
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDistanceToDestination() {
        return distanceToDestination;
    }

    public void setDistanceToDestination(int distanceToDestination) {
        this.distanceToDestination = distanceToDestination;
    }

    public int getBasicFare() {
        return basicFare;
    }

    public void setBasicFare(int basicFare) {
        this.basicFare = basicFare;
    }

    public int getBasicDistance() {
        return basicDistance;
    }

    public void setBasicDistance(int basicDistance) {
        this.basicDistance = basicDistance;
    }

    public int getDistanceFare() {
        return distanceFare;
    }

    public void setDistanceFare(int distanceFare) {
        this.distanceFare = distanceFare;
    }
}
