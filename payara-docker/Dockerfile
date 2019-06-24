FROM payara/server-full:5.183

MAINTAINER Luis Guillermo Garcìa Aguilar luisggaguilar@gmail.com

RUN wget -O /opt/payara/glassfish/lib/maridb.jar \
	 https://downloads.mariadb.com/Connectors/java/connector-java-2.3.0/mariadb-java-client-2.3.0.jar && \
	echo 'AS_ADMIN_PASSWORD=admin' > /opt/payara/pass.txt

WORKDIR /opt/payara/bin 

RUN ./asadmin start-domain && \
	./asadmin -I false --user admin --passwordfile /opt/payara/pass.txt create-jdbc-connection-pool \
	--datasourceclassname org.mariadb.jdbc.MariaDbDataSource --restype javax.sql.DataSource \
	--property user=root:password=root:servername=mariadbservice:portnumber=3306:databasename=Farmacia farmacia && \
	./asadmin -I false --user admin --passwordfile /opt/payara/pass.txt create-jdbc-resource \
	--connectionpoolid farmacia jdbc/farmacia && \
	./asadmin -I false --user admin --passwordfile /opt/payara/pass.txt stop-domain

	
WORKDIR /opt/payara
COPY Farmacia-1.0-SNAPSHOT.war $DEPLOY_DIR
