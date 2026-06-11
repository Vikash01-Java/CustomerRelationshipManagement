const BASE_URL = "http://localhost:8080/api/customers";

// ADD CUSTOMER
function addCustomer() {

    const customer = {
        firstName: document.getElementById("firstName").value,
        lastName: document.getElementById("lastName").value,
        email: document.getElementById("email").value,
        mobileNumber: document.getElementById("mobileNumber").value,
        age: document.getElementById("age").value
    };

    fetch(BASE_URL + "/insert", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(customer)
    })
    .then(res => res.text())
    .then(data => {
        alert(data);
        getCustomers();
    });
}

// GET ALL CUSTOMERS
function getCustomers() {
    fetch(BASE_URL)
    .then(res => res.json())
    .then(data => {

        let output = "";

        data.forEach(c => {
            output += `
                <div class="customer">
                    <b>${c.firstName} ${c.lastName}</b><br>
                    📧 ${c.email}<br>
                    📱 ${c.mobileNumber}<br>
                    🎂 ${c.age}
                </div>
            `;
        });

        document.getElementById("output").innerHTML = output;
    });
}