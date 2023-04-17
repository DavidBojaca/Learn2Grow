function CrearProfesor() {

    let a = $("#name").val();
    let b = $("#apellido").val();
    let c = $("#cc").val();
    let d = $("#estudios").val();
    let f = $("#descripcion").val();
    let g = $("#correo").val();

    // Obtener el objeto checkbox
    const checkbox = document.getElementById("mentoria");
    let h = checkbox.checked ? "yes" : "no";
    //document.getElementById("campo").reset();

    let data = {
        name: a,
        apellido: b,
        cc: c,
        estudios: d,
        descripcion:f,
        correo: g,
        mentor: h
    };
    $.ajax({

        url: 'api/profesores/save',
        data: JSON.stringify(data),
        type: 'POST',
        contentType: "application/json",
        dataType: "json",

        success: function (rta) {
            console.log("se envio la informacion");
            console.log(data)

            window.alert('Comentario de ' + a + ' Creado correctamente')

        },
        error: function (xhr, status) {
            alert('Disculpe, existió un problema');
        },
        complete: function (xhr, status) {
            //  alert('Petición realizada');
        }
    });
}