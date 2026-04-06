
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Owner extends User {
    private String vehicleID;
    private String vehicleModel;
    private String vehicleMake;
    private int vehicleYear;
    private String arrivalTime;
    private String departureTime;

    public Owner(String ownerID, String vehicleID, String vehicleModel, String vehicleMake,
                 int vehicleYear, String arrivalTime, String departureTime) {
        super(ownerID);
        this.vehicleID = vehicleID;
        this.vehicleModel = vehicleModel;
        this.vehicleMake = vehicleMake;
        this.vehicleYear = vehicleYear;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public String getVehicleID()    { return vehicleID; }
    public String getVehicleModel() { return vehicleModel; }
    public String getVehicleMake()  { return vehicleMake; }
    public int getVehicleYear()     { return vehicleYear; }
    public String getArrivalTime()  { return arrivalTime; }
    public String getDepartureTime(){ return departureTime; }

    @Override
    public String fileText() {
        return "Owner ID: " + ID +
               " | Timestamp: " + time +
               " | Vehicle ID: " + vehicleID +
               " | Vehicle Model: " + vehicleModel +
               " | Vehicle Make: " + vehicleMake +
               " | Vehicle Year: " + vehicleYear +
               " | Arrival Time: " + arrivalTime +
               " | Departure Time: " + departureTime;
    }

    // SOCKET METHOD 
    public String sendVehicleInfo(String host, int port) {
        try (Socket socket = new Socket(host, port);
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
             DataInputStream dis = new DataInputStream(socket.getInputStream())) {

            String data = fileText();

            // send data
            dos.writeUTF(data);
            dos.flush();

            // receive response
            String message = dis.readUTF();
            System.out.println("Message: " + message);

            String result = dis.readUTF();
            System.out.println("Result: " + result);

            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR";
        }
    } 


}

