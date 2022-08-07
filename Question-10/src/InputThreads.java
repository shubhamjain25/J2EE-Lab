public class InputThreads {
    public static void main(String[] args) throws InterruptedException{
    	
    	GetStringThread getStringThread = new GetStringThread();
    	GetNumberThread getNumberThread = new GetNumberThread();
    
    	getStringThread.start();
    	Thread.sleep(1000);
    	getNumberThread.start();
    
    }
}