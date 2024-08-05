public class Driver extends User {
    private String vehicleInfo;
    private double rating;
    private int totalRides;
    private boolean isAvailable;

    public Driver(String userId, String name, String location, String vehicleInfo) {
        super(userId, name, location);
        this.vehicleInfo = vehicleInfo;
        this.rating = 0.0;
        this.totalRides = 0;
        this.isAvailable = true;
    }

    public void registerDriver() {
        System.out.println("Водитель " + getName() + " успешно зарегистрирован.");
    }

    public void updateAvailability(boolean status) {
        this.isAvailable = status;
    }

    public void viewPastRidesAndRating() {
        super.viewPastRides();
        System.out.println("Средний рейтинг: " + (totalRides == 0 ? "Еще нет рейтинга" : rating / totalRides));
    }

    public String getVehicleInfo() {
        return vehicleInfo;
    }

    public double getRating() {
        return rating;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void addRating(double rating) {
        this.rating += rating;
        this.totalRides++;
    }
}