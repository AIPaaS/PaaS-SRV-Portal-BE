#!/bin/sh

for file in ${COMMON_LIB_HOME}/**/*.jar;
do CP=${CP}:$file;
done

DUBBO_CONFIG_PATH=${COMMON_LIB_HOME}/config

CLASSPATH="${CP}"
CLASSPATH="${DUBBO_CONFIG_PATH}:${CLASSPATH}"
export CLASSPATH

MEM_ARGS="-Xms256m -Xmx512m -XX:PermSize=64M -XX:MaxPermSize=128M"
JAVA_OPTIONS="-Dfile.encoding=UTF-8 -Djava.net.preferIPv4Stack=true -Dsun.net.inetaddr.ttl=10 -Dpaas.dubbo.provider.timeout=300000"

START_CMD="${MEM_ARGS} -Dpaas.dubbo.registry.address=${DUBBO_REGISTRY_ADDR} -Dpaas.dubbo.protocol.port=${DUBBO_PORT} ${JAVA_OPTIONS} com.ai.paas.ipaas.DubboServiceStart > /iPaaS-User-Dubbo-${DUBBO_PORT}.log & 2 > 1 &"

echo ${JAVA_HOME}
echo ${CLASSPATH}
echo ${DUBBO_PORT}
echo ${START_CMD}

echo "------------------- portal dubbo start --------------------"
java ${START_CMD}
echo "------------------- portal dubbo server started! -------------------"
