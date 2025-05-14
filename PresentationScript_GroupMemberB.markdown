# Presentation Script for Group Member B  
**Duration**: ~5 minutes  
**Project**: CampusAssist (OODD-MainApp-B)  

---

**Slide 1: Introduction and Class Diagram**  
*(~1 minute, 150 words)*  
Good morning, everyone. I’m Group Member B for the CampusAssist project, and today I’ll present my contributions: admin appointment management, a role-based login system, and feedback viewing. Let’s start with my UML Class Diagram. It includes `User`, `Appointment`, `UserService`, and `AdminService`. `User` manages user data with a `role` attribute, `Appointment` handles session details, `UserService` implements login, and `AdminService` manages appointments. The diagram shows a one-to-many association between `User` and `Appointment`, and `AdminService` depends on both for operations. I used encapsulation with private attributes and public methods. My code comments, such as in `AdminService.java`, explain the logic for approving appointments, ensuring clarity for maintenance. This design supports scalability, as `UserService` can be extended for more roles.

---

**Slide 2: Code Walkthrough – Login System**  
*(~1 minute, 150 words)*  
Let’s look at my role-based login system in `UserService.java`. This class implements the `IUser` interface, which defines `login` and `Register` methods. The `login` method checks the email and password against a list of users, as noted in the comments, ensuring secure authentication. In `MainAppB.java`, I use `UserService` to register users from `DataManagerB` and authenticate them. For example, logging in as Anna with email `anna@example.com` and password `admin123` outputs “Login successful!” The system then checks the user’s role, allowing only admins to access the `AdminService` menu. Comments in `MainAppB.java` explain this role-based restriction, ensuring only authorized users can manage appointments. This design separates authentication logic, making it reusable across the project.

---

**Slide 3: Code Walkthrough – Admin Appointment Management**  
*(~1.5 minutes, 225 words)*  
Now, let’s explore admin appointment management in `AdminService.java`. The `adminMenu` method provides options to view, approve, reschedule, or cancel appointments, and view feedback. For example, `approveCancelAppointment` prompts for an appointment ID, displays its current status, and lets the admin set it to “Approved” or “Canceled.” Comments explain the status validation logic, ensuring only valid inputs are accepted. If I approve appointment ID 1, it outputs “Appointment updated successfully.” Similarly, `rescheduleAppointment` allows admins to update the date and time, using `LocalDateTime` for parsing, as noted in the comments. For instance, rescheduling to 2025-05-16 at 14:00 works seamlessly. The `viewFeedback` method displays feedback for all appointments, with comments clarifying how it filters for non-null feedback. This ensures admins can monitor session quality effectively.

---

**Slide 4: Integration and Conclusion**  
*(~1.5 minutes, 225 words)*  
For integration, my code integrates smoothly into the combined project. `UserService` provides the login system for all members—A’s `StudentService` and C’s `FAQService` use it to authenticate users before accessing their menus. I added comments in the combined `MainApp.java` to explain how `UserService` initializes users and directs them to role-specific menus. `AdminService` shares the `Appointment` class with A and C, enabling A’s session requests to be managed by admins and C’s analytics to use the same data. A challenge was ensuring role-based access; I solved this by adding role checks in `MainAppB.java`, as noted in the comments. Another challenge was maintaining appointment consistency across features, which I addressed by standardizing `Appointment` attributes. In conclusion, my login system and admin features were implemented with clear comments and OOP principles, as shown in my diagram. My code is on GitHub at [insert your OODD-MainApp GitHub link]. Thank you!

---

**Total Time**: ~5 minutes (~750 words at 150 words/minute)