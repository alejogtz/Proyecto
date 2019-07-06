package com.heroku.GutierrezReyesAlejo.Generadoores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.heroku.GutierrezReyesAlejo.Cifrados.Cifrado;

public class DocumentoPdf {
	public static void deObjetosCifrado(HttpServletResponse response, List<Cifrado> objetos) throws IOException {
		/*// ==========================================================================
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=objetosCifrado.pdf");
		ServletOutputStream salida = response.getOutputStream();
		PdfDocument archivoPdf = new PdfDocument(new PdfWriter(salida));
		// ==========================================================================
		Document documentoPdf = new Document(archivoPdf);
		Table tabla = new Table(new float[] { 0.5f, 2.5f, 5.0f, 5.0f });

		String[] cabeceras = { "id", "Tipo de Cifrado", "Texto Plano", "Texto Cifrado" };
		for (String cabecera : cabeceras) {
			tabla.addCell(cabecera);
		}

		for (Cifrado obj : objetos) {
			tabla.addCell(String.valueOf(obj.getId()));
			tabla.addCell(String.valueOf(obj.getTipoCifrado()));
			tabla.addCell(String.valueOf(obj.getTextoPlano()));
			tabla.addCell(String.valueOf(obj.getTextoCifrado()));
		}
		documentoPdf.add(tabla);
		documentoPdf.close();
		*/
	}
}
