public class Payment {
    private String paymentId;
    private String rideId;
    private double amount;
    private String status;

    public Payment(String paymentId, String rideId, double amount) {
        this.paymentId = paymentId;
        this.rideId = rideId;
        this.amount = amount;
        this.status = "В ожидании";
    }

    public void processPayment() {
        this.status = "Успешно выполнено";
        System.out.println("Оплата " + paymentId + " за поездку " + rideId + " обработана. Сумма: " + amount);
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getRideId() {
        return rideId;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }
}