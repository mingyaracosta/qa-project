const {When} = require('cucumber');

When('I prepare the JSON for the GET request', function () {
    this.request = {
        method: 'GET',
        uri: this.wsUrl,
        json: true,
        resolveWithFullResponse: true
    };
});


