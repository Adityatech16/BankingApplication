document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('accountForm').addEventListener('submit', function (event) {
        event.preventDefault();

        const formData = new FormData(this);
        const accountData = {};
        formData.forEach((value, key) => accountData[key] = value);

        fetch('/bankapp/addaccount', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(accountData)
        })
        .then(response => response.json())
        .then(data => {
            console.log('Account added:', data);
            // You can perform further actions here, such as displaying a success message or redirecting to another page
        })
        .catch(error => {
            console.error('Error adding account:', error);
            // Handle errors here, such as displaying an error message to the user
        });
    });
});
