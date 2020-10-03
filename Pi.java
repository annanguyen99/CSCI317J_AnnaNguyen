/**
 * Pi Simulation class
 * @author Anna Nguyen
 *
 */
public class Pi {
	//the number of darts in a game
	private int n_total;
	//the number of games
	private int num_game;
	private double mean;
	private double radius =  0.5;

	/**
	 * Constructor
	 * @param game the number of game
	 * @param n_total the number of darts per game
	 */
	public Pi(int game, int n_total) {
		this.num_game = game;
		this.n_total = n_total;

		double[] score_array = this.throwDart();

		this.mean = this.doMean(score_array);
		System.out.println("Average pi result: " + this.mean);

		System.out.println("Standard deviation: " + this.standardDev(score_array));



	}
	public static void main(String[] args) {
		int g = Integer.parseInt(args[0]);
		int n= Integer.parseInt(args[1]);
		Pi p = new Pi(g, n);
	}

	/**
	 * Throw dart method 
	 * @return a list contain of distance from the dart to the
	 * center of the circle
	 */
	public double[] throwDart() {
		double[] result_array = new double[this.num_game];;
		for (int i = 0; i <this.num_game ; i++) {
			int n_inside = 0;
			for(int j = this.n_total; j> 0; j--) {
				double x =  (Math.random() - 0.5);
				double y =  (Math.random() - 0.5);
				double d = Math.sqrt(x*x + y*y);
				if(d < this.radius) {
					n_inside++;
				}
			}
			double result = (4 * ((double) n_inside/this.n_total));
			result_array[i] = result;
		}
		return result_array;		
	}

	/**
	 * 
	 * @param score_array the array list contains the distance between 
	 * the dart and the center of the circle
	 * @return the mean between all the distance
	 */
	public double doMean(double[] score_array) {
		double sum = 0; 
		for(double k: score_array) {
			sum = sum + k;
		}
		double mean_pi = sum/this.num_game;
		return mean_pi;
	}

	/**
	 * Method to calculate the standard deviation
	 * @param score_array the array list contains the distance between
	 * the dart and the center of the circle
	 * @return the standard deviation
	 */
	public double standardDev(double[] score_array) {
		double[] mean_array = new double[this.num_game];
		for(int h = 0; h < this.num_game; h++) {
			mean_array[h] = (score_array[h] - this.mean) * (score_array[h] - this.mean);
		}
		double s = 0; 
		for(double o: mean_array) {
			s = s + o;
		}
		double mean_dev = s/this.num_game;
		double dev = Math.sqrt(mean_dev);
		return dev;
	}


}
