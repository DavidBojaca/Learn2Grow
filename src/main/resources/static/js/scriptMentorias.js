
function solicitarMentorias() {
    let a=$("#nombre").val();
    let b=$("#email").val();
    let c=$("#area").val();
    document.getElementById("campo").reset();

    let data={
        nombre:a,
        email:b,
        area:c;
    };
    $.ajax({

        url : '',
        data : JSON.stringify(data),
        type : '',
        contentType : "application/json",
        dataType : "json",

        success : function(rta) {
            console.log("se envio la informacion");
            console.log(data)

            window.alert('Solicitud de mentoria de '+ a  +' Creada correctamente')

        },
        error : function(xhr, status) {
            alert('Disculpe, existió un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}