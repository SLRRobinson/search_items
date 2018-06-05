function changeNumber(clientId, increment) {
    var inc = Number(increment);
    if (isNaN(inc) || inc == 0 ) {
        inc = 1;
    }
    var input = document.getElementById(clientId);
    var val = Number(input.value);
    if (isNaN(val)) {
        val = 0;
    }

    var result = val + inc;
    if (result >= 0){
    	input.value = result;
    } else {
    	input.value = 0;
    }
    return false;
}
