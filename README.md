---

# CSCI 3200 – Project #2

## Convert Infix ↔ Postfix Expressions Using Stacks

## Course Information

* **Course:** Data Structures and Algorithm Analysis (CSCI 3200)
* **Semester:** Spring 2026
* **Due Date:** April 25, 2026 @ 11:59 PM
* **Project Type:** Group Project

---

## Project Overview

This project implements a Java program that performs:

* Conversion of **Infix → Postfix expressions**
* Conversion of **Postfix → Infix expressions (with parentheses)**

All conversions must be implemented using **stack-based algorithms** as specified in the assignment.

---

## Project Setup

* **Project Name:** `ConvertInfixAndPostfix`
* **Package Name:** `CSCI3200`

---

## Classes

### 1. Main Class

* Must have the **same name as the project**
* Contains the `main` method
* Responsibilities:

  * Display menu
  * Handle user input/output
  * Call conversion methods

---

### 2. ConvertInfixAndPostfix Class

#### Data Field

* A private `String` variable to store the expression
* Must use **encapsulation** (getter/setter)

---

#### Constructors

```java
public ConvertInfixAndPostfix() { }

public ConvertInfixAndPostfix(String string) {
    // initialize data field
}
```

---

#### Methods

**Convert Infix → Postfix**

```java
public String convertToPostfix()
```

* Uses a stack
* Returns a postfix expression

---

**Convert Postfix → Infix**

```java
public String convertToInfix()
```

* Uses a stack
* Returns a fully parenthesized infix expression

---

**toString Method**

```java
public String toString()
```

* Returns the stored expression

---

**Getter and Setter**

* Standard accessor and mutator methods for the expression field

---

**Helper Methods (Recommended)**

* Operator precedence checker
* Operator validation
* Parentheses handling

---

## Supported Operators

* `+` (Addition)
* `-` (Subtraction)
* `*` (Multiplication)
* `/` (Division)
* `%` (Modulo)

---

## Assumptions

* Expressions are **syntactically correct**
* No unary operators
* No exponentiation
* Operands are single digits or characters
* Tokens are separated by spaces (e.g., `1 + 2 * 3`)
* Only parentheses used: `(` and `)`

---

## Conversion Logic

### Infix → Postfix

* Read tokens left to right
* If operand → add to output
* If operator → compare precedence and use stack
* If `(` → push to stack
* If `)` → pop until `(` is found
* At end → pop remaining operators

---

### Postfix → Infix

* If operand → push onto stack
* If operator:

  * Pop two operands
  * Combine: `(operand1 operator operand2)`
  * Push result back
* Final stack value = complete infix expression

---

## Program Behavior

### Menu

```
//////////////////////////////////////
/ 0: Exit                         /
/ 1: Infix to Postfix            /
/ 2: Postfix to Infix            /
//////////////////////////////////////
```

---

## Example Output

### Infix → Postfix

```
Enter an infix expression: 1 + 1 - 3
The postfix expression of 1 + 1 - 3 = 1 1 + 3 -
```

---

### Postfix → Infix

```
Enter a postfix expression: 1 3 - 2 *
The postfix expression of 1 3 - 2 * = ((1 - 3) * 2)
```

---

## User Flow

1. Display menu
2. User selects option
3. Prompt for expression
4. Perform conversion
5. Display result
6. Repeat until user enters `0`

---

## Required Submission

* `ConvertInfixAndPostfix.java`
* `InfixAndPostfix.java`
* Screenshot showing program execution

**Important:**

* Do NOT submit a zip file
* Submit files individually

---

## Required Code Header

Add the following at the top of one Java file:

```java
//--------------------------------------------------------------
// Group Members:
// Date:
// Course: Data Structures and Algorithm Analysis (CSCI 3200)
// Project Description:
//--------------------------------------------------------------
```

---

## Collaboration Notes

* Both members must contribute
* Weekly group evaluations are required
* Use GitHub for version control and collaboration

---

## Suggested Git Workflow

* Create feature branches:

  * `infix-to-postfix`
  * `postfix-to-infix`
* Commit frequently with clear messages
* Merge only after testing

---

## Summary

This project demonstrates:

* Stack data structure usage
* Expression parsing
* Algorithm implementation from pseudocode
* Java class design and encapsulation

---

