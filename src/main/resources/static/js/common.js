function addFirstRow(table, transaction) {
    var row = table.insertRow(1);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    cell1.innerHTML = transaction.transactionDate;
    cell2.innerHTML = transaction.transactionType;
    cell3.innerHTML = transaction.amount;
    cell4.innerHTML = transaction.balance;
}