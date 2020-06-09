javascript: (function (){
    function autoFill(ele, val) {
      if (document.getElementById(ele) && val != "") {
        document.getElementById(ele).value = val;
      }
    }
    autoFill("order_billing_name", "Chris Smith");
    autoFill("order_email", "insertEmail@gmail.ca");
    autoFill("order_tel", "InsertPhoneNumber");
    autoFill("bo", "Insert Address");
    autoFill("order_billing_zip", "99501");
    autoFill("order_billing_city", "Anchorage");
    document.getElementById("order_billing_country").value = "USA";
    document.getElementById("order_billing_state").value = "AK";
    autoFill("rnsnckrn", "InsertCreditCardNumber");
    document.getElementById("credit_card_month").value = "00";
    // insert a value for the expiry month
    document.getElementById("credit_card_year").value = "2020";
    // insert a value for the expiry year
    autoFill("orcer", "116");
    // insert a value for the cvv
    document.getElementsByClassName("icheckbox_minimal")[1].getElementsByClassName("iCheck-helper")[0].click()
})();
