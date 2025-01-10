# Screenshot Manager

A utility library to enhance Selenium WebDriver by capturing and managing screenshots during test execution. The **Screenshot Manager** simplifies screenshot handling by providing features such as auto-saving screenshots with meaningful filenames, annotating them with test details, and organizing them in a structured directory.

---

## Features

- **Take Screenshots:**
  Capture the current browser state during test execution.
- **Auto-Save with Meaningful Filenames:**
  Save screenshots with a timestamp, test name, and other relevant details.
- **Annotate Screenshots (Optional):**
  Add annotations (e.g., "Test Passed" or "Test Failed") directly to the screenshot.
- **Organized Directory Structure:**
  Screenshots are stored in a dedicated directory for better organization and easy debugging.

---

## Installation

To use the Screenshot Manager, include the following dependencies in your project:

### Maven
```xml
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.10.0</version>
    </dependency>
    <dependency>
        <groupId>commons-io</groupId>
        <artifactId>commons-io</artifactId>
        <version>2.11.0</version>
    </dependency>
</dependencies>
