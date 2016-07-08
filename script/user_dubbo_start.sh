#!/bin/sh

COMMON_LIB_HOME=/iPaaS-User-Dubbo
DUBBO_CONFIG_PATH=${COMMON_LIB_HOME}/config

for file in ${COMMON_LIB_HOME}/**/*.jar;
do CP=${CP}:$file;
done

CLASSPATH="${CP}"
CLASSPATH="${DUBBO_CONFIG_PATH}:${CLASSPATH}"
export CLASSPATH

MEM_ARGS="-Xms256m -Xmx512m -XX:PermSize=64M -XX:MaxPermSize=128M"
JAVA_OPTIONS="-Dfile.encoding=UTF-8 -Djava.net.preferIPv4Stack=true -Dsun.net.inetaddr.ttl=10 -Dpaas.dubbo.provider.timeout=300000"

START_CMD="${MEM_ARGS} -Dpaas.dubbo.registry.address=${DUBBO_REGISTRY_ADDR} -Dpaas.dubbo.protocol.port=${DUBBO_PORT} ${JAVA_OPTIONS} com.ai.paas.ipaas.DubboServiceStart >> /iPaaS-User-Dubbo.log & 2 > 1 &"

echo ${JAVA_HOME}
echo ${CLASSPATH}
echo ${DUBBO_PORT}
echo ${START_CMD}

sed -i "s/jdbc.url=.*/jdbc.url=jdbc:mysql:\/\/${DB_HOST}\/${DB_NAME}?useUnicode=true\&characterEncoding=UTF-8/g" /iPaaS-User-Dubbo/config/context/jdbc.properties
sed -i "s/jdbc.username=.*/jdbc.username=${DB_USRER}/g" /iPaaS-User-Dubbo/config/context/jdbc.properties
sed -i "s/jdbc.password=.*/jdbc.password=${DB_PWD}/g" /iPaaS-User-Dubbo/config/context/jdbc.properties
sed -i "s/paas.dubbo.protocol.port=.*/paas.dubbo.protocol.port=${DUBBO_PORT}/g" /iPaaS-User-Dubbo/config/context/dubbo.properties
sed -i "s/paas.dubbo.registry.address=.*/paas.dubbo.registry.address=${DUBBO_REGISTRY_ADDR}/g" /iPaaS-User-Dubbo/config/context/dubbo.properties
sed -i "s/zookeeper.address=.*/zookeeper.address=${ZK_ADDR}/g" /iPaaS-User-Dubbo/config/context/zookeeper.properties

if [ ! -n "$LOG_LEVEL" ] ;then  
    sed -i "s/\<Root level=.*/\<Root level=\"INFO\"\>/g" /iPaaS-User-Dubbo/config/log4j2.xml 
else  
    sed -i "s/\<Root level=.*\<Root level=\"${LOG_LEVEL}\"\>/g" /iPaaS-User-Dubbo/config/log4j2.xml
fi

echo "------------------- portal dubbo start --------------------"
java ${START_CMD}
echo "------------------- portal dubbo server started! -------------------"
