# Pull base image  
FROM centos:7

RUN yum install -y java-1.8.0-openjdk

# deploy user dubbo service
RUN mkdir iPaaS-User-Dubbo && cd /iPaaS-User-Dubbo && mkdir 3rd-libs lib config
COPY ./build/3rd-libs/*.jar /iPaaS-User-Dubbo/3rd-libs/
COPY ./build/libs/*.jar /iPaaS-User-Dubbo/lib/

COPY ./script/user_dubbo_start.sh /user_dubbo_start.sh
RUN chmod 755 /user_dubbo_start.sh

## copy config
RUN cd /iPaaS-User-Dubbo/config && mkdir context email mybatis
COPY ./build/all-config/context/* /iPaaS-User-Dubbo/config/context/
COPY ./build/all-config/email/* /iPaaS-User-Dubbo/config/email/
COPY ./build/all-config/mybatis /iPaaS-User-Dubbo/config/mybatis/
COPY ./build/all-config/*.* /iPaaS-User-Dubbo/config/

# Expose ports.
EXPOSE 20999

# Define default command.
CMD ["/user_dubbo_start.sh"]