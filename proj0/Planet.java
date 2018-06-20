public class Planet {
	public double xxPos, yyPos, xxVel, yyVel, mass;
	public String imgFileName;
	private static double grav_const = 6.67e-11;
	
	/** Constructor */
	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP; yyPos = yP;
		xxVel = xV; yyVel = yV;
		mass = m; 
		imgFileName = img;
	}
	
	/** Constructor take in a Planet object and initialize an indentical object
	 *  Like a copy constructor in C++
	 */
	public Planet(Planet p) {
		xxPos = p.xxPos; yyPos = p.yyPos;
		xxVel = p.xxVel; yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}
	
	public double calcDistance(Planet p) {
		double dx = this.xxPos - p.xxPos;
		double dy = this.yyPos - p.yyPos;
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	public double calcForceExertedBy(Planet p) {
		double rr = this.calcDistance(p)*this.calcDistance(p);
		return grav_const*this.mass*p.mass/rr;
	}
	
	public double calcForceExertedByX(Planet p) {
		double dx = - this.xxPos + p.xxPos;
		return this.calcForceExertedBy(p)*dx/this.calcDistance(p);
	}
	
	public double calcForceExertedByY(Planet p) {
		double dy = - this.yyPos + p.yyPos;
		return this.calcForceExertedBy(p)*dy/this.calcDistance(p);
	}
	
	public double calcNetForceExertedByX(Planet[] allp) {
		double Fnet = 0;
		for(Planet p : allp) { //Skip the targe planet (dist = 0)
			if(this.calcDistance(p)<1e-8) {
				continue;
			}
			Fnet += this.calcForceExertedByX(p);
		}
		return Fnet;
	}
	
	public double calcNetForceExertedByY(Planet[] allp) {
		double Fnet = 0;
		for(Planet p : allp) { //Skip the targe planet (dist = 0)
			if(this.calcDistance(p)<1e-8) {
				continue;
			}
			Fnet += this.calcForceExertedByY(p);
		}
		return Fnet;
	}
	
	/** Update the velocity and position of a planet */
	public void update(double dt, double fX, double fY) {
		this.xxVel += dt * fX/this.mass;
		this.yyVel += dt * fY/this.mass;
		this.xxPos += dt * this.xxVel;
		this.yyPos += dt * this.yyVel;
	}
	
	public void draw() {
		String img = "./images/"+this.imgFileName;
		StdDraw.picture(this.xxPos,this.yyPos,img);
	}
}