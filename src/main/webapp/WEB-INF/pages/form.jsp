<html>
<head>
    <title>Form Plugin Demo</title>

    <link href="/resources/assets/styles/form.css" rel="stylesheet"/>

    <style>
        #form-wrapper {
            font-family: Verdana, Arial, "Times New Roman";
            margin: 180px auto;
            width: 500px;
            background-color: #eeeeee;
            border: 2px solid #ccc;
            border-radius: 1%;
            padding: 40px 40px 20px;
        }
    </style>
</head>

<body>
<div id="form-wrapper"></div>
</body>

<script type="text/javascript" src="/resources/assets/scripts/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/resources/assets/scripts/custom/jquery-form.1.0.js"></script>

<script type="text/javascript">
    $(function () {
        $("#form-wrapper").form({
            name: "EmployerForm",
            title: "Register a new employer",
            ajaxOptions: {
                headers: {
                    "X-REQUESTED-BY": "form"
                },
                url: "/api/create"
            },
            fields: [
                {label: "First Name", type: "text"},
                {label: "Middle Name", type: "text"},
                {label: "Last Name", type: "text"},
                {label: "Company", type: "text"},
                {label: "Email Id", type: "email"},
                {label: "Contact", type: "phone"},
            ],
            submitLabel: "Create Employer",
            /*created: function (e) {
                console.log("created triggered! " + e.attr("id"));
            }*/
            responseerror: function(e, el, response) {
                console.log("[ERROR] >> " + response);
                //el.remove();
                return false;
            }
        });

    });
</script>

</html>