function sha512(str) {
    return crypto.subtle.digest("SHA-512", new TextEncoder("utf-8").encode(str)).then(buf => {
        return Array.prototype.map.call(new Uint8Array(buf), x=>(('00'+x.toString(16)).slice(-2))).join('');
    });
}
function CrearProfesor(pws) {

    let a = $("#nombre").val();
    let b = $("#apellido").val();
    let c = $("#correo").val();
    let d = pws;
    let e = $("#estudios").val();
    let f = $("#descripcion").val();

    // Obtener el objeto checkbox
    const checkbox = document.getElementById("mentoria");
    let g = checkbox.checked ? true : false;
    //document.getElementById("campo").reset();

    let data = {
        nombre: a,
        apellido: b,
        correoElectronico: c,
        contrasena: d,
        estudios :e,
        descripcion: f,
        mentor: g
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

            window.alert('Registro de ' + a + ' Creado correctamente')


        },
        error: function (xhr, status) {
            alert('Disculpe, existió un problema');
        },
        complete: function (xhr, status) {
            //  alert('Petición realizada');
        }
    });
}

function getPassCP(){
    sha512($("#contrasena").val()).then(x => CrearProfesor(x));

}

function LoginProfesor(pws) {

    let c = $("#correoLogin").val();
    let d = pws;

    $.ajax({

        url: 'api/profesores/validate/'+c+'/'+d,
        type: 'GET',
        contentType: "application/json",
        dataType: "json",

        success: function (rta) {
            console.log("se envio la informacion");
            console.log(rta)

            window.alert('Ingreso de ' + rta.nombre + ' correctamente')

            window.location.href = "profesores.html";


        },
        error: function (xhr, status) {
            alert('Disculpe, existió un problema');
        },
        complete: function (xhr, status) {
            //  alert('Petición realizada');
        }
    });
}


function getPassL(){
    sha512($("#contrasenaLogin").val()).then(x => LoginProfesor(x));

}

//Ejecutando funciones
document.getElementById("btn__iniciar-sesion").addEventListener("click", iniciarSesion);
document.getElementById("btn__registrarse").addEventListener("click", register);
window.addEventListener("resize", anchoPage);

//Declarando variables
var formulario_login = document.querySelector(".formulario__login");
var formulario_register = document.querySelector(".formulario__register");
var contenedor_login_register = document.querySelector(".contenedor__login-register");
var caja_trasera_login = document.querySelector(".caja__trasera-login");
var caja_trasera_register = document.querySelector(".caja__trasera-register");

//FUNCIONES

function anchoPage(){

    if (window.innerWidth > 850){
        caja_trasera_register.style.display = "block";
        caja_trasera_login.style.display = "block";
    }else{
        caja_trasera_register.style.display = "block";
        caja_trasera_register.style.opacity = "1";
        caja_trasera_login.style.display = "none";
        formulario_login.style.display = "block";
        contenedor_login_register.style.left = "0px";
        formulario_register.style.display = "none";
    }
}

anchoPage();


function iniciarSesion(){
    if (window.innerWidth > 850){
        formulario_login.style.display = "block";
        contenedor_login_register.style.left = "10px";
        formulario_register.style.display = "none";
        caja_trasera_register.style.opacity = "1";
        caja_trasera_login.style.opacity = "0";
    }else{
        formulario_login.style.display = "block";
        contenedor_login_register.style.left = "0px";
        formulario_register.style.display = "none";
        caja_trasera_register.style.display = "block";
        caja_trasera_login.style.display = "none";
    }
}

function register(){
    if (window.innerWidth > 850){
        formulario_register.style.display = "block";
        contenedor_login_register.style.left = "410px";
        formulario_login.style.display = "none";
        caja_trasera_register.style.opacity = "0";
        caja_trasera_login.style.opacity = "1";
    }else{
        formulario_register.style.display = "block";
        contenedor_login_register.style.left = "0px";
        formulario_login.style.display = "none";
        caja_trasera_register.style.display = "none";
        caja_trasera_login.style.display = "block";
        caja_trasera_login.style.opacity = "1";
    }
}