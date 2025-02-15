function displayDateTime() {
    const days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
    const now = new Date();

    let day = days[now.getDay()];
    let hours = now.getHours();
    let minutes = now.getMinutes();
    let seconds = now.getSeconds();
    let ampm = hours >= 12 ? "PM" : "AM";

    hours = hours % 12 || 12; 

    console.log(`Today is : ${day}.`);
    console.log(`Current time is : ${hours} ${ampm} : ${minutes.toString().padStart(2, '0')} : ${seconds.toString().padStart(2, '0')}`);
}

displayDateTime();
