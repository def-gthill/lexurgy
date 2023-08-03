docker build -t lexurgy-services-local .
docker run -it -p 8080:8080 -e API_KEY='exampleApiKey' lexurgy-services-local
