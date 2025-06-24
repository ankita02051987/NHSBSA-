# NHSBSA-
NHSBSA job Search Automation
## 📁 Project Structure

NHSBSA_JobSearch_Automation/
│
├── src/
│ ├── main/
│ │ └── java/
│ │ └── org.example/ # Common utilities and page objects
│ │ ├── pages/
│ │ └── utils/
│ │
│ └── test/
│ ├── java/
│ │ ├── hooks/ # Hooks for browser setup/teardown
│ │ ├── runner/ # TestRunner class
│ │ └── stepDefinitions/ # Step definitions for Cucumber
│ └── resources/
│ └── features/ # Cucumber feature files
│
├── pom.xml
├── README.md
└── target/


---

## ⚙️ Technologies Used

- **Java**
- **Maven**
- **Cucumber BDD**
- **JUnit**
- **Selenium WebDriver**
- **WebDriverManager**
- **Cucumber HTML Report**

---

## 🚀 How to Run the Tests

### 1. Prerequisites

- Java 8+ installed
- Maven installed and configured in system path
- Chrome and Firefox browsers installed

### 2. Run Tests from Command Line

To run tests on **Chrome** (default browser):

```bash
mvn clean test -Dbrowser=chrome

To run tests on Firefox:

mvn clean test -Dbrowser=firefox

3. View Test Report

After execution, open the generated HTML report at:

target/cucumber-reports.html

🧪 Sample Feature File

Located in:

src/test/resources/features/job_search.feature

🧹 Clean and Rebuild Project

mvn clean install

👩‍💻 Author

Ankita @ankita02051987
📄 License

This project is licensed under the MIT License.


---

### ✅ How to Use

Yes, you can **just copy and paste** this into your `README.md` file in the root of the project (you already have one). After that, commit and push it:

```bash
git add README.md
git commit -m "Add project README"
git push