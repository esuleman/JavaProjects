public class Flight {
    String flightnum;
    String flightcode;
    private Aircraft airplane;
    private Airport origin;
    private Airport destination;
    private String departure;
    private String actual_departure;
    private String arrival;
    private String actual_arrival;
    private String flightduration;

    public Flight(String flightnum, String flightcode, Aircraft airplane,  Airport origin, Airport destination, String departure, String arrival) {
        this.flightnum = flightnum;
        this.flightcode = flightcode;
        this.airplane = airplane;
        this.origin = origin;
        this.destination = destination;
        this.departure = departure;
        this.arrival = arrival;
    }

    public void setActual_departure(String time) {
        String departurehours = departure.substring(0, 2);
        String departureminutes = departure.substring(3);

        String timehours = time.substring(0, 2);
        String timeminutes = time.substring(3);

        int deptime = (Integer.parseInt(departurehours) * 60) + Integer.parseInt(departureminutes);
        int delay = (Integer.parseInt(timehours) * 60) + Integer.parseInt(timeminutes);

        deptime += delay;
        int newhour = deptime / 60;
        int newminutes = deptime % 60;
        String zero = "0";

        if (newhour < 10) {
            departurehours = zero += String.valueOf(newhour);
        } else
            departurehours = String.valueOf(newhour);
        if (newminutes < 10) {
            departureminutes = zero + newminutes;

        } else
            departureminutes = String.valueOf(newminutes);

        actual_departure = departurehours + ":" + departureminutes;
    }

    public void setActual_arrival(String time) {

        String arrivalhours = arrival.substring(0, 2);
        String arrivalminutes = arrival.substring(3);

        String timehours = time.substring(0, 2);
        String timeminutes = time.substring(3);

        int arrtime = (Integer.parseInt(arrivalhours) * 60) + Integer.parseInt(arrivalminutes);
        int delay = (Integer.parseInt(timehours) * 60) + Integer.parseInt(timeminutes);

        arrtime += delay;
        int newhour = arrtime / 60;
        int newminutes = arrtime % 60;
        String zero = "0";

        if (newhour < 10) {
            arrivalhours = zero += String.valueOf(newhour);
        } else
            arrivalhours = String.valueOf(newhour);
        if (newminutes < 10) {
            arrivalminutes = zero + newminutes;
        } else
            arrivalminutes = String.valueOf(newminutes);

        actual_arrival = arrivalhours + ":" + arrivalminutes;
    }

    public void getFlightDuration() {
        String flightdurationhours;
        String flightdurationminutes;
        String departurehours = actual_departure.substring(0, 2);
        String departureminutes = actual_departure.substring(3);
        String arrivalhours = actual_arrival.substring(0, 2);
        String arrivalminutes = actual_arrival.substring(3);

        int deptime = (Integer.parseInt(departurehours) * 60) + Integer.parseInt(departureminutes);
        int arrtime = (Integer.parseInt(arrivalhours) * 60) + Integer.parseInt(arrivalminutes);

        if (arrtime <= deptime) {
            arrtime += 1440;
        }

        int flight = arrtime - deptime;
        int newhour = flight / 60;
        int newminutes = flight % 60;
        String zero = "0";

        if (newhour < 10) {
            flightdurationhours = zero += String.valueOf(newhour);
        } else
            flightdurationhours = String.valueOf(newhour);
        if (newminutes < 10) {
            flightdurationminutes = zero + newminutes;
        } else
            flightdurationminutes = String.valueOf(newminutes);

        flightduration = flightdurationhours + ":" + flightdurationminutes;
    }

    public int getEmptySeats() {
        return airplane.getCapacity() - airplane.getNum_crew() - airplane.getNum_passengers();
    }

    @Override
    public String toString() {
        return "Flight: " + flightnum + flightcode +
                "\nDeparting To: " + destination.getName() + " in " + destination.getLocation() +
                "\nArrival At: " + arrival +
                "\nDeparting From: " + origin.getName() + " in " + origin.getLocation() +
                "\nDeparting At: " + departure +
                "\nEstimated Flight Duration: " + flightduration +
                "\nWeather In " + destination.getName() + " Is Currently " + destination.getWeather();
    }
}
