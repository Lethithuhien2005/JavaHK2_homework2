package Exercise_MutiThreading;

public class MyThread extends Thread{
	  int start;

	  public MyThread(int s){
	   start =s;	
	   }
	  public synchronized static void go(int s){
		  for(int i = s;i<10;i+=2){
	         System.out.print(i+"  ");
	         try{
	        	 Thread.sleep(100);
	         }catch(Exception e){}
		  }
	  }
		   public void run(){
		      go(start);
		 }
}
