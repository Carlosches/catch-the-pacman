package userInterface;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Window;
import model.Game;
import model.PacMan;
import threads.PacThread;

public class PacManController {


    @FXML
    private MenuBar menuBar;

    @FXML
    private Pane pane;
    
    @FXML
    private Menu file;
    
    @FXML
    private Label bouncesNumber;
    
    private Game game;
    
    private List<PacThread> threads;
    
    

    

    
    private Window w;
    
    @FXML
    private GridPane squareOfFame;
   
    
    @FXML
    public void initialize() {
    	try {
			game = new Game();
		} catch (FileNotFoundException e) {
			//
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
    	
    	threads = new ArrayList<PacThread>();
    	
    	
    	 squareOfFame = new GridPane();
    	
    
    }
    
    
    @FXML
    void loadSavedGame(ActionEvent event) {
   
    	for (int i = 0; i < threads.size(); i++) {
    		pane.getChildren().remove(threads.get(i).getPacMan());
    		pane.getChildren().remove(threads.get(i).getEye());
    		
    		threads.get(i).desactive();
		}
    	
    	
    	pane.getChildren().clear();
    	game.getPacMans().clear();
    
    	threads.clear();
   
    	
    	try {
			game.loadGame("data/savedGame.txt", " ");
		} catch (IOException e) {
		
			e.printStackTrace();
		}
    	
    	createPacMans(game.getPacMans());
    	catchPac();
    	for(int i=0; i<threads.size(); i++) {
    		threads.get(i).start();
    	}
     	
    	int bouncesTotal = 0;
    	for (int i = 0; i < game.getPacMans().size(); i++) {
			bouncesTotal += game.getPacMans().get(i).getBounces(); 
		}
    	bouncesNumber.setText("" + bouncesTotal);
    	
    }
    
    @FXML
    void level0(ActionEvent event) {
    	
    	for (int i = 0; i < threads.size(); i++) {
    		pane.getChildren().remove(threads.get(i).getPacMan());
    		pane.getChildren().remove(threads.get(i).getEye());
    		
    		threads.get(i).desactive();
		}
    	
    	
    	bouncesNumber.setText("0");
    	pane.getChildren().clear();
    	game.getPacMans().clear();
    	
    	threads.clear();
    	
    	try {
			game.loadGame("data/levelZero.txt", " ");
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	createPacMans(game.getPacMans());
    	catchPac();
    	for(int i=0; i<threads.size(); i++) {
    		threads.get(i).start();
    		
   
    	}
    	
    
    	
    }

    

	@FXML
    void level1(ActionEvent event)  {
		
		for (int i = 0; i < threads.size(); i++) {
    		pane.getChildren().remove(threads.get(i).getPacMan());
    		pane.getChildren().remove(threads.get(i).getEye());
    		
    		threads.get(i).desactive();
		}
    	
		
		bouncesNumber.setText("0");
    	pane.getChildren().clear();
    	game.getPacMans().clear();
    	
    	threads.clear();
    	
    	try {
			game.loadGame("data/levelOne.txt", " ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	createPacMans(game.getPacMans());
    	catchPac();
    	for(int i=0; i<threads.size(); i++) {
    		threads.get(i).start();
   
    	}
    }

    @FXML
    void level2(ActionEvent event) {
    
    	for (int i = 0; i < threads.size(); i++) {
    		pane.getChildren().remove(threads.get(i).getPacMan());
    		pane.getChildren().remove(threads.get(i).getEye());
    		
    		threads.get(i).desactive();
		}
    	
    	
    	bouncesNumber.setText("0");
    	pane.getChildren().clear();
    	
    	game.getPacMans().clear();
    	
    	threads.clear();
    	try {
			game.loadGame("data/levelTwo.txt", " ");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	createPacMans(game.getPacMans());
    	catchPac();
    	for(int i=0; i<threads.size(); i++) {
    		threads.get(i).start();
   
    	}
    }

    
    
    
    
    public void createPacMans(List<PacMan> pacM) {
    	
    	
    	for(int i=0; i<pacM.size(); i++) {
    		double radius = pacM.get(i).getRadius();
    		double x =  pacM.get(i).getPosX();
    		double y = pacM.get(i).getPosY();
    		boolean stop = pacM.get(i).isState();
    		
    		if(!stop) {
    			
    			
    			
    			Arc arc1 = new Arc(x, y, radius, radius, 45, 270);
    			
    			arc1.setStroke(Color.BLACK);
    		
    			x = x+5;
    			y = y -(radius/2);
    					
    			Circle c1 = new Circle(x, y, 5);
    		
    			
    			arc1.setType(ArcType.ROUND);
    			arc1.setFill(Color.YELLOW);
    			
    			PacThread pacT = new PacThread(pacM.get(i), this, arc1, c1);
    			threads.add(pacT);
    			
    			
    			pane.getChildren().add(arc1);
    			pane.getChildren().add(c1);
    		}


    	}
    	
    	
    }	
    
    public void movePacMans(Arc ar , Circle cir, PacMan pacD) {
   
    		
	
    		if(pacD.getDirection().equals(PacMan.LEFT) ) {
    			
    			
    			ar.setCenterX(ar.getCenterX()-10);
        		cir.setCenterX(cir.getCenterX()-10);
        		pacD.setPosX(ar.getCenterX());
    	   	
        		if(ar.getCenterX() - ar.getRadiusX() <= 0 || collidePacmans(ar, cir)) {
    	    		pacD.setDirection(PacMan.RIGHT);
    	    		int boun = Integer.parseInt(bouncesNumber.getText());
    	    		boun++;
    	    		bouncesNumber.setText("" + boun);
    	    		pacD.setBounces(pacD.getBounces()+1);
    	    		
    	    	}
    	    		
    	    	
    		}else if(pacD.getDirection().equals(PacMan.RIGHT)) {
    			ar.setCenterX(ar.getCenterX()+10);
    			cir.setCenterX(cir.getCenterX()+10);
    			pacD.setPosX(ar.getCenterX());
    		
    			
    			if((ar.getCenterX()) >= w.getWidth() - ar.getRadiusX() || collidePacmans(ar, cir) ) {
    				pacD.setDirection(PacMan.LEFT);	
    				int boun = Integer.parseInt(bouncesNumber.getText());
    				boun++;
    	    		bouncesNumber.setText("" + boun);
    	    		pacD.setBounces(pacD.getBounces()+1);
    			}
    	    		
    			
    		}else if(pacD.getDirection().equals(PacMan.UP) ) {
    			
    			ar.setCenterY(ar.getCenterY()-10);
    			cir.setCenterY(cir.getCenterY()-10);
    			pacD.setPosY(ar.getCenterY());
    			
    			if((ar.getCenterY() - ar.getRadiusY()) <= 0 || collidePacmans(ar, cir)) {
    				pacD.setDirection(PacMan.DOWN);
    				int boun = Integer.parseInt(bouncesNumber.getText());
    				boun++;
    	    		bouncesNumber.setText("" + boun);
    	    		pacD.setBounces(pacD.getBounces()+1);
    	    	}
    	    		
    			
    		}else {
    			
    			ar.setCenterY(ar.getCenterY()+10);
    			cir.setCenterY(cir.getCenterY()+10);
    			pacD.setPosY(ar.getCenterY());
    			
    			if(ar.getCenterY() >= w.getHeight() - (ar.getRadiusX()*2)|| collidePacmans(ar, cir)) {
    				pacD.setDirection(PacMan.UP);
    				int boun = Integer.parseInt(bouncesNumber.getText());
    				boun++;
    	    		bouncesNumber.setText("" + boun);
    	    		pacD.setBounces(pacD.getBounces()+1);
    	    	}
    	    		
    		}
    		
    } 
    
    
    
    public boolean collidePacmans(Arc arc, Circle cir) {
    	
    	boolean collision = false;
    	
    	for(int i=0; i<threads.size();i++){
    		
    			double cx2 = arc.getCenterX();
    			double cy2 = arc.getCenterY();
    			double radi2 = arc.getRadiusX();
    			double cx1 = threads.get(i).getPacMan().getCenterX();
    			double cy1 = threads.get(i).getPacMan().getCenterY();
    			double radi1 = threads.get(i).getPacMan().getRadiusX();
    			
    			double distance = Math.sqrt((cx1-cx2)*(cx1-cx2)+(cy1-cy2)*(cy1-cy2));
    			
    			if(distance <= radi1+radi2 && threads.get(i).isActive() && !arc.equals(threads.get(i).getPacMan())) {
    				
    				if(threads.get(i).getPac().getDirection().equals(PacMan.RIGHT) ) {
    					threads.get(i).getPac().setDirection(PacMan.LEFT);
    				}else if(threads.get(i).getPac().getDirection().equals(PacMan.LEFT) ) {
    					threads.get(i).getPac().setDirection(PacMan.RIGHT);
    				}else if(threads.get(i).getPac().getDirection().equals(PacMan.UP)) {
    					threads.get(i).getPac().setDirection(PacMan.DOWN);
    				}else {
    					threads.get(i).getPac().setDirection(PacMan.UP);
    				}
    				collision = true;
    				
    			}
    			}
    			
    		
    		
    	
    		
    	
    	return collision;
    	}
    
    
    
    
    public void catchPac(){
    	
    	
    	for(int i=0; i<threads.size(); i++) {
    		
    		Text ite = new Text("" + i);
    		threads.get(i).getPacMan().setOnMouseClicked(new EventHandler<MouseEvent>() {
    			
    			
				@Override
				public void handle(MouseEvent arg0) {
					threads.get(Integer.parseInt(ite.getText())).getPac().setState(true);
					threads.get(Integer.parseInt(ite.getText())).desactive();
					threads.get(Integer.parseInt(ite.getText())).getPacMan().setVisible(false);
					threads.get(Integer.parseInt(ite.getText())).getEye().setVisible(false);
					
					if(game.getLevel() == 0) {
						compareScore(game.getScore().getHallOfFame0());
					}else if(game.getLevel() == 1) {
						compareScore(game.getScore().getHallOfFame1());
					}else {
						compareScore(game.getScore().getHallOfFame2());
					}
					
					}
				
    		});
    		
    		
    	}
    	
    		
    }
    
    
    @FXML
    void viewScores(ActionEvent event) {
    	pane.getChildren().clear();
    	GridPane grid = new GridPane();
    	int i =0;
    	
    	if(game.getLevel() ==0) {
	    	for(Map.Entry<Integer, String> entry : game.getScore().getHallOfFame0().entrySet()) {
	    		
	    		
	    			Label name = new Label(entry.getValue());
	    			Label score = new Label("" + entry.getKey());
	    			
	    			name.setPrefWidth(200);
	    			grid.add(name, 0, i);
	    			grid.add(score, 1, i);
	    		
	    			i++;
	    		}
    	}else if(game.getLevel() == 1) {
    		for(Map.Entry<Integer, String> entry : game.getScore().getHallOfFame1().entrySet()) {
	    		
	    		
    			Label name = new Label(entry.getValue());
    			Label score = new Label("" + entry.getKey());
    			
    			name.setPrefWidth(200);
    			grid.add(name, 0, i);
    			grid.add(score, 1, i);
    		
    			i++;
    		}
    	}else {
    		for(Map.Entry<Integer, String> entry : game.getScore().getHallOfFame2().entrySet()) {
	    		
	    		
    			Label name = new Label(entry.getValue());
    			Label score = new Label("" + entry.getKey());
    			
    			name.setPrefWidth(200);
    			grid.add(name, 0, i);
    			grid.add(score, 1, i);
    		
    			i++;
    		}
    	}
    	grid.setLayoutY(300);
    	grid.setLayoutX(200);
    	if(squareOfFame!= null)
    		pane.getChildren().remove(squareOfFame);
    pane.getChildren().add(grid);
    squareOfFame = grid;
    }



    @FXML
    void saveGame(ActionEvent event) {
    	try {
			game.saveGame("data/savedgame.txt");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
    }


    public void compareScore(Map<Integer, String> scores) {
    	
    	boolean exit = true;
		for(int i=0; i<threads.size(); i++) {
			if(threads.get(i).isActive()) {
				exit = false;
			}
		}
	
	
	if(exit) {
	
		int less = Integer.parseInt(bouncesNumber.getText());
		int lastKey = 0;
		boolean better = false;
		if(scores.size()==0) {
			better = true;
		}
		else {
			for(Map.Entry<Integer, String> entry : scores.entrySet()) {
			
				if(less < entry.getKey() || entry.getKey() == 0 || scores.size() < 10) {
					better = true;
					
				}
				lastKey = entry.getKey();
			}
		}
		if(better) {
			
			TextField name = new TextField();
			name.setPromptText("Enter your name");
			
			int k = lastKey;
			Button b = new Button("Add score");
			b.setLayoutX(350);
			pane.getChildren().add(name);
			pane.getChildren().add(b);
			b.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					if(scores.size() >= 10) {
						scores.remove(k);
						scores.put(less, name.getText());
					}else {
						scores.put(less, name.getText());
					}
					viewScores(null);
					
				}
				
				
			});
			
		}
		

	}
	}
	



    

	
	public void onCloseRequest() throws InterruptedException {
		try {
			game.saveScore();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("finalizing threads...");
    	for(int i=0; i<threads.size(); i++) {
    		threads.get(i).desactive();
    		threads.get(i).join();
    	}
    	System.out.println("Threads finalized!");
	}
	
						
	public void setWindow(Window n) {
		w = n;
	}

	
	
    
    
    

}
