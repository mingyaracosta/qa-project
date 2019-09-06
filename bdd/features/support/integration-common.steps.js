const {Given, When, Then} = require('cucumber');
const {expect} = require('chai');
const httpClient = require('request-promise');

Given('The following url for the consuming the web service {string}', function (wsUrl) {
    this.wsUrl = wsUrl;
});

When('I perform the request', async function () {
    let httpResponse = undefined;
    await httpClient(this.request)
        .then(function (response) {
            httpResponse = response;
        })
        .catch(function (error) {
            httpResponse = error;
        });
    this.wsResponse = httpResponse;
});

Then('I get a response with a {int} http status', function (httpStatus) {
    expect(httpStatus).to.eql(this.wsResponse.statusCode);
});