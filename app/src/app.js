const fetch = require("node-fetch");

async function hello() { return "Hello" };
hello().then(console.log);

fetch('https://www.google.com/')
    .then(response => response.json())
    .then(data => console.log(data));