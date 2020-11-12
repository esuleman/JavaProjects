public class Gate {
    private String name;
    private String airline;
    private boolean occupied;
    private Flight flight;

    public Gate(String name, String airline) {
        this.name = name;
        this.airline = airline;
        occupied = false;
    }

    public void setfull() {
        occupied = true;
    }
}
