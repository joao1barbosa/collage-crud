

sudo docker run --name postgres-faculdade \
  --restart unless-stopped \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=adm \
  -e POSTGRES_DB=faculdade \
  -p 5332:5432 \
  -d postgres

