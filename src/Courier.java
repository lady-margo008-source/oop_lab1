public class Courier {
    private final String name;
    private final String phone;
    private final Integer id;
    private boolean isAvailable;
    public Courier(String courierName, String courierPhone, Integer courierId){
        if (courierId<=0){
            throw new IllegalArgumentException ("ID курьера должен быть положителен!");
        }
        if (courierName==null||courierName.trim().isEmpty()){
            throw new IllegalArgumentException("Имя курьера не может быть пустым!");
        }
        if (courierPhone==null||courierPhone.trim().isEmpty()){
            throw new IllegalArgumentException("Телефон курьера не может быть пустым!");
        }

        this.name = courierName.trim();
        this.phone = courierPhone.trim();
        this.id = courierId;
        this.isAvailable = true;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void markBusy() {
        if (!isAvailable) {
            throw new IllegalArgumentException("Курьер уже занят");
        }
        this.isAvailable = false;
    }
    public void markAvailable(){
        this.isAvailable = true;
    }
}
