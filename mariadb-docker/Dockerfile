FROM mariadb:10.1.38

MAINTAINER Luis Guillermo Garcìa Aguilar luisggaguilar@gmail.com

ENV MYSQL_ROOT_PASSWORD=user1
ENV MYSQL_DATABASE=Farmacia

ADD Farmacia.sql /docker-entrypoint-initdb.d/Farmacia.sql
 
EXPOSE 3306
CMD ["mysqld"]

