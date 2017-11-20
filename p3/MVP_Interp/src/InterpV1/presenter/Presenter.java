package InterpV1.presenter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;
import java.util.StringTokenizer;
import java.util.Vector;

import InterpV1.model.*;
import InterpV1.view.*;


public class Presenter extends Observable {
	
	private double _value, result;
	private Vector<Double> x, y;
    private final String CS_METHOD = "Cubic Spline";
    private final String L_METHOD = "Lagrange";
    private DecimalFormat formatResult = new DecimalFormat("####.######");
    private final String DEFAULT_METHOD = CS_METHOD;
	
	InterpolationMethod interpolationModel;
	IView view;
	
	public Presenter(Observer view, InterpolationMethod i) {
		interpolationModel = i;
		addObserver(view);
	}
	
	// RESPONSABILITY: ESCOLHER O METODO DE INTERPOLACAO DESEJADO E CRIAR O OBJETO CORRESPONDENTE
    public InterpolationMethod getMethod() { return interpolationModel; }
    public InterpolationMethod getMethod(String method) {
        switch (method) {
            case L_METHOD:
                interpolationModel = new Lagrange();
                break;
            case CS_METHOD:
                interpolationModel = new CubicSpline();
                break;
            default:
            	System.out.println("Unknown method " + method);
        }

        return interpolationModel;
    }

    // RESPONSABILITY: DADO O VALOR DE X, EFETIVAMENTE LER O ARQUIVO E CHAMAR O CALCULO. 
    public void calculateResult(float value, File file, FileView view) {
        view._value = value;
        buildDataPoints(file);
        if(getMethod() != null) {
            result = getMethod().calculateResult(_value, x, y);
            this.updateView(view);
            //view.printResult();
        } else {
            System.out.println("It is not defined an interpolation method.");
        }
    }
    
    // RESPONSABILITY: LER ARQUIVO DE DADOS
	private void buildDataPoints(File file) {
        if(file == null)
           return;
        else _file = file;

        x = new Vector<Double>();
        y = new Vector<Double>();
        try {
            input = new FileReader(_file);
		    /* Filter FileReader through a Buffered read to read a line at a time */
            bufRead = new BufferedReader(input);
            // Read first line
            String line = bufRead.readLine();
            // Read through file one line at time.
            while (line != null){
                xy = new StringTokenizer(line, "\t ");
                while(xy.hasMoreTokens()) {
                    x.addElement(Double.parseDouble(xy.nextToken()));
                    y.addElement(Double.parseDouble(xy.nextToken()));
                }
                line = bufRead.readLine();
            }
            bufRead.close();
        } catch (IOException e) { // If another exception is generated, print a stack trace
            e.printStackTrace();
        }
    }//buildDataPoints

	public void updateView(IView view) {
		// TODO Auto-generated method stub
		
	}


	


}
