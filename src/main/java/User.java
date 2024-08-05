import java.util.ArrayList;
import java.util.List;

    public class User {
        private String userId;
        private String name;
        private String location;
        private List<Ride> pastRides;

        public User(String userId, String name, String location) {
            this.userId = userId;
            this.name = name;
            this.location = location;
            this.pastRides = new ArrayList<>();
        }

        public void registerUser() {
            System.out.println("Пользователь " + name + " успешно зарегистрирован.");
        }

        public void viewPastRides() {
            if (pastRides.isEmpty()) {
                System.out.println("Нет прошлых поездок");
            } else {
                for (Ride ride : pastRides) {
                    System.out.println(ride);
                }
            }
        }

        public String getUserId() {
            return userId;
        }

        public String getName() {
            return name;
        }

        public String getLocation() {
            return location;
        }

        public List<Ride> getPastRides() {
            return pastRides;
        }

        public void addRide(Ride ride) {
            pastRides.add(ride);
        }
    }
}
