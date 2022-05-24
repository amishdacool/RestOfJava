import java.awt.Color;

import graphics.Canvas;

public class Program {
    // Canvas GUI instance providing the drawing area on which to plot the functions
    private static Canvas canvas;

    public static void main(String[] args) {
        
        // Create the canvas instance, set its range to x:[-360, 360] and y:[-240, 240] then 
        // open it on the screen. Use canvas.plot(pX, pY) to plot a point at the (pX, pY) coords
        canvas = new Canvas();
        canvas.setRange(-360, -240, 360, 240);
        canvas.open();

        // Draw a short red diagonal on the canvas
        canvas.pause();
        canvas.setColor(Color.red);
        
        MyFunction fSin = (x) -> {return (int) (200*Math.sin(Math.PI*x/360));};
        MyFunction fCos = (x) -> {return (int) (200*Math.cos(Math.PI*x/360));};
        MyFunction fQuadratic = (x) -> {return (int) (((x-200)*(x+200))/250);};
        MyFunction fLog = (x) -> {return (int) (20 * Math.log10(x));};
        MyFunction fCubic = (x) -> {return (int) (x*x*x/200000);};
        
        MyFunction[] functions = {fSin, fCos, fQuadratic, fLog, fCubic};
        	
        for (int i = -360; i < 360; i++) {
            canvas.plot(i, fSin.calcY(i));
            canvas.plot(i, fCos.calcY(i));
            canvas.plot(i, fQuadratic.calcY(i));
            canvas.plot(i, fLog.calcY(i));
            canvas.plot(i, fCubic.calcY(i));
        }

        // Pause and close the canvas then terminate the program.
        canvas.pause();
        canvas.close();
    }
}
