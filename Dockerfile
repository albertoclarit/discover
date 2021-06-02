FROM    tomee:8-jre-8.0.6-webprofile


COPY  target/*.war /usr/local/tomee/webapps/ROOT.war
COPY  target/*.war /usr/local/tomee/conf/tomcat-users.xml
COPY  redisson.conf /usr/local/tomee/redisson.conf

COPY  ext/redisson-all-3.15.5.jar  /usr/local/tomee/lib/redisson-all-3.15.5.jar
COPY  ext/redisson-tomcat-9-3.15.5.jar  /usr/local/tomee/lib/redisson-tomcat-9-3.15.5.jar
