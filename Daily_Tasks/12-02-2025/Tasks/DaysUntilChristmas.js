function daysUntilChristmas() {
    let today = new Date(); 
    let year = today.getFullYear();

    let christmas = new Date(year, 11, 25); 

    if (today > christmas) {
        christmas.setFullYear(year + 1);
    }

    let diff = Math.ceil((christmas - today) / (1000 * 60 * 60 * 24));

    console.log(`There are ${diff} days left until Christmas!`);
}

daysUntilChristmas();
