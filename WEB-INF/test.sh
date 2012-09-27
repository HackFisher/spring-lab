curl -d "name=test&type=abc&timefrom=09-10-2012" http://10.64.4.136:8080/flybyu/dispatcher/saveActivity
curl http://10.64.4.136:8080/flybyu/dispatcher/viewAllActivities
curl -u rod:koala http://10.64.49.136:8080/flybyu/dispatcher/viewAllActivities

curl http://rod:koala@10.64.49.136:8080/flybyu/dispatcher/viewAllActivities