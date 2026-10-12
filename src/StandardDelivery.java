public class StandardDelivery implements DeliveryMethod {
    private final double fixedCost=300.0;
    @Override
    public double calculateCost(double orderSumma){
        return fixedCost;
    }
    @Override
    public boolean isCourierRequired(){
        return true;
    }
}
