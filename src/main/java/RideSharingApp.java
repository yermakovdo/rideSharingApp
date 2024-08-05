import java.util.ArrayList;
import java.util.List;

public class RideSharingApp {
    private List<User> users;
    private List<Driver> drivers;
    private List<Ride> rides;

    public RideSharingApp() {
        this.users = new ArrayList<>();
        this.drivers = new ArrayList<>();
        this.rides = new ArrayList<>();
    }

    public void registerUser(User user) {
        users.add(user);
        user.registerUser();
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
        driver.registerDriver();
    }

    public Driver matchRide(User passenger, String origin, String destination) {
        for (Driver driver : drivers) {
            if (driver.isAvailable() && driver.getLocation().equals(origin)) {
                driver.updateAvailability(false);
                Ride ride = new Ride("401" + (rides.size() + 1), driver, passenger, origin, destination);
                rides.add(ride);
                passenger.addRide(ride);
                driver.addRide(ride);
                return driver;
            }
        }
        return null;
    }

    public void displayAvailableDrivers() {
        for (Driver driver : drivers) {
            if (driver.isAvailable()) {
                System.out.println(driver.getName() + " - " + driver.getVehicleInfo());
            }
        }
    }

    public void initiateRide(User passenger, String origin, String destination) {
        Driver driver = matchRide(passenger, origin, destination);
        if (driver != null) {
            System.out.println("Водитель " + driver.getName() + " подобран для поездки");
            Ride ride = passenger.getPastRides().get(passenger.getPastRides().size() - 1);
            ride.startRide();
        } else {
            System.out.println("Водители не найдены");
        }
    }

    public void endRide(Ride ride) {
        ride.endRide();
        ride.getDriver().updateAvailability(true);
    }

    public void handleCancellationsAndReassignments(Ride ride) {
        ride.updateStatus("Отменено");
        ride.getDriver().updateAvailability(true);
        initiateRide(ride.getPassenger(), ride.getOrigin(), ride.getDestination());
    }
}