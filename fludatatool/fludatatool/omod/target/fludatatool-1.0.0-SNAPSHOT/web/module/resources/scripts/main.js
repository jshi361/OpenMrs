window.onload = function() {
	console.log(window.emails);
};

function sentEmail(email) {
	console.log(emails);
	
	var xmlhttp = new XMLHttpRequest();

    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == XMLHttpRequest.DONE ) {
           if (xmlhttp.status == 200) {
        	   alert(xmlhttp.responseText);
           }
           else if (xmlhttp.status == 400) {
              alert('There was an error 400');
           }
           else {
               alert('something else other than 200 was returned');
           }
        }
    };

    xmlhttp.open("GET", "http://localhost:8080/openmrs/module/fludatatool/sentArticles.form?email="+email, true);
    xmlhttp.send();
}