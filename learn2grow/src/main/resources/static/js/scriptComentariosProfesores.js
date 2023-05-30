function CrearComentarioProfesor(){

    let a=$("#name").val();
    let b=$("#comentario").val();
    document.getElementById("campo").reset();

    let data={
        name:a,
        comentario:b,

    };
    $.ajax({

        url : 'api/foroprofesores/save',
        data : JSON.stringify(data),
        type : 'POST',
        contentType : "application/json",
        dataType : "json",

        success : function(rta) {
            console.log("se envio la informacion");
            console.log(data)

            window.alert('Comentario de '+ a  +' Creado correctamente')

        },
        error : function(xhr, status) {
            alert('Disculpe, existió un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });


}


function cargarComentariosProfesores(data){

    const coment= document.getElementById('cajaComentarios')
    coment.innerHTML=`<button onclick="traerComentariosProfesores()" type="submit" class="btn btn-primary">Cargar Comentarios</button> `
    for(i=0;i<data.length;i++){

        coment.innerHTML+=`<div class="card">
                                <div class="card-body">
                                    <h4 class="card-title">${data[i].name}</h4>
                                    <td class="card-subtitle mb-4 text-body-secondary" >${data[i].fechaRegistro}</td>
                                    <p class="card-text">${data[i].comentario}</p>
                                    <a href="#" class="card-link">Responder</a>
                              </div>
                        </div>`;

    }

}

function traerComentariosProfesores(){

    $.ajax(
        {
            url : 'api/foroprofesores/all',
            type : 'GET',
            contentType : "application/json",
            dataType : "json",

            success : function(data) {
                console.log("Se recibio algo desde el servidor");
                console.log(data);
                cargarComentariosProfesores(data);




            },
            error : function(xhr, status) {
                window.alert('Disculpe, existió un problema');
            },
            complete : function(xhr, status) {
                //  alert('Petición realizada');
            }
        }
    )


}

