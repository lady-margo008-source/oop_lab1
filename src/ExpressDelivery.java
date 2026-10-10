public class ExpressDelivery implements DeliveryMetod{
    private final double baseCost = 500.0;
    @Override
    public  double calculateCost(double orderSumma){
        double percentBonus = orderSumma * 0.10;
        return baseCost + percentBonus;
    }
    @Override
    public  boolean isCourierRequired(){
        return true;
    }
}
