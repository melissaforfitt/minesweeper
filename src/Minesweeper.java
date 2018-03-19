import java.util.Random;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Minesweeper extends Application {

	Random rand = new Random();

	public int setMineX() {

		int randX = rand.nextInt(9) + 0;

		return randX;

	}

	public int setMineY() {

		int randY = rand.nextInt(9) + 0;

		return randY;

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Group group = new Group();
		Scene scene = new Scene(group, 250, 250);
		Rectangle r = new Rectangle();

		// Create board
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {

				r.setX(25 * x);
				r.setY(25 * y);
				r.setWidth(25);
				r.setHeight(25);
				r.setFill(Color.BLACK);
				r.setStrokeWidth(1);
				r.setStroke(Color.RED);
				group.getChildren().add(r);

			}
		}

		// Get computer to set mine locations
		int[][] mines = new int[10][10];
		boolean[][] mine = new boolean[10][10];

		for (int x = 0; x < rand.nextInt(9); x++) {
			for (int y = 0; y < rand.nextInt(9); y++) {
				mines[x][y] = mines[setMineX()][setMineY()];
				mine[x][y] = true;
			}
		}

		// Check if user has clicked on a mine
		r.setOnMouseClicked(event -> {

			if (mine[(int) r.getX()][(int) r.getY()] = true) {
				System.out.println("Game is over. You found a mine.");
			} else {
				Text text = new Text("X");
				double a = r.getX();
				double b = r.getY();
				text.setX(a);
				text.setY(b);
				text.setFill(Color.RED);
				//group.getChildren().add(text);
			}
		});

		primaryStage.setTitle("Minesweeper");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {

		launch(args);

	}

}
