javascript: (function (){
    function autoFill(ele, val) {
      if (document.getElementById(ele) && val != "") {
        document.getElementById(ele).value = val;
      }
    }
    autoFill("order_billing_name", "Chris Smith");
    autoFill("order_email", "insertEmail@gmail.ca");
    autoFill("order_tel", "4167896650");
    autoFill("bo", "39 Dewey Dr");
    autoFill("order_billing_zip", "99501");
    autoFill("order_billing_city", "Anchorage");
    document.getElementById("order_billing_country").value = "USA";
    document.getElementById("order_billing_state").value = "AK";
    autoFill("rnsnckrn", "4060511703000022");
    document.getElementById("credit_card_month").value = "01";
    document.getElementById("credit_card_year").value = "2021";
    autoFill("orcer", "116");
    document.getElementsByClassName("icheckbox_minimal")[1].getElementsByClassName("iCheck-helper")[0].click()
})();
