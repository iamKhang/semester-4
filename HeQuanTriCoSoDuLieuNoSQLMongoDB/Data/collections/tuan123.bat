mongoimport --drop -d collections -c xe D:\collections\xe.json
mongorestore --drop -d collections -c sinhvien D:\collections\dsSinhvien.bson
mongorestore --drop -d collections -c lophoc D:\collections\dsLophoc.bson
mongoimport --drop -d collections -c restaurants D:\collections\restaurants.json

