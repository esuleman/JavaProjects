public class Airport {
    private String name;
    private String location;
    private Terminal[] terminals;
    private Runway[] runways;
    private String weather;

    public Airport(String name, String location, int num_terminals, int num_runways) {
        this.name = name;
        this.location = location;
        terminals = new Terminal[num_terminals];
        runways = new Runway[num_runways];

        double random = Math.random() * 100;
        if (random >= 0 && random < 25) {
            weather = "Surface Wind";
        }
        if (random >= 25 && random < 50) {
            weather = "Low C&V (Visibility)";
        }
        if (random >= 50 && random < 75) {
            weather = "Convective (Rain & Thunderstorms)";
        }
        if (random >= 75 && random < 100) {
            weather = "Normal";
        }
    }

    public void runwayDelay() {

    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getWeather() {
        return weather;
    }
}
