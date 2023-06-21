TEHNOLOGII WEB

Partea de Simple
app.use(express.static('public'))

Bold Solved 2020

# Satisfaceți următoarele cerințe:
- fișierul `index.html`, care conține textul `A simple app` este livrat de server ca conținut static (0.5 pts);
- butonul cu id-ul `del` există în pagină și se poate da click pe el(0.5 pts);
- la încărcarea paginii sunt încărcate toate elementele în tabelul cu id `main` cu un `tr` pentru fiecare (0.5 pts);
- când se dă click pe butonul `del` se șterg elementele cu numele prezent în text input-ul cu id-ul `name` (0.5 pts);
- elementele cu numele selectat pentru ștergere nu mai apar în tabel (0.5 pts);

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>A simple app</title>
    <script>
        window.onload = async () => {
            let btn = document.getElementById('del')
            let name = document.getElementById('name')

            btn.onclick = async () => {
                await deleteCar(name.value)
            } 

            let deleteCar = async (name) => {
                try 
                {
                  window.fetch('/cars/'+name,
                  {
                     method:'delete'
                  }
                  ).then((response)=>{return response.json();})
                  .then(()=>{
                      load();
                  });
            
            } catch (e) {
                console.warn(e.message);
            }

            }

            let tbl = document.getElementById('main')

            let load = async () => {
                try{
                    let response = await fetch(`/cars`)
                    let data = await response.json()
                    let rows = data.map((e) => `
                        <tr>
                            <td>
                                ${e.name}
                            </td>
                            <td>
                                ${e.color}
                            </td>
                        </tr>
                    `)
                    console.warn(rows)
                    tbl.innerHTML = rows.join('')
                }
                catch(err){
                    console.warn(err)
                }
            }
            load('')
        }
    </script>
</head>
<body>
    A simple app
    <input type="text" placeholder="name" id="name" />
    <table id=main></table>
    <button id="del" onclick=deleteCar()>Delete</button>
</body>
</html>



IN APP.JS

const express = require('express')

const app = express()
app.use(express.static('public'))

app.locals.cars = [{
    name :  'a',
    color : 'red'
},{
    name :  'b',
    color : 'blue'
}]

app.get('/cars', (req, res) => {
    res.status(200).json(app.locals.cars)
})

app.delete('/cars/:name', (req, res) => {
    app.locals.cars = app.locals.cars.filter((e) => e.name !== req.params.name)
    res.status(202).json({message : 'accepted'}) 
})

module.exports = app



# Satisfaceți următoarele cerințe:
- Fișierul `index.html`, trebuie sa contina un element de tip `paragraf` cu textul `Webtech app` si sa fie furnizat ca si continut static din directorul `public` (0.5 pts);
- Butoanele cu id-urile `load` si `delete` există în pagină și nu se afla intr-o stare disabled (0.5 pts);
- La apasarea butonului `load` sunt încărcate toate elementele din fisierul `data.json` în tabelul cu id `table` cu un `tr` pentru fiecare element si 3 `td-uri` pentru fiecare proprietate (0.5 pts);
- Input-ul de tip `text` cu id-ul `name` exista in pagina (0.5pts);
- La apasarea butonului `delete` se șterg elementele cu numele prezent în text input-ul cu id-ul `name` (0.5 pts);

<!DOCTYPE html>
<html>
    <head>
        <title>Webtech</title>
    </head>
    <body>
        <p>Webtech app</p>
        <table id="table"></table>
        <button id="load">Load</button>
        <button id="delete">Delete</button>
        <script>
        </script>
    </body>
</html>


const express = require('express');
const cors = require('cors');
const path = require('path');

const app = express();
app.use(express.static('public'))

app.use(cors());
app.get('/data', (req, res) => {
    res.status(200).json(app.data.json)
})

module.exports = app;




# Satisfaceți următoarele cerințe:
- fișierul `index.html`, care conține textul `A simple app` este livrat de server ca conținut static (0.5 pts);
- fișierul `profil.json` livrat de catre server respecta structura descrisa in test (0.5 pts)
- pagina `index.html` conține titlu de rang 1 cu textul `Profil Influencer` (0.5 pts)
- detaliile profiluli (name, instagram, youtube) sunt afisate in paragrafe separate in div-ul cu id=content (0.5 pts) 
- butonul convert afiseaza numarul de urmaritori pe instagram in milioane (ex: 5M); operatia se realizeaza doar pe client (0.5 pts)

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>A simple app</title>
    
    <script>
        

            let load = async () => {
                try{
                    let response = await fetch(`/profile.json`)

                }
                catch(err){
                    console.warn(err)
                }
            }

            let convert = () => {
                
            }
    </script>
</head>
<body>
  <h1>Profile Influencer</h1>
    <div id="content"></div>
    <input type="button" value="convert" id="convert" onclick="convert()" />
</body>
</html>


IN APP.JS

const express = require('express')
const { use } = require('../../../webtech_subj0_v3/var-3/main/app')

const app = express()
app.use(express.static('public'))

module.exports = app




# Satisfaceți următoarele cerințe:
- fișierul `index.html`, care conține textul `A simple app` este livrat de server ca conținut static (0.5 pts);
- butonul cu id-ul `load` există în pagină și se poate da click pe el(0.5 pts);
- când se dă click pe butonul cu id-ul `load` se cere lista de `cars` de pe server; mașinile cu culoare `red` sunt încărcate în tabelul cu id `main` cu un `tr` pentru fiecare (0.5 pts);
- tabelul conține câte un `tr` pentru fiecare mașină încărcată (0.5 pts);
- sunt afișate doar mașini cu culoarea `red` (0.5 pts);

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>A simple app</title>
    <script type="text/javascript">
    async function getJSON()
    {
        try 
        {
           window.fetch(
            '/cars',
           {
             method:'get',
             headers:
             {
                 'Content-Type':'application/json',
                 'Accept':'application/json'
             }
           }
           ).then((response)=>{return response.json();})
           .then((result)=>{
               for(var i=0;i<result.length;i++)
               {
                   if(result[i].color==='red')
                   {
                       var table=document.getElementById("main");
                       var row=table.insertRow(0);
                       var cell1=row.insertCell(0);
                       var cell2=row.insertCell(1);
                       cell1.innerHTML=result[i].name;
                       cell2.innerHTML=result[i].color;
                       
                   }
               }
           });
            
        } catch (e) {
            console.warn(e.message);
        }
    }
 
    </script>
</head>
<body>
    A simple app
    <button id="load" onClick=getJSON()>load</button>
    <table id=main></table>
</body>
</html>


In app.js
const express = require('express')

const app = express()

app.use('/',express.static('public'));

app.get('/cars', (req, res) => {
    res.status(200).json([{
        name :  'a',
        color : 'red'
    },{
        name :  'b',
        color : 'blue'
    }])
})

module.exports = app

# Satisfaceți următoarele cerințe:
- fișierul `index.html`, care conține textul `A simple app` este livrat de server ca conținut static (0.5 pts);
- butonul cu id-ul `reload` există în pagină și se poate da click pe el(0.5 pts);
- când se dă click pe butonul cu id-ul `reload` nimic in filtru, toate elementele sunt returnate (0.5 pts);
- când se dă click pe butonul cu id-ul `reload` cu valoarea `red` in filtru, elementele roșii sunt returnate (0.5 pts);
- când se dă click pe butonul cu id-ul `reload` cu o valoare in filtru care nu corespunde culorii niciunui element, este returnată o listă vidă (0.5 pts);

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>A simple app</title>
    <script>
        window.onload = async () => {
            let btn = document.getElementById('reload');
            let filter = document.getElementById('filter');

            btn.addEventListener("click",function(){
                 try 
                {
                  window.fetch('/cars?filter='+filter.value,
                  {
                     method:'get',
                     headers:
                     {
                         'Content-Type':'application/json',
                         'Accept':'application/json'
                     }
                  }
                  ).then((response)=>{return response.json();})
                  .then((data)=>{
                      load(filter.value,data);
                  });
            
            } catch (e) {
                console.warn(e.message);
            }
            })            
            
            let tbl = document.getElementById('main');

             let load = async (filter,data) => {
                try{
                    let rows = data.map((e) => `
                        <tr>
                            <td>
                                ${e.name}
                            </td>
                            <td>
                                ${e.color}
                            </td>
                        </tr>
                    `)
                    tbl.innerHTML = rows.join()
                }
                catch(err){
                    console.warn(err)
                }
            }
            load('')
        }
            
    </script>
</head>
<body>
    A simple app
    <input type="text" placeholder="filter" id="filter" />
    <button id="reload" onClick=load()>reload</button>
    <table id=main></table>
</body>
</html>



Bold Solved 2019

1) Realizează fisierul JSON din directorul public confrom schemei descrise în fisierul ./test/test.js - 2p
2) Adaugă un fisier index.html care citeste fisierul JSON printr-un request asincron si afiseaza continutul lui intr-un div - 3p

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>A simple app</title>
    <script>
        window.onload = async () => {
            let btn = document.getElementById('reload');
            let filter = document.getElementById('filter');
            btn.addEventListener("click",function(){
                 try 
                {
                  window.fetch('/cars?filter='+filter.value,
                  {
                     method:'get',
                     headers:
                     {
                         'Content-Type':'application/json',
                         'Accept':'application/json'
                     }
                  }
                  ).then((response)=>{return response.json();})
                  .then((data)=>{
                      load(filter.value,data);
                  });
            
            } catch (e) {
                console.warn(e.message);
            }
            })            
            
            let tbl = document.getElementById('main');

             let load = async (filter,data) => {
                try{
                    let rows = data.map((e) => `
                        <tr>
                            <td>
                                ${e.name}
                            </td>
                            <td>
                                ${e.color}
                            </td>
                        </tr>
                    `)
                    tbl.innerHTML = rows.join()
                }
                catch(err){
                    console.warn(err)
                }
            }
            load('')
        }
            
    </script>
</head>
<body>
    A simple app
    <input type="text" placeholder="filter" id="filter" />
    <button id="reload" onClick=load()>reload</button>
    <table id=main></table>
</body>
</html>

V0 S0
1) Realizează fisierul JSON din directorul public confrom schemei descrise în fisierul ./test/test.js - 2p
2) Adaugă un fisier index.html care citeste fisierul JSON printr-un request asincron si afiseaza continutul lui intr-un div - 3p

<!DOCTYPE html>
<html>
<body>
    <div>
    <p id="invoiceNumber"></p>
    <p id="invoiceSeries"></p>
    <p id="invoiceItems1"></p>
    <p id="invoiceItems2"></p>
    <p id="invoiceItems3"></p>
</div>
 

<script>
var xmlhttp = new XMLHttpRequest();
xmlhttp.onreadystatechange = function() {
  if (this.readyState == 4 && this.status == 200) {
    var myObj = JSON.parse(this.responseText);
    document.getElementById("invoiceNumber").innerHTML = myObj.invoiceNumber;
    document.getElementById("invoiceSeries").innerHTML = myObj.invoiceSeries;
    document.getElementById("invoiceItems1").innerHTML = myObj.invoiceItems[0].productName;
    document.getElementById("invoiceItems2").innerHTML = myObj.invoiceItems[0].quantity;
    document.getElementById("invoiceItems3").innerHTML = myObj.invoiceItems[0].productPrice;
   
  }
};
xmlhttp.open("GET", "invoice.json", true);
xmlhttp.send();
</script>

</body>
</html>



Bold pregatire examen JSON
<script>
    function loadJson(filename) {
          var xhttp = new XMLHttpRequest();
          xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
             document.getElementById("demo").innerHTML = this.responseText;
            }
          };
          xhttp.open("GET", filename, true);
          xhttp.send();
        }
    loadJson("invoice.json");
</script>

<div id="demo">test</div>





Bold pregatire examen JS


# Completati urmatoarele taskuri:
- `input` trebuie sa fie de tip `string`. Daca este dat un input de alt tip se va arunca un `Error` cu mesajul `Input should be a string`; (0.5 pts)
- `dictionary` este un vector de elemente de tip `string`. Daca cel putin un element nu este `string` se va arunca un `Error` cu mesajul `Invalid dictionary format`; (0.5 pts)
- Daca `dictionary` contine cuvinte, vor fi inlocuite in `input` cu prima litera, urmată de  o serie de caractere `*` urmate de ultima litera. Lungimea cuvantului rezultat este acceasi ca a celui initial (ex. 'test' va deveni 't**t') ; (0.5 pts)
- Se va returna un nou string, `input` nefiind modificat; (0.5 pts)
- Functia returneaza rezultatul corect si pentru cuvinte care incep cu litere mari. (0.5 pts)

function bowdlerize(input, dictionary){
    if(!(typeof input ==='string')){
        throw(new Error('Input should be a string'));
        
    }
            dictionary.forEach(element => {
                if(typeof element!="string"){
                    throw(new Error("Invalid dictionary format"));
                }
            });
        //pt ca input contine propozitii
            let cuvantCenzurat=input;
            let propozitie=input.split(" ")
        
        //daca in dictionary se regaseste un cuvant
        // input acesta este inlocuit cu t**t
            dictionary.forEach(cuvantDictionar=>{
               propozitie.forEach(cuvant=>{
                   let transforInLitereMici=cuvant.toLowerCase();
                   if(cuvantDictionar===cuvant ||
                    cuvantDictionar=== transforLitereMici){
                        let cuvantNou=cuvant[0] + "*".repeat(cuvant.length-2)+cuvant[cuvant.length-1]
                        cuvantCenzurat=cuvantCenzurat.replace(cuvant,cuvantNou)
                    }
                   
               })
            })
            return cuvantCenzurat
       
    }

const app = {
    bowdlerize
};
let input={
    type='string'
}
let dictionary={
    type:'array',
    items:{
        type:'string'

    }
    
}

module.exports = app;



# Completati urmatoarele taskuri:
- `input` trebuie sa fie de tip `string` sau `String`. Daca este dat un input de alt tip se va arunca un `Error` cu mesajul `Input should be a string`; (0.5 pts)
- `dictionary` este un vector de elemente de tip `string`sa `String`. Daca cel putin un element nu este `string` se va arunca un `Error` cu mesajul `Invalid dictionary format`; (0.5 pts)
- functia calculeaza frecventele relative ale cuvintelor in input si returneaza un dictionar care are cuvintele drept chei si frecventele drept valori (ex. pentru string-ul 'orange cat' rezultatul va fi {orange : 0.5, cat : 0.5}); (0.5 pts)
- daca stopWords contine cuvinte, ele vor fi ignorate pentru calcularea frecventelor (ex. pentru 'the orange cat' cu 'the' in stopWords rezultatul va fi {orange : 0.5, cat : 0.5}); (0.5 pts)
- functia returneaza rezultatul corect si pentru cuvinte care incep cu o litera mare, care sunt considerate identice cu varianta fara litera mare. (0.5 pts)

function calculateFrequencies(input, dictionary){
    if(!(typeof input==="string")){
        throw(new Error("Input should be a string"))
    }
   
    if(Array.isArray(dictionary))
    {
        let cuvinte = input.split(' ');
        let n = 0;
        let cuvinteNoi = [];
        let obj = {};
            
        for(let i = 0 ; i < dictionary.length ; i++)
        {
            if(typeof dictionary[i] !== 'string' )
            {
                throw new Error('Invalid dictionary format');
            }
        }
            
        for(let i=0;i<cuvinte.length;i++)
        {
            if(!dictionary.find(cuvant => cuvant === cuvinte[i].toLowerCase()))
            {
                n++;
                obj[cuvinte[i].toLowerCase()]=0;
                cuvinteNoi.push(cuvinte[i].toLowerCase());
            }
        }
            

        for(let i=0;i < cuvinteNoi.length ; i++)
        {
            obj[cuvinteNoi[i]] = 1/n;
        }

        return obj;
    }
    else
    {
        throw new Error('Invalid dictionary format');
    }
}

const app = {
    calculateFrequencies
};

module.exports = app;




# Completati urmatoarele taskuri:
- `name` trebuie sa fie de tip `string` sau `String`. Daca este furnizat alt tip este aruncat `Error` cu mesajul`name must be string or String`; (0.5 pts)
- daca i se cere unui obiect Duck sa inoate va returna un string (ex. daca avem un Duck cu numele `Donald` atunci string-ul returnat este `Donald is swimming`); (0.5 pts)
- o rata de cauciuc este atat de tip `Duck` cat si `RubberDuck`; (0.5 pts)
- daca i se cere unui obiect RubberDuck sa pluteasca va returna un string (ex. daca avem un RubberDuck cu numele `Donald` atunci string-ul returnat este `Donald floats`); (0.5 pts)
- daca i se cere unui obiect RubberDuck sa inoate va returna un string (ex. daca avem un RubberDuck cu numele `Donald` atunci string-ul returnat este `Donald can't swim, only float`); (0.5 pts)


class Duck{
    constructor(name){
        if(!name||typeof name !=="string"){
            throw(new Error("name must be string or String"))
        }
        this.name = name
    }
    move(){
        return `${this.name} is moving`
    }
    swim(){
        return `${this.name} is swimming`
    }
}

class RubberDuck extends Duck{
swim(){
    return `${this.name} can't swim, only float`
}
float(){
    return `${this.name} floats`

}

}

const app = {
    Duck,
    RubberDuck
}

module.exports = app




V0 S1

/*
 - funcția distance primește ca parametrii două array-uri
 - fiecare element poate apărea cel mult o dată într-un array
 - distanța dintre cele 2 array-uri este numărul de elemente diferite dintre ele
 - dacă parametrii nu sunt array-uri se va arunca o excepție ("InvalidType")
*/
function distance(first, second){
    let me = [...new Set(first)]
    let other = [...new Set(second)]
    let v1=first;
    let v2=second;

    if (!Array.isArray(v1) || !Array.isArray(v2)){
        throw new Error('InvalidType')
    }
    let diffCount = 0
    for (let item of me){
        if (other.indexOf(item) === -1){
            diffCount++
        }
        else{
            other.splice(other.indexOf(item), 1)            
        }
    }
    diffCount += other.length
    return diffCount
}

module.exports.distance = distance

SAU V0 S1
function distance(first, second){
    //TODO: implementați funcția
    // TODO: implement the function
        if(!(Array.isArray(first)) ||  !(Array.isArray(second) )){
        throw new Error("InvalidType");
        }
        else
        {
        let count = 0;
        let vector = [];
        for(let i=0;i< first.length;i++){
            //daca nu gasesc fisrt[i] in second intorc -1
            if(second.indexOf(first[i]) === -1 && vector.indexOf(first[i]) === -1 ){
                count = count +1;
                vector.push(first[i]);
            }
        }
        
        for(let i=0;i< second.length;i++){
            if(first.indexOf(second[i]) === -1 && vector.indexOf(second[i]) === -1 ){
                count = count +1;
                vector.push(second[i]);
            }
        }
        
        
        return count;
    }
}



V2 S1
/*
Exista un tip obiectual definit (Widget)
Funcția decorate adaugă la Widget o metodă numită enhance, care crește mărimea unui widget cu "n"
Dacă parametrul trimis nu este un număr, se aruncă o excepție ("InvalidType")
Metoda funcționează și asupra Widget-urilor deja declarate
*/

class Widget {
    constructor(name, size){
        this.name = name
        this.size = size
    }

    getDescription(){
        return `a ${this.name} of size ${this.size}`
    }
}

function decorate(){
    Widget.prototype.enhance = function (n){
        if (typeof n !== 'number'){
            throw new Error("InvalidType")
        }
        this.size += n
    }
}

module.exports.decorate = decorate
module.exports.Widget = Widget

V2 S2

// TODO: implementați funcția
    // adăugați o metoda pentru modificarea autorului
    // un autor inexistent nu poate fi modificat
    // numai câmpurile care sunt definite in request trebuie actualizate

const express = require('express')
const bodyParser = require('body-parser')
const Sequelize = require('sequelize')

const mysql = require('mysql2/promise')

const DB_USERNAME = 'root'
const DB_PASSWORD = 'pass'

mysql.createConnection({
    user : DB_USERNAME,
    password : DB_PASSWORD
})
.then(async (connection) => {
    await connection.query('DROP DATABASE IF EXISTS tw_exam')
    await connection.query('CREATE DATABASE IF NOT EXISTS tw_exam')
})
.catch((err) => {
    console.warn(err.stack)
})

const sequelize = new Sequelize('tw_exam', DB_USERNAME, DB_PASSWORD,{
    dialect : 'mysql',
    logging: false
})

let Author = sequelize.define('author', {
    name : Sequelize.STRING,
    email : Sequelize.STRING,
    address : Sequelize.STRING,
    age : Sequelize.INTEGER
},{
    timestamps : false
})



const app = express()
app.use(bodyParser.json())

app.get('/create', async (req, res) => {
    try{
        await sequelize.sync({force : true})
        for (let i = 0; i < 10; i++){
            let author = new Author({
                name : 'name ' + i,
                email : 'name' + i + '@nowhere.com',
                address : 'some address on ' + i + 'th street',
                age : 30 + i
            })
            await author.save()
        }
        console.warn('CREATED')
        res.status(201).json({message : 'created'})
    }
    catch(err){
        console.warn(err.stack)
        res.status(500).json({message : 'server error'})
    }
})

app.get('/authors', async (req, res) => {
    try{
        let authors = await Author.findAll()
        res.status(200).json(authors)
    }
    catch(err){
        // console.warn(err.stack)
        res.status(500).json({message : 'server error'})        
    }
})

app.post('/authors', async (req, res) => {
    try{
        let author = new Author(req.body)
        await author.save()
        res.status(201).json({message : 'created'})
    }
    catch(err){
        // console.warn(err.stack)
        res.status(500).json({message : 'server error'})        
    }
})

app.put('/authors/:id', async (req, res) => {
    let autor=await Author.findByPk(req.params.id)
    if(autor){
            await autor.update(req.body)
            res.status(202).json({message : 'accepted'})
    }else{
        res.status(404).json({message : 'not found'})
    }
    
})

app.delete('/authors/:id', async (req, res) => {
    let autor=await Author.findByPk(req.params.id)
    if(autor){
        await autor.destroy()
        res.status(202).json({message : 'accepted'})
}else{
    res.status(404).json({message : 'not found'})
}
    
})

app.listen(8080)

module.exports = app


V2 S3

// TODO : adăugați o componentă RobotForm 
// RobotForm ar să permită adăugarea unui robot

class RobotList extends Component {
    constructor(){
        super()
        this.state = {
            robots : []
        }
        this.addRobot=(robot)=>{
            this.store.addRobot(robot)
    
        }
    }
    componentDidMount(){
        this.store = new RobotStore()
        this.setState({
            robots : this.store.getRobots()
        })
        this.store.emitter.addListener('UPDATE', () => {
            this.setState({
                robots : this.store.getRobots()
            })          
        })
    }
    render() {
        return (
            <div>
                 
                {
                    this.state.robots.map((e, i) => 
                        <Robot item={e} key={i} />
                    )
                }
                <RobotForm onAdd={this.addRobot}/>
            </div>
        )
    }
}

export default RobotList




V4 S1
/*
Exista un tip obiectual definit (Bird)
Să se definească tipul Penguin.
Un pinguin este un tip copil pentru Bird și are în plus metoda swim(distance)
Un pinguin nu poate fi creat fără un nume de tip string
Un pinguin nu poate să zboare și va spune asta dacă i se cere
Dacă se apelează makeNest, un pinguin va apela metoda părintelui său
Vedeți testele pentru formatul exact al mesajelors
*/

class Bird {
    constructor(name){
        this.name = name
    }

    fly(distance){
        return `${this.name} flies ${this.distance}`
    }

    makeNest(){
        return `${this.name} makes a nest`
    }
}

class Penguin extends Bird {
    constructor(name){
        if (!name || typeof name !== 'string'){
            throw new Error('CreationError')
        }
        super(name)
    }

    fly(distance){
        return `${this.name} is a penguin and cannot fly`
    }

    swim(distance){
        return `${this.name} swims ${distance}`     
    }
}

module.exports.Bird = Bird
module.exports.Penguin = Penguin


V4 S2
// TODO: adăugați funcția pentru cererea listei autorilor
    // ar trebui să trimită clientului lista autorilor
    // ar trebui să permită paginare cu un număr de pagina pageNo și o mărime de pagină pageSize trimiși prin query 
    
app.get('/authors', async (req, res) => {
    
    try{
        let pageSize=req.query.pageSize ? parseInt(req.query.pageSize):5
        let pageNo=req.query.pageNo ? parseInt(req.query.pageNo):0
        let authors
        if(pageNo){
            authors=await Author.findAll({
                limit:pageSize,
                offset:pageNo*pageSize
            })
        }else{
            authors=await Author.findAll()
        }
        res.status(200).json(authors)   
    }catch(err){
        // console.warn(err.stack)
        res.status(500).json({message : 'server error'})        
    }
})

app.post('/authors', async (req, res) => {
    try{
        let author = new Author(req.body)
        await author.save()
        res.status(201).json({message : 'created'})
    }
    catch(err){
        // console.warn(err.stack)
        res.status(500).json({message : 'server error'})        
    }
})

app.listen(8080)

module.exports = app


V4 S3

// TODO : adăugați posibilitatea de a edita un robot 
// editarea se face prin intermediul unui robot cu 2 stări, una de vizualizare și una de editare


class Robot extends Component {
    constructor(props){
        super(props)
        this.state={
            isEditing:false,
            name:this.props.item.name,
            mass:this.props.item.mass,
            type:this.props.item.type
        }
        this.edit=()=>{
            this.setState({
                isEditing:true
            })
        }
        this.cancel=()=>{
            this.setState({
                isEditing:false
            })
        }
        this.save=()=>{
            this.props.onSave(this.props.item.id,{
                name:this.state.name,
                mass:this.state.mass,
                type:this.state.type
            })
            this.setState({
                isEditing:false
            })
        }
        
        this.onChange=(eveniment)=>{
            this.setState({
                [eveniment.target.name]:eveniment.target.value
            })
        }
    }
    render() {
        let {item} = this.props
        if(this.state.isEditing){
            return(
                <div>
                    <input type="text" value={this.state.name} name="name" onChange={this.onChange}></input>
                    <input type="text" value={this.state.mass} name="mass" onChange={this.onChange}></input>
                    <input type="text" value={this.state.type} name="type" onChange={this.onChange}></input>
                    <input type="button" value="save" onClick={this.save}  />
                    <input type="button" value="cancel" onClick={this.cancel} />        
                </div>
            )
        }else{
            return (
                <div>
                    Hello, my name is {item.name}. I am a {item.type} and weigh {item.mass}
                    <input type="button" value="edit" onClick={this.edit}  />
                            
                </div>
            )
        }
        
    }
}

export default Robot




V6 S1

/*
 - funcția capitalize primește ca parametrii un string și un array
 - dicționarul conține o serie de termeni
 - in textul ințial cuvintele sunt separate de spațiu
 - fiecare termen din dicționar trebuie să apară capitalizat în rezultat
 - rezultatul este un string nou, fără modificarea celui inițial
 - dacă textul nu este un string sau dicționarul nu este un array de string-uri se va arunca o excepție
*/

function capitalize(text, dictionary){
    if (typeof text !== 'string'){
        throw new Error('TypeError')
    }
    if (!Array.isArray(dictionary)){
        throw new Error('TypeError')
    }
    if (dictionary.filter((e) => typeof e !== 'string').length){
        throw new Error('TypeError')        
    }
    let result = text
    let items = result.split(' ')
    for (let i = 0; i < items.length; i++){
        if (dictionary.indexOf(items[i]) !== -1){
            items[i] = items[i][0].toUpperCase() + items[i].slice(1, items[i].length)
        }
    }
    return items.join(' ')
}

module.exports.capitalize = capitalize



SAU

function capitalize(text, dictionary){
    if(typeof text !== 'string' || !Array.isArray(dictionary)){
        throw new Error('TypeError')
    } else if(dictionary.find(d => typeof d !== 'string')){
        throw new Error('TypeError')
    } else if(dictionary.length === 0){
        return text
    } else{
        text = text.split(" ")
        for(var i=0; i < dictionary.length; i++){
            for(var j=0; j < text.length; j++){
                if(text[j].toUpperCase() === dictionary[i].toUpperCase()){
                    var value = dictionary[i].charAt(0).toUpperCase() + dictionary[i].slice(1)
                    text.splice(j, 1, value)
                    var modified = text.toString()
                    modified = modified.replace(/,/g , " ")
                }
            }
        }
        return modified
    }
}

module.exports.capitalize = capitalize

SAU

function capitalize(text, dictionary) {
    if (!(text instanceof String || typeof text === 'string') ||
        !(dictionary instanceof Array) || !check(dictionary)) {
        throw new Error("TypeError");
    }
    else {
        var cuvinte_din_text = text.split(' ');
        console.log("array ul de cuvinte: ", cuvinte_din_text);
        var newString = "";

        for (cuvant_din_text of cuvinte_din_text) {
            console.log("unul dintre cuvinte este " + cuvant_din_text);
            var cuvantDeAdaugat = cuvant_din_text;
            var ok = false;
            if (dictionary.indexOf(cuvant_din_text) !== -1) {
                ok = true;
            }
            if (ok === true) {
                cuvantDeAdaugat = cuvant_din_text;
                var firstLetter = cuvantDeAdaugat.charAt(0);
                firstLetter = firstLetter.toUpperCase();
                cuvantDeAdaugat = firstLetter + cuvantDeAdaugat.slice(1);
                console.log(cuvant_din_text + " trebuie schimbat in " + cuvantDeAdaugat);
            }
            newString += cuvantDeAdaugat + " ";

        }
        return newString.substring(0, newString.length - 1);
    }
}

function check(x) {
    return x.every(function (i) {
        return typeof i === 'string';
    });
}

module.exports.capitalize = capitalize

V6 S3
// TODO : adăugați posibilitatea de a vizualiza detaliile unui robot
// RobotList are 2 stări una de detalii și una de listă
// se poate trece în starea de detalii printr-un buton pe fiecare robot
// se poate trece înapoi la listă printr-un buton de anulare


class RobotList extends Component {
    constructor(){
        super()
        this.state = {
            robots : [],
        }
        
    }
    componentDidMount(){
        this.store = new RobotStore()
        this.setState({
            robots : this.store.getRobots()
        })
        this.store.emitter.addListener('UPDATE', () => {
            this.setState({
                robots : this.store.getRobots(),
            })          
        })
    }
    render() {
        return (
        <div>        
            {
                this.state.robots.map((e, i) => 
                    <Robot item={e} key={i} />
                )
            }
        </div>
    )       
    }
}

export default RobotList





/*
 - funcția translate primește ca parametrii un string și un obiect
 - funcția aruncă excepții dacă tipurile nu sunt respectate
 - obiectul dicționar are în cheie valoarea inițială și în valoare traducerea ei
 - valorile din dicționar sunt string-uri
 - funcția înlocuiește fiecare cheie din dicționar găsită în textul inițial cu valoarea tradusă
*/

function translate(text, dictionary){
    if (typeof text !== 'string'){
        throw new Error('TypeError')
    }
    if (typeof dictionary !== 'object' || !dictionary){
        throw new Error('TypeError')
    }
    for (let prop in dictionary){
        if (typeof dictionary[prop] !== 'string'){
            throw new Error('TypeError')
        }
    }
    let result = text.split(' ')
    for (let prop in dictionary){
        let position = result.indexOf(prop)
        if (position !== -1){
            result[position] = dictionary[prop]
        }   
    }
    return result.join(' ')
}

module.exports.translate = translate




V3 S1
- Functia trebuie sa returneze un promise; (0.5 pts)
- `discount` trebuie sa fie un numar, in caz contrar apelati `reject` in promise cu `Error` si mesajul `Invalid discount`; (0.5 pts)
- `discount` trebuie sa fie mai mare ca 0 si mai mic egal cu 10, in caz contrar apelati `reject` in promise cu `Error` si mesajul `Discount not applicable`; (0.5 pts)
- `products` trebuie sa contina produse cu formatul specificat, in caz contrar se va apela `reject` cu `Error` si mesajul `Invalid array format`; (0.5 pts)
Un produs: {name: string, price: number}
- Functia trebuie sa returneze un vector cu preturile reduse pentru toate produsele; (0.5 pts)

function applyBonus(employees, bonus){
     return new Promise((resolve, reject) => {
        if(typeof bonus !== "number")
            reject(new Error("Invalid bonus"));
        if(employees.filter(product => !(typeof product.name === "string" &&
            typeof product.salary === "number")).length)
            reject(new Error("Invalid array format"));
        let smax=Math.max.apply(Math, employees.map(function(o) { return o.salary; }))    
        if(bonus >= (0.1*smax)){
            resolve(employees.map(product => {
                let val = bonus;
                return { ...product,
                        salary: product.salary + val
                }
            }))
        } else {
            reject("Bonus too small");
        }
    });
}

let app = {
    applyBonus: applyBonus,
}

module.exports = app;


SAU

function applyDiscount(vehicles, discount){
    
     return new Promise((resolve, reject) => {
        if(typeof discount !== "number")
            reject(new Error("Invalid discount"));
        if(vehicles.filter(product => !(typeof product.make === "string" &&
            typeof product.price === "number")).length)
            reject(new Error("Invalid array format"));
         let smax=Math.min.apply(Math, vehicles.map(function(o) { return o.price; })) 
        if(discount<=(0.5*smax)){
            resolve(vehicles.map(product => {
                let val = product.price * discount / 100;
                return {product,
                        price: product.price - discount
                }
            }));
        } else {
            reject("Discount too big");
        }
    });
}

const app = {
    applyDiscount: applyDiscount
};

module.exports = app;



SAU

function applyBlackFriday(products, discount){
    return new Promise((resolve, reject) => {
        if(typeof discount !== "number")
            reject(new Error("Invalid discount"));
        if(products.filter(product => !(typeof product.name === "string" &&
            typeof product.price === "number")).length)
            reject(new Error("Invalid array format"));
        if(discount > 0 && discount <= 10){
            resolve(products.map(product => {
                let val = product.price * discount / 100;
                return { product,
                        price: product.price - val
                }
            }))
        } else {
            reject(new Error("Discount not applicable"));
        }
    });
}

const app = {
    applyBlackFriday: applyBlackFriday
};
module.exports = app;


V3 S2
# Avand urmatoa aplicatie dezvoltata in NodeJS, sa se completeze metoda de tip `POST` de pe calea `/students` :

- Daca nu exista body pentru cererea http, trebuie sa returnati un JSON cu urmatorul format: `{message: "Body is missing"}`. Codul de raspuns trebuie sa fie: `500`;
- Daca body-ul nu respecta formatul unui student, trebuie sa returnati un JSON cu urmatorul format: `{message: "Invlid body format"}`. Codul de raspuns trebuie sa fie: `500`;
- Varsta unui student trebuie sa fie mai mare ca 0.In caz contrar trebuie sa returnati un JSON cu urmatorul format: `{message: "Age should be a positive number"}`. Codul de raspuns trebuie sa fie: `500`; 
- Daca studentul exista deja in vector, trebuie sa returnati un JSON cu urmatorul format: `{message: "Student already exists"}`.Codul de raspuns trebuie: `500`. Unicitatea se face in functie de nume;
- Daca body-ul are formatul corespunzator, studentul trebuie adaugat in vector si sa returnati un JSON cu urmatorul format: `{message: "Created"}`. Codul de raspuns trebuie sa fie: `201`;

app.get('/students', (req, res) => {
    res.status(200).json(app.locals.products);
});

app.post('/students', (req, res, next) => {
    let student=req.body
    if(Object.keys(student).length===0){
        res.status(500).json({message: 'Body is missing'});
    }
        else if(app.locals.students.find(s=>s.name===student.name)){
            res.status(500).json({message: 'Student already exists'});
        }
        else if(!(student.hasOwnProperty("name")&&student.hasOwnProperty("surname")
        &&student.hasOwnProperty("age") )){
            res.status(500).json({message: 'Invalid body format'});
        }
            else if(student.age<0){
                res.status(500).json({message: 'Age should be a positive number'})
            }
            else{
                app.locals.students.push(student)
                res.status(201).json({message : 'Created'})
            }
           
    res.status(400).json({message: 'Bad request'});
})

module.exports = app;








Bold tehnologii web sub rezolvate JS
V1 S1
# Avand urmatoarea functie `function textProcessor(input, tokens)` unde:
- `input` este un string ce poate sa contina tokenuri (Example: "Hello ${user}" or "Hello")
- `tokens` este un vector ce contine obiecte cu numele si valoarea tokenurilor.
- Toate tokenurile sunt idetificate sub urmatorul format: `${tokenName}`

# Completati urmatoarele taskuri:

- `input` trebuie sa fie de tip `string`. Daca alt tip de date este pasat aruncati `Error` cu mesajul `Input should be a string`; (0.5 pts)
- `input` trebuie sa aiba cel putin 6 caractere. Daca lungimea `inputului` este mai mica de 6, aruncati `Error` cu mesajul `Input should have at least 6 characters`; (0.5 pts)
- `tokens` este un vector de elemente cu urmatorul format: `{tokenName: string, tokenValue: string}`. Daca acest format nu este respectat, aruncati `Error` cu urmatorul mesaj `Invalid array format`; (0.5 pts)
- Daca `input-ul` nu contine niciun token trebuie sa returnati valoarea initiala a `inputului`; (0.5 pts)
- Daca `input` contine tokenuri, inlocuiti-le cu valorile specifice si returnati noul `input`; (0.5 pts)

function textProcessor(input, tokens){
    if(!(input instanceof String || typeof input === 'string')){
        throw new Error('Input should be a string');
    }
    
    if(input.length <6) {
        throw new Error('Input should have at least 6 characters');
    }
    if(!Array.isArray(tokens)){
        throw new Error('Invalid array format!');
    } else {
        for(let i=0;i<tokens.length;i++){
            if(!(tokens[i].tokenName instanceof String || typeof tokens[i].tokenName === 'string') || 
            !(tokens[i].tokenValue instanceof String || typeof tokens[i].tokenValue === 'string') ){
                throw new Error('Invalid array format!');
            }
            else {
             let index =  input.search(tokens[i].tokenName); 
             if(index !== -1){
               input = input.split('${'+tokens[i].tokenName+'}').join(tokens[i].tokenValue);
               //input = input.replace('${'+tokens[i].tokenName+'}',tokens[i].tokenValue);
             }
            }
        }
    
        

    }
    
    return input;
    
}
const app = {
    textProcessor: textProcessor
};

module.exports = app;

SAU

function addTokens(input, tokens){
    if(typeof input !== 'string'){
        throw new Error('Invalid input')
    } else if(input.length <= 6){
        throw new Error('Input should have at least 6 characters')
    } else if(tokens.find(a => typeof a.tokenName !== 'string' )){
        throw new Error('Invalid array format')
    } else if(input.search('...') !== -1){
        for(let e of tokens){
            let a="${"+e.tokenName+"}";
            input = input.replace("...", a)
        }
    }
    return input
}

const app = {
    addTokens: addTokens
}

module.exports = app;

SAU

function addTokens(input, tokens) {
    if (typeof input !== "string") {
        throw new Error("Invalid input");

    }
    if (input.length < 6) {
        throw new Error("Input should have at least 6 characters");
    }

    if (tokens.filter(product => !(typeof product.tokenName === "string")).length) {
        throw new Error("Invalid array format");

    }
    if (input.search("...") !== -1) {

        for (let e of tokens) {
            let v="${"+e.tokenName+"}";
            input=input.replace("...",v);

        }

    }
    return input;

}

const app = {
    addTokens: addTokens
}

module.exports = app;

V1 S2

# Avand urmatoa aplicatie dezvoltata in NodeJS, sa se completeze metoda de tip `POST` de pe calea `/products` :

- Daca nu exista body pentru cererea http, trebuie sa returnati un JSON cu urmatorul format: `{message: "Body is missing"}`. Codul de raspuns trebuie sa fie: `500`;
- Daca body-ul nu respecta formatul unui produs, trebuie sa returnati un JSON cu urmatorul format: `{message: "Invlid body format"}`. Codul de raspuns trebuie sa fie: `500`;
- Pretul unui produs trebuie sa fie mai mare ca 0.In caz contrar trebuie sa returnati un JSON cu urmatorul format: `{message: "Price should be a positive number"}`. Codul de raspuns trebuie sa fie: `500`; 
- Daca produsul exista deja in vector, trebuie sa returnati un JSON cu urmatorul format: `{message: "Product already exists"}`.Codul de raspuns trebuie: `500`. Unicitatea se face in functie de nume;
- Daca body-ul are formatul corespunzator, produsul trebuie adaugat in vector si sa returnati un JSON cu urmatorul format: `{message: "Created"}`. Codul de raspuns trebuie sa fie: `201`;

app.get('/products', (req, res) => {
    res.status(200).json(app.locals.products);
});

app.post('/products', (req, res, next) => {
    let product=req.body
    if(Object.keys(product).length === 0) {
        res.status(500).json({message : "Body is missing"})}
        else{
            if(product.hasOwnProperty("name")&&
            product.hasOwnProperty("category")&&
            product.hasOwnProperty("price")){
                if(product.price>0){
                    app.locals.products.forEach(element => {
                        if(element.name===product.name){
                            res.status(500).json({message : "Product already exists"})
                        } 
                            else{ 
                                app.locals.products.push({
                                name: req.body.name,
                                category: req.body.category,
                                price: req.body.price
                            })
                            res.status(201).json({message: 'Created'})
                        }
                        
                    });
                    

                }else{
                    res.status(500).json({message : "Price should be a positive number"})}  
                }

            else{
                res.status(500).json({message : "Invalid body format"})}
            }
        
    res.status(400).json({message: 'Bad request'});
})

module.exports = app;
app.get('/products', (req, res) => {
    res.status(200).json(app.locals.products);
});

app.post('/products', (req, res, next) => {
    let product=req.body
    if(Object.keys(product).length === 0) {
        res.status(500).json({message : "Body is missing"})}
        else{
            if(product.hasOwnProperty("name")&&
            product.hasOwnProperty("category")&&
            product.hasOwnProperty("price")){
                if(product.price>0){
                    app.locals.products.forEach(element => {
                        if(element.name===product.name){
                            res.status(500).json({message : "Product already exists"})
                        } 
                            else{ 
                                app.locals.products.push({
                                name: req.body.name,
                                category: req.body.category,
                                price: req.body.price
                            })
                            res.status(201).json({message: 'Created'})
                        }
                        
                    });
                    

                }else{
                    res.status(500).json({message : "Price should be a positive number"})}  
                }

            else{
                res.status(500).json({message : "Invalid body format"})}
            }
        
    res.status(400).json({message: 'Bad request'});
})

module.exports = app;



V1 S3
# Avand urmatoarea apliatie create folosind `create-react-app`, completati urmatoarele taskuri:
- Componenta `AddCar` trebuie adaugata in interiorul componentei `CarList`;
- Componenta `AddCar` trebuie sa contina 3 elemente de tip input cu `id-ul` si `name-ul`: `make`, `model`, `price`;
- Componenta `AddCar` trebuie sa contina un element input de tip buton `button` cu valoarea `add car`, folosit pentru a apela metoda `addCar`;
- Componenta `AddCar` din interiorul componentei `CarList` trebuie sa contina in `props` metoda `onAdd`;
- La apasarea butonului `add car` un nou element trebuie afisat in componenta `CarList`;

import React from 'react';
import AddCar from './AddCar'
export class CarList extends React.Component {
    constructor(){
        super();
        this.state = {
            cars: []
        };

        
    }  
    addCar =(masina)=>{
        let cars=[...this.state.cars]
        cars.push(masina)
        this.setState({cars:cars})
    }

    render(){
        
        return (
            <div>
            <AddCar onAdd={this.addCar}/>
            {
            this.state.cars.map((e,i)=>< div key={i} item={e}/>)
            }
           
            </div>
        )
    }
}
export default CarList





// # Avand urmatoarea functie function `calculateFrequencies(input, stopWords)` unde:
// - `input` este un string sau un obiect String (ex. "This is a cat")
// - `stopWords` este un vector ce contine o serie de string-uri sau obiecte String.

// # Completati urmatoarele taskuri:
// - `input` trebuie sa fie de tip `string` sau `String`. Daca este dat un input de alt tip se va arunca un `Error` cu mesajul `Input should be a string`; (0.5 pts)
// - `dictionary` este un vector de elemente de tip `string`sa `String`. Daca cel putin un element nu este `string` se va arunca un `Error` cu mesajul `Invalid dictionary format`; (0.5 pts)
// - functia calculeaza frecventele relative ale cuvintelor in input si returneaza un dictionar care are cuvintele drept chei si frecventele drept valori (ex. pentru string-ul 'orange cat' rezultatul va fi {orange : 0.5, cat : 0.5}); (0.5 pts)
// - daca stopWords contine cuvinte, ele vor fi ignorate pentru calcularea frecventelor (ex. pentru 'the orange cat' cu 'the' in stopWords rezultatul va fi {orange : 0.5, cat : 0.5}); (0.5 pts)
// - functia returneaza rezultatul corect si pentru cuvinte care incep cu o litera mare, care sunt considerate identice cu varianta fara litera mare. (0.5 pts)

function calculateFrequencies(input, dictionary){
    if(typeof input !== 'string')
    {
        throw new Error('Input should be a string');
    }
    if(Array.isArray(dictionary))
    {
        let cuvinte = input.split(' ');
        let n = 0;
        let cuvinteNoi = [];
        let obj = {};
            
        for(let i = 0 ; i < dictionary.length ; i++)
        {
            if(typeof dictionary[i] !== 'string' )
            {
                throw new Error('Invalid dictionary format');
            }
        }
            
        for(let i=0;i<cuvinte.length;i++)
        {
            if(!dictionary.find(cuvant => cuvant === cuvinte[i].toLowerCase()))
            {
                n++;
                obj[cuvinte[i].toLowerCase()]=0;
                cuvinteNoi.push(cuvinte[i].toLowerCase());
            }
        }
            

        for(let i=0;i < cuvinteNoi.length ; i++)
        {
            obj[cuvinteNoi[i]] = 1/n;
        }

        return obj;
    }
    else
    {
        throw new Error('Invalid dictionary format');
    }
}
const app = {
    calculateFrequencies
};

module.exports = app;


# Avand urmatoarea functie  `removeOrderItem(orderInfo, position)` unde:
- `orderInfo` este un obiect cu proprietatile total si items
- `position` este un numar intreg ce determina un element din items

# Completati urmatoarele taskuri:
- validati proprietatea `items` sa fie de tip `array`. Daca este dat un input de alt tip se va arunca eroare cu mesajul `Items should be an array`; (0.5 pts)
- fiecare obiect din `items` este are proprietatile price si quantity. Daca cel putin un element nu respecta formatul se va arunca mesajul `Malformed item`; (0.5 pts)
- parametrul `position` este valid in relatie cu vectorul items (0.5 pts)
- se va returna obiectul orderInfo din care s-a eliminat elementul de pe pozitia data (0.5 pts)
- functia returneaza totalul corect pentru comanda in urma eliminarii elementului de pe pozitia data. (0.5 pts)

function removeOrderItem(orderInfo, position){
    if(!(Array.isArray(orderInfo.items))){
        throw(new Error("Items should be an array"))
    }
    for(var i=0; i<orderInfo.items.length; i++)
    {
        if(orderInfo.items[i].quantity && orderInfo.items[i].price){}
        else { throw "Malformed item";}
    }
    if(position>0 && position <= orderInfo.items.length){}
   else{ throw "Invalid position";}

    orderInfo.items.splice(position,1);

    orderInfo.total=0;
    for(var i=0; i<orderInfo.items.length; i++)
    orderInfo.total+=orderInfo.items[i].quantity*orderInfo.items[i].price;

    return orderInfo;

}

const app = {
    removeOrderItem
};

module.exports = app;




# Avand clasa `Queue` din fisierul `index.js` sa se implementeze urmatoarele functionalitati: 
- clasa `Queue` trebuie sa contina o proprietate numita `items`, de tip `Array` care va fi initializata cu un vector gol (0.5 pts);
- se va implementa metoda `insert` ce va primi ca parametru un `element` care va fi adaugat in vector, conform principiului cozii;
- metoda `insert` va permite adaugarea in coada doar a elementelor de tip `string` si va arunca o eroare cu textul `Invalid Type` pentru elementele de alt tip.
- se va implementa metoda `extract` ce va returna un `element` din vector, conform principiului cozii;
- in cazul in care vectorul este gol si se apeleaza metoda `extract`, se va arunca o eroare cu textul `Invalid Operation`;

class Queue {
 items=[];
 
 insert(element){
    if(!(typeof element==="string")){
        throw(new Error("Invalid Type"))
    }else{
     this.items.push(element)
 } 
}
  extract(){
      if(this.items.length===0){
          throw(new Error("Invalid Operation"))
      }else{
        return this.items.shift()
        } 
  }
}
module.exports = Queue;


REST

# Dată fiind aplicația `app` completați metoda `POST` la adresa `/ships`:

- Dacă s-a trimis un request cu un corp gol sau nedefinit, se va returna un json cu următorul format: `{"message": "body is missing"}`. Codul de răspuns va fi: `400`; (0.5 pts)
- Dacă din corpul request-ului lipsesc proprietăți se va returna un json cu următorul format: `{"message": "malformed request"}`. Codul de răspuns va fi: `400`; (0.5 pts)
- Deplasamentul trebuie sa fie un numar mai mare ca 1000; în caz contrar se va returna un json cu următorul format: `{"message": "displacement should be over 1000"}`. Codul de răspuns va fi: `400`; (0.5 pts)
- Dacă nava trimisa prin corpul request-ului este valida, va fi adăugata și se va returna un răspuns cu  codul `201`. Corpul răspunsului va fi `{"message": "created"}`;(0.5 pts)
- Dacă se face un request `GET /ships` corpul răspunsului trebuie să conțină 11 `ships`, inclusiv cea adăugata anterior; (0.5 pts)


const express = require('express')
const bodyParser = require('body-parser')
const Sequelize = require('sequelize')

const mysql = require('mysql2/promise')

const DB_USERNAME = 'root'
const DB_PASSWORD = 'qwerty1234'

let conn

mysql.createConnection({
    user : DB_USERNAME,
    password : DB_PASSWORD
})
.then((connection) => {
    conn = connection
    return connection.query('CREATE DATABASE IF NOT EXISTS tw_exam')
})
.then(() => {
    return conn.end()
})
.catch((err) => {
    console.warn(err.stack)
})

const sequelize = new Sequelize('tw_exam', DB_USERNAME, DB_PASSWORD,{
    dialect : 'mysql',
    logging: false
})

let Ship = sequelize.define('student', {
    name : Sequelize.STRING,
    portOfSail : Sequelize.STRING,
    displacement : Sequelize.INTEGER
},{
    timestamps : false
})

const app = express()
app.use(bodyParser.json())

app.get('/create', async (req, res) => {
    try{
        await sequelize.sync({force : true})
        for (let i = 0; i < 10; i++){
            let ship = new Ship({
                name : `name${i}`,
                portOfSail : `port ${i}`,
                displacement : 3000 + 10 * i
            })
            await ship.save()
        }
        res.status(201).json({message : 'created'})
    }
    catch(err){
        console.warn(err.stack)
        res.status(500).json({message : 'server error'})
    }
})

app.get('/ships', async (req, res) => {
    try{
        let ships = await Ship.findAll()
        res.status(200).json(ships)
    }
    catch(err){
        console.warn(err.stack)
        res.status(500).json({message : 'server error'})        
    }
})

app.post('/ships', async (req, res) => {
    if(Object.keys(req.body).length!=0) {
        if(req.body.name && req.body.portOfSail && req.body.displacement){
            if (req.body.displacement < 1000)
                {
                    res.status(400).json({message: "displacement should be over 1000"})
                }
            else {
                    let ship = new Ship(req.body)
                    if (ship)
                    {
                        await ship.save()
                        res.status(201).json({message : 'created'})
                    }
                }
            }
        else  
        {
            res.status(400).json({message: "malformed request"});
        }
    }
    else
    {
        res.status(400).json({message: "body is missing"});
    }
        
})

module.exports = app



SAU

const express = require('express')
const bodyParser = require('body-parser')
const Sequelize = require('sequelize')

const mysql = require('mysql2/promise')

const DB_USERNAME = 'root'
const DB_PASSWORD = 'pass'

let conn

mysql.createConnection({
    user : DB_USERNAME,
    password : DB_PASSWORD
})
.then((connection) => {
    conn = connection
    return connection.query('CREATE DATABASE IF NOT EXISTS tw_exam')
})
.then(() => {
    return conn.end()
})
.catch((err) => {
    console.warn(err.stack)
})

const sequelize = new Sequelize('tw_exam', DB_USERNAME, DB_PASSWORD,{
    dialect : 'mysql',
    logging: false
})

let Ship = sequelize.define('student', {
    name : Sequelize.STRING,
    portOfSail : Sequelize.STRING,
    displacement : Sequelize.INTEGER
},{
    timestamps : false
})

const app = express()
app.use(bodyParser.json())

app.get('/create', async (req, res) => {
    try{
        await sequelize.sync({force : true})
        for (let i = 0; i < 10; i++){
            let ship = new Ship({
                name : `name${i}`,
                portOfSail : `port ${i}`,
                displacement : 3000 + 10 * i
            })
            await ship.save()
        }
        res.status(201).json({message : 'created'})
    }
    catch(err){
        console.warn(err.stack)
        res.status(500).json({message : 'server error'})
    }
})

app.get('/ships', async (req, res) => {
    try{
        let ships = await Ship.findAll()
        res.status(200).json(ships)
    }
    catch(err){
        console.warn(err.stack)
        res.status(500).json({message : 'server error'})        
    }
})

app.post('/ships', async (req, res) => {
    let ship=req.body
    if(Object.keys(ship).length === 0) {
        res.status(400).json({message : 'body is missing'})
    
    }else{
        if(!(ship.hasOwnProperty("name")&&ship.hasOwnProperty("portOfSail")
        &&ship.hasOwnProperty("displacement") )){
            res.status(400).json({message : 'malformed request'})
        }else if (ship.displacement<1000){
           
                res.status(400).json({message : 'displacement should be over 1000'})
            }  
            
            else{
                let ship2=new Ship(req.body)
                await ship2.save()
                res.status(201).json({message : 'created'}) 
        }
    }

})

module.exports = app



# Dată fiind aplicația `app` completați metodele `PUT` si `DELETE` la adresa `/ships/id`:

- Daca se incerca modificarea unei nave inexistente raspunsul trebuie sa fie `{"message": "not found"}`. Codul de raspuns va fi: `404`; (0.5 pts)
- Daca se incearca modificarea unei nave existente raspunsul trebuie sa fie `{"message": "accepted"}`. Codul de raspuns va fi: `202`; (0.5 pts)
- O cerere get ulterioara la adresa navei editate trebuie sa reflecte modificarile. Codul de raspuns va fi: `200`; (0.5 pts)
- Daca se incearca stergerea unei nave existente raspunsul trebuie sa fie `{"message": "accepted"}`. Codul de raspuns va fi: `202`; (0.5 pts)
- O cerere get ulterioara la adresa navei sterse trebuie sa returneze `{"message": "not found"}`. Codul de raspuns va fi: `404`; (0.5 pts)



const express = require('express')
const bodyParser = require('body-parser')
const Sequelize = require('sequelize')

const mysql = require('mysql2/promise')

const DB_USERNAME = 'root'
const DB_PASSWORD = 'qwerty1234'

let conn

mysql.createConnection({
    user : DB_USERNAME,
    password : DB_PASSWORD
})
.then((connection) => {
    conn = connection
    return connection.query('CREATE DATABASE IF NOT EXISTS tw_exam')
})
.then(() => {
    return conn.end()
})
.catch((err) => {
    console.warn(err.stack)
})

const sequelize = new Sequelize('tw_exam', DB_USERNAME, DB_PASSWORD,{
    dialect : 'mysql',
    logging: false
})

let Ship = sequelize.define('student', {
    name : Sequelize.STRING,
    portOfSail : Sequelize.STRING,
    displacement : Sequelize.INTEGER
},{
    timestamps : false
})

const app = express()
app.use(bodyParser.json())

app.get('/create', async (req, res) => {
    try{
        await sequelize.sync({force : true})
        for (let i = 0; i < 10; i++){
            let ship = new Ship({
                name : `name${i}`,
                portOfSail : `port ${i}`,
                displacement : 3000 + 10 * i
            })
            await ship.save()
        }
        res.status(201).json({message : 'created'})
    }
    catch(err){
        console.warn(err.stack)
        res.status(500).json({message : 'server error'})
    }
})

app.get('/ships/:id', async (req, res) => {
    try{
        let ship = await Ship.findByPk(req.params.id)
        if (!ship){
            res.status(404).json({message : 'not found'})
        }
        else{
            res.status(200).json(ship)
        }
    }
    catch(err){
        console.warn(err.stack)
        res.status(500).json({message : 'server error'})        
    }
})

app.put('/ships/:id', async (req, res) => {

    if(req.params.id){
        let ship = await Ship.findByPk(req.params.id)
        if (!ship){
            res.status(404).json({message : 'not found'})
        }
        else{
          /* let updated = */await ship.update(req.body);
           res.status(202).json({message:'accepted'});
        }
    }
})

app.delete('/ships/:id', async (req, res) => {
    const id = req.params.id;
    if(id){
        let ship = await Ship.findByPk(id);
        if(ship){
            ship.destroy();
            res.status(202).json({message:'accepted'});
        }
        else{
            res.status(404).json({message : 'not found'})
        }
    }
})

module.exports = app






# Dată fiind aplicația `app` completați metoda `GET` la adresa `/ships`:
- se pot utiliza parametrii de query `page` si `pageSize`

- Daca nu s-a specificat nici pagina si marimea paginii, se vor returna toate navele (0.5 pts)
- Daca s-a specificat pagina, dar nu page size se va presupune ca marimea paginii este 5 si se va returna a n-a pagina de 5 nave (0.5 pts)
- Daca s-au specificat atat pagina cat si marimea unei pagini, se va returna pagina specificata de marimea specificata (0.5 pts)
- Daca s-a specificat o pagina malformata sau o marime de pagina malformata se vor returna toate navele; (0.5 pts)
- Daca pagina specificata este dincolo de ultima nava, se va returna un array vid. (0.5 pts)


const express = require('express')
const bodyParser = require('body-parser')
const Sequelize = require('sequelize')

const mysql = require('mysql2/promise')

const DB_USERNAME = 'root'
const DB_PASSWORD = 'qwerty1234'

let conn

mysql.createConnection({
    user : DB_USERNAME,
    password : DB_PASSWORD
})
.then((connection) => {
    conn = connection
    return connection.query('CREATE DATABASE IF NOT EXISTS tw_exam')
})
.then(() => {
    return conn.end()
})
.catch((err) => {
    console.warn(err.stack)
})

const sequelize = new Sequelize('tw_exam', DB_USERNAME, DB_PASSWORD,{
    dialect : 'mysql',
    logging: false
})

let Ship = sequelize.define('student', {
    name : Sequelize.STRING,
    portOfSail : Sequelize.STRING,
    displacement : Sequelize.INTEGER
},{
    timestamps : false
})

const app = express()
app.use(bodyParser.json())

app.get('/create', async (req, res) => {
    try{
        await sequelize.sync({force : true})
        for (let i = 0; i < 10; i++){
            let ship = new Ship({
                name : `name${i}`,
                portOfSail : `port ${i}`,
                displacement : 3000 + 10 * i
            })
            await ship.save()
        }
        res.status(201).json({message : 'created'})
    }
    catch(err){
        console.warn(err.stack)
        res.status(500).json({message : 'server error'})
    }
})

app.get('/ships', async (req, res) => {
   
    try{
        let ships = await Ship.findAll()
        res.status(200).json(ships)
    }
    catch(err){
        console.warn(err.stack)
        res.status(500).json({message : 'server error'})        
    }

})

app.post('/ships', async (req, res) => {
    try{
        let ship = new Ship(req.body)
        await ship.save()
        res.status(201).json({message : 'created'})
    }
    catch(err){
        res.status(500).json({message : 'server error'})        
    }
})

module.exports = app





SAU LA GET
app.get('/ships', async (req, res) => {
    try{
        let pageSize = req.query.pageSize ? parseInt(req.query.pageSize) : 5
        let pageNo = req.query.pageNo ? parseInt(req.query.pageNo) : 0
        let ships
        if(pageNo) {
            ships = await Ship.findAll({
                limit: pageSize, 
                offset: pageNo * pageSize
            })
        }
        else {
            ships = await Ship.findAll()
        }
        res.status(200).json(ships)
    
    }
    catch(err){
        console.warn(err.stack)
        res.status(500).json({message : 'server error'})        
    }
})



# Dată fiind aplicația `app` completați metodele `POST` si `DELETE` pe pathurile `/device` si `/device/:id`:
- `POST /device` returneaza status code 400 si raspuns `{message: "bad request"}` daca `body-ul` este gol. (0.5 pts)
- `POST /device` returneaza status code 400 si raspuns `{message: "bad request"}` daca `pretul < 0`. (0.5 pts)
- `POST /device` returneaza status code 400 si raspuns `{message: "bad request"}` daca `numele are mai putin de 4 caractere`. (0.5 pts)
- `POST /device` returneaza status code 201 si raspuns `{message: "device created"}` daca `body-ul este valid`. (0.5 pts)
- `DELETE /device/:id` returneaza status code 202 si raspuns `{message: "device deleted"}` daca `id-ul` trimis ca request parameter este gasit in baza de date. (0.5 pts)


const express = require('express');
const Sequelize = require('sequelize');
const bodyParser = require('body-parser');
const mysql = require('mysql2/promise');

const DB_USERNAME = 'root';
const DB_PASSWORD = 'qwerty1234';
let conn

mysql.createConnection({
    user : DB_USERNAME,
    password : DB_PASSWORD
})
.then((connection) => {
    conn = connection
    return connection.query('CREATE DATABASE IF NOT EXISTS tw_exam')
})
.then(() => {
    return conn.end()
})
.catch((err) => {
    console.warn(err.stack)
})

const sequelize = new Sequelize('tw_exam', DB_USERNAME, DB_PASSWORD, {
    dialect: 'mysql',
    logging: false
});

class Device extends Sequelize.Model { 

};

Device.init({
    id: {
        type: Sequelize.INTEGER,
        primaryKey: true,
        autoIncrement: true
    },
    name: {
        type: Sequelize.STRING,
    },
    price: {
        type: Sequelize.FLOAT,
    }
}, {
    sequelize,
    modelName: 'devices',
    timestamps: false
});

const app = express();
app.use(bodyParser.json());

app.get('/create', async (req, res) => {
    await sequelize.sync({force: true});
    for(let i = 0; i < 10; i++) {
        await Device.create({name: `Device-${i}`, price: `${Math.random() * 100 + i + 10}`});
    }
    res.status(201).json({message: 'devices created'});
})

app.get('/device', async (req, res) => {
    const devices = await Device.findAll();
    res.status(200).send(devices);
})

app.post('/device', async (req, res) => {
    try{
        if(Object.keys(req.body).length>=0){
            if(req.body.price>0&&Object.keys(req.body.name).length>3){
                let dev = new Device(req.body)
                await dev.save()
                res.status(201).json({message : 'device created'})

            } else{
                res.status(400).json({message:'bad request'})

            }

        } 
    } catch(ex){
        res.status(500).json({message : 'server error'})      
    }
})

app.delete('/device/:id', async (req, res) => {
    let dev = await Device.findByPk(req.params.id)
   
        dev.destroy()
        res.status(202).json({message : 'device deleted'})
    
})




module.exports = app;




SAU

const express = require('express');
const Sequelize = require('sequelize');
const bodyParser = require('body-parser');
const mysql = require('mysql2/promise');

const DB_USERNAME = 'root';
const DB_PASSWORD = 'pass';
let conn

mysql.createConnection({
    user : DB_USERNAME,
    password : DB_PASSWORD
})
.then((connection) => {
    conn = connection
    return connection.query('CREATE DATABASE IF NOT EXISTS tw_exam')
})
.then(() => {
    return conn.end()
})
.catch((err) => {
    console.warn(err.stack)
})

const sequelize = new Sequelize('tw_exam', DB_USERNAME, DB_PASSWORD, {
    dialect: 'mysql',
    logging: false
});

class Device extends Sequelize.Model { };

Device.init({
    id: {
        type: Sequelize.INTEGER,
        primaryKey: true,
        autoIncrement: true
    },
    name: {
        type: Sequelize.STRING,
    },
    price: {
        type: Sequelize.FLOAT,
    }
}, {
    sequelize,
    modelName: 'devices',
    timestamps: false
});

const app = express();
app.use(bodyParser.json());

app.get('/create', async (req, res) => {
    await sequelize.sync({force: true});
    for(let i = 0; i < 10; i++) {
        await Device.create({name: `Device-${i}`, price: `${Math.random() * 100 + i + 10}`});
    }
    res.status(201).json({message: 'devices created'});
})

app.get('/device', async (req, res) => {
    const devices = await Device.findAll();
    res.status(200).send(devices);
})

app.post('/device', async (req, res) => {
    let device=req.body
    if(Object.keys(device).length === 0) {
        res.status(400).json({message : 'bad request'})
    }else{
        if(device.price < 0) {
            res.status(400).json({message : 'bad request'})
        }else{
            if(device.name.length < 4) {
                res.status(400).json({message : 'bad request'})
            }else{
                let dev = new Device(req.body)
                await dev.save()
                res.status(201).json({message : 'device created'})
            }
        }
    }

})

app.delete('/device/:id', async (req, res) => {
    let dev = await Device.findByPk(req.params.id)
    if (dev){
        dev.destroy()
        res.status(202).json({message : 'device deleted'})
    }
})

module.exports = app;



# Dată fiind aplicația `app` completați metoda `GET` la adresa `/homeworks` si metoda `GET` la adresa `/homeworks/id`:

- Daca metoda GET /homeworks a fost apelata fara parametri va returna toate temele din baza de date
- Daca metoda GET /homeworks a fost apelata cu parametrul pass = true va returna toate temele care au obtinut o nota mai mare sau egala ca 5
- Daca metoda GET /homeworks/id a fost apelata cu id inexistent returneaza status code `404`
- Daca metoda GET /homeworks/id a fost apelata cu un id valid returneaza un obiect json
- Daca clientul HTTP accepta doar text metoda GET /homeworks/id returneaza doar continutul temei


const express = require('express')
const bodyParser = require('body-parser')
const Sequelize = require('sequelize')

const mysql = require('mysql2/promise')

const DB_USERNAME = 'root'
const DB_PASSWORD = 'qwerty1234'

let conn

mysql.createConnection({
    user : DB_USERNAME,
    password : DB_PASSWORD
})
.then((connection) => {
    conn = connection
    return connection.query('CREATE DATABASE IF NOT EXISTS tw_exam')
})
.then(() => {
    return conn.end()
})
.catch((err) => {
    console.warn(err.stack)
})

const sequelize = new Sequelize('tw_exam', DB_USERNAME, DB_PASSWORD,{
    dialect : 'mysql',
    logging: false
})

let Homework = sequelize.define('homework', {
    student : Sequelize.STRING,
    content : Sequelize.STRING,
    grade : Sequelize.INTEGER
},{
    timestamps : false
})

const app = express()
app.use(bodyParser.json())

app.get('/create', async (req, res) => {
    try{
        await sequelize.sync({force : true})
        const grades  = [2, 5, 7, 7, 3, 10, 9, 4, 10, 8]
        for (let i = 0; i < 10; i++){
            let homework = new Homework({
                student : `name${i}`,
                content : `some text here ${i}`,
                grade : grades[i]
            })
            await homework.save()
        }
        res.status(201).json({message : 'created'})
    }
    catch(err){
        console.warn(err.stack)
        res.status(500).json({message : 'server error'})
    }
})

app.get('/homeworks', async (req, res) => {
    try{
        const homework = await Homework.findAll()
        if(req.params.pass === "true"){
            homework.forEach(element => {
                if(element.grade > 5){
                    res.status(200).send(element);
                }
            });
        }else{
            res.status(200).send(homework)
        }
       
    }
    catch(err){
        console.warn(err.stack)
        res.status(500).json({message : 'server error'})        
    }
})

app.get('/homeworks/:id', async (req, res) => {
    try{
        const homework = await Homework.findByPk(req.params.id);
        if(homework){
            if(!(req.accepts("json"))){
                res.status(200).send(homework.content);
            }else{
                res.status(200).json(homework);
            }
        }else{
            res.status(404).json({message: 'not found'})
        }
        
    }
    catch(err){
        console.warn(err.stack)
        res.status(500).json({message : 'server error'})        
    }
})

module.exports = app




SAU

app.get('/homeworks', async (req, res) => {
    try{
        let filter = req.query.pass ? req.query.pass : '';
        if(filter){
           let homeworks= await Homework.findAll({
                where:
                {grade:{
                    gt:5
                }}
            }
            )
            res.status(200).json(homeworks);
        }else{
            let homeworks =await  Homework.findAll();
            res.status(200).json(homeworks);
        }

    }
    catch(err){
        console.warn(err.stack)
        res.status(500).json({message : 'server error'})        
    }
})

app.get('/homeworks/:id', async (req, res) => {
    try{
        let homeworks = await Homework.findByPk(req.params.id)
        if (!homeworks){
            res.status(404).json({message : 'not found'})
        }
        else{
            if(!(req.accepts("json"))){
                res.status(200).send(homeworks.content)
            }else{
                res.status(200).json(homeworks)
            }
        }

    }
    catch(err){
        console.warn(err.stack)
        res.status(500).json({message : 'server error'})        
    }
})

module.exports = app






REACT
SUB3 V0
# Avand urmatoarea aplicatie create folosind `create-react-app`, adaugati o componenta `Company` astfel incat:
- aplicatia se deseneaza corect (0.5 pts);
- `CompanyList` este desenata ca un copil al lui `App` (0.5 pts);
- `CompanyList` se deseneaza ca o lista de  `Company` (0.5 pts);
- `Company` are o proprietate numita `item` care contine compania pe care o afiseaza
- `Company` poate fi sters prin apasarea unui buton cu eticheta `delete` (0.5 pts);


import React, { Component } from 'react'

class Company extends Component{
    constructor(props){
        super(props)

        this.delete=() =>{
            this.props.onDelete(this.props.item.id)
        }
    }

    render(){
        let{item}=this.props
        return <div>
            <h4>{item.name}</h4>
            <div>
                <input type="button" id="delete" value="delete" onClick={this.delete}></input>
            </div>
        </div>
    }

}

export default Company



import React, { Component } from 'react'
import CompanyStore from '../stores/CompanyStore'
import Company from './Company'

class CompanyList extends Component {
    constructor(){
        super()
        this.state = {
            companies : []
        }

        this.deleteCompany=(id)=>{
            this.store.deleteOne(id)
        }
    }
    componentDidMount(){
        this.store = new CompanyStore()
        this.setState({
            companies : this.store.getAll()
        })
        this.store.emitter.addListener('UPDATE', () => {
            this.setState({
                companies : this.store.getAll()
            })          
        })
    }
  render() {
    return (
      <div>
          <div>
            {
                this.state.companies.map((e,i)=><Company key={i} item={e} onDelete={this.deleteCompany}/>)
            }
          </div>
          
      </div>
    )
  }
}

export default CompanyList









SUB3 V1
# Avand urmatoarea aplicatie create folosind `create-react-app`, modificati `Company` astfel incat:
- aplicatia se deseneaza corect (0.5 pts);
- `CompanyList` se deseneaza ca o lista de  `Company`, iar fiecare `Company` are un buton cu eticheta `edit` (0.5 pts);
- Daca se da click pe butonul edit al unui `Company` aceasta trece in mod de editare (0.5 pts);
- Daca in mod edit se da click pe butonul cancel al unui `Company` aceasta trece in mod view (0.5 pts);
- Se poate salva o companie, iar schimbarea se reflecta in lista de companii (0.5 pts);

import React, { Component } from 'react'

class Company extends Component {
  constructor(props){
    super(props)
    let {item} = this.props
    this.state = {
      isEditing:false,
      name : item.name,
      employees : item.employees,
      revenue : item.revenue,
    }
    this.save=()=>{
        this.props.onSave(this.props.item.id,{
        name:this.state.name,
        employees : this.state.employees,
        revenue : this.state.revenue
            })
        this.setState({
        isEditing:false
            })

    }
    this.select = () => {
      this.props.onSelect(this.props.item)
  }
    
    this.edit=() =>{
      this.setState({
        isEditing:true
      })
    }
    this.cancel=() =>{
      this.setState({
        isEditing:false
      })
    }
    this.handleChange = (evt) => {
      this.setState({
        [evt.target.name] : evt.target.value
      })
    }
    

  }
  render() {
    let {item} = this.props
    if (this.state.isEditing){
      return (
        <div>
          <h4>
            <input type="text" value={this.state.name} name="name" onChange={this.handleChange}></input></h4>
            <h4><input type="text" value={this.state.employees} name="employees" onChange={this.handleChange}></input></h4>
            <h4> <input type="text" value={this.state.revenue} name="revenue" onChange={this.handleChange}></input></h4>
          
          <input type="button" value="save" onClick={this.save}  />
          <input type="button" value="cancel" onClick={this.cancel} />            
        </div>
      )
    }
    else{
      return (
        <div>
          Name {item.name} with {item.employees} employees {item.revenue} revenue
          <input type="button" value="edit" onClick={this.edit} />     
          <input type="button" value="select" onClick={this.select} />           
        </div>
      )
    }
  }
}

export default Company

import React, { Component } from 'react'
import CompanyStore from '../stores/CompanyStore'
import Company from './Company'

class CompanyList extends Component {
    constructor(){
        super()
        this.state = {
            companies : [],
            selectedCompany:null
        }
        
        this.selectCompany=(Company)=>{
            this.setState({
                selectedCompany:Company
            })
        }
        this.cancelSelection=(Company)=>{
            this.setState({
                selectedCompany:null
            })
        }

        this.saveCompany=(id,Company)=>{
            this.store.saveOne(id,Company)

        }
    }
    componentDidMount(){
        this.store = new CompanyStore()
        this.setState({
            companies : this.store.getAll()
        })
        this.store.emitter.addListener('UPDATE', () => {
            this.setState({
                companies : this.store.getAll()
            })          
        })
    }
  render() {
    return (
      <div>
        <div>
              {
                  this.state.companies.map((e,i)=> <Company key={i} item={e} onSave={this.saveCompany} onSelect={this.selectCompany}></Company>)
              }
          </div>
      </div>
    )
  }
}

export default CompanyList



SUB3 V2
# Avand urmatoarea aplicatie create folosind `create-react-app`, modificati `Company` si adaugati `CompanyDetails` astfel incat:
- aplicatia se deseneaza corect (0.5 pts);
- `CompanyDetails` are o proprietate numita `item` care contine compania ale carei detalii le afiseaza (0.5 pts);
- `CompanyList` se deseneaza ca o lista de  `Company`, iar fiecare `Company` are un buton cu eticheta `select` (0.5 pts);
- Daca se da click pe butonul select al unui `Company` se deschide afiseaza componenta de detalii (0.5 pts);
- Daca este afisat `CompanyDetails` si se da click pe butonul cancel se afiseaza din nou lista de companii (0.5 pts);

import React, { Component } from 'react'

class Company extends Component {
  render() {
    let {item} = this.props
    return (
      <div>
        Name {item.name} with {item.employees} employees {item.revenue} revenue
      <input type="button" value="select" onClick={this.select}></input>
      <input type="button" value="cancel" onClick={this.cancel}></input>
      </div>
    )
  }
}

export default Company

import React, { Component } from 'react'

class CompanyDetails extends Component{
    constructor(props){
        super(props)
        let{item}=this.props
        this.state = {
            
                  name : item.name,
                  employees : item.employees,
                  revenue : item.revenue,
          }
       

        this.select=()=>{
            this.props.onSelect(this.props.item)
        }
        this.cancel=()=>{
           
        }
    }

    render() {
        let {item} = this.props
       
          return (
            <div>
              <h4>
                <input type="text" value={this.state.name} name="name" ></input></h4>
                <h4><input type="text" value={this.state.employees} name="employees" ></input></h4>
                <h4> <input type="text" value={this.state.revenue} name="revenue" ></input></h4>
              
             
              <input type="button" value="cancel" onClick={this.cancel} />            
            </div>
          )
        }
}

export default CompanyDetails


import React, { Component } from 'react'
import CompanyStore from '../stores/CompanyStore'
import Company from './Company'
import CompanyDetails from './CompanyDetails'

class CompanyList extends Component {
    constructor(){
        super()
        this.state = {
            companies : [],
            selectedCompany:null
        }
        this.selectCompany=(CompanyDetails)=>{
            this.setState({
                selectedCompany:CompanyDetails
            })
        }
        this.cancelSelection=(Company)=>{
            this.setState({
                selectedCompany:null
                
            })
        }
        
    }
    componentDidMount(){
        this.store = new CompanyStore()
        this.setState({
            companies : this.store.getAll()
        })
        this.store.emitter.addListener('UPDATE', () => {
            this.setState({
                companies : this.store.getAll()
            })          
        })
    }
  render() {
    if (this.state.selected){
        <CompanyDetails>
            {
                this.state.companies.map((e, i) => 
                    <Company item={e} key={i}  />
                )
            }
        </CompanyDetails>
    }
    else{
        return (
          <div>
            {
                this.state.companies.map((e, i) => 
                    <Company item={e} key={i} onSelect={this.selectCompany} />
                )
            }
          </div>
        )
    }
  }
}

export default CompanyList





SUB3 V3
# Avand urmatoarea aplicatie create folosind modulul `create-react-app` completati urmatoarele cerinte:
- Adaugati componenta `AddDevice` in template-ul componentei `DeviceList`;
- Componenta `AddDevice` trebuie sa contina 2 elemente de tip `input` cu `id`: `name` si `price`;
- Componenta `AddDevice` trebuie sa contina un element de tip `button` cu textul `Submit`, folosit pentru a apela metoda `addItem`;
- Componenta `AddDevice` din interiorul componentei `DeviceList` trebuie sa contina o proprietate numita `onAdd` in obiectul `props`;
- La apasarea butonului `Submit` un nou element va fi afisat si adaugat in starea componentei `DeviceList`;

### INFORMATII UTILE: Obiectele adaugate in vectorul din starea componentei `DeviceList` sunt de forma { name: String, price: Number }.

import React from 'react';
import AddDevice from './AddDevice';

class DeviceList extends React.Component {
    constructor(){
        super();
        this.state = {
            devices: []
        };

      
        this.addDevice=(device)=>{
            
            this.state.devices.push(device)
            
        }
    }   
    
   
    render(){
        let {item} = this.props
        return (
            <div>
               
            <AddDevice onAdd={this.addDevice}></AddDevice>
         
            </div>
        )
    }
}

export default DeviceList;


import React from 'react';

class AddDevice extends React.Component {
    constructor(props){
        super(props)
        this.state={
            name:'',
            price:''
        }

        this.handleChange=(eveniment)=>{
            this.setState({
                [eveniment.target.name]:eveniment.target.value
            })
        }
        
    }
    render() {
      
        return (

            <div>
                <input type="text" id="name" name='name' placeholder='Device name:'  onChange={this.handleChange} ></input>
                <input type="text" id="price"name='price' placeholder='Device price:'  onChange={this.handleChange}></input>
                <button id="submit"  onClick={()=>this.props.onAdd({
    name:this.state.name,
    price:this.state.price,
     })
     
     }>Submit</button>
            </div>
        )
    }
}

export default AddDevice;



SUB3 V4
# Avand urmatoarea aplicatie pentru vanzare automata de produse  realizati modificari astfel incat:
- aplicatia se deseneaza corect (0.5 pts)
- incarcati lista de produse din ProductStore la desenarea componentei `VendingMachine` (0.5 pts)
- adaugati componenta `Product` afisati numele, pretul si un buton cu eticheta buy care apeleaza metoda onBuy (0.5 pts)
- implementati metoda addTokens care incrementeaza numarul de token cu 1 la fiecare apasare de buton (0.5 pts)
- implementati metoda buyProduct care scade numarul de tokeni cu pretul produsului cumparat; daca nu sunt suficienti tokeni nu se realizeaza vanzare (0.5 pts)

import React, { Component } from 'react'

class Product extends Component {
    render(){
        return(
            <div>
                <h4>{this.props.name}</h4>
                <h4>{this.props.price}</h4>
                <input type="button" value="buy" onClick={()=>this.props.onBuy(this.props.price)}></input>
            </div>
        )
    }
}

export default Product


import React, { Component } from 'react'
import Product from './Product'
import ProductStore from '../stores/ProductStore'

class VendingMachine extends Component {
    constructor() {
        super()
        this.state = {
            products: [],
            tokens: 0
        }

        this.addToken = () => {
            this.setState({
                tokens:this.state.tokens+1
            })
        }

        this.buyProduct = (price) => {
           if(this.state.tokens>=price){
            this.setState({
                tokens:this.state.tokens-price
            })
           }
        }
    }

    componentDidMount(){
        let productStore = new ProductStore()

        this.setState({products: productStore.getAll()})

}

    render() {
        return (
            <div>
                {this.state.products.map((el, index) => <Product key={index} name={el.name} price={el.price} onBuy={this.buyProduct}  />)}
                <div>Tokens: {this.state.tokens}</div>
                <input type="button" value="add token" onClick={this.addToken} />
            </div>
        )
    }
}

export default VendingMachine



V5 S1
# Avand urmatoarea functie `function applyDiscount(vehicles, discount)`, completati urmatoarele taskuri:

- Functia trebuie sa returneze un Promise; (0.5 pts)
- Daca `discount` nu este numar, functia trebuie sa apeleze `reject` cu `Error` si mesajul `Invalid discount`; (0.5 pts)
- `vehicles` este un vector ce contine elemente cu urmatorul format: `{make: string, price: number}` (Example: [{make: "Audi A5", price: 15000}]). Daca este pasat un vector cu obiecte invalide, se apeleaza `reject` cu `Error` si mesajul `Invalid array format`; (0.5 pts)
- Functia trebuie sa apeleze `reject` cu `string` cu `Discount too big` daca `discount` este mai mare de 50% fata de cel mai mic pret din `vehicles`; (0.5 pts)
- Functia trebuie sa apeleze `resolve` cu un vector ce contine valorule modificate pentru fiecare element din `vehicles`; (0.5 pts)

function applyDiscount(vehicles, discount){
    return new Promise((resolve,reject)=>{
        if(!(typeof discount==="number")){
            reject(new Error('Invalid discount'))
        }
        let min=vehicles[0].price
        vehicles.forEach(element => {
            if(!(typeof element.make==="string")&&!(typeof element.price==="number")){
                reject(new Error('Invalid array format'))
            }else{
                if(min>element.price){
                    min=element.price
                }
            }
        });
        if(discount>0.5*min){
            reject('Discount too big')
        }
        resolve(vehicles.map(v => {
            return {
                make : v.make,
                price: v.price  - discount
            }
        }))
    })

    
    
}

const app = {
    applyDiscount: applyDiscount
};

module.exports = app;



V5 S2
# Avand urmatoa aplicatie dezvoltata in NodeJS, sa se completeze metoda de tip `POST` de pe calea `/cars` :

- Daca nu exista body pentru cererea http, trebuie sa returnati un JSON cu urmatorul format: `{message: "Body is missing"}`. Codul de raspuns trebuie sa fie: `500`;
- Daca body-ul nu respecta formatul unei masini, trebuie sa returnati un JSON cu urmatorul format: `{message: "Invlid body format"}`. Codul de raspuns trebuie sa fie: `500`;
- Pretul unei masini trebuie sa fie mai mare ca 0.In caz contrar trebuie sa returnati un JSON cu urmatorul format: `{message: "Price should be a positive number"}`. Codul de raspuns trebuie sa fie: `500`; 
- Daca masina exista deja in vector, trebuie sa returnati un JSON cu urmatorul format: `{message: "Product already exists"}`.Codul de raspuns trebuie: `500`. Unicitatea se face in functie de model;
- Daca body-ul are formatul corespunzator, masina trebuie adaugata in vector si sa returnati un JSON cu urmatorul format: `{message: "Created"}`. Codul de raspuns trebuie sa fie: `201`;

app.get('/cars', (req, res) => {
    res.status(200).json(app.locals.cars);
});

app.post('/cars', (req, res, next) => {
    let car=req.body
    if(Object.keys(car).length === 0) {
        res.status(500).json({message : 'Body is missing'})
    
    }
    else if(app.locals.cars.find(s=>s.model===car.model)){
        res.status(500).json({message: 'Car already exists'});
    }else if(!(car.hasOwnProperty("make")&&car.hasOwnProperty("model")
        &&car.hasOwnProperty("price") )){
            res.status(500).json({message : "Invalid body format"})
        }else if (car.price<0){         
                res.status(500).json({message : "Price should be a positive number"})
            }            
            else{
                app.locals.cars.push(car)
                res.status(201).json({message : 'Created'}) 
        }
    

    res.status(400).json({message: 'Bad request'});
})

module.exports = app;


V5 S3
# Avand urmatoarea apliatie create folosind `create-react-app`, completati urmatoarele taskuri:
- Componenta `AddStudent` trebuie adaugata in interiorul componentei `StudentList`;
- Componenta `AddStudent` trebuie sa contina 3 elemente de tip input cu `id-ul` si `name-ul`: `name`, `surname`, `age`;
- Componenta `AddStudent` trebuie sa contina un element input de tip buton `button` cu valoarea `add student`, folosit pentru a apela metoda `addStudent`;
- Componenta `AddStudent` din interiorul componentei `StudentList` trebuie sa contina in `props` metoda `onAdd`;
- La apasarea butonului `add student` un nou element trebuie afisat in componenta `StudentList`;

import React from 'react';

export class AddStudent extends React.Component {
    constructor(props){
        super(props);
        this.state = {
            name: '',
            surname: '',
            age: ''
        };
    }

    addStudent = () => {
        let student = {
            name: this.state.name,
            surname: this.state.surname,
            age: this.state.age
        };
        this.props.onAdd(student);
    }

    render(){
        return (
            <div>
                
            </div>
        )
    }
}





V0 S2 2020
// TODO: implementați funcția
    // ar trebui să adauge un autor
    // numele și email-ul autorului nu pot fi vide
    // adresele autorilor pot fi vide
    // email-urile autorilor trebuie validate ca formă

const express = require('express')
const bodyParser = require('body-parser')
const Sequelize = require('sequelize')

const mysql = require('mysql2/promise')

const DB_USERNAME = 'root'
const DB_PASSWORD = 'pass'

mysql.createConnection({
    user : DB_USERNAME,
    password : DB_PASSWORD
})
.then(async (connection) => {
    await connection.query('DROP DATABASE IF EXISTS tw_exam')
    await connection.query('CREATE DATABASE IF NOT EXISTS tw_exam')
})
.catch((err) => {
    console.warn(err.stack)
})

const sequelize = new Sequelize('tw_exam', DB_USERNAME, DB_PASSWORD,{
    dialect : 'mysql',
    logging: false
})

let Author = sequelize.define('author', {
    name : Sequelize.STRING,
    email : Sequelize.STRING,
    address : Sequelize.STRING,
    age : Sequelize.INTEGER
})

const app = express()
app.use(bodyParser.json())

app.get('/create', async (req, res) => {
    try{
        await sequelize.sync({force : true})
        for (let i = 0; i < 10; i++){
            let author = new Author({
                name : 'name ' + i,
                email : 'name' + i + '@nowhere.com',
                address : 'some address on ' + i + 'th street'
            })
            await author.save()
        }
        res.status(201).json({message : 'created'})
    }
    catch(err){
        console.warn(err.stack)
        res.status(500).json({message : 'server error'})
    }
})

app.get('/authors', async (req, res) => {
    // should get all authors
    try{
        let authors = await Author.findAll()
        res.status(200).json(authors)
    }
    catch(err){
        // console.warn(err.stack)
        res.status(500).json({message : 'server error'})        
    }
})

app.post('/authors', async (req, res) => {
    let autor=req.body
    if(autor.name && autor.email){
        if(autor.email.includes("@")){
            try{
                let author=await Author.create(autor)
                res.status(201).send({message : 'created'})
             res.status(201).json({author: author})
    
            }
            catch(err){
                // console.warn(err.stack)
                res.status(500).json({message : 'server error'})        
            }   
        }else{
            res.status(500).json({message : 'server error'});
        }
        
    }else{
        res.status(500).json({message: "server error"});
    }
    
    

})

app.listen(8080)

module.exports = app



app.post('/authors/:id/books', async (req, res) => {
    // TODO: implementați funcția
    // ar trebui să adauge o carte la un autor
    // TODO: implement the function
    // should add a book to an author
    if(req.params.id){
        let author = await Author.findByPk(req.params.id)
        if(author){
            let book = req.body;
            book.authorId = req.params.id;
            await Book.create(book);
            //author.addBook(book);

            res.status(201).json({message:"created"})
        }else{
                res.status(404).json({message:"not found"})
                    
        }
    }else{
            res.status(404).json({message : 'not found'})
        }
})


app.get('/authors/:id/books', async (req, res) => {
    // TODO: implementați funcția
    // ar trebui să listeze toate cărțile unui autor

    // TODO: implement the function
    // should list all of an authors' books
    if(req.params.id){
        const author = await Author.findByPk(req.params.id);
        if(author){
            
            let books = await author.getBooks()
            res.status(200).json(books);
            
        }else{
                res.status(404).json({message:"not found"})
                    
        }
    }
        else{
            res.status(404).json({message : 'not found'})
        }
})




V0 S3 2020
// TODO : adăugați o componentă Robot 
// afișați o componentă Robot pentru fiecare robot din stare 
// o componentă robot ar trebui să afișeze un robot și să permită ștergerea lui
class RobotList extends Component {
    constructor(){
        super()
        this.state = {
            robots : []
        }
        this.deleteRobot = (id) => {
            this.store.deleteRobot(id)
        }
    }
    componentDidMount(){
        this.store = new RobotStore()
        this.setState({
            robots : this.store.getRobots()
        })
        this.store.emitter.addListener('UPDATE', () => {
            this.setState({
                robots : this.store.getRobots()
            })          
        })
    }
  render() {
    return (
      <div>
        {
            this.state.robots.map((e,i)=><Robot item={e} key={i} onDelete={this.deleteRobot}></Robot>)
        }
      </div>
    )
  }
}

export default RobotList



# Avand definită clasa `Shape` rezolvați următoarele taskuri:

- Dacă `Shape` este instanțiată direct și este apelată metoda `area`, se va arunca un obiect `Error`  cu mesajul `not implemented`; (0.5 pts)
- Se va defini clasă `Square` care extinde `Shape`; Un `Square` poate fi instanțiat pe baza unui obiect cu o proprietate `width`; (0.5 pts)
- Dat fiind un `Square`, se va calcula corect aria acestuia; (0.5 pts)
- Se va defini clasă `Circle` care extinde `Shape`; Un `Circle` poate fi instanțiat pe baza unui obiect cu o proprietate `radius`; Dat fiind un `Circle`, se va calcula corect aria acestuia; (0.5 pts)
- Se va defini clasă `Rectangle` care extinde `Shape`; Un `Rectangle` poate fi instanțiat pe baza unui obiect cu o proprietate `width` și o proprietate `height`; Dat fiind un `Rectangle`, se va calcula corect aria acestuia; (0.5 pts)

class Shape{
    constructor(dimensions){
        this.dimensions = dimensions

    }
    area(){
        throw Error('not implemented');
    }
    
}

// TODO: Square, Circle, Rectangle
class Square extends Shape{
    constructor(dimensions,width)
    {
        super(dimensions);
        var {width:w}=dimensions;
        this.width=w;
    
    
    }
    area()
    {
        console.log(this.width);
        return this.width*this.width;
    }
    
}
class Circle extends Shape{
    constructor(dimensions,radius)
    {
        super(dimensions);
        var {radius:r}=dimensions;
        this.radius=r;
        
    }

    area()
    {
        return parseInt(Math.PI*this.radius*this.radius);
    }
}
class Rectangle extends Shape{
    constructor(dimensions,width,height)
    {
        super(dimensions);
        var {width:w}=dimensions;
        var {height:h}=dimensions;
        this.width=w;
        this.height=h;
    
    }
    area()
    {
        return this.width*this.height;
    }
}
const app = {
  Shape: Shape,
  Square : Square,
  Circle : Circle,
  Rectangle : Rectangle
}

module.exports = app



# Avand următoarea funcție `function toCamelCase(input)`, completați următoarele taskuri:

- Funcția trebuie să arunce un obiect `Error` cu mesajul `Input must be a string primitive or a string object` dacă inputul este un număr; (0.5 pts)
- Funcția trebuie să arunce un obiect `Error` cu mesajul `Input must be a string primitive or a string object` dacă inputul este un `undefined`; (0.5 pts)
- Dat fiind un input format din cuvinte separate de `-` funcția trebuie să îl returneze transformat în camelCase (cu inițiala cu literă mică); (0.5 pts)
- Dat fiind un input format din cuvinte separate de `_` funcția trebuie să îl returneze transformat în camelCase (cu inițiala cu literă mică); (0.5 pts)
- Dat fiind un input format din cuvinte separate de `spațiu` funcția trebuie să îl returneze transformat în camelCase (cu inițiala cu literă mică); (0.5 pts)


function toCamelCase(input){
    
    var words;
    if(input)
    {
        if(typeof(input)==='number')
        {
            throw Error("Input must be a string primitive or a string object")
        }
        else
        {
        if(input.includes(' '))
        {
         var res='';
         words=input.split(' ');
         
         words.forEach(word=>{
            var converted= word.slice(0,1).toUpperCase()+word.slice(1,word.length);
            res+=converted;
         })
         res=res.slice(0,1).toLowerCase()+res.slice(1,res.length);
         return res;
        }
        else 
            if(input.includes('-'))
            {
                 res='';
                 words=input.split('-');
                 
                 words.forEach(word=>{
                    var converted= word.slice(0,1).toUpperCase()+word.slice(1,word.length);
                    res+=converted;
                 })
                 res=res.slice(0,1).toLowerCase()+res.slice(1,res.length);
                 return res;
            }
                else if(input.includes('_'))
                {
                     res='';
                     words=input.split('_');
                     
                     words.forEach(word=>{
                        var converted= word.slice(0,1).toUpperCase()+word.slice(1,word.length);
                        res+=converted;
                     })
                     res=res.slice(0,1).toLowerCase()+res.slice(1,res.length);
                     return res;
                }
        }
    }
    else
    {
        throw Error("Input must be a string primitive or a string object")
    }
    
    
    

    
}

const app = {
  toCamelCase: toCamelCase
}

module.exports = app

