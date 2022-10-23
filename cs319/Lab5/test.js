const text = "Hello World!";

console.log(text);


const greet = (name) => {
    console.log(`hello, ${name}`);
}

greet ("mario");
greet ("yoshi");

global.setTimeout(() => {
    console.log("In timeout mode")
}, 3000);

const interval = setInterval(() => {
    console.log("in interval")
}, 1000)