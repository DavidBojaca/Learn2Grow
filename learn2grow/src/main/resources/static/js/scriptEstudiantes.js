

function CrearComentarioEstudiante(){

    let a=$("#name").val();
    let b=$("#comentario").val();
    document.getElementById("campo").reset();

    let data={
        name:a,
        comentario:b,

    };
    $.ajax({

        url : 'api/foroestudiantes/save',
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
function cargarComentariosEstudiantes(data){

    const coment= document.getElementById('cajaComentarios')
    coment.innerHTML=`<button onclick="traerComentariosEstudiantes()" type="submit" class="btn btn-primary">Cargar Comentarios</button> `
    for(i=0;i<data.length;i++){

        coment.innerHTML+=`<div class="card">
                                <div class="card-body">
                                    <h4 class="card-title">${data[i].name}</h4>
                                    <td class="card-subtitle mb-4 text-body-secondary" >${data[i].fechaRegistro}</td>
                                    <p class="card-text">${data[i].comentario}</p>
                                    <a href="https://i.pinimg.com/564x/18/30/75/183075ad86552308be9fc5695e8d3dd9.jpg" type="submit" class="type-name-link">responder</a>
                              </div>
                        </div>
                        `;

    }

}
function traerComentariosEstudiantes() {

    $.ajax(
        {
            url: 'api/foroestudiantes/all',
            type: 'GET',
            contentType: "application/json",
            dataType: "json",

            success: function (data) {
                console.log("Se recibio algo desde el servidor");
                console.log(data);
                cargarComentariosEstudiantes(data);


            },
            error: function (xhr, status) {
                window.alert('Disculpe, existió un problema');
            },
            complete: function (xhr, status) {
                //  alert('Petición realizada');
            }
        }
    )
}
window.onload = traerComentariosEstudiantes;

//Funciones respuesta
function iniciarRespuestaEstudiante(){
    let resp =""
    resp=`<div class="form-group">
                        <label>Nombre:</label>
                        <input type="text" class="form-control" id="nombre" placeholder="Nombre del Estudinate">
                      </div>
                      <div class="form-group">
                        <label >Comentario:</label>
                        <textarea class="form-control" id="respuesta" rows="3" placeholder="Deja tu comentario"></textarea>
                      </div>
                  <button onclick="CrearRespuestaEstudiante()" type="submit" class="btn btn-primary">Publicar</button>`



}
function CrearRespuestaEstudiante(){
    let a=$("#nombre").val();
    let b=$("#respuesta").val();
    document.getElementById("cRespuestas").innerHTML = '';

    let data={
        nombre:a,
        respuesta:b,

    };
    $.ajax({

        url : 'api/foroestudiantes/saverespuesta',
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

    pintarRespuesta(i, data);

}

function pintarRespuesta(i,data){
    let respuesta="";
    for(i=0;i<data.length;i++){
        //<td className="card-subtitle mb-4 text-body-secondary" >${data[i].fechaRegistro}</td>
        respuesta=`<div class="card">
                                <div class="card-body">
                                    <h4 class="card-title">${data.nombre}</h4>                    
                                    <p class="card-text">${data.respuesta}</p>
                                </div>`;
        //$(#cRespuestas).html(respuesta)
    }
}




