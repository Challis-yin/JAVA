package Õº–ŒΩÁ√Ê¡∑œ∞;



public class main {
	PaintThread a = new PaintThread();
	public  main () {
		new Thread(new PaintThread()).start();
		
	}

	
		} class PaintThread implements Runnable{

		public void run() {
			ClientUI ui = new ClientUI();  
	        ui.initFrame();  
			}
		}
