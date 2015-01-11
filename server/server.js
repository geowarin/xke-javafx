var express = require('express');
var fs = require('fs');
var app = express();
var defaultCharset = 'utf8';

app.set('port', process.env.PORT || 8080);

/* Cards data */
app.get('/cards', function(req, res) {
    setTimeout(function() {
	returnJsonFile('cards_data', res);
    }, 1500);
});

/* Default (home page) */
app.get('^*$', function(req, res) {
    res.type('text/html; charset=' + defaultCharset);
    res.status(200).send(readFileSyncReplacingUrl('data/index.html', req));
});

/* Starts server */
app.listen(app.get('port'), function () {
    console.log('Express server listening on port ' + app.get('port'));
});

/* Returns the content of the specified file as an HTTP response */
function returnJsonFile(fileName, res) {
    res.type('application/json; charset=' + defaultCharset);
    fs.readFile('data/' + fileName + '.json', defaultCharset, function (err, data) {
	if (err) {
	    res.status(500);
	}
	res.status(200).send(data);
    });
}

/* Opens file and replaces 'localhost:8080' template data with actual host information */
function readFileSyncReplacingUrl(fileName, req) {
    var port = app.get('port');
    var host = req.protocol + '://' + req.hostname + (port == 80 || port == 443 ? '' : ':' + port);
    var data = fs.readFileSync(fileName, defaultCharset);
    return data.replace(/http:\/\/localhost:8080/g, host);
}
