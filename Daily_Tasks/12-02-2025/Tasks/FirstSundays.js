function findSundays(a, b) {
    console.log("Years where January 1st is a Sunday:");
    
    for (let i = a; i <= b; i++) {
        let date = new Date(i, 0, 1); 
        if (date.getDay() === 0) { 
            console.log(i);
        }
    }
}

findSundays(2014, 2050);
