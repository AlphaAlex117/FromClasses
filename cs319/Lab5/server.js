const http = require('http');
const fs = require('fs');

// Takes a callback to handle each request
const server = http.createServer((request, response) => {
    console.log(request.url, request.method);

    //set header content type
    response.setHeader('Content-Type', 'text/html');

    //URL Routing
    switch (request.url) {
        // Root url
        case '/':
            path = "index.html";
            response.statusCode = 200;
            break;
        // Alternative url
        case '/about':
            path = "about.html";
            response.statusCode = 200;
            break;
        // Redirecting case
        case '/about-us':
            response.statusCode = 301;
            response.setHeader("Location","/about");
            response.end();
            break;
        // 404 case
        default:
            path = "404.html";
            response.statusCode = 404;
            break;
    }

    //Response
    fs.readFile(path, (err, data) => {
        if (err) {
            console.log(err);
            response.end();
        }
        else {
            // response.write(data);
            response.end(data); // pass data to end method, if only writing one thing!
        }
    });
});

server.listen(3000, "localhost", () => {
    console.log('Listening for request on port 3000');
});