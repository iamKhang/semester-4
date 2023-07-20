mongoimport --drop -d dbGiuaKi -c companies "T:\data_kt giua ky\companies.json"
mongorestore --drop -d dbGiuaKi -c customers "T:\data_kt giua ky\customers.bson"
mongorestore --drop -d dbGiuaKi -c sales "T:\data_kt giua ky\sales.bson"
mongorestore --drop -d dbGiuaKi -c movies "T:\data_kt giua ky\movies.bson"