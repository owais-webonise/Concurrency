import java.util.*;



public class Assignment_Concurrent{
	public static int cart_load()
	{
		return 10;
	}

	public static int time_travel(){
		return 30;
	}

	public static int burn(){
		return 20;
	}




	protected static int total=0;
	protected static int total1=0;
	protected static int final_total=0;
	protected static int total2;
	

	
	public static void main(String args[]){
		System.out.println("Time to load books in cart :" + cart_load() + "Sec");
		System.out.println("Time to travel one way :" + time_travel() + "Sec");
		System.out.println("Time to unload cart :" + cart_load() + "Sec");
		System.out.println("Time to burn 3 books :" + burn() + "Sec");
		System.out.println("Time to travel other way :" + time_travel() + "Sec");
		System.out.println("Enter total books you want to burn" );
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int count=1;
		 Thread t1 = new Thread(
                 new Runnable() {
                     public void run () {
                         // Add T1 -- Load cart
                    	 int thread_total1=0;
                    	 thread_total1=thread_total1+ cart_load();
                    	total+=thread_total1;
                  
                    	System.out.println("1 : "+thread_total1);
                    	System.out.println("Total 1 : "+total);
                     }
                   
                  }
              
    );
		 
		 Thread t2 = new Thread(
                 new Runnable() {
                     public void run () {
                         // Add T2 --One way travel
                    	 int thread_total2=0;
                    	 thread_total2=thread_total2+ time_travel();
                    	 total+=thread_total2;
                    	 total1+=thread_total2;
                    	 System.out.println("2 : "+thread_total2);
                    	 System.out.println("Total 2 : "+total);
                     }
                   
                  }
              
    );
		 Thread t3 = new Thread(
                 new Runnable() {
                     public void run () {
                         // Add T3 -- UnLoad cart
                    	 int thread_total3=0;
                    	 thread_total3=thread_total3+ cart_load();
              
                    
                     }
                  }
    );
		 Thread t4 = new Thread(
                 new Runnable() {
                     public void run () {
                         // Add T4 --Other way travel
                    	 int thread_total4=0;
                    	 thread_total4=thread_total4+ time_travel();
                    	
                     }
                   
                  }
              
    );
		 
			int i=n/5;
			int j=i;
			while (j-- > 0){
	
		 if (count==1){
			t1.start();
			try{
	  			t1.join();	//Waiting for t1 to finish
			}catch(InterruptedException ie){}
			t2.start();
			//t4.start();
			try{
	  			t2.join();	//Waiting for t2 to finish
			}catch(InterruptedException ie){}
			t3.start();
			try{
	  			t3.join();	//Waiting for t3 to finish
			}catch(InterruptedException ie){}
			t4.start();
			try{
	  			t4.join();	//Waiting for t4 to finish
			}catch(InterruptedException ie){}
			System.out.println(total);
			final_total+=total;
			count++;
		 }
		 
		 else{
		 t1 = new Thread(); 
		 t2= new Thread();
	       
		
				t1.start();
					try{
		  			t1.join();	//Waiting for t1 to finish
				}catch(InterruptedException ie){}
			
				try{
		  			t2.join();	//Waiting for t2 to finish
				}catch(InterruptedException ie){} 
				//System.out.println(total1);
			   final_total= final_total+total1;
		
		 }
			}
			 //System.out.println(total2);
			//final_total= final_total + total2* burn();
			 System.out.println(final_total);
			
	
			}
	
}



