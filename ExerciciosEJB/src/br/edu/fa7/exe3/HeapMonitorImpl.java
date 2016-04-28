package br.edu.fa7.exe3;

import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless(name = "HeapMonitor")
@LocalBean
public class HeapMonitorImpl implements HeapMonitor {

	@Schedule(minute = "*", hour="*")
	@Override
	public void getEstatistica() {
		System.out.println("Executando  schedule");
	}

}
