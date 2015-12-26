# mazarin-test

Technologies used <br/>
<b>Java 7 (JEE),
Spring MVC and AOP,
Spring data JPA,
MySQL,
Apache Tiles,
Maven,
Wildfly</b>.



# Instructions to deploy
<ul>
<li>Clone the repository (https://github.com/Dmdl/mazarin-test.git)</li>
<li>Change properties of <b>db.properties</b> under resources folder (url,username,password)</li>
<li>Create a MySQL database (same as above property file's url)</li>
<li>Invoke maven command <b>mvn clean compile package</b></li>
<li>Copy generated war file (in side target of project root folder) to wildfly server (standalone/deployments folder) Tested on wildfly-8.2.1.Final</li>
<li>Navigate to http://your_ip:port/TestApp/  in web browser</li>
</ul>
