# Suppose that network 'app_network' has been created with type bridge

# Product service
docker --context remote-server-thinhlh run --env-file .env -dp 8080:8080 --name product_container --network=app_network www.thinhlh.com/product_service:latest

# Transportation service
docker --context remote-server-thinhlh run --env-file .env -dp 8081:8081 --name transportation_container --network=app_network www.thinhlh.com/transportation_service:latest

# Route service
docker --context remote-server-thinhlh run --env-file .env -dp 8083:8083 --name route_container --network=app_network www.thinhlh.com/route_service:latest

# Organization service
docker --context remote-server-thinhlh run --env-file .env -dp 8082:8082 --name organization_container --network=app_network www.thinhlh.com/organization_service:latest

# Healthcheck service
docker --context remote-server-thinhlh run --env-file .env -dp 8084:8084 --name healthcheck_container --network=app_network www.thinhlh.com/healthcheck_service:latest