The-Task Grupp 5


_______________________
**Kod ordning** *(vad behöver kodas först)*

**Phase 1**

- [ ] Basklasser
- [ ] Controller klasser - För att kunna se sidorna.
    - [ ] Login Controller Class
        - [ ] Mapping Method för att visa sidan
    - [ ] Register Controller Class
        - [x] Mapping Method för att visa sidan
    - [ ] Dashboard Controller Class
        - [ ] Mapping Method för att visa sidan
- [ ] Html filer utan funktioner till backend

**Phase 2**

- [ ] Controllers
    - [ ] Login post
    - [ ] register post
    - [ ] Hantera skapande av ny lista/task
    - [ ] Få Mappings att funka
        - [ ] login -> dashboard
        - [ ] login -> register
        - [ ] register -> login
        - [ ] dashboard - login
- [ ] Fragments html (arv/Extends/interface) (Måste inte användas)
    - [ ] Task-div
    - [ ] List-div
    - [ ] Add 'TaskList' rutan-div

**Phase 3**

- [ ] Testar som galningar

_______________________

**Arbetsflöde: Metod**

 1. Bestäm vad du vill göra
 2. Skapa issue OCH sätt dig som assignee
 3. Börja jobba
 4. När du klar med jobbet, kryssa i vald uppgift i README
 5. Pusha (ALDRIG main branch)
 6. Merga. Ta bort branch OCH stäng ner issue


_______________________

**Våran generella TODO**

**Java**

- **Folders**
    - [ ] Controllers
    - [ ] Todo för list och task

- **Databasen**
    - [x] Kunna lägga till användare till databasen(username m password)
    - [x] Lista av users med password i databasen
        - [x] Skapa mock data -> users att börja med: Dennis, Niklas, Farre & Qutaiba

- **User**
    - [x] Kunna skapa nya listor
    - [x] Kunna hämta alla listor
    - [x] Kunna hämta specifc lista (kräver id?)
    - [x] Kunna hämta password (för att checka mot inlogg)

- **TodoList**
    - [x] Kunna Hämta tasks
    - [x] Kunna Hämta specifc task (kräver id?)
    - [x] Unikt ID

- **TodoTask**
    - [ ] Kunna hämta title
    - [ ] Kunna hämta deadline

- **Check klass**
    - [ ] Kontrollera om login uppgifter stämmer - boolean
    - [ ] Kontrollera om user redan finns - boolean

**Javascript**
- [x] Skapa script.js fil som kan användas vid behov

**Html**

- **Login Page**
    - [x] Skapa Knapp för login
    - [x] Skapa textfield för användarnamn och lösenord
    - [x] titel
    - [ ] POST för login uppgifter
    - [ ] Visa felmedelande vid misslyckat inlogg
    - [ ] Visa felmedelande vid saknad username/password i input fälten
    - [ ] Vid lyckad inlogg, redirect till dashboard
    - [ ] Skapa knapp för login
    - [ ] Skapa txt fält username, password
    - [ ] Skapa header "welcome"
    - [ ] skapa länk till register
    - [ ] style (extra krydda)

- **Register Page**
    - [ ] POST för ny user uppgifter
    - [ ] Visa felmedelande när username redan finns (vid post)
    - [ ] Visa felmedelande när passwords inte stämmer (innan post)
    - [ ] Vid lyckad skapande, redirect till login
    - [x] Skapa knapp för register
    - [x] Skapa txt fält, username, password, password 2
    - [x] Skapa tillbaka länk ("redan medlem?, logga in")


- **Dashboard Page**
    - [ ] Visa Listor
        - [ ] Visa tasks som tillhör listan
            - [ ] checkbox för klar - (byta färg till grön(extra krydda))
                - [ ] deadline blockas när task klar.(inaktiveras / triggas ej / checkas ej / lös det bara)
                - [ ] kan unchecka checkboxen (extra krydda)
                - [ ] spara i backend att task klar? (om behov finns)
            - [ ] Färg vanligt -> basfärg
            - [ ] visa title/name på task
            - [ ] färgändring om deadline nådd (röd)
            - [ ] visa deadline på något sätt. ( extra spicy)
    - [ ] Header med username + välkommen
    - [ ] Knapp för skapa ny lista
        - [ ] Knappens plats är där nästa lista ska skapas
    - [ ] Knapp för ny task (Sitter i listan)
    - [ ] Yta för hantera ny lista/task
        - [ ] txt field för Title/name
        - [ ] txt field kunna sätta Deadline (ej för lista) (ska finnas någon html kod för detta, kalender?)
        - [ ] Knapp för skapa lista / task
            - [ ] vid skapade så blir ytan tom.
        - [ ] Visa vilken lista den tillhör - om det är en task - txt fält
    - [ ] knapp för logout
        - [ ] redirect till loginpage
            - [ ] visa medelande "välkommen åter!" (extra krydda)
    - [ ] Styla (extra krydda)
    - [ ] vid utlogg -> redirect till login.html


- **Fragments**
    - [x] Lägg till dependencies
    - [x] Skapa baslayout.html
    - [x] Skapa en test sida med baslayout som layout
    - [x] Skapa en annan test sida med baslayout som layout

**Controllers**
    - [x] Grundlläggande Mapping i LoginController

- **Login**
    - [ ] Hantera korrekt inlogg - Redirect dashboard
    - [ ] Hantera felaktigt inlogg - visa felmedelande för user

- **Register**
    - [ ] Hantera ny user
        - [ ] lägg till userobj i databas user lista
        - [ ] Redirect till login
            - [ ] Visa meddelande att du har skapat ny user
    - [ ] Hantera user som redan finns
        - [ ] skicka felmedelande till user

- **Dashboard**
    - [ ] Hantera skapande av ny lista
        - [ ] spara i user objectet
        - [ ] visa nya listan
    - [ ] Hantera skapande av ny task
        - [ ] spara i korrekt lista