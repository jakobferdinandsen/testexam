var url = "http://52.57.228.6/easj-simulation/acme.php";
var customerArray = [];

$(document).ready(function () {
    loadData();
    $("#searchField").keyup(function (e) {
            updateView();
    });
});

function updateView() {
    $("#tableBody").html("");
    customerArray.forEach(function (customer) {
        add(customer, $("#searchField").val())
    });
}

function loadData() {
    $.ajax({
        method: "GET",
        url: url,
        dataType: "json",
        success: function (data) {
            customerArray = data.data;
            updateView();
        },
    });
}

function createTRHtml(customer) {
    var offerHtml = "<tr>" +
        "<td>" + customer.id + "</td>" +
        "<td>" + customer.first_name + "</td>" +
        "<td>" + customer.last_name + "</td>" +
        "<td>" + customer.date_of_birth + "</td>" +
        "<td>" + customer.email + "</td>" +
        "<td>" + customer.street + "</td>" +
        "<td>" + customer.city + "</td>" +
        "<td>" + customer.zip + "</td>" +
        "<td>" + customer.country + "</td>" +
        "</tr>";
    $("#tableBody").append(offerHtml)
}

function add(customer, searchTerm) {
    customer.id = customer.id + "";
    var add = true;
    var searchString = "";
    for (var prop in customer) {
        searchString += customer[prop].toLowerCase();
    }
    searchTerm.split(" ").forEach(function (term) {
        term = term.toLowerCase();
        if (!(searchString.indexOf(term) !== -1)) {
            add = false;
        }
    });
    if (add) {
        createTRHtml(customer);
    }
}
