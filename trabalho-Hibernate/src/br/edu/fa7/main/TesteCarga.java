package br.edu.fa7.main;

public class TesteCarga implements Runnable {

	public static void main(String[] args) throws Exception {

		for (int i = 0; i < 5; i++) {
			(new Thread() {
				public void run() {
					while (true) {
						try {
							Thread teste = new ThreadCarga();

							teste.run();
						} catch (Exception e) {

							e.printStackTrace();
						}
					}
				}
			}).start();
		}
	}

	@Override
	public void run() {

		Thread teste = new ThreadCarga();
		teste.setName("Carga1");
		Thread testeRunnable = new Thread(new TesteCarga());

		testeRunnable.start();
		teste.start();

	}

}
