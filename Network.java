import java.util.Scanner;

public class Network {


	    private int numberOfConnections;
	    private int numberOfDevices;
	    private String[] nameOfDevice = new String [numberOfDevices];

	    public Network(){
	        numberOfConnections = 0;
	        numberOfDevices = 0;
	    }

	    public Network(int numberOfConnections, int numberOfDevices, String[] nameOfDevice) {
	        this.numberOfConnections = numberOfConnections;
	        this.numberOfDevices = numberOfDevices;
	        this.nameOfDevice = nameOfDevice;
	    }

	    public int getNumberOfConnections() {
	        return numberOfConnections;
	    }

	    public void setNumberOfConnections(int numberOfConnections) {
	        this.numberOfConnections = numberOfConnections;
	    }

	    public int getNumberOfDevices() {
	        return numberOfDevices;
	    }

	    public void setNumberOfDevices(int numberOfDevices) {
	        this.numberOfDevices = numberOfDevices;
	    }

	    public String[] getNameOfDevice() {
	        return nameOfDevice;
	    }

	    public void setNameOfDevice() {
	        int number = getNumberOfDevices();
	        for (int i = 0; i < number; i++){
	            Scanner scan = new Scanner(System.in);
	            nameOfDevice[i] = scan.nextLine();
	        }
	    }

	    public String deviceName (String device){
	        String name;
	        int index = device.indexOf(" ");
	        name = device.substring(0,index);
	        return name;
	    }

	    public String deviceType (String device){
	        String type;
	        int index = device.indexOf(" ");
	        type = device.substring(index+1);
	        return type;
	    }
	}

