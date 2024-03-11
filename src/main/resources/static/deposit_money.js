// Function to handle form submission
document.getElementById("depositForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent the default form submission

    // Get the values from the form
    var accountNo = document.getElementById("accountNo").value;
    var amount = parseFloat(document.getElementById("amount").value);

    // Validate the input
    if (isNaN(amount) || amount <= 0) {
        alert("Please enter a valid amount to deposit.");
        return;
    }

    // Make an AJAX request to deposit money
    var xhr = new XMLHttpRequest();
   xhr.open("POST", "/bankapp/accounts/" + accountNo + "/deposit?amount=" + amount, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                var response = JSON.parse(xhr.responseText);
                // Handle successful deposit
                alert("Successfully deposited $" + amount + " into account " + response.accountNo);
            } else {
                // Handle errors
                alert("Failed to deposit money. Please try again later.");
            }
        }
    };
    xhr.send();
});
