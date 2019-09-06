$.get("api/transactions", function (data) {
    let table = document.getElementById("trans-tb");
    addFirstRow(table, {
        balance: 0.0,
        amount: null,
        transactionType: null,
        transactionDate: null
    });
    let accountBalanceLabel = document.getElementById("account-balance");
    let lastTransactionLabel = document.getElementById("last-transaction-amount-label");
    for (let i = 0; i < data.length; i++) {
        let transaction = data[i];
        addFirstRow(table, transaction);
        accountBalanceLabel.innerHTML = transaction.balance;
        lastTransactionLabel.innerHTML = transaction.amount;
    }
});