import java.util.*;
import java.lang.*;

class Threads extends Thread{
	String name="";
	Semaphore s=null;
	Threads(String n , Semaphore s){
		this.name=n;
		this.s=s;
	}
@Override
public void run() {
	s.P(name);
	int rand =(int)(Math.random()*1000+1);
	try {
		Thread.sleep(rand);
	}
	catch(InterruptedException e) {
		e.printStackTrace();
	}
	System.out.println(name+":"+"occupied");
	///////////////////////////////////////////////////////////////////////////
	 rand =(int)(Math.random()*1000+1);
	try {
		Thread.sleep(rand);
	}
	catch(InterruptedException e) {
		e.printStackTrace();
	}
	System.out.println(name+":"+"being served");
      rand =(int)(Math.random()*1000+1);
	try {
		Thread.sleep(rand);
	}
	catch(InterruptedException e) {
		e.printStackTrace();
	}
	System.out.println(name+":"+"paying");
	 rand =(int)(Math.random()*1000+1);
	try {
		Thread.sleep(rand);
	}
	catch(InterruptedException e) {
		e.printStackTrace();
	}
	System.out.println(name+":"+"leave");
	
	s.V();
	
}
	
}
class Semaphore{
	protected int value=0;
	protected Semaphore(int initial){
		value=initial;
	}
	protected Semaphore(){
		value=0;
	}
	public synchronized void P(String name) {
		value--;
		if (value<0) {
			try{
				System.out.println(name+":"+"Arrived and Waiting");
				wait();}
			catch(InterruptedException e) {}}
		else {
			System.out.println(name+":"+"Arrived");
		}
	}
	public synchronized void V() {
		value++;
		if(value<=0 ) {
			notify();
		}
			
	}
}



public class PetrolStation {
	public void PetrolStation() {
		ArrayList<Threads>clients=new ArrayList<Threads>();
	Scanner scan=new Scanner(System.in);
	System.out.println("What is the number of pumps? ");
	int n=scan.nextInt();
	Semaphore s= new Semaphore(n);
	System.out.println("Number of Clients : ");
	int nc=scan.nextInt();
	System.out.println("Client's names ");
	ArrayList<String>cnames= new ArrayList<String>();
	String v=scan.nextLine();
    for(int i=0 ; i<nc; i++) {
		v=scan.nextLine();
		cnames.add(v);
		}
	for(int i=0 ; i<nc ; i++) {
		Threads x=new Threads(cnames.get(i),s);
		clients.add(x);
	}
	for(int i=0 ; i<nc ; i++) {
		clients.get(i).start();
	}
	
	}
	public static void main(String[] args) {
	
		PetrolStation obj=new PetrolStation();
		obj.PetrolStation();
}
	}
