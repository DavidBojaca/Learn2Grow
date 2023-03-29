/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


/* global consol */

function peticion_doPost(){
	//Capturar datos!
	let a=$("#nombre").val();
	let b=$("#comentario").val();
        
        
        
        let datos={
            nombre:a,
            comentarios:b
        };
        
        let dataToSend=JSON.stringify(datos);
        
        
	$.ajax({
    
                url : 'Servlet/Foro',
                data : dataToSend,
                type : 'POST',
                contentType: 'text/json; charset=utf-8',
                dataType: 'json',
                
                success : function() {
                 alert('Se creo el archivo')
                 consol.log("se envio el comentario");
                 
                },
                error : function(xhr, status) {
                    alert('Disculpe, existió un problema');
                    alert("Los datos  que se intentaron enviar fueron \n"+ dataToSend);
                    
                    
                },
                complete : function(xhr, status) {
                  //  alert('Petición realizada');
                  //hide modal
                },
                beforeSend: function(){
                   
                }
});


}