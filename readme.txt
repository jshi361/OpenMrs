Flu Data Tool Module:

Adding patient into a email list and enroll them to free flu articles.

Installation Guide:

Before installing the module, changes need to make to the database connection code, and the smtp mail server for sending emails.

  Change database connection:
  Edit 'FludatatoolSentController.java' in /fludatatool/omod/src/main/java/org/openmrs/module/fludatatool/web/controller
      & 'viewFDT.jsp' in /fludatatool/omod/src/main/webapp
  Change email authentication with gmail
  Edit 'FDTUpdateEmailController.java' in /fludatatool/omod/src/main/java/org/openmrs/module/fludatatool/web/controller


Package the module:

  After you editing the email and database configuration for the module, you will have to package the module again using maven

  After installing maven or if you have maven already and can execute 'mvn' from command line.

  To package the module navaigate to the folder where you have both api folder and omod folder, in the command line execute 'mvn package'


To install the module, either use a admin page, that is provide by the Legacy GUI Module https://wiki.openmrs.org/display/docs/Legacy+UI+Module
                        Or you can navigate into your openmrs server directory and drop the 'fludatatool-1.0.0-SNAPSHOT.omod' file found in fludatatool/omod/target/
