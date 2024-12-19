It was a group work wiht 3 students 
The-Task Grupp 5

Info:
How to use this app
If you want to try the app out you can use:

### Login  
- username: **"admin"**
- Password **"admin"**

_______________________
**Kod ordning** *(vad behöver kodas först)*

### **Phase 1**

- [x] Basklasser
- [x] Controller klasser - För att kunna se sidorna.
    - [x] Login Controller Class
        - [x] Mapping Method för att visa sidan
    - [x] Register Controller Class
        - [x] Mapping Method för att visa sidan
    - [x] Dashboard Controller Class
        - [x] Mapping Method för att visa sidan
- [x] Html filer utan funktioner till backend

### **Phase 2**

- [x] Controllers
    - [x] Login post
    - [x] register post
    - [x] Hantera skapande av ny lista/task
    - [x] Få Mappings att funka
        - [x] login -> dashboard
        - [x] login -> register
        - [x] register -> login
        - [x] dashboard - login

### **Phase 3**

- [x] Synka så samma stil på alla sidor (Samma tema/intryck)
    - [x] Bakgrund
- [x] Fixa div - inte relativ till längsta lista **Extra krydda**

### **Phase 4**

- [x] Testar som galningar

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

## **Java**

- **Constant Class**
    - [x] Add a constant class with final values. This to avoid any spelling issues and DRY concept

- **Folders**

    - [x] Controllers
    - [x] Todo för list och task

- **Databasen**
    - [x] Kunna lägga till användare till databasen(username m password)
    - [x] Lista av users med password i databasen
        - [x] Skapa mock data -> users att börja med: Dennis, Niklas, Farre & Qutaiba

- **User**
    - [x] Kunna skapa nya listor
    - [x] Kunna hämta alla listor
    - [x] Kunna hämta specific lista (kräver id?)
    - [x] Kunna hämta password (för att checka mot inlogg)

- **TodoList**
    - [x] Kunna Hämta tasks
    - [x] Kunna Hämta specific task (kräver id?)
    - [x] Unikt ID

- **TodoTask**
    - [x] Kunna hämta title
    - [x] Kunna hämta deadline

- **Check klass**
    - [x] Kontrollera om login uppgifter stämmer - boolean
    - [x] Kontrollera om user redan finns - boolean

## **Javascript**

- [x] Skapa script.js fil som kan användas vid behov

## **Html**

- **Login Page**

    - [x] POST för login uppgifter
    - [x] Visa felmeddelande vid misslyckat inlogg
    - [x] Visa felmeddelande vid saknad username/password i input fälten
    - [x] Vid lyckad inlogg, redirect till dashboard
    - [x] Skapa knapp för login
    - [x] Skapa txt fält username, password
    - [x] Skapa header som förklarar vart du kommit
    - [x] skapa länk till register
    - [x] style (extra krydda)

- **Register Page**
    - [x] POST för ny user uppgifter
    - [x] Visa felmeddelande när username redan finns (vid post)
    - [x] Visa felmeddelande när passwords inte stämmer (innan post)
    - [x] Vid lyckad skapande, redirect till login
    - [x] Skapa knapp för register
    - [x] Skapa txt fält, username, password, password 2
    - [x] Skapa tillbaka länk ("redan medlem?, logga in")


- **Dashboard Page**
    - [x] Visa Listor
        - [x] Visa tasks som tillhör listan
            - [x] checkbox för klar - (byta färg till grön(extra krydda))
                - [x] deadline blockas när task klar.(inaktiveras / triggas ej / checkas ej / lös det bara)
                - [x] kan unchecka checkboxen (extra krydda)
                - [x] spara i backend att task klar. ("Task status?")
            - [ ] Färg vanligt -> basfärg
            - [x] visa title/name på task
            - [x] färgändring om deadline nådd (röd)
            - [x] visa deadline på något sätt. ( extra spicy)
    - [x] Header med username + välkommen
    - [x] Skapa divs för list, task och todoadd view
        - [x] TodoList div
        - [x] TodoTask div
        - [x] TodoAdd div
    - [x] Knapp för skapa ny lista
        - [x] Knappens plats är där nästa lista ska skapas
    - [x] Knapp för ny task (Sitter i listan)
    - [x] Yta för hantera ny lista/task
        - [x] txt field för Title/name
        - [x] txt field kunna sätta Deadline (ej för lista) (ska finnas någon html kod för detta, kalender?)
        - [x] Knapp för skapa lista / task
    - [x] knapp för logout
        - [x] redirect till loginpage
            - [x] visa meddelande "välkommen åter!" (extra krydda)
    - [x] Styla (extra krydda)
    - [x] vid utlogg -> redirect till login.html
  

- **Fragments**
    - [x] Lägg till dependencies
    - [x] Skapa baslayout.html
    - [x] Skapa en test sida med baslayout som layout
    - [x] Skapa en annan test sida med baslayout som layout

- **Controllers**
    - [x] Grundläggande Mapping i LoginController

- **Login**
    - [x] Hantera korrekt inlogg - Redirect dashboard
    - [x] Hantera felaktigt inlogg - visa felmeddelande för user
    - [x] Hantera om session redan finns - Redirect dashboard.

- **Register**
    - [x] Hantera ny user
        - [x] lägg till userobj i databas user lista
        - [x] Redirect till login
            - [x] Visa meddelande att du har skapat ny user
    - [x] Hantera user som redan finns
        - [x] skicka felmeddelande till user

- **Dashboard**
    - [x] Hantera skapande av ny lista
        - [x] spara i user objectet
        - [x] visa nya listan
    - [x] Hantera skapande av ny task
        - [x] spara i korrekt lista
    - [x] Redirect till login om ingen session finns.
        - (ska inte kunna gå att nå dashboard utloggad)
