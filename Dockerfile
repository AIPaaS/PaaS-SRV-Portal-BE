# Pull base image  
FROM centos:7

RUN yum install -y java-1.8.0-openjdk

# deploy user dubbo service
RUN mkdir iPaaS-User-Dubbo && cd /iPaaS-User-Dubbo && mkdir 3rd-libs lib config
COPY ./build/3rd-libs/*.jar /iPaaS-User-Dubbo/3rd-libs/
COPY ./build/libs/*.jar /iPaaS-User-Dubbo/lib/
COPY ./build/all-config/* /iPaaS-User-Dubbo/config/

COPY ./script/user_dubbo_start.sh /user_dubbo_start.sh
RUN chmod 755 /user_dubbo_start.sh

## copy config files
RUN cd /iPaaS-User-Dubbo/config && mkdir context
COPY ./build/all-config/context/* /iPaaS-User-Dubbo/config/context/

# set start parameter for dubbo service
ENV COMMON_LIB_HOME /iPaaS-User-Dubbo
ENV PATH $CATALINA_HOME/bin:$PATH

# set properties param
ENV DB_HOST ""
ENV DB_NAME ""
ENV DB_USRER ""
ENV DB_PWD ""
ENV DUBBO_PORT ""
ENV DUBBO_REGISTRY_ADDR ""
ENV ZK_ADDR ""

RUN sed -i 's/jdbc.url=.*/jdbc.url=jdbc:mysql:\/\/${DB_HOST}\/${DB_NAME}?useUnicode=true\&characterEncoding=UTF-8/g' /iPaaS-User-Dubbo/config/context/jdbc.properties
RUN sed -i 's/jdbc.username=.*/jdbc.username=${DB_USRER}/g' /iPaaS-User-Dubbo/config/context/jdbc.properties
RUN sed -i 's/jdbc.password=.*/jdbc.password=${DB_PWD}/g' /iPaaS-User-Dubbo/config/context/jdbc.properties

RUN sed -i 's/paas.dubbo.protocol.port=.*/paas.dubbo.protocol.port=${DUBBO_PORT}/g' /iPaaS-User-Dubbo/config/context/dubbo.properties
RUN sed -i 's/default.dubbo.registry.address=.*/default.dubbo.registry.address=${DUBBO_REGISTRY_ADDR}/g' /iPaaS-User-Dubbo/config/context/dubbo.properties

RUN sed -i 's/zookeeper.address=.*/zookeeper.address=${ZK_ADDR}/g' /iPaaS-User-Dubbo/config/context/zookeeper.properties

# Expose ports.
EXPOSE 20999

# Define default command.
CMD ["/user_dubbo_start.sh"]