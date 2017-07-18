   javac -d web\WEB-INF\classes\ src\TestingServlet.java
   jar -cvf target\alevikzs.war -C web .
   copy target\alevikzs.war "%CATALINA_HOME%\webapps\alevikzs.war"
   net stop tomcat9
   net start tomcat9