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

# Expose ports.
EXPOSE 20999

# Define default command.
CMD ["/user_dubbo_start.sh"]