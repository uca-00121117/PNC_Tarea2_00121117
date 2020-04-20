package com.uca.capas.controller;

import java.util.Calendar;
import java.util.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class MainController {

	@RequestMapping("/alumno")
	public @ResponseBody String alumno() {

		return "<b>Nombre:</b> Diego Alejandro Rubi Cordova<br>"
				+ "<b>Carnet:</b> 00121117<br>"
				+ "<b>Carrera:</b> Ingeniería Informática<br> "
				+ "<b>Año de la carrera:</b> Cuarto";
		
	}
	

	@RequestMapping("/dia")
	public @ResponseBody String dia(HttpServletRequest request) {
		//peticiones en url
		
		int d = Integer.parseInt(request.getParameter("d"));
		int m = Integer.parseInt(request.getParameter("m"));
		int y = Integer.parseInt(request.getParameter("y"));
		
		try { return dia_semana(d,m,y);}
		//Recoge el error de la fecha incorrecta
		catch(IllegalArgumentException e){return "No es fecha correcta";}		
	} 
	String dia_semana(int d,int m, int y) {
		//Guarda el dia
		String dia_semana = "El dia de la semana es ";
		//Crea una fecha con los datos seleccionados
		Calendar calendario =Calendar.getInstance();
		//Para validar los valores
		calendario.setLenient(false);
		calendario.set(Calendar.YEAR,y);
		calendario.set(Calendar.MONTH,m-1);
		calendario.set(Calendar.DAY_OF_MONTH,d);
		switch(calendario.get(Calendar.DAY_OF_WEEK)) {
		case Calendar.SUNDAY:
			dia_semana+= "Domingo";
			break;
		case Calendar.MONDAY:
			dia_semana+= "Lunes";
			break;
		case Calendar.TUESDAY:
			dia_semana+= "Martes";			
			break;
		case Calendar.WEDNESDAY:
			dia_semana+= "Miercoles";
			break;
		case Calendar.THURSDAY:
			dia_semana+= "Jueves";
			break;
		case Calendar.FRIDAY:
			dia_semana+= "Viernes";
			break;
		case Calendar.SATURDAY:
			dia_semana+= "Sabado";
			break;
		default:
			dia_semana= "no existe";
			break;
		}
		return dia_semana;
	}

}