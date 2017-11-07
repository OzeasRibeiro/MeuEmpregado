package br.com.facear.testes;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import org.junit.Test;


public class TesteTimer extends TimerTask{

	@Test
	public void main() {
		Calendar date = Calendar.getInstance();
		Timer timer = new Timer();
	    
		
	    date.set(Calendar.DAY_OF_MONTH, 1);
	    date.set(Calendar.HOUR, 0);
	    date.set(Calendar.MINUTE, 1);
	    date.set(Calendar.SECOND, 0);
	    
	    
	    timer.schedule(
	      new TesteTimer(),
	      date.getTime(),
	      1000 * 60 * 60 * 24
	    );
	    System.out.println("Thread started at");
	    System.out.println(date.getTime());
	}

	@Override
	public void run() {
		System.out.println("aa");
	}
}
