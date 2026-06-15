# Java Programming Projects

A collection of Java programs developed during the Diploma of Information Technology at Swinburne University of Technology (UniLink Pathway), demonstrating object-oriented programming principles including inheritance, polymorphism, interfaces, exception handling, and file persistence.

---

## Projects

### Assignment 1 — Cinema Seat Reservation System

A console-based ticket reservation system for an 8-row, 10-seat cinema.

**Features:**
- Reserve up to 10 seats per booking (system enforced limit)
- **Auto-allocation:** system finds and assigns the next available seats
- **Manual allocation:** user specifies a starting seat (e.g. `B3`) and books consecutive seats from there
- Visual seat map display showing available (`O`) and reserved (`X`) seats
- Count of remaining available seats
- Search for a booking by Ticket ID
- Print all issued tickets with seat range and total cost

**OOP concepts used:** Classes, objects, static fields for auto-incrementing IDs, 2D arrays, Scanner input handling, JUnit tests

**Classes:**
- `MovieScreen` — main class, manages the seat grid and menu
- `Ticket` — stores ticket ID, seat range, and calculates cost ($15 per seat)

---

### Assignment 2 — Travel Australia Tour Booking System

A full-featured staff booking system for a travel agency, built with object-oriented design across 11 classes.

**Features:**
- Role-based login (Admin and Sales Executive accounts)
- Admin can create new Sales Executive accounts
- Users are saved to and loaded from a `users.txt` file between sessions
- Book four types of tours: City Tours, Attractions Tours, Queensland Tours, International Tours
- Family/group discount system (10% for 1A+1C or 2A+1C, 15% for 4+ passengers)
- Optional insurance for Queensland tours, mandatory insurance for International tours
- Automatic pickup cost ($150) for groups of 6 or fewer
- Cancel a booking with 75% refund calculation
- Search bookings by ticket number
- Filter and display bookings by tour name
- Sales report showing total revenue per Sales Executive
- JUnit 5 test suite covering price calculation, discount logic, and insurance calculation

**OOP concepts used:**
- **Inheritance** — `Admin` and `SalesExecutive` extend `User`; all tour types extend abstract `Tour`
- **Polymorphism** — `displayTour()` and `calculatePrice()` overridden in each tour subclass
- **Abstract classes** — `Tour` defines the contract all tour types must follow
- **Interfaces** — `Insurance` interface implemented by `QueenslandTour` and `InternationalTour`
- **Custom exceptions** — `NoInsuranceException` thrown when International Tour is booked without insurance
- **File I/O** — users persisted to disk with `FileWriter` / `Scanner`
- **ArrayList** — dynamic storage for bookings and users
- **Constructor overloading** — `Customer` class supports name-only or name+contact construction

**Classes:**
| Class | Role |
|-------|------|
| `Main` | Entry point, menus, business logic |
| `Tour` | Abstract base class for all tours |
| `CityTour` | Melbourne city tour bookings |
| `AttractionsTour` | Day-trip attraction bookings with pickup location |
| `QueenslandTour` | Interstate tour with optional insurance |
| `InternationalTour` | Overseas tour with mandatory insurance |
| `User` | Base class for system users |
| `Admin` | Admin role, manages staff accounts |
| `SalesExecutive` | Sales staff role, manages bookings |
| `Customer` | Stores customer name and contact number |
| `Insurance` | Interface defining insurance behaviour |
| `NoInsuranceException` | Custom exception for missing insurance |
| `TourTest` | JUnit 5 test suite |

---

## Technologies Used

| Tool | Purpose |
|------|---------|
| Java 17 | Core language |
| Eclipse IDE | Development environment |
| JUnit 5 | Unit testing |
| Java File I/O | Data persistence |

---

## Running the Projects

### Assignment 1
1. Open in Eclipse or any Java IDE
2. Run `MovieScreen.java`

### Assignment 2
1. Open in Eclipse or any Java IDE
2. Run `Main.java`
3. Default login: username `admin`, password `admin123`

---

## About

**Student:** Sehan Madusha Jayasuriya  
**Program:** Diploma of Information Technology (UniLink) — Swinburne University of Technology  
**Unit:** COS10033 Advanced Programming  
**Year:** 2026
