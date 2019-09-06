function submitTransaction() {
    let transactionAmount = parseFloat(document.getElementById("amount-input").value);
    if (isNaN(transactionAmount)) {
        return;
    }

    $.ajax({
        url: "api/transactions/process-transaction",
        type: "POST",
        data: JSON.stringify({amount: transactionAmount}),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: onSuccessPost,
        error: onErrorPost
    });
}

function onSuccessPost(response) {
    let table = document.getElementById("trans-tb");
    addFirstRow(table, response);
    let accountBalanceLabel = document.getElementById("account-balance");
    accountBalanceLabel.innerHTML = response.balance;
    let lastTransactionLabel = document.getElementById("last-transaction-amount-label");
    lastTransactionLabel.innerHTML = response.amount;
}

function onErrorPost(response) {
    alert(response.responseJSON.message)
}

