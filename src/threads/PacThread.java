package threads;

import javafx.application.Platform;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import model.PacMan;
import userInterface.PacManController;

public class PacThread extends Thread {

		private PacMan pac;
		private PacManController pControl;

		private boolean active;
		private Arc pacMan;
		private Circle eye;
		
		public PacThread(PacMan pa, PacManController pacM, Arc ar, Circle e) {
			pac = pa;
			pControl = pacM;
			pacMan = ar;
			eye = e;
			active = !pa.isState();
		}
	
		
		@Override
		public void run() {
			while(active) {
				
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					pControl.movePacMans(pacMan, eye, pac);
					
				}
				
			});
	
					try {
						sleep(pac.getWaitTime());
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				
			
				
			}
			
		}
		
		public void desactive() {
			active = false;
		}


		public PacMan getPac() {
			return pac;
		}


		public boolean isActive() {
			return active;
		}


		public Arc getPacMan() {
			return pacMan;
		}




		public Circle getEye() {
			return eye;
		}


		
		
		
		
		
		
}
