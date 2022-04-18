function cuenta (campo, limite) {
    res = "";

    if (campo.value.length > limite){
        campo.value = campo.value.substring(0, limite);
    }
    else{ 
        var x = document.getElementById("resultt");
        x.querySelector(".example").innerHTML = (limite - campo.value.length);
    }    
}