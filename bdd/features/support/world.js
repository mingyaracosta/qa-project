const {setWorldConstructor} = require("cucumber");

class CustomWorld {
    constructor() {
        this._request = undefined;
        this._requestBody = undefined;
        this._wsUrl = undefined;
        this._wsResponse = undefined;

        this._transactionAmount = undefined;
        this._lastTransactionAmount = undefined;
    }

    get request() {
        return this._request;
    }

    set request(value) {
        this._request = value;
    }

    get requestBody() {
        return this._requestBody;
    }

    set requestBody(value) {
        this._requestBody = value;
    }

    get wsUrl() {
        return this._wsUrl;
    }

    set wsUrl(value) {
        this._wsUrl = value;
    }

    get wsResponse() {
        return this._wsResponse;
    }

    set wsResponse(value) {
        this._wsResponse = value;
    }

    get transactionAmount() {
        return this._transactionAmount;
    }

    set transactionAmount(value) {
        this._transactionAmount = value;
    }

    get lastTransactionAmount() {
        return this._lastTransactionAmount;
    }

    set lastTransactionAmount(value) {
        this._lastTransactionAmount = value;
    }
}

setWorldConstructor(CustomWorld);