import edu.princeton.cs.algs4.Picture;

import java.awt.*;

public class SeamCarver {
    Picture pic;
    public SeamCarver(Picture picture){
        this.pic = picture;
    }

    public Picture picture(){
        return pic;
    }


    public int width(){
        return pic.width();
    }

    public int height(){
        return pic.height();
    }

    public double energy(int x, int y){
        int dRx = pic.get(wrapX(x-1), y).getRed() - pic.get(wrapX(x+1), y).getRed();
        int dGx = pic.get(wrapX(x-1), y).getGreen() - pic.get(wrapX(x+1), y).getGreen();
        int dBx = pic.get(wrapX(x-1), y).getBlue() - pic.get(wrapX(x+1), y).getBlue();

        int dRy = pic.get(x, wrapY(y-1)).getRed() - pic.get(x, wrapY(y+1)).getRed();
        int dGy = pic.get(x, wrapY(y-1)).getGreen() - pic.get(x, wrapY(y+1)).getGreen();
        int dBy = pic.get(x, wrapY(y-1)).getBlue() - pic.get(x, wrapY(y+1)).getBlue();

        return dRx*dRx + dGx*dGx + dBx*dBx + dRy*dRy + dGy*dGy + dBy*dBy;
    }

    private int wrapX(int x){
        return Math.floorMod(x,width());
    }

    private int wrapY(int y){
        return Math.floorMod(y,height());
    }

    public int[] findHorizontalSeam(){
        double[][] energy = new double[width()][height()];
        for(int x = 0; x<width(); x++){
            for(int y = 0; y<height(); y++){
                energy[x][y] = energy(x,y);
            }
        }

        for(int x = 1; x<width(); x++){
            for(int y = 0; y<height(); y++){
                if(y == 0)
                    energy[x][y] += Math.min(energy[x-1][y],energy[x-1][y+1]);
                else if(y == height()-1)
                    energy[x][y] += Math.min(energy[x-1][y-1],energy[x-1][y]);
                else
                    energy[x][y] += Math.min(energy[x-1][y-1],
                            Math.min(energy[x-1][y],energy[x-1][y+1]));
            }
        }

        double min = Double.MAX_VALUE;
        int minId = 0;
        for(int y = 0; y<height(); y++){
            if(energy[width()-1][y] < min){
                min = energy[width()-1][y];
                minId = y;
            }
        }

        int[] minY = new int[width()];
        minY[width()-1] = minId;
        for(int x = width()-2; x>=0; x--){
            minId = minY[x+1];
            min = Double.MAX_VALUE;
            int next = minId;
            for(int y = minId-1; y<= minId+1; y++){
                if(energy[x][y] < min){
                    min = energy[x][y];
                    next = y;
                }
                minY[x] = next;
            }
        }

        return minY;
    }

    public int[] findVerticalSeam(){
        double[][] energy = new double[width()][height()];
        for(int x = 0; x<width(); x++){
            for(int y = 0; y<height(); y++){
                energy[x][y] = energy(x,y);
            }
        }

        for(int y = 1; y<height(); y++){
            for(int x = 0; x<width(); x++){
                if(x == 0)
                    energy[x][y] += Math.min(energy[x][y-1],energy[x+1][y-1]);
                else if(x == width()-1)
                    energy[x][y] += Math.min(energy[x-1][y-1],energy[x][y-1]);
                else
                    energy[x][y] += Math.min(energy[x-1][y-1],
                            Math.min(energy[x][y-1],energy[x+1][y-1]));
            }
        }

        double min = Double.MAX_VALUE;
        int minId = 0;
        for(int x = 0; x<width(); x++){
            if(energy[x][height()-1] < min){
                min = energy[x][height()-1];
                minId = x;
            }
        }

        int[] minX = new int[height()];
        minX[height()-1] = minId;
        for(int y = height()-2; y>=0; y--){
            minId = minX[y+1];
            min = Double.MAX_VALUE;
            int next = minId;
            for(int x = minId-1; x<= minId+1; x++){
                if(energy[x][y] < min){
                    min = energy[x][y];
                    next = x;
                }
                minX[y] = next;
            }
        }
        return minX;
    }

    public void removeHorizontalSeam(int[] seam){
        pic = SeamRemover.removeHorizontalSeam(pic,seam);
    }

    public void removeVerticalSeam(int[] seam){
        pic = SeamRemover.removeVerticalSeam(pic,seam);
    }
}
