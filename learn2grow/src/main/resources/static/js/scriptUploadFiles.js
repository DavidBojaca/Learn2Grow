const dropArea = document.querySelector(".drop-area");
const dropText =dropArea.querySelector("h2");
const button = dropArea.querySelector("button");
const input = dropArea.querySelector("#input-file");
let files;
let name;
button.addEventListener("click", (e) =>{
    input.click();
} );


input.addEventListener("change",(e) =>{
    files = this.files;
    dropArea.classList.add("active");
    showFiels(fiels);
    dropArea.classList.remove("active");
})


dropArea.addEventListener("dragover",(e)=>{
    e.preventDefault();
    dropArea.classList.add("active")
    dropText.textContent= "Suelta para subir";

})
dropArea.addEventListener("dragleave",(e)=>{
    e.preventDefault();
    dropArea.classList.remove("active")
    dropText.textContent= "Arrastra tus archivos aqui";
})
dropArea.addEventListener("drop",(e)=>{
    e.preventDefault();
    files= e.dataTransfer.files;
    showFiels(files);
    dropArea.classList.remove("active")
    dropText.textContent= "Arrastra tus archivos aqui";
})

function showFiels(fiels){
    if(fiels.length === undefined){
        processFile(files);
    }else{
        for(const  file of fiels){
            processFile(file);
        }
    }
}

function processFile(file){
    const docType = file.type;
    const validExtention= ['image/jpeg', 'image/jpg', 'image/png', 'image/gif',
        'application/docx','application/pdf']
    name=file.name;
    if (validExtention.includes(docType)){
         //archivos validos
        const fileReader = new FileReader();


        fileReader.addEventListener('load',e => {
            const fileUrl = fileReader.result;
            const image= `
                <div id="archivo-cargado" class="file-container">
                    <img src="${fileUrl}" alt="${file.name}" width="50px">
                    <div class="status">
                      <span>${file.name}</span>
                      <span class="success">Archivo cargado correctamente</span>
                    </div>
                </div>
                
            `;
            const html = document.querySelector("#preview").innerHTML;
            document.querySelector('#preview').innerHTML= image + html;


        });

        fileReader.readAsDataURL(file);
        uploadFile(file);


    }else{
        alert("no es un archivo valido es de tipo: "+ docType);
    }
}



function uploadFile(file){
    var fileInput =file;

    var formData = new FormData();
    formData.append('archivo',fileInput)

    $.ajax({
        url: '/api/publicaciones/upload',
        type: 'POST',
        data: formData,
        processData: false,
        contentType:false,
        success: function (response){
            console.log("Archivo enviado correctamente.");

        },
        error: function (xhr,status,error) {
            console.error("Error al enviar el archivo: ", error);
        }
    })

}
function crearPublicacion(){
    let a= "src/main/java/com/example/learn2grow/Publicaciones/"+name;
    let b=$("#descripcion").val();

    document.getElementById("cont-publicacion").reset();

    let data={
        url: a,
        descripcion: b,


    };
    $.ajax({

        url : 'api/publicaciones/save',
        data : JSON.stringify(data),
        type : 'POST',
        contentType : "application/json",
        dataType : "json",

        success : function(rta) {
            console.log("se envio la informacion");
            console.log(data);

            window.alert('Se ha creado la publicacion correctamente');
            location.href="http://localhost:8080/perfilDocentes.html";
        },
        error : function(xhr, status) {
            alert('Disculpe, existió un problema');

        },

    });
}