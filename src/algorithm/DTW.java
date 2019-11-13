package algorithm;

public class DTW {
	private Trajectory newTrajecotry;
	public double[][] distance;

	public double distPoint(Point p1, Point p2) {
		return Math.sqrt(
				(p1.getX() - p2.getX()) * (p1.getX() - p2.getX()) + (p1.getY() - p2.getY()) * (p1.getY() - p2.getY()));
	}

	public double calculateDTW(Trajectory t1, Trajectory t2) {
		//System.out.println("visit");
		double sum = 0.0;
		//System.out.println(t1.length()+"\t"+t2.length());
		distance = new double[t1.length()][t2.length()];
		for (int i = 0; i < t1.length(); i++) {
			for (int j = 0; j < t2.length(); j++) {
				distance[i][j] = distPoint(t1.getPoints()[i], t2.getPoints()[j]);
			}
		}
		//System.out.println("dtw");
		sum = DTW(t1, t2);
		return sum;
	}

	public double DTW(Trajectory t1, Trajectory t2) {
		//System.out.println("dtw2");
		double sum = 0;
		if (t2.length() == 1) {
			for (int i = 1; i < t1.length(); i++) {
				sum += distance[i][0];
				 return sum;
			}
		} else if (t1.length() == 1) {
			for (int j = 1; j < t2.length(); j++) {
				sum += distance[0][j];
				 return sum;
			}
		}
		
		// System.out.println(distance[t1.length()-1][t2.length()-1]+Math.min(Math.min(DTW(getSubTrajectory(t1),
		// getSubTrajectory(t2)), DTW(t1, getSubTrajectory(t2))),DTW(t2,
		// getSubTrajectory(t1))));
		else
			return distance[t1.length() - 1][t2.length() - 1]
					+ Math.min(Math.min(DTW(getSubTrajectory(t1), getSubTrajectory(t2)), DTW(t1, getSubTrajectory(t2))),
							DTW(t2, getSubTrajectory(t1)));
		return sum;
	}

	public Trajectory getSubTrajectory(Trajectory t) {

		newTrajecotry = new Trajectory();
		Point[] p = new Point[t.getPoints().length - 1];
		for (int i = 0; i < t.getPoints().length - 1; i++)
			p[i] = t.getPoints()[i];
		newTrajecotry.setPoints(p);
		return newTrajecotry;
	}


}
