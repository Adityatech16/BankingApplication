document.addEventListener('DOMContentLoaded', function () {
    const withdrawForm = document.getElementById('withdrawForm');
    withdrawForm.addEventListener('submit', function (event) {
        event.preventDefault();
        const formData = new FormData(withdrawForm);
        const accountId = formData.get('accountId');
        const amount = parseFloat(formData.get('amount'));
        if (!isNaN(amount) && amount > 0) {
            withdrawMoney(accountId, amount);
        } else {
            alert('Invalid amount. Please enter a valid positive number.');
        }
    });

    function withdrawMoney(accountId, amount) {
        fetch(`/bankapp/accounts/${accountId}/withdraw?amount=${amount}`, {
            method: 'POST'
        })
        .then(response => response.json())
        .then(updatedAccount => {
            alert(`Withdrawal of ${amount} successful. New balance: ${updatedAccount.balance}`);
            withdrawForm.reset();
        })
        .catch(error => console.error('Error withdrawing money:', error));
    }
});
