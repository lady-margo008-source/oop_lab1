public class PickupDelivery implements DeliveryMetod{
    @Override
    public double calculateCost(double orderSumma){
        return 0.0
    }
    @Override
    public boolean isCourierRequired(){
        return false;
    }
}
