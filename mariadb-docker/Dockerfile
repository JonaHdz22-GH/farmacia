FROM mariadb:10.1.38

ENV MYSQL_ROOT_PASSWORD=user1
ENV MYSQL_DATABASE=Farmacia

ADD Farmacia.sql /docker-entrypoint-initdb.d/Farmacia.sql
 
EXPOSE 3306
CMD ["mysqld"]

