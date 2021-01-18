import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int con,dev;
		
	   
		System.out.println("please enter number of connections");
		con=scan.nextInt();
		System.out.println("please enter number of devices");
		dev=scan.nextInt();
		  String[] names= new String[dev];

		Network net=new Network(con,dev,names);
		
		net.setNameOfDevice();
		
		Router router=new Router(net);
		Device[] devarr=new Device[dev];
		for (int i =0;i<dev;i++)
		{
			
			Device device=new Device(net.deviceName(net.getNameOfDevice()[i]),net.deviceType(net.getNameOfDevice()[i]),router);
			devarr[i]=device;
			if(i<con)
			{
				System.out.println(devarr[i].getname()+" "+devarr[i].getType()+" "+"arrived\n");
			}
			else
				System.out.println(devarr[i].getname()+" "+devarr[i].getType()+" "+"arrived and waiting\n");
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			devarr[i].start();
		}
		
	}

}
