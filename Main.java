public class Main {
    public static void main(String[] args) {
        RideSharingApp app = new RideSharingApp();

        User user1 = new User("101", "Алиса", "Локация А");
        User user2 = new User("102", "Адольф", "Локация Б");
        app.registerUser(user1);
        app.registerUser(user2);

        Driver driver1 = new Driver("201", "Боб", "Локация А", "Машина 1");
        Driver driver2 = new Driver("202", "Майк", "Локация Б", "Машина 2");
        app.registerDriver(driver1);
        app.registerDriver(driver2);

        app.displayAvailableDrivers();

        app.initiateRide(user1, "Локация А", "Пункт Назначения А");

        Ride ride = user1.getPastRides().get(0);
        if (ride != null && ride.getStatus().equals("В процессе")) {
            app.endRide(ride);

            Payment payment = new Payment("301", ride.getRideId(), ride.getFare());
            payment.processPayment();
        }

        user1.viewPastRides();
        driver1.viewPastRidesAndRating();
    }
}