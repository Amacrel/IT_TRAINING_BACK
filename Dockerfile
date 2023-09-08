# cat Dockerfile
FROM mysql:latest 

ENV MYSQL_DATABASE=It-training
ENV MYSQL_USER=db_user
ENV MYSQL_PASSWORD=db_user_pass
ENV MYSQL_ROOT_PASSWORD=my_secret_password
ENV NAMESQL=IT-TRAINING.sql

COPY $NAMESQL /docker-entrypoint-initdb.d/

EXPOSE 3306