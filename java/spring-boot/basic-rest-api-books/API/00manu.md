# notas, guia, documentacion

### instalacion

este proyecto me lo hice siguiendo esta guia :



https://www.freecodecamp.org/news/how-to-build-a-rest-api-with-spring-boot-using-mysql-and-jpa-f931e348734b/


How to build a Rest API with Spring Boot using MySQL and JPA
 
  
 
  
 
  
 
como el mysql fallaba, me baje el unicontroller
 
al abrirlo la primera vez te pide la contraseña del root, le puse 32145678
 
cree schema, tabla y usuario :
 
mysql> create schema kk22 ;
mysql> use kk22
mysql> CREATE TABLE kk23( nombre TEXT (25) , numero INT );
 
CREATE USER 'kk24'@'localhost' IDENTIFIED BY '32145678';
 
GRANT ALL PRIVILEGES ON * . * TO 'kk24'@'localhost';
 
  
 
  
 
  
 
el generador online maven tuve que ejecutarlo en i explorer, no chrome
 
al ejecutarlo, fallaba, no se encendia el servidor
 
y me cree la tablita pal ejemplito :  
 
CREATE TABLE books ( id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY , book_name TEXT (25), author_name TEXT (25), isbn TEXT (25) );
 
  
 
  
 
  
 
siguiente error :
 
2019-08-05 19:24:27.347 ERROR 36092 --- [  restartedMain] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Exception during pool initialization.
java.sql.SQLException: The server time zone value 'Hora de verano romance' is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the serverTimezone configuration property) to use a more specifc time zone value if you want to utilize time zone support.
  at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:129) ~[mysql-connector-java-8.0.16.jar:8.0.16]
 
-> solucion ->
 
SET GLOBAL time_zone = '+1:00';
 
  
 
  
 
  
 
y por fin funciona la aplicacion
 
insert into books ( book_name , author_name , isbn ) values ( 'quijote' , 'cervantes' , 'feijfe868628' );
insert into books ( book_name , author_name , isbn ) values ( 'ratas' , 'camus' , 'vkdej9282' );
insert into books ( book_name , author_name , isbn ) values ( 'celestina' , 'rojas' , 'oeojg82827' );
 
curl -X GET     http://127.0.0.1:8080/books/3
 
C:\manu\git\manu23>curl -X GET     http://127.0.0.1:8080/books
[{"id":1,"book_name":"quijote","author_name":"cervantes","isbn":"feijfe868628"},{"id":3,"book_name":"ratas4a","author_name":"camus","isbn":"vkdej9282"},{"id":4,"book_name":"celestina","author_name":"rojas","isbn":"oeojg82827"}]
 
C:\manu\git\manu23>curl -X GET     http://127.0.0.1:8080/books/3
{"id":3,"book_name":"ratas3","author_name":"camus","isbn":"vkdej9282"}
C:\manu\git\manu23>curl -X GET     http://127.0.0.1:8080/books/4
{"id":4,"book_name":"celestina","author_name":"rojas","isbn":"oeojg82827"}
 
  
 
el put consegui que funcionase en el postman, pero no con el curl
no funciona por las comillas, en linux supongo que si funcionaria
 
curl -X PUT     http://127.0.0.1:8080/books/3    -d "{   "book_name": "ratas3",   "author_name": "camus",   "isbn": "vkdej9282" }"
curl -X PUT     http://127.0.0.1:8080/books/3    -d '{   "book_name": "ratas3",   "author_name": "camus",   "isbn": "vkdej9282" }'
 
pero consiguo que funcione en power shell : 
 
 
``` 
PS C:\Users\manue>
PS C:\Users\manue> $book = @{
>>     book_name='ratas4a'
>>     author_name='camus'
>>     isbn='vkdej9282'
>> }
 
  
 
PS C:\Users\manue> $json = $book | ConvertTo-Json
 
  
 
PS C:\Users\manue> Invoke-RestMethod  http://127.0.0.1:8080/books/3  -Method Put -Body $json -ContentType 'application/j
son'
id book_name author_name isbn
-- --------- ----------- ----
 3 ratas4a   camus       vkdej9282
´´´
 
 
  
 
  
 
  
 
  