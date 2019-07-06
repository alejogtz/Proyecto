package com.heroku.GutierrezReyesAlejo.Util;

import javax.servlet.http.HttpServletRequest;

public final class UrlPara {

	private static String protocoloHostPuertoContexto(HttpServletRequest request) {
		return "http://" +
				request.getLocalName() + ":" +
				request.getLocalPort() +
				request.getContextPath();
	}

	/*
	 * Dado un objeto de la interfaz HttpServlerRequest *request* y una cadena de
	 * caracteres *ubicación* regresa un URL hacia la *ubicación*
	 *
	 * parámetro ubicación = "/recurso/dentro/del/contexto"
	 * resultado = "http://Nombre-De-Host:Puerto-TCP/Contexto/recurso/dentro/del/contexto
	 *
	 * Ejemplo:
	 *
	 *   parámetro ubicación = "/assets/css/main.css"
	 *   resultado = "http://localhost:1234//assets/css/main.css"
	 */
	public static String uri(HttpServletRequest request, String ubicacion) {
		return protocoloHostPuertoContexto(request) + ubicacion;
	}

	public static String uriAsset(HttpServletRequest request, String ubicacion) {
		return uri(request, "/assets" + ubicacion);
	}

	/*
	 * Ejemplo:
	 *
	 *   parámetro ubicación = "/main.css"
	 *   resultado = "http://localhost:1234//assets/css/main.css"
	 */
	public static String uriCss(HttpServletRequest request, String ubicacion) {
		return uriAsset(request, "/css" + ubicacion);
	}

	public static String uriImg(HttpServletRequest request, String ubicacion) {
		return uriAsset(request, "/img" + ubicacion);
	}

	public static String uriJs(HttpServletRequest request, String ubicacion) {
		return uriAsset(request, "/js" + ubicacion);
	}
}
