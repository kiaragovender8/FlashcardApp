GitHub Repository:
https://github.com/kiaragovender8/FlashcardApp

YouTube:



Flashcard App
1. Purpose of the App
The Flashcard App is a simple Android application designed to help users test their knowledge using a series of true/false questions. The app presents questions one at a time, allows users to submit their answers, provides immediate feedback, and displays a final score with a review of the user's answers.
The app's main purpose is to:
•	Present users with true/false questions on a specific topic (currently South African facts).
•	Test user knowledge and provide a learning experience.
•	Track user progress and display a final score.
•	Allow users to review their answers and learn from their mistakes.

2. Core Features
•	Question Presentation: The app displays one true/false question at a time.
•	User Input: Users can answer each question by selecting either "True" or "False".
•	Immediate Feedback: The app provides immediate feedback ("Correct!" or "Incorrect.") after the user answers each question.
•	Score Tracking: The app tracks the user's score during the quiz.
•	End-of-Quiz Summary: At the end of the quiz, the app displays the user's score and provides an option to review their answers.
•	Answer Review: Users can review each question, their answer, and the correct answer.
•	Restart Quiz: Users can restart the quiz to try again.

3. Design Considerations
   
3.1 User Interface (UI) Design
The app's UI is designed to be simple and intuitive, focusing on ease of use. Key UI elements include:
•	TextView (Question): Displays the current true/false question.
•	Buttons (True/False): Allows users to submit their answers.
•	TextView (Feedback): Provides immediate feedback after each answer.
•	TextView (Score): Displays the user's score at the end of the quiz.
•	Button (Next): Proceeds to the next question.
•	Button (Review): Allows the user to review their answers.
•	Button (Restart): Restarts the quiz.
•	Button (Exit): Exits the application.
•	Edge-to-Edge UI: The app utilizes edge-to-edge design, making use of the full screen and providing a modern look.

3.2 Functionality Design
The app's functionality is structured around a question-and-answer flow:
•	Question Storage: Questions and their corresponding answers are stored within the QuestionActivity.
•	Question Flow: The QuestionActivity manages the presentation of questions, user input, and feedback.
•	Answer Checking: The app checks the user's answer against the correct answer and provides feedback.
•	Score Calculation: The app calculates the user's score based on the number of correct answers.
•	Navigation: Intents are used to navigate between activities:
o	MainActivity to QuestionActivity to start the quiz.
o	QuestionActivity to ScoreActivity to display the results.
•	Data Passing: Question data, user answers, and the final score are passed between activities using Intents.

4. GitHub Utilization
The Flashcard App project uses GitHub for:
•	Version Control: Git is used for version control, and GitHub serves as the remote repository. This enables:
o	Tracking changes to the codebase.
o	Branching for feature development and bug fixes.
o	Collaborative development through pull requests.
o	Maintaining a history of changes and enabling rollbacks.
•	Collaboration: GitHub facilitates collaboration by providing:
o	A centralized platform for code sharing.
o	Pull requests for code review and merging.
o	Issue tracking for managing tasks and bugs.
o	Code review processes to ensure code quality.
•	Code Hosting: GitHub hosts the project's source code, providing a central location for access and sharing.

5. GitHub Actions
GitHub Actions can be used to automate aspects of the development process, including:
•	Continuous Integration (CI): GitHub Actions can automate the building and testing of the Android application. This can include:
o	Compiling the Kotlin code.
o	Running unit tests.
o	Running UI tests (if implemented).
o	Performing static analysis (linting).
o	Generating APKs.
o	Providing build and test results to developers.
•	Continuous Delivery (CD): GitHub Actions can also be used to automate the release process, such as:
o	Creating release builds.
o	Uploading builds to a testing or production track on the Google Play Store.
By automating these processes, GitHub Actions helps to:
•	Ensure code quality through automated testing.
•	Reduce the number of bugs.
•	Accelerate the development cycle.
•	Increase developer productivity.
•	Enable more frequent and reliable releases.

Conclusion
The Flashcard App is a simple Android application that provides users with a way to test their knowledge with true/false questions. It incorporates a straightforward design and uses intents to manage the flow between activities.
GitHub is used for version control, collaboration, and code hosting. GitHub Actions can be implemented to automate the CI/CD pipeline, improving the efficiency and reliability of the development process.












