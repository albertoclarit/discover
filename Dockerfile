FROM    tomee:8-jre-8.0.6-webprofile

COPY  target/*.war /usr/local/tomee/webapps/discover.war
COPY  target/*.war /usr/local/tomee/conf/tomcat-users.xml
COPY  redisson.conf /usr/local/tomee/redisson.conf
