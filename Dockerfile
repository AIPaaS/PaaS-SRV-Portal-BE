# Pull base image  
FROM centos:7

RUN yum install -y java-1.8.0-openjdk

# deploy user dubbo service
RUN mkdir iPaaS-User-Dubbo logs && cd /iPaaS-User-Dubbo && mkdir 3rd-libs lib config
COPY ./build/3rd-libs/*.jar /iPaaS-User-Dubbo/3rd-libs/
COPY ./build/libs/*.jar /iPaaS-User-Dubbo/lib/
COPY ./build/all-config/* /iPaaS-User-Dubbo/config/

COPY ./script/user_dubbo_start.sh /user_dubbo_start.sh
RUN chmod 755 /user_dubbo_start.sh
RUN chmod 755 /logs

# set start parameter for dubbo service
ENV COMMON_LIB_HOME /iPaaS-User-Dubbo
ENV PATH $CATALINA_HOME/bin:$PATH

ENV DUBBO_PORT="20999"
ENV DUBBO_SERVER_NAME="IPAAS-USER-SERV"
ENV DUBBO_REGISTRY_ADD="10.1.228.199:49181,10.1.228.200:49181,10.1.228.202:49181"
ENV DUBBO_CONFIG_PATH=$COMMON_LIB_HOME/config
ENV PROCESS_PARM="paas.dubbo.protocol.port=$DUBBO_PORT"
ENV MEM_ARGS="-Xms256m -Xmx512m -XX:PermSize=64M -XX:MaxPermSize=128M"
ENV JAVA_OPTIONS="-Dfile.encoding=UTF-8 -Djava.net.preferIPv4Stack=true -Dsun.net.inetaddr.ttl=10 -Dpaas.dubbo.provider.timeout=300000"

# Expose ports.
EXPOSE 20999

# Define default command.
CMD ["/user_dubbo_start.sh"]