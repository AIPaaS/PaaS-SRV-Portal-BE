#!/bin/sh

for file in ${COMMON_LIB_HOME}/**/*.jar;
do CP=${CP}:$file;
done

CLASSPATH="${CP}"
CLASSPATH="${DUBBO_CONFIG_PATH}:${CLASSPATH}"

echo ${CLASSPATH}
echo ${DUBBO_PORT}
echo ${DUBBO_SERVER_NAME}
echo ${DUBBO_REGISTRY_ADD}
echo ${DUBBO_CONFIG_PATH}
echo ${PROCESS_PARM}
echo ${MEM_ARGS}
echo ${JAVA_OPTIONS}

echo "------------------- dubbo start --------------------"
{JAVA_HOME}/bin/java ${MEM_ARGS} -Dpaas.dubbo.registry.address=${DUBBO_REGISTRY_ADD} -Dpaas.dubbo.protocol.port=$DUBBO_PORT  ${JAVA_OPTIONS} com.ai.paas.ipaas.DubboServiceStart > ${HOME}/logs/iPaas-${DUBBO_SERVER_NAME}-${DUBBO_PORT}.log & 2 > 1 &
echo "------------------- user dubbo server started! log is [$PROCESS_PARM].logs -------------------"
