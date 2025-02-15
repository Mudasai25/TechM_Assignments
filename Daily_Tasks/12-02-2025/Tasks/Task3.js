function getCurrentDate() {
    const now = new Date();

    let day = now.getDate();
    let month = now.getMonth() + 1; 
    let year = now.getFullYear();

    day = day.toString().padStart(2, '0');
    month = month.toString().padStart(2, '0');

    console.log(`dd-mm-yyyy: ${day}-${month}-${year}`);
    console.log(`dd/mm/yyyy: ${day}/${month}/${year}`);
}

getCurrentDate();
