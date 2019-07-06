<%@page import="com.heroku.GutierrezReyesAlejo.Util.UrlPara"%>
<%@page import="com.heroku.GutierrezReyesAlejo.Cifrados.Cifrado"%>
<%@page import="com.heroku.GutierrezReyesAlejo.Util.Parser.DeString"%>
<%@page import="com.heroku.GutierrezReyesAlejo.Util.Parser.DeObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Aplicacion para cifrar Texto</title>

<link rel="icon" type="image/png" href="assets/img/iconoo.png" />
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/main.css">
<script src="assets/js/jquery-3.3.1.min.js"></script>
<script src="assets/js/main.js"></script>

</head>
<body>
	<!-- ---------------------------------------------------------------------------------------------- -->

	<div class="jumbotron text-center">
		<h1>Algoritmos de Cifrado</h1>
	</div>
	<!-- ********************************************************************************** -->
	<form method="post" action="Cifrar">
		<fieldset>
			<!-- <legend>Formulario</legend>  -->
			<!-- ********************-->
			<div class="container">
				<div class="row">
					<div class="col-sm-5">
						<div>
							<label for="tipo-cifrado">Cifrado por: </label> 
							<select name="tipo-cifrado" id="tipo-cifrado" onchange="mostrarInput()">
								<option value="polybios" selected>Polybios</option>
								<option value="desplazamiento">Desplazamiento</option>
								<option value="playfair">Playfair</option>
								<option value="hill">Hill</option>
								<option value="vernarm">vernarm</option>
							</select>
							<input type="text" class="form-control" name = "input-key-para-cifrado" 
							id="input-key-para-cifrado" placeholder="Llave de cifrado">
						</div>

						<!-- --------------------------------- -->
						<h3>Texto a cifrar/descifrar</h3>
						<p>
							<textarea name="texto" id="texto" rows="10"
								placeholder="Texto que quiere cifrar" class="form-control"></textarea>
						</p>
					</div>
					<!-- ---------------------------------------------------------------------- -->
					<div class="col-sm-2">
						<h3>Acciones</h3>
						<p>
							<button type="submit" name="accion" id="btn-submit"
								value="cifrar" class="btn btn-info btn-responsive btninter">Cifrar</button>
						</p>
						<p>
							<button type="submit" name="accion" id="btn-submit"
								value="descifrar" class="btn btn-info btn-responsive btninter">Descifrar</button>
						</p>

					</div>
					<!-- ---------------------------------------------------------------------- -->
					<div class="col-sm-5">
						<h3>Resultado:</h3>
						<%
							String textoPlano = "";
							String textoCifrado = "";
							Cifrado data = DeObject.aCifrado(request.getSession().getAttribute("objeto-cifrado"));

							if (data != null) {
								textoPlano = data.getTextoPlano();
								textoCifrado = data.getTextoCifrado();
								System.out.println(textoCifrado);
							}
						%>
						<div class="row">
							<!-- --------------------------------- -->
							<textarea name="textoPlanoVer" id="textoPlanoVer" rows="5"
								placeholder="Texto Plano" readonly class="form-control"><%=textoPlano%></textarea>
							<!-- --------------------------------- -->
						</div>
						<div class="row">
							<!-- ---------------------------------------------------------------------- -->
							<textarea name="textoCifradoVer" id="textoCifradoVer" rows="5"
								placeholder="Texto Cifrado" readonly class="form-control"><%=textoCifrado%></textarea>
							<!-- ---------------------------------------------------------------------- -->
						</div>
					</div>
				</div>
			</div>
		</fieldset>
	</form>
	<!-- ********************************************************************************** -->
	<div class="container">
		<%
			String aviso = (String) request.getAttribute("aviso");
			if (aviso != null) {
				out.println(aviso);
				request.setAttribute("aviso", null);
			}
		%>
	</div>
	<!-- ********************************************************************************** -->
	<div class="container">
		<form action="exportar-file" method="post">
			<fieldset>
				<legend>Exportar</legend>
				<button name="formato" value="csv" type="submit"
					class="btn btn-info ">to Csv</button>
				<button name="formato" value="xml" type="submit"
					class="btn btn-info">to Xml</button>
				<button name="formato" value="json" type="submit"
					class="btn btn-info">to Json</button>
			</fieldset>
		</form>
	</div>
	<!-- ---------------------------------------------------------------------------------------------- -->


	<!-- ----------------------- -->
</body>
</html>