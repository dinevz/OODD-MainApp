# Presentation Script for Group Member C  
**Duration**: ~5 minutes  
**Project**: CampusAssist (OODD-MainApp-C)  

---

**Slide 1: Introduction and Class Diagram**  
*(~1 minute, 150 words)*  
Good morning, everyone. I’m Group Member C for the CampusAssist project, and today I’ll present my contributions: viewing FAQs for students, managing FAQs for admins, and providing appointment trends and feedback analytics. Let’s start with my UML Class Diagram. It includes `User`, `Appointment`, `FAQ`, `FAQService`, and `FeedbackService`. `User` handles user data, `Appointment` stores session details, and `FAQ` manages FAQ entries. `FAQService` and `FeedbackService` implement my tasks, depending on `User`, `Appointment`, and `FAQ`. The diagram shows proper encapsulation with private attributes and public methods. My code comments, like in `FAQService.java`, explain the logic for adding FAQs, ensuring clarity. This design separates concerns, with `FAQService` focusing on FAQ management and `FeedbackService` on data analysis, making it maintainable.

---

**Slide 2: Code Walkthrough – View and Manage FAQs**  
*(~1.5 minutes, 225 words)*  
Let’s look at FAQ features in `FAQService.java`. The `viewFAQs` method lets students see all FAQs. It’s straightforward, printing each FAQ’s question and answer, with comments explaining the iteration over the FAQ list. For example, a student sees FAQs like “What is mental health support?” with the answer “Counseling and therapy sessions.” For admins, `manageFAQs` provides options to add, update, or remove FAQs. The `addFAQ` method prompts for a question and answer, creates a new `FAQ` object, and adds it to the list. Comments note how the ID is auto-incremented for simplicity. For instance, adding a new FAQ outputs “FAQ added successfully.” Similarly, `updateFAQ` lets admins modify existing entries, with comments explaining the ID lookup process. This ensures admins can keep FAQs up-to-date, supporting user needs effectively.

---

**Slide 3: Code Walkthrough – Appointment Trends and Feedback Analytics**  
*(~1.5 minutes, 225 words)*  
Now, let’s explore analytics in `FeedbackService.java`. The `showAppointmentTrends` method counts appointments by support type using a `HashMap`, as noted in the comments. For example, it might show “Mental Health: 1 appointments, Academic Support: 1 appointments,” giving admins insights into demand. The `showFeedbackAnalysis` method calculates the average feedback score across appointments, with comments explaining the logic for handling null feedback. For instance, with scores of 4 and 3, it outputs “Average Feedback Score: 3.5,” helping admins assess session quality. These methods use `Appointment` data, ensuring consistency across features. The comments in `FeedbackService.java` clarify how data is aggregated, making the code easy to understand and maintain.

---

**Slide 4: Integration and Conclusion**  
*(~1 minute, 150 words)*  
For integration, my code fits into the combined project smoothly. `FAQService` and `FeedbackService` use Member B’s `UserService` for role-based login, as noted in `MainApp.java` comments, ensuring students and admins access the right menus. `FeedbackService` uses `Appointment` data from Members A and B, providing trends and feedback analysis for their sessions. I added comments in `DataManager.java` to explain how FAQs and appointments are initialized together. A challenge was ensuring role-based access for FAQ management, which I solved by checking roles in `MainAppC.java`. My code, with clear comments, supports OOP principles, as shown in my diagram. It’s on GitHub at [insert your OODD-MainApp GitHub link]. Thank you!

---

**Total Time**: ~5 minutes (~750 words at 150 words/minute)