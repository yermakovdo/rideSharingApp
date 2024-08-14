import java.time.Duration;
import java.time.LocalDateTime;

public class Ride {
    private String rideId;
    private Driver driver;
    private User passenger;
    private String origin;
    private String destination;
    private double fare;
    private String status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Ride(String rideId, Driver driver, User passenger, String origin, String destination) {
        this.rideId = rideId;
        this.driver = driver;
        this.passenger = passenger;
        this.origin = origin;
        this.destination = destination;
        this.status = "В ожидании";
    }

    public void startRide() {
        this.startTime = LocalDateTime.now();
        this.status = "В процессе";
        System.out.println("Поездка " + rideId + " начата.");
    }

    public void endRide() {
        this.endTime = LocalDateTime.now();
        this.status = "Успешно выполнено";
        calculateFare();
        System.out.println("Поездка " + rideId + " завершена. Тариф: " + fare);
    }

    private void calculateFare() {
        Duration duration = Duration.between(startTime, endTime);
        this.fare = duration.toMinutes() * 2.0;
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    public String getRideId() {
        return rideId;
    }

    public Driver getDriver() {
        return driver;
    }

    public User getPassenger() {
        return passenger;
    }

    public double getFare() {
        return fare;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "Поездка{" +
                "ID поездки='" + rideId + '\'' +
                ", водитель=" + driver.getName() +
                ", пассажир=" + passenger.getName() +
                ", откуда='" + origin + '\'' +
                ", куда='" + destination + '\'' +
                ", тариф=" + fare +
                ", статус='" + status + '\'' +
                ", времяНачала=" + startTime +
                ", времяКонца=" + endTime +
                '}';
    }

    public String getOrigin() {
        return null;
    }

    public String getDestination() {
        return null;
    }
}