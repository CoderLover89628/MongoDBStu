cd C:\Program Files\MongoDB\Server\3.0\bin

注册服务 两种方式
mongod --logpath D:\MongoDB\log\mongodb.log --logappend --dbpath D:\MongoDB\db --directoryperdb --serviceName MongoDB --install
mongod.exe --logpath D:\MongoDB\log\log.txt --dbpath D:\MongoDB\db --install --serviceName "MongoDB"
mongod.exe --config=D:\MongoDB\mongo.config --install --serviceName "MongoDB"


参考网址：
官方MongoDB-Java-api文档：
http://api.mongodb.org/java/3.2/

Mongo-java-driver3.2.0Jar包下载:(注意选择版本：mongo-java-driver)
http://mongodb.github.io/mongo-java-driver/?_ga=1.129228044.1417091622.1449625614

Mongo-java-driver3.2.0源码：https://oss.sonatype.org/content/repositories/releases/org/mongodb/mongo-java-driver/3.2.0/
GitHub上MongoDB-driver源码：https://github.com/mongodb/mongo-java-driver/tree/3.2.x

mvn:http://mvnrepository.com/artifact/org.mongodb/mongo-java-driver/3.2.0

文摘blog：
http://blog.csdn.net/leoleocmm/article/details/17260749
http://www.cnblogs.com/hoojo/archive/2011/06/02/2068665.html
http://www.liyanblog.cn/articles/2012/11/01/1351759880413.html
http://www.cnblogs.com/zhoulf/p/4571647.html

