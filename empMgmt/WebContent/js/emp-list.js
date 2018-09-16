$(document).on("click", ".emp-list", function() {
	$('.emp-list-div').show();
	 console.log("insid func")
                $.get("empList", function(responseText) { 
                	$('.emp-list-div table tbody').empty();
                	console.log("success");
                	console.log(responseText)
                    //$('.emp-list-div').html("");
                	//var $tr = $("<tr>").appendTo($(".emp-list-div")); // Create HTML <ul> element and append it to HTML DOM element with ID "somediv".
                    $.each(responseText, function(index, employee) { // Iterate over the JSON array.
                    	var $tr = $("<tr>").appendTo($(".emp-list-div table"));
                        var td = ("<td></td><td>" + employee.id + "</td>"+"<td>" + employee.userName + "</td>"+"<td>" 
                        		+ employee.department + "</td>"+"<td>" + employee.role + " </td> " +"<td>"
                        		+employee.salary +"</td>");
                        		$tr.append(td);     // Create HTML <li> element, set its text content with currently iterated item and append it to the <ul>.
                    });

                });
            });