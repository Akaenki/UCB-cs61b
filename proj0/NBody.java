public class NBody{
	/** Read radius of the Universe */
	public static double readRadius(String filename) {
		In in = new In(filename);
		int N = in.readInt();
		double Radius = in.readDouble();
		return Radius;
	}
	
	/** Read the planet information */
	public static Planet[] readPlanets(String filename) {
		In in = new In(filename);
		int N = in.readInt();
		Planet[] p = new Planet[N];
		double Radius = in.readDouble();
		for(int i = 0; i<N; i++) {
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();
			p[i] = new Planet(xP,yP,xV,yV,m,img);
		}
		return p;
	}
	
	public static void main(String[] args) {
		/* read cmd line inputs */
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		
		/* read universe information from file */
		double r = readRadius(filename);
		Planet[] ps = readPlanets(filename);
		
		/* Draw Backgroudn */
		StdDraw.enableDoubleBuffering();
		
		StdDraw.setScale(-r,r);
		StdDraw.clear();
		StdDraw.picture(0,0,"./images/starfield.jpg");
		for(Planet p : ps) {
			p.draw();
		}
		
		for(double t = 0.0; t<=T; t+=dt) {
			double[] xForces = new double[ps.length];
			double[] yForces = new double[ps.length];
			for(int i = 0; i<ps.length; i++) {
				xForces[i] = ps[i].calcNetForceExertedByX(ps);
				yForces[i] = ps[i].calcNetForceExertedByY(ps);
			}
			
			for(int i=0; i<ps.length; i++) {
				ps[i].update(dt,xForces[i],yForces[i]);
			}
			
			StdDraw.picture(0,0,"./images/starfield.jpg");
			for(Planet p : ps) {
				p.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
		}
	}
}
