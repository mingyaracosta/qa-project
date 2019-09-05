$.get("api/transactions", function (data) {
    var table = document.getElementById("trans-tb");
    addFirstRow(table, {
        balance: 0.0,
        amount: null,
        transactionType: null,
        transactionDate: null
    });
    var accountBalanceLabel = document.getElementById("account-balance");
    for (var i = 0; i < data.length; i++) {
        var transaction = data[i];
        addFirstRow(table, transaction);
        accountBalanceLabel.innerHTML = transaction.balance;
    }
});