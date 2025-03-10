var imagenes = [
	'https://i.imgur.com/k8Qtlyf.png',
	'https://i.imgur.com/6eZjAou.png',
	'https://i.imgur.com/2QYFEKQ.png',
	'https://i.imgur.com/7KNafXw.png',
	'https://i.imgur.com/M1XgdJe.png',
	'https://i.imgur.com/yywbOxd.png',
	'https://i.imgur.com/b1C8bqq.png',
];
// Array para llevar el seguimiento de las imágenes mostradas
var imagenesMostradas = [];

// Función para obtener una imagen aleatoria que no se haya mostrado
function obtenerImagenAleatoria() {
	if (imagenesMostradas.length === 0) {
		// Si todas las imágenes se han mostrado al menos una vez, reiniciar el array de imágenes mostradas
		imagenesMostradas = [...imagenes];
	}

	var indiceAleatorio = Math.floor(Math.random() * imagenesMostradas.length);
	var imagenAleatoria = imagenesMostradas.splice(indiceAleatorio, 1)[0];

	return imagenAleatoria;
}

// Obtén la referencia a la etiqueta de imagen
var imgElement = document.getElementById('imagenAleatoria');

// Establece la fuente de la imagen al cargar la página
window.onload = function() {
	imgElement.src = obtenerImagenAleatoria();
};

//funcion para acceder a la ventana INGAME
$(document).ready(function() {
	$("#btnStartPlaying").click(function() {
		let ventana = window.open('http://localhost:8080/ingame', '_blank', 'width=775,height=565,toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no');
		if (!ventana) {
			alert('Permite las ventanas emergentes para abrir el juego.');
		} else {
			ventana.focus();
		}
	});
});			