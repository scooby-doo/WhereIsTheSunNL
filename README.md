# Where is the sun in Netherlands?
This application shows a list of cities grouped by weather:
if there is a place with sun and no rain in the Netherlands, you will see it in the list!

# Instructions:

## Run together
`cd backend-with-frontend`

`sbt run`

## Run separately
Run Backend first:

`cd backend/`

`sbt run`

Then run the front end: 

`cd frontend/`

`python -m SimpleHTTPServer 8000`

Navigate to:  `http://localhost:8000`

## Run the backend in production mode
In the desired folder do:

`sbt runProd`

To stop it, type:

`CTRL + C`

# TODO:
## How much to the sun?
The application will also show the time needed to get to the sunny places, based on the location of the user.

## Proper Deployment
Figure out how to deploy separately the backend and frontend (or if it is actually needed)
https://stackoverflow.com/questions/41247687/how-to-deploy-separated-frontend-and-backend
https://www.reddit.com/r/webhosting/comments/6sh2lr/separate_frontend_and_backend_on_heroku/