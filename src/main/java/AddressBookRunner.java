import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AddressBookRunner {
  public static final String ADD_CONTACT = "Add a contact";
  public static final String LOOKUP_CONTACT = "Look up a contact";
  public static final String GENERATE_LIST = "Generate a distribution list for the contacts";
  public static final String CLEAR_BOOK = "Delete all contacts";
  public static final String SAVE_BOOK = "Save address book to a file";
  public static final String LOAD_BOOK = "Load address book from a file";
  public static final String QUIT_TEXT = "Quit";

  public static final String FILE_PATH = "";

  public static void main(String[] args) throws IOException {

    Map<String, String> newContacts = new HashMap<>();
    List<String> options = new ArrayList<String>();
    options.add(ADD_CONTACT);
    options.add(LOOKUP_CONTACT);
    options.add(GENERATE_LIST);
    options.add(CLEAR_BOOK);
    options.add(SAVE_BOOK);
    options.add(LOAD_BOOK);
    options.add(QUIT_TEXT);


    Scanner inputScanner = new Scanner(System.in);
    Scanner textInput= new Scanner(System.in);
    String menuChoice = "";

    while(menuChoice != QUIT_TEXT) {
      int menuIndex = 1;
      for(String option : options) {
        System.out.println(menuIndex + ". " + option);
        menuIndex++;
      }

      System.out.println("Total contacts: " + newContacts.keySet().size());
      System.out.println("\nWhat would you like to do? Select a number.");
      try {
        int selectedOption = inputScanner.nextInt();
        menuChoice = options.get(selectedOption - 1);



        if (menuChoice == ADD_CONTACT) {
          String name = provideInput("What is the name of the contact you wish to add?", "Name", textInput);
          String email = provideInput("What is the email of the contact you wish to add?", "Email", textInput);

          if (newContacts.keySet().contains(name)) {
            System.out.println("This contact already exists. Do you wish to overwrite it? (Y / N)");
            String confirmation = textInput.nextLine();
            if (confirmation.equals("Y")) {
              newContacts.put(name, email);
              System.out.println("Contact info has been updated");
            }
             } else {
            newContacts.put(name, email);
             }
            } else if (menuChoice == LOOKUP_CONTACT) {
           String name = provideInput("What is the name of the contact you wish to look up?", "Name", textInput);
           String email = newContacts.get(name);
           if (email != null) {
            System.out.println(email + "\n");
           } else {
            System.out.println("The contact was not found\n");
           }
          } else if (menuChoice == GENERATE_LIST) {
          String list = "";
          Set<String> names = newContacts.keySet();
          for (String name: names) {
            list += "\"" + name + "\"" + " " + "<" + newContacts.get(name) + ">, ";
            	          }
             list = list.trim().substring(0, list.length() - 2);
          System.out.println(list);
          } else if (menuChoice == CLEAR_BOOK) {
            newContacts.clear();
          } else if (menuChoice == SAVE_BOOK) {
          String fileName = "";
          do {
            System.out.println("What is the name of the file?");
            fileName = textInput.nextLine();
            if (fileName.length() <= 2) {
              System.out.println("The name of the file needs to be longer than 2 characters\n");
            }
          } while (fileName.length() <= 2);

          File file = new File(fileName + ".csv");
          if (!file.exists()) {
            file.createNewFile();
          }
          FileWriter fileWriter = new FileWriter(file);

          for (String name: newContacts.keySet()) {
            fileWriter.write(name + " " + newContacts.get(name) + ", ");
          }
          fileWriter.close();
          } else if (menuChoice == LOAD_BOOK) {
          System.out.println("What is the name of the file?");
          String fileName = textInput.nextLine();
          if (!fileName.equals("cancel")) {
            File file = new File(fileName);
            if (file.exists()) {
              Scanner fileScanner = new Scanner(file).useDelimiter(",");
              newContacts.clear();
              while (fileScanner.hasNext()) {
                String nameEmailPair = fileScanner.next();
                String[] nameEmailArr = nameEmailPair.split(" ");
                newContacts.put(nameEmailArr[0], nameEmailArr[1]);
              }
              } else {
              System.out.println("Sorry, file does not exist");
            }
          }
        }
      } catch(IndexOutOfBoundsException | IOException err) {
        System.out.println("Please make a valid selection!");
      }
    }
  }

  public static String provideInput(String prompt, String fieldName, Scanner textInput) {
    System.out.println(prompt);
    String field = "";
    do {
      field = textInput.nextLine();
      if (field.isEmpty()) {
        System.out.println(fieldName + " cannot be empty");
      }
    } while(field.isEmpty());
    return field;
    }
  }







//        if (menuChoice == ADD_CONTACT) {
//          System.out.println("Please provide a name of a new contact");
//          String userInput = inputScanner.next();
//
//          while (userInput.isBlank()) {
//            System.out.println("The name field cannot be blank, please provide a name.");
//            userInput = inputScanner.next();
//          }
//          String newName = userInput;
//
//          System.out.println("Please, provide an email for the contact");
//
//          userInput = inputScanner.next();
//          while (userInput.isBlank()) {
//            System.out.println("The email field cannot be blank, please provide a valid email.");
//            userInput = inputScanner.nextLine();
//          }
//          String email = userInput;
//
//          newContacts.put(newName, email);
//          System.out.println("Thank you! Your contact has been added to an Address Book");
//
//          for(String name : newContacts.keySet()) {
//            System.out.println(name + " " + newContacts.get(name));
//            System.out.println(newContacts);
//          }
//
//        } else if (menuChoice == LOOKUP_CONTACT) {
//          System.out.println("Please provide a name of a contact you're looking for:");
//          String userInput = inputScanner.next();
//          while (userInput.isBlank()) {
//            System.out.println("Please let us know whom are you looking for, provide a name");
//            userInput = inputScanner.next();
//
//            if (newContacts.keySet().contains(userInput)) {
//              System.out.println();
//            }
//          }
//        }
//      } catch(IndexOutOfBoundsException err) {
//        System.out.println("Please make a valid selection!");
//      }
//    }
//  }
