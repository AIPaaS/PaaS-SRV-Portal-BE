#!/bin/sh

for file in ${COMMON_LIB_HOME}/**/*.jar;
do CP=${CP}:$file;
done

CLASSPATH="${CP}"
CLASSPATH="${DUBBO_CONFIG_PATH}:${CLASSPATH}"
export CLASSPATH
START_CMD="${MEM_ARGS} -Dpaas.dubbo.registry.address=${DUBBO_REGISTRY_ADD} -Dpaas.dubbo.protocol.port=$DUBBO_PORT ${JAVA_OPTIONS} com.ai.paas.ipaas.DubboServiceStart > /iPaaS-User-Dubbo.log &"

echo ${JAVA_HOME}
echo ${CLASSPATH}
echo ${DUBBO_PORT}
echo ${DUBBO_SERVER_NAME}
echo ${DUBBO_REGISTRY_ADD}
echo ${DUBBO_CONFIG_PATH}
echo ${PROCESS_PARM}
echo ${MEM_ARGS}
echo ${JAVA_OPTIONS}
echo ${START_CMD}

echo "------------------- portal dubbo start --------------------"
java ${START_CMD}
echo "------------------- portal dubbo server started! -------------------"
