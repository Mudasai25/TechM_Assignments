function rotateStringRight(str, delay) {
    function rotateOnce(s) {
        let lastChar = s[s.length - 1]; 
        let rotated = lastChar + s.slice(0, -1); 

        console.log(rotated); 

        setTimeout(() => rotateOnce(rotated), delay); 
    }

    rotateOnce(str);
}

rotateStringRight("digiterati", 500); 
