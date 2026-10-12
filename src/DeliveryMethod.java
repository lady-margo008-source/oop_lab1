public interface DeliveryMethod {
    double calculateCost(double orderSumma);
    boolean isCourierRequired();
}
