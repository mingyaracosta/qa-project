function addFirstRow(table, transaction) {
    let row = table.insertRow(1);
    let cell1 = row.insertCell(0);
    let cell2 = row.insertCell(1);
    let cell3 = row.insertCell(2);
    let cell4 = row.insertCell(3);
    cell1.innerHTML = transaction.transactionDate;
    cell2.innerHTML = transaction.transactionType;
    cell3.innerHTML = transaction.amount;
    cell4.innerHTML = transaction.balance;
}