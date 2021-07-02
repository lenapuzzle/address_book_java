Remember that celebrenerd address book that we built with Node? We're going to build a more robust version in Java!

## Getting Started

```no-highlight
et get java-address-book
cd java-address-book
idea .
```

We're going to build an application that has an interactive, command-line driven menu. The first user story will set this up, and then we'll add to the menu as we add new features.

## Core User Stories

A main menu has been provided to you, with options for the user to "Add a contact", "Look up a contact", and "Quit". Fill in the functionality described in the user stories below.

### Add a Contact

```no-highlight
As a resourceful coder
I want to add a contact
So that I can build a list of contacts
```

Acceptance Criteria:

- There's an option on the main menu for me to add a contact
- When I select that option, I'm prompted for the contact's name
- If I don't supply a name, I'm continuously prompted until I provide one
- Once I supply a name, I'm prompted for an email address
- If I don't supply an email address, I'm continuously prompted until I provide one
- Once I've supplied both a name and email, the contact is added to the address book (it should be stored in memory in an `HashMap`)

### Look Up a Contact

```no-highlight
As a coder that needs help
I want to locate celebrenerd's email address
So that I can contact them
```

Acceptance Criteria:

- There's an option on the main menu for me to look up a contact
- When I select that option, I'm prompted for the contact's name
- If I don't supply a name, I'm continuously prompted until I provide one
- If the name is in the address book, the corresponding email address is outputted, and I'm then returned to the main menu
- If the name is not in the address book, I receive a message that tells me the contact was not found and I'm then returned to the main menu

### Distribution List for My Contacts

```no-highlight
As a hopeless late night coder
I want to blast my email list
So that I can hopefully reach someone
```

Acceptance Criteria:

- There's an option to generate a distribution list for my contacts
- All of my contacts are included in this distribution list
- The distribution list follows a certain format as supplied below:

```no-highlight
"Jane Doe" <jane@example.com>, "Sam Smith" <sam@example.com>, "Sally Swanson" <sally@example.com>
```

## Non-Core User Stories

### Validate Duplicated Name

```no-highlight
As a mistaken contact manager
I want to protect against overwriting a record
So that I don't lose an important email address
```

Acceptance Criteria:

- If I mistakenly try to add a new contact to the list, when I've already added that contact, I'm prompted to confirm that I want to overwrite that contact
- If I confirm, then the new email address I provided should be reflected in the address book

### Clear Address Book

```no-highlight
As a wayward networker
I want to clear my list
So that I can start again
```

Acceptance Criteria:

- There's a new menu option to clear my address book
- When I select that option, I'm prompted to confirm I want to clear the list
- Once I've acknowledged that I want to clear the list, the list is cleared and I'm returned to the main menu
- If I don't confirm, nothing happens and I'm returned to the main menu

### Show the Count of Contacts on the Main Menu

```no-highlight
As a numbers-focused networker
I want to know how many contacts are on my list
So that I know how important I am
```

Acceptance Criteria:

- The total number of contacts in the address book is outputted as part of the main menu

### Save a CSV

```no-highlight
As a savvy manager of contacts
I want to save my address book
So that I can reload it when I start the program again
```

Acceptance Criteria:

- From the main menu, there's a new option to save my address book
- When I select that option, I'm prompted for a name
- `<name>.csv` is saved with all of the contacts I've added to my list
- I must specify a name of more than 2 characters
- Each name and email address is saved to the CSV, with a comma delimiting the name and email address

### Load an Address Book

```no-highlight
As a savvy manager of contacts
I want to load a previously saved address book
So that I can continue to work on my list
```

Acceptance Criteria:

- From the main menu, there's a new option to load an address book
- When I select this option, I'm prompted for a name
- If `<name>.csv` exists, replace the address book with the file's contents
- If the file does not exist, output an error and return the user to the main menu
- I can type `cancel` and I'm returned to the main menu
- If I don't load a new address book, my existing address book should be unaffected
