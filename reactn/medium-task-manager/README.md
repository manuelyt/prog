# todo app

hay que hacer :

npm install
<br>
npm start

como esta hecho con expo, al hacer el npm start se lanza el expo
<br>
hay que ponerlo en tunnel, y despues con el expo del movil pillar el qr. ( despues ya se puede usar el emulador ) 
<br><br><br>
me lo baje de aqui :

https://levelup.gitconnected.com/react-native-mongodb-stitch-building-a-crud-application-without-a-server-3e4ae0b34d67
 
https://github.com/deeayeen/medium-task-manager.git


tuve que poner esto en el app id : taskmanager-ankpp
<br>
como supongo que no hice bien el tutorial, y en el "task manager stitch service name" puse tmssn en vez de mongodb-atlas, tambien tuve que poner esto en el servicio
  
 
 

<br><br><br><br><br><br>



 
 
para borrar registros de la bbdd
 
https://cloud.mongodb.com
 
  
 
asi se hace la select : 
 
  
 
!!! !!! !!! ojo
para que funcione tiene que tener esquema
puede generarlo el automaticamente
 
  
 
query Query {  
  tasks {
    description,status,_id
  }
}
 
  
 
 {
  "data": {
    "tasks": [
      {
        "_id": "5e53288c6feb75c16697afe6",
        "description": "Hhgg",
        "status": "completed"
      },
      {
        "_id": "5e532a4f3f5a9cab743701bc",
        "description": "Jdjfh",
        "status": "new"
      },
      {
        "_id": "5e54aca5bc201ff6fad50736",
        "description": "Hcgvv",
        "status": "new"
      }
    ]
  }
}
 
  
 
  
 
para borrar : 
 
mutation {
  deleteOneTask(query: { _id: "5e532a5a3f5a9cab743701bd" }) {
    _id   status  description
  }
}
  
 
 {
  "data": {
    "deleteOneTask": {
      "_id": "5e532a5a3f5a9cab743701bd",
      "description": "aa",
      "status": "new"
    }
  }
}
 
 


<br><br><br><br><br><br>

















esto es lo que el colega ( dan halperin ) tenia en el readme original :

Replace "YOUR APP ID" in "App.js" with your Stitch App ID






