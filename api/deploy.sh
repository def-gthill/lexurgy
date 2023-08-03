heroku container:login

docker build -t lexurgy-services:latest --platform linux/amd64 .

docker tag lexurgy-services:latest registry.heroku.com/lexurgy-services/web
docker push registry.heroku.com/lexurgy-services/web
heroku container:release web --app lexurgy-services
