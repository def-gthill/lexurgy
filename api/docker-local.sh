../gradlew :api:stage
docker build -t lexurgy-services-local .
docker run -it -p 8080:8080 \
  -e API_KEY='exampleApiKey' \
  -e SINGLE_STEP_TIMEOUT=1 \
  -e REQUEST_TIMEOUT=5 \
  -e TOTAL_TIMEOUT=60 \
  lexurgy-services-local
