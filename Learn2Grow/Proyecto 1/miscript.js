function peticion(){
	//Capturar datos!
	let a=$("#idLibro").val();
	let b=$("#titulo").val();
        let c=$("#isbn").val();
        let d=$("#autor").val();
        let e=$("#categoria").val();
        let f=$("#edicion").val();
        let g=$("#editorial").val();
        
        
        let datos={
            id:a,
            function peticion(){
                //Capturar datos!
                let a=$("#idLibro").val();
                let b=$("#titulo").val();
                    let c=$("#isbn").val();
                    let d=$("#autor").val();
                    let e=$("#categoria").val();
                    let f=$("#edicion").val();
                    let g=$("#editorial").val();
                    
                    
                    let datos={
                        id:a,
                        isbn:c,
                        titulo:b,
                        autor:d,
                        categoria:e,
                        edicion:f,
                        editorial:g
                    };
                    
                    let dataToSend=JSON.stringify(datos);
                    
                    
                $.ajax({
                
                            url : 'ServletControlador',
                            data : dataToSend,
                            type : 'PUT',
                            contentType: 'application/json; charset=utf-8',
                            dataType: 'json',
                            success : function(rta) {
                             //  $("#respuesta").append("El resultado del server es: "+rta);
                             
                            },
                            error : function(xhr, status) {
                                alert('Disculpe, existió un problema');
                            },
                            complete : function(xhr, status) {
                              //  alert('Petición realizada');
                              //hide modal
                            },
                            beforeSend: function(){
                                //show modal
                            }
            });
            }          isbn:c,
            titulo:b,
            autor:d,
            categoria:e,
            edicion:f,
            editorial:g
        };
        
        let dataToSend=JSON.stringify(datos);
        
        
	$.ajax({
    
                url : 'ServletControlador',
                data : dataToSend,
                type : 'PUT',
                contentType: 'application/json; charset=utf-8',
                dataType: 'json',
                success : function(rta) {
                 //  $("#respuesta").append("El resultado del server es: "+rta);
                 
                },
                error : function(xhr, status) {
                    alert('Disculpe, existió un problema');
                },
                complete : function(xhr, status) {
                  //  alert('Petición realizada');
                  //hide modal
                },
                beforeSend: function(){
                    //show modal
                }
});
}
