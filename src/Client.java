public class Client {
    private final String name;
    private final String phone;
    private final Integer id;
    private String address;


    public Client(String clientName, String clientPhone, Integer clientId, String clientAddress){
        if (clientId<=0){
            throw new IllegalArgumentException ("ID клиента должен быть положителен!");
        }
        if (clientName==null||clientName.trim().isEmpty()){
            throw new IllegalArgumentException("Имя клиента не может быть пустым!");
        }
        if (clientPhone==null||clientPhone.trim().isEmpty()){
            throw new IllegalArgumentException("Телефон клиента не может быть пустым!");
        }
        if (clientAddress==null||clientAddress.trim().isEmpty()){
            throw new IllegalArgumentException("Адрес клиента не может быть пустым!");
        }

        this.name = clientName.trim();
        this.phone = clientPhone.trim();
        this.id = clientId;
        this.address = clientAddress.trim();
    }
    public String getName(){
        return name;
    }
    public String getPhone(){
        return phone;
    }
    public Integer getId(){
        return id;
    }
    public String getAddress(){
        return address;
    }
    public void changeAddress(String newAddress){
        if (newAddress==null||newAddress.trim().isEmpty()){
            throw new IllegalArgumentException("Адрес клиента не может быть пустым!");
        }
        address = newAddress.trim();
    }
}
