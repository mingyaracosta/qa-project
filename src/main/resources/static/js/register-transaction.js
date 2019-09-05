function submitTransaction() {
    var transactionAmount = parseFloat(document.getElementById("amount-input").value);
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
    var table = document.getElementById("trans-tb");
    addFirstRow(table, response);
    var accountBalanceLabel = document.getElementById("account-balance");
    accountBalanceLabel.innerHTML = response.balance;
}

function onErrorPost(response) {
    alert(response.responseJSON.message)
}

