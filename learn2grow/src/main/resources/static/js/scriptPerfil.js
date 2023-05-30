function handleProfilePhotoChange(event) {
    const file = event.target.files[0];
    const imgElement = document.getElementById('avatar-img');

    const reader = new FileReader();
    reader.addEventListener('load', function () {
        imgElement.src = reader.result;
    });

    if (file) {
        reader.readAsDataURL(file);
    }
}

function getPerfil(){
    document.getElementById('nombre').innerHTML += sessionStorage.getItem('usuarioNom') +" "+sessionStorage.getItem('usuarioApe');

}

function getEstudios(){
    document.getElementById('estudios').innerHTML += sessionStorage.getItem('usuarioEst') ;

}