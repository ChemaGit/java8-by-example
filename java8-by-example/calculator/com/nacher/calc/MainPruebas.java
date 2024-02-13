package com.nacher.calc;

import com.nacher.calc.action.Operation;
import com.nacher.calc.ui.Constants;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nacher.calc.ui.Constants;

public class MainPruebas {

	public static void main(String[] args) {
		//Creamos un patrón A digit: [0-9]
		/*String pattern = "(,)(0|1|2|3|4|5|6|7|8|9)";
		Pattern r = Pattern.compile(pattern);
		String value = "0,10";
		Matcher m = r.matcher(value.toString());
		if(m.find()) {
			System.out.println("Encontrado patron: " + m.group());
		} else {
			System.out.println("No encontramos una mierda.");
		}*/
		
		//Suprimir la coma del final y ponerla al principio del String
		String value = "123,";
		String replace = ",".concat(value.replaceFirst(",", "")) ;				
		System.out.println(value + " ----- " + replace);
		System.out.println();
		
		//1,192092895507813e+16
		String con = conversion(new Double(32654789.2365478965321254));
		System.out.println(con);
		System.out.println(conversion(Math.sqrt(new Double(3.0))));
		System.out.println(conversion(new Double(1526987459556696974.0)));
		
		System.out.println();
		System.out.println(Operation.EQ.toString());
		
		System.out.println("Factorial(14): " + MainPruebas.factorial(14L));
		
	}
	
	private static Long factorial(Long n) {
		if(n == 1) {
			return 1L;
		} else {
			return n * factorial(n -1);
		}
	}
	
    //Convierte un numero en notacion cientifica a numero normal
    private static String conversion(Double valor) {
    	Locale loc = Locale.US;
    	Locale.setDefault(loc);
    	NumberFormat nf = NumberFormat.getNumberInstance(loc);   
    	DecimalFormat df = (DecimalFormat)nf;
    	df.applyPattern("#######################################.######################################");
    	//DecimalFormat num = new DecimalFormat("#######################################.######################################");
    	return df.format(valor);
    }	
    
    private static String conversion(BigDecimal valor) {
    	Locale loc = Locale.US;
    	Locale.setDefault(loc);
    	NumberFormat nf = NumberFormat.getNumberInstance(loc);   
    	DecimalFormat df = (DecimalFormat)nf;
    	df.applyPattern("#######################################.######################################");
    	//DecimalFormat num = new DecimalFormat("#######################################.######################################");
    	return df.format(valor);
    }	    

}


/*
 *  else if(value.toString().endsWith(Constants.OPER_COMMA)){				 				
				String replace = ",".concat(value.toString().replaceFirst(",", ""));
				textNumber.setText(replace);
			} 
 */

/**
 //              Instituto Tecnologico de Zacatepec
//      Descripcion:  Programa que expande un numero en notacion cientifica
//          Si el numero esta en notacion cientifica lo convierte a notacion normal
//      Author: Gonzalo Silverio   gonzasilve@hotmail.com
//      Archivo: ConversionCientifica.java
 
import java.util.*;
import java.text.*;
 
public class ConversionCientifica
{
    double elNumero =  0.0;
 
    public ConversionCientifica()
    {
 
    }
 
    public ConversionCientifica(double num)
    {
        elNumero = num;
    }
 
    //Convierte un numero en notacion cientifica a numero normal
    //el numero se supone ya fue especificado en el constructor
    public String conversion()
    {
      return conversion(elNumero);
    }
 
    //Convierte un numero en notacion cientifica a numero normal
    public String conversion(double valor)
    {
      Locale.setDefault(Locale.US);
      DecimalFormat num = new DecimalFormat("#,###.00");
      return num.format(valor);
    }
 
    public static void main(String args[])
    {
        double num = 23457E6;
        ConversionCientifica con = new ConversionCientifica();
        ConversionCientifica con2 = new ConversionCientifica(num);
 
        System.out.println("Numero convertido: "+con.conversion(653E3));
        System.out.println("Numero convertido: "+con2.conversion());
    }
}
 */
