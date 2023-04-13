# Pilotes
Manage Pilotes orders by restful apis:


This is a spring boot application released under the branch "main".

It is dokerized and there is a dokercompose yaml file.
The docker image is built with:
docker build -t pilotes-management-h2-image . 
and compose is run with the command:
docker-compose -f docker-compose-server-h2.yml up -d

The app can be run launching the java class SpringBootH2Application in the root of the sources.

There are several tests for almost the cases.

To test the application when launched there are in the soap-ui folder a collection of calls that
can be made against the application.
The first call to be run in order to save initial data in the h2 in memory db is in the
pilotes-add-customer-api-soapui-project.xml project file.

There is also a utility api to generate the jwt token in order to authorize the getter apis.
But in case you can use this static token and it works: 

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VybmFtZSIsImlhdCI6MTY3ODQ2MDk5NywiZXhwIjoxNjc4NTM3Mjk3fQ.iJTIkqrSEkw2lk3Y1q9TfoUXW-3sglMV5qOUUroQ2nMl0XBzpf7mAu_cebqTonfec-iNwmBgdgEBd902xY1MLg
