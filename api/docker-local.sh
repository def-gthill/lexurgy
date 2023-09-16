docker build -t lexurgy-services-local .
docker run -it -p 8080:8080 -e API_KEY='exampleApiKey' -e TIMEOUT=30 -e SINGLE_STEP_TIMEOUT=1 lexurgy-services-local
