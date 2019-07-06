window.addEventListener('load',iniciarEventos);


function iniciarEventos(){
	var select_tipo_cifrado = document.getElementById('tipo-cifrado');
	
	select_tipo_cifrado.addEventListener('change', mostrarInputKey);
	document.getElementById("input-key-para-cifrado").style.display = "none";
    
};

function mostrarInputKey(){
    var select_tipo_cifrado = document.getElementById("tipo-cifrado");
    var input_key_cifrado = document.getElementById("input-key-para-cifrado");
    if (select_tipo_cifrado.value === "hill" ||
    	select_tipo_cifrado.value === "vernarm" ||
    	select_tipo_cifrado.value === "playfair"){
    	
        input_key_cifrado.style.display = 'block';
        input_key_cifrado.placeholder = 'LLave de cifrado/descifrado. [Default: ProyectoFinal]';
        
    }else if (select_tipo_cifrado.value === "desplazamiento"){
    	
        input_key_cifrado.style.display = 'block';
        input_key_cifrado.placeholder = 'Desplazamiento: 1-100 [Default: 13 (si ingresa letras o nada)]';
        
    }else {
    	
    	input_key_cifrado.style.display = "none";
    }
};







