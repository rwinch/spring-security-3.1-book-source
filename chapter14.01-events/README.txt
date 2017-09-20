To run this project in Spring Tool Suite you must use the GWT plugin. You can find detailed instructions
within the the GWT documentation https://developers.google.com/web-toolkit/usingeclipse A summary of the
steps can be found below:

Install the GWT Eclipse Plugin

* Help -> Install New Software...
* Press Add...
* For Eclipse 4.2 Enter https://dl.google.com/eclipse/plugin/4.2 For other versions refer to the detailed
  instructions at https://developers.google.com/eclipse/docs/install-eclipse-3.7
* Press OK
* Select to install Google App Engine Java SDK, Google Web Toolkit 2.5.0, Google Plugin for Eclipse
* Click Next
* Click Next
* Accept the terms and Click Finish
* When asked to restart, select Restart Now.

To run the application perform the following steps:

* Right click this project and select Debug As -> Web Application
* Select ApplicationScaffold.html
* A URL will appear next to the console window that looks something like this:
  http://127.0.0.1:8888/ApplicationScaffold.html?gwt.codesvr=127.0.0.1:9997
  Paste the URL into Firefox or Chrome
* You will be prompted to install a plugin for your browser. Install the plugin.

You can now use the application with the username admin1@example.com and the password admin1