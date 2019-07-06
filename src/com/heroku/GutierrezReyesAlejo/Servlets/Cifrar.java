package com.heroku.GutierrezReyesAlejo.Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heroku.GutierrezReyesAlejo.Cifrados.Cifrado;
import com.heroku.GutierrezReyesAlejo.Cifrados.Desplazamiento;
import com.heroku.GutierrezReyesAlejo.Cifrados.Fabrica;
import com.heroku.GutierrezReyesAlejo.Generadoores.AvisosHtml;
import com.heroku.GutierrezReyesAlejo.Util.Parser.DeObject;
import com.heroku.GutierrezReyesAlejo.Util.Parser.DeString;


@WebServlet(description = "Servlet para Cifrar", urlPatterns = {
		"/Cifrar",
		"/cifrar"
})
public class Cifrar extends HttpServlet {

	
    public Cifrar() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/formulario.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Validar que reciba en utf-8
		request.setCharacterEncoding("UTF-8");		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		// Obtener los parametros
		boolean cifrar = DeString.aString(request.getParameter("accion"), "cifrar").equals("cifrar");
		String tipoCifrado = DeString.aString(request.getParameter("tipo-cifrado"), "_NO_SELECTED_");
		String texto = DeString.aString(request.getParameter("texto"), "_EMPTY_");
		String param_key = DeString.aString(request.getParameter("input-key-para-cifrado"), null);
		
		// Avisos en pantalla
		String aviso = null;
		// Obtener la lista de obj cifrados...
		ArrayList<Cifrado> objs = DeObject.aArrayList(request.getSession().getAttribute("lista-de-objetos"));
		
		//
		
		try {
			
			
			if (!"_EMPTY_".equals(texto) && !"_NO_SELECTED_".equals(tipoCifrado)) {
				
				Cifrado objCifrado = Fabrica.deObjetoCifrado(tipoCifrado, texto, cifrar, param_key);
				
				if (objCifrado != null && objs != null) {
					objs.add(objCifrado);
				}else if (objCifrado != null && objs == null) {
					objs = new ArrayList<Cifrado>();
					objs.add(objCifrado);				
				}else if (objCifrado == null){
					throw new NullPointerException("Error interno, no se pudo crear una instancia de Cifrado.");
				}
				
				request.getSession().setAttribute("objeto-cifrado", objCifrado);
				request.getSession().setAttribute("lista-de-objetos", objs);
				
				
			}else {
				request.setAttribute("aviso", "No hay nada que cifrar");
				request.getSession().setAttribute("objeto-cifrado", null);
			}
			
			
		}catch(NullPointerException | IllegalArgumentException ex) {
			aviso = ex.getMessage();
			aviso = AvisosHtml.avisoAdvertencia(aviso);
			request.getSession().setAttribute("objeto-cifrado", null);
			request.setAttribute("aviso", aviso);
			
			
		}catch(StringIndexOutOfBoundsException ex) {
			aviso = "No es un formato valido para desencriptar";
			request.getSession().setAttribute("objeto-cifrado", null);
			aviso = AvisosHtml.avisoAdvertencia(aviso);
			request.setAttribute("aviso", aviso);
			
			
		}finally {
			ServletContext contextoServlet = request.getServletContext();
			RequestDispatcher despachadorSolicitud = contextoServlet.getRequestDispatcher("/formulario.jsp");
			despachadorSolicitud.forward(request, response);
		}
				
		
	}
}
