// view_accounts.js

document.addEventListener("DOMContentLoaded", function() {
    fetchAccounts();
});

function fetchAccounts() {
    fetch('http://localhost:8088/bankapp/accounts')
        .then(response => response.json())
        .then(data => {
            displayAccounts(data);
        })
        .catch(error => console.error('Error fetching accounts:', error));
}

function displayAccounts(accounts) {
    const accountListContainer = document.getElementById('accountList');
    accountListContainer.innerHTML = '';

    accounts.forEach(account => {
        const accountDiv = document.createElement('div');
        accountDiv.innerHTML = `
            <p>Account No: ${account.accountNo}</p>
            <p>Account Holder Name: ${account.accountHolderName}</p>
            <p>Balance: ${account.balance}</p>
        `;
        accountListContainer.appendChild(accountDiv);
    });
}
