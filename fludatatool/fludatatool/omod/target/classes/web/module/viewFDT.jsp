<%@ include file="/WEB-INF/template/include.jsp"%>

<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<script type="text/javascript" src="https://cdn.emailjs.com/dist/email.min.js"></script>
<script type="text/javascript">
   (function(){
      emailjs.init("user_KpwGTPWJfjNDpfdcTvtBg");
   })();
</script>

<openmrs:htmlInclude file="/moduleResources/fludatatool/css/main.css"/>

<openmrs:htmlInclude file="/moduleResources/fludatatool/scripts/main.js"/>
	<style>
	.button {
    background-color: #ccc;
    -moz-border-radius: 5px;
    -webkit-border-radius: 5px;
    border-radius:6px;
    color: #fff;
    font-family: 'Oswald';
    font-size: 20px;
    text-decoration: none;
    cursor: poiner;
     border:none;
     display:inline-block;
	}
	</style>
		<script>
		function updateEmail() {
			var pid = document.getElementById("pid").value;
			var emailLocal = document.getElementById("emailLocal").value;
			var emailDomain = document.getElementById("emailDomain").value;
			
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

		    xmlhttp.open("GET", "http://localhost:8080/openmrs/module/fludatatool/updateEmail.form?pid="+pid+"&emailLocal="+emailLocal+"&emailDomain="+emailDomain, true);
		    xmlhttp.send();
		}
		
			var emails = [];
				<%--insert DB QUERY HERE--%>
<%  
			String username = "root";
   			String password = "password";
   			String dbURL = "jdbc:mysql://localhost:3306/server9";
            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            
            connection = DriverManager.getConnection(dbURL, username, password);

            Statement statement = connection.createStatement();

            String command = "select * from fdt_contact_info";
			ResultSet resultset=null; 
            resultset = statement.executeQuery(command);
			
			String email = "";
			ArrayList<String> emails = new ArrayList<String>();
			int numOfSubPatient  = 0;
			while(resultset.next()){
			  email = resultset.getString(3) + "@" + resultset.getString(4);
			  emails.add(email);
			  numOfSubPatient++;
			  %>
			  	emails.push("<%= email %>");
			  <%
			}
			
			request.setAttribute("emails", emails);
			connection.close();
			%>
			</script>
<div id="fdt-container">
	<div id="fdt-btn" value="<%= emails.get(0) %>" onclick='sentEmail(this.getAttribute("value"))'>
		<div id="fdt-main-header">Sent Articles</div>
	</div>
	<div id="fdt-tip">
		<%= numOfSubPatient %> Patients Are Subscribe for the Articles
	</div>
</div>

<h3>Add email to you patient</h3>
<div>

	<input id="pid" type="text" placeholder="Patient ID"/>
	<br>
	<p>Enter the email for the patient below:</p>
	<input id="emailLocal" type="text"/>@<input id="emailDomain" type="text"/>
	
	
	<div class="button" id="email-button" onclick="updateEmail()">Enter/Update Email</div>
</div>
<%-- <%
	String[] emailList = (String[])request.getAttribute("emailList");

	for(String email: emailList) {
%>
	<%= email %>
<% 
	}
%> --%>

<%@ include file="/WEB-INF/template/footer.jsp"%>
