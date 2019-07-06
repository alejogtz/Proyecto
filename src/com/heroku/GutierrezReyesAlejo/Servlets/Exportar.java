package com.heroku.GutierrezReyesAlejo.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.heroku.GutierrezReyesAlejo.Cifrados.Cifrado;
import com.heroku.GutierrezReyesAlejo.Generadoores.AvisosHtml;
import com.heroku.GutierrezReyesAlejo.Generadoores.DocumentoCsv;
import com.heroku.GutierrezReyesAlejo.Generadoores.DocumentoJson;
import com.heroku.GutierrezReyesAlejo.Generadoores.DocumentoPdf;
import com.heroku.GutierrezReyesAlejo.Generadoores.DocumentoXls;
import com.heroku.GutierrezReyesAlejo.Generadoores.DocumentoXlsx;
import com.heroku.GutierrezReyesAlejo.Generadoores.DocumentoXml;
import com.heroku.GutierrezReyesAlejo.Util.Parser.DeObject;

@WebServlet(description = "Servlet para exportar", urlPatterns = { "/Exportar-file", "/exportar-file" })
public class Exportar extends HttpServlet {
 
	public Exportar() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String formatoSolicitado = request.getParameter("formato");
		if (formatoSolicitado == null) {
			formatoSolicitado = "";
		}
		PrintWriter salida = null;// response.getWriter();
		String aviso = null;
		
		/* Obtención de Datos */

		List<Cifrado> listaObjetos = DeObject.aArrayList(request.getSession(true).getAttribute("lista-de-objetos"));

			
			try {
				switch (formatoSolicitado) {
				case "xls":
					/* Microsoft Excel Worksheet */
					DocumentoXls.deObjetosCifrado(response, listaObjetos);
					break;
				case "xlsx":
					/* Microsoft 2007 spreadsheet */
					DocumentoXlsx.deObjetosCifrado(response, listaObjetos);
					break;
				case "pdf":
					/* PDF Document */
					DocumentoPdf.deObjetosCifrado(response, listaObjetos);
					break;
				case "csv":					
					response.setCharacterEncoding("UTF-8");
					response.setContentType("text/csv;charset=UTF-8");
					response.setHeader("Content-Disposition", "inline; filename=\"ObjetosCifrado.csv\"");

					if (salida == null)
						salida = response.getWriter();
					salida.println(DocumentoCsv.deObjetosCifrado(listaObjetos));
					break;
				case "xml":					
					response.setCharacterEncoding("UTF-8");
					response.setContentType("application/xml;charset=UTF-8");
					response.setHeader("Content-Disposition", "inline; filename=\"ObjetosCifrado.xml\"");

					if (salida == null)
						salida = response.getWriter();
					salida.println(DocumentoXml.deObjetosCifrado(listaObjetos));
					break;
				case "json":					
					response.setCharacterEncoding("UTF-8");
					response.setContentType("application/json;charset=UTF-8");
					response.setHeader("Content-Disposition", "inline; filename=\"ObjetosCifrado.json\"");

					if (salida == null)
						salida = response.getWriter();
					salida.println(DocumentoJson.deObjetosCifrado(listaObjetos));
					break;
				}
			}catch(IllegalStateException ex) {
				aviso = AvisosHtml.avisoAdvertencia("Problema con las librerías, No se puede Exportar al formato " + formatoSolicitado);
				request.setAttribute("aviso", aviso);
				
			}catch(NullPointerException ex) {
				aviso = AvisosHtml.avisoAdvertencia(formatoSolicitado + " dice: " + "No hay elementos que exportar" );
				request.setAttribute("aviso", aviso);
				ServletContext contextoServlet = request.getServletContext();
				RequestDispatcher despachadorSolicitud = contextoServlet.getRequestDispatcher("/formulario.jsp");
				despachadorSolicitud.forward(request, response);
				
			}finally {}
	}

}
