import java.util.concurrent.TimeUnit;

public class Device extends Thread {
	private String name ;
	private String type ;
	
	Router router;

	public String getname() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	

	void connect(int num) {
		router.produce(this);


		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	void online(int num) {
		System.out.println("connection "+num+"( " + name + " )" + " perform online activity\n");

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void logout() {
		System.out.println("( " + name + " )" + " (" + type +") logged out \n" );
		router.consume(this);

	}
	Device (String n , String t,Router r) {
		name = n; 
		type = t;
		this.router=r;
	}
	
	public void run() {
		connect(router.indexpr+1);
		logout();
		
	}
}