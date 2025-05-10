CONTAINER_NAME="postgres-faculdade"

if ! docker -v
then
    echo "❌ Docker não está instalado."
    exit 1
fi

if sudo docker ps --filter "name=^/${CONTAINER_NAME}$" | grep -wq "$CONTAINER_NAME"; then
    echo "✅ O contêiner '$CONTAINER_NAME' está em execução."
    exit 1
elif sudo docker ps -a --filter "name=^/${CONTAINER_NAME}$" | grep -wq "$CONTAINER_NAME"; then
    echo "▶️ Startando container '$CONTAINER_NAME'."
    sudo docker start "$CONTAINER_NAME"
    exit 1
else
    echo "🚀 Criando container '$CONTAINER_NAME'."
    sudo docker run --name postgres-faculdade \
      --restart unless-stopped \
      -e POSTGRES_DB=faculdade \
      -e POSTGRES_USER=postgres \
      -e POSTGRES_PASSWORD=adm \
      -v "$(pwd)/initdb":/docker-entrypoint-initdb.d \
      -p 5332:5432 \
      -d postgres
fi



