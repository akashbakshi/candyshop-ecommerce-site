echo "Creating users..."
mongo admin --host localhost -u root -p root --eval "db.createUser({user: 'candyshopdba', pwd: 'supersecret',roles: [{role: 'readWrite', db: 'candyshopdb'}]}); db.createUser({user: 'admin', pwd: 'somuchpower', roles: [{role: 'userAdminAnyDatabase', db: 'admin'}]});"
echo "Users created."