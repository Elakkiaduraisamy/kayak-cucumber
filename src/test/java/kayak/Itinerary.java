package kayak;

public class Itinerary {
    String origin;

    @Override
    public String toString() {
        return "Itinerary{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    String destination;


    public Itinerary(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }


}
