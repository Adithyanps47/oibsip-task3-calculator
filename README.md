<div align="center">
  <img src="app/src/main/res/mipmap-xxxhdpi/ic_launcher.png" width="120" height="120" alt="Calculator Logo"/>

  <h1>Scientific Calculator App</h1>
  <p>
    <b>OIBSIP Task 2</b> - Android Development Internship
  </p>

  <a href="https://github.com/Adithyanps47">
    <img src="https://img.shields.io/badge/Language-Java-orange" alt="Language" />
  </a>
  <a href="https://developer.android.com/">
    <img src="https://img.shields.io/badge/Platform-Android-green" alt="Platform" />
  </a>
  <a href="https://developer.android.com/studio">
    <img src="https://img.shields.io/badge/IDE-Android%20Studio-blue" alt="IDE" />
  </a>
  <a href="#">
    <img src="https://img.shields.io/badge/Status-Completed-success" alt="Status" />
  </a>
</div>

<br />

## 📖 About
This Android application was developed as part of the **Oasis Infobyte Android Development Internship** (OIBSIP). 

Unlike standard calculators that perform sequential operations, this app functions as an **Expression Parsing Engine**. It utilizes **Stack Data Structures** to parse, construct, and evaluate complex mathematical expressions with strict adherence to **Order of Operations (BODMAS/PEMDAS)**. The interface is designed with a modern **Glassmorphism** aesthetic that adapts to system themes.

## 🚀 Key Features & Engineering
The core logic relies on advanced algorithm concepts to ensure precision:

* **🧠 Lexical Analysis (Tokenization):** Break down input streams into distinct operators and operands.
* **📚 Shunting-yard Algorithm:** Converts Infix Notation (human-readable) to Reverse Polish Notation (Postfix) for machine processing.
* **🌳 Abstract Syntax Tree (AST):** Treats expressions as binary trees, performing Post-Order Traversal to resolve nested brackets and complex roots.
* **✨ Glassmorphism UI:** A responsive "Frosted Glass" interface featuring custom XML gradients and layer-lists that switch between "Ice" (Light Mode) and "Deep Space" (Dark Mode).

## 📸 Screenshots
| Light Mode ("Ice Glass") | Dark Mode ("Deep Space") |
|:---:|:---:|
| <img src="[ui_glassmorphism_light.png](https://github.com/Adithyanps47/oibsip-task3-calculator/blob/main/docs/screenshots/ui_glassmorphism_light.jpg)" width="280" alt="Light Mode UI"> | <img src="[ui_glassmorphism_dark.png](https://github.com/Adithyanps47/oibsip-task3-calculator/blob/main/docs/screenshots/ui_glassmorphism_dark.jpg)" width="280" alt="Dark Mode UI"> |

## 🎥 Demos & Test Cases
Watch the engine handle complex mathematical challenges:

| Test Case | Description | Demo |
| :--- | :--- | :---: |
| **1. The Stress Test** | `100 + 4! * 2 - 5^2`<br>Demonstrates strict **Operator Precedence**. The engine prioritizes the Factorial (`!`) and Exponent (`^`) before Multiplication and Subtraction. | [**▶️ Watch Video**]([demo_operator_precedence.mp4](https://github.com/Adithyanps47/oibsip-task3-calculator/blob/main/docs/demo_video/demo_operator_precedence.mp4)) |
| **2. Scientific Mapping** | `sin(90) + log(100) * (3 + 1)`<br>Shows function mapping where `log` converts to Base 10 and `sin` accepts Degrees. Resolves nested brackets first. | [**▶️ Watch Video**]([demo_function_mapping.mp4](https://github.com/Adithyanps47/oibsip-task3-calculator/blob/main/docs/demo_video/demo_function_mapping.mp4)) |
| **3. Tree Structure** | `(5 + 3) * (10 - 2)`<br>Visualizes **Tree Logic**. The parser resolves child nodes `(5+3)` and `(10-2)` before executing the root multiplication node. | [**▶️ Watch Video**]([demo_ast_tree_logic.mp4](https://github.com/Adithyanps47/oibsip-task3-calculator/blob/main/docs/demo_video/demo_ast_tree_logic.mp4)) |

> **Note:** You can also view the full demonstration on my [LinkedIn Profile](https://www.linkedin.com/in/adithyan-p-s-mobile/).

## 🛠 Tech Stack
* **Language:** Java
* **Algorithm:** Shunting-yard & Postfix Evaluation
* **UI:** XML (ConstraintLayout, Custom Gradient Drawables, State Selectors)
* **IDE:** Android Studio
* **Library:** exp4j (Expression Builder)

## 📥 How to Run
If you want to build the project from source:

1.  **Clone the repository**
    ```bash
    git clone [https://github.com/Adithyanps47/scientific-calculator.git](https://github.com/Adithyanps47/scientific-calculator.git)
    ```
2.  **Open in Android Studio**
    * Open Android Studio -> File -> Open -> Select the cloned folder.
3.  **Sync Gradle**
    * Wait for the build dependencies to fetch.
4.  **Run**
    * Press the ▶️ Run button to launch on an Emulator or Physical Device.

## 📱 Download APK
Don't want to build it? Download the latest version directly:
[**⬇️ Download v1.0 APK**](https://github.com/Adithyanps47/scientific-calculator/releases)

---

## 👤 Internship Details
* **Company:** Oasis Infobyte
* **Program:** Android Development Internship
* **Task:** Task 2 (Scientific Calculator)
* **Intern:** Adithyan P S
* **LinkedIn:** [**Adithyan P S**](https://www.linkedin.com/in/adithyan-p-s-mobile/)

---
<div align="center">
  <i>Made by Adithyan P S</i>
</div>
