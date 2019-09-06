const {Given, When} = require('cucumber');

Given('The following data transactionAmount {int}', function (transactionAmount) {
    this.requestBody = {amount: transactionAmount};
});

When('I prepare the JSON for the POST request', function () {
    this.request = {
        method: 'POST',
        uri: this.wsUrl,
        json: true,
        body: this.requestBody,
        resolveWithFullResponse: true
    };
});
