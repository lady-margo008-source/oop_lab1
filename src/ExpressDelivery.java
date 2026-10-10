public class ExpressDelivery implements DeliveryMetod{
    private final double baseCost = 500.0;
    @Override
    public  double calculateCost(double orderSumma){
        return baseCost;
    }
    @Override
    public  boolean isCourierRequired(){
        return true;
    }
}
