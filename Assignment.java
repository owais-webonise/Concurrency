import java.util.*;


public class Assignment {
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
public static void main(String args[]){
	System.out.println("Time to load books in cart :-" + cart_load() + "Sec");
	System.out.println("Time to travel one way :-" + time_travel() + "Sec");
	System.out.println("Time to unload cart :-" + cart_load() + "Sec");
	System.out.println("Time to burn 3 books :-" + burn() + "Sec");
	System.out.println("Time to travel other way :-" + time_travel() + "Sec");
	System.out.println("Enter total books you want to burn" );
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	//int n=50;
	int i=n/5;
	int j=i;
	int total=0;
	while (j-- > 0){
		total = total + cart_load()+time_travel()+cart_load()+time_travel();
	}
	int total1=i*2;
	int total2;
	if (total1%3 == 0){
		total2=total1/3;
	}
	else
	{
		total2=total1/3 + 1;
	}
	//System.out.println("Total"+total+" + "+total1+"+ "+total2);
	total= total + total2* burn();
System.out.println("Total Time is :-" + total + "Sec");	
}
}
