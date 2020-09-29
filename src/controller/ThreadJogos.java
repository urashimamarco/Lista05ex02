package controller;
import java.text.DecimalFormat;
import java.util.concurrent.Semaphore;

public class ThreadJogos extends Thread {

	private int idPrato;
	private Semaphore semaforo;
	private double cozimento = 0.0;
	private static int posPrato;
	private double porcentagem = 0;
	
	DecimalFormat f = new DecimalFormat("0.00");

	public ThreadJogos(int idPrato, Semaphore semaforo) {

		this.idPrato = idPrato;
		this.semaforo = semaforo;
	}

	public void run () {

		preparaPrato();
		try {
			semaforo.acquire();
			pratoPronto();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}



	}

	public void preparaPrato() {

		if (idPrato % 2 != 0) {
			cozimento = ((Math.random() * 801) + 500);
			porcentagem = 10000 / cozimento;
		} else {
			cozimento = ((Math.random() * 1201) + 600);
			porcentagem = 10000 / cozimento;
		}
		try {
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		posPrato++;
		System.out.println("#" + idPrato + "| Começou ");
		while (porcentagem < 100) {
				porcentagem+=porcentagem;
				System.out.println("#" + idPrato + "| está em " + f.format(porcentagem) + "%");
			}
		}

	public void pratoPronto() {

	}
}