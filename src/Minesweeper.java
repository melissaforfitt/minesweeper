import java.util.Random;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Minesweeper extends Application {

	private Random rand = new Random();
	private Rectangle r[][] = new Rectangle[10][10];
	private Group group = new Group();

	public void buildGrid() {

		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {

				r[x][y] = new Rectangle();
				r[x][y].setWidth(25);
				r[x][y].setHeight(25);
				r[x][y].setX(25 * x);
				r[x][y].setY(25 * y);
				r[x][y].setFill(Color.BLACK);
				r[x][y].setStrokeWidth(1);
				r[x][y].setStroke(Color.RED);
				group.getChildren().addAll(r[x][y]);

			}
		}
	}

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

		Scene scene = new Scene(group, 250, 250);

		buildGrid();

		// Get computer to set mine locations
		int[][] mines = new int[3][3];
		boolean[][] mine = new boolean[10][10];

		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				mines[x][y] = mines[setMineX()][setMineY()];
				mine[x][y] = true;
			}
		}
		System.out.println(mines[1][1]);

		// Check if user has clicked on a mine
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				int i = x;
				int j = y;

				r[x][y].setOnMouseClicked(event -> {

					if (mine[i][j] = true) {
						Text text = new Text("X");
						text.setFill(Color.RED);
						group.getChildren().add(text);
						System.out.println("Game is over. You found a mine.");
					} else {
						Text text = new Text("X");
						text.setFill(Color.RED);
						group.getChildren().addAll(text);
					}
				});
			}

			// Add everything to stage
			primaryStage.setTitle("Minesweeper");
			primaryStage.setScene(scene);
			primaryStage.show();
		}
	}

	public static void main(String[] args) {

		launch(args);

	}
}
