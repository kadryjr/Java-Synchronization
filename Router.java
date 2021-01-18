
public class Router {
	
	
	private int size;
	protected Device listofdevices[];
	protected int indexpr= 0;
	private int indexcn= 0;

	Semaphore sem ;
	
	Router(Network net){
		this.size=net.getNumberOfConnections();
		listofdevices=new Device[size];
		sem= new Semaphore(size);
	}
	
	Router(){}
	
	public void produce(Device device) {
	sem.wit();
	listofdevices[indexpr] = device;
	indexpr = (indexpr + 1) % size;
	
	System.out.println("connection "+(indexpr+1)+" ( " + device.getname() + " )" + " Occupied \n");
	device.online(indexpr+1);
	
	}
	
	public void consume(Device device) {
		listofdevices[indexcn]=null;
		sem.post();
		indexcn = (indexcn + 1) % size;
		
	}

}


