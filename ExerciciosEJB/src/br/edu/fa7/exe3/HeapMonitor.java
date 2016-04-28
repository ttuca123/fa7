package br.edu.fa7.exe3;

import javax.ejb.Remote;

@Remote
public interface HeapMonitor {

	public void getEstatistica();
}
