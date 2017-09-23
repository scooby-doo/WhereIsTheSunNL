# Where is the sun in Netherlands?
This application shows a list of cities grouped by weather:
if there is a place with sun and no rain in the Netherlands, you will see it in the list!

# Instructions:

## Run project

`sbt run`

## Run in production mode

`sbt runProd`

To stop it, type:

`CTRL + C`

## Load Testing
Install wrk
`brew install wrk` for OS X
`wrk -t12 -c400 -d30s https://staydry-nl.herokuapp.com/`

## Known dev issues
logback filetrs do not work in dev mode

https://github.com/playframework/playframework/issues/822
https://stackoverflow.com/questions/20210574/play-fails-to-load-custom-log-back-appender