package InterpV2.view;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;
import java.util.StringTokenizer;
import java.util.Vector;
import InterpV2.presenter.*;
import presenter.Presenter;




public class View1 implements  Observer, IView  {

    
    private FileReader input;
    private BufferedReader bufRead;
    private StringTokenizer xy;
    private double _value, result;
    private File _file;
    private Vector<Double> x, y;
    private final String CS_METHOD = "Cubic Spline";
    private final String L_METHOD = "Lagrange";
    private DecimalFormat formatResult = new DecimalFormat("####.######");
    private final String DEFAULT_METHOD = CS_METHOD;

    public View1(Presenter p) {
        
        bind(p);
     }
    
    @Override
    public void bind(Presenter p) {
        
        p.interpolationModel = (InterpolationMethod) getMethod(DEFAULT_METHOD);
    }

    public File getDataFile() {
        
        return _file;
    }



    

 // RESPONSABILITY: IMPRIMIR RESULTADOS
    private void printResult() {
    	System.out.println("***********************");
    	System.out.println("DataFile: " + getDataFile());
    	System.out.println("Interp at " + formatResult.format(_value) + " ; result = " + formatResult.format(result));
	}


	
	@Override
	public void update(Observable observable, Object o) {
		Presenter _p = (Presenter) o;
		_p.updateView(this);	
		
	}

	   public static void main(String[] args) {
		   // RESPONSABILITY: CREATE APP
		   View1 myInterp = new View1();

        // ENTRADA DE USUARIO HUMANO: ESCOLHA DO METODO DE INTERPOLACAO   
        // RESPONSABILITY: LEITURA DO NOME DO METODO DE INTERPOLACAO
		   myInterp.getMethod("Lagrange");
		// ENTRADA DE USUARIO HUMANO: PONTO DE INTERPOLACAO E NOME DO ARQUIVO DE DADOS.   
		// RESPONSABILITY: DEFINIR PONTO DE INTERPOLACAO (LEITURA ENTRADA DE USUARIO HUMANO) 
		// RESPONSABILITY: DEFINIR QUAL EH O ARQUIVO COM DADOS DE PONTOS DA FUNCAO (LEITURA ENTRADA DE USUARIO HUMANO)
		   myInterp.calculateResult(10.3f, new File("./data.dat"));
	    }



}//class
