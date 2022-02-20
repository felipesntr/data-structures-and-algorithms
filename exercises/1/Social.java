import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class User {
    private String name;
    private User next = null;
    private User prev = null;

    private User first = null;
    private User last = null;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getNext() {
        return next;
    }

    public void setNext(User next) {
        this.next = next;
    }

    public User getPrev() {
        return prev;
    }

    public void setPrev(User prev) {
        this.prev = prev;
    }

    public User getFirst() {
        return first;
    }

    public void setFirst(User first) {
        this.first = first;
    }

    public User getLast() {
        return last;
    }

    public void setLast(User last) {
        this.last = last;
    }
}

class Users {
    User first;
    User last;
    int size = 0;

    public String add(User user) {
        if (first == null) {
            user.setNext(user);
            user.setPrev(user);
            user.setLast(user);
            user.setFirst(user);
            first = user;
            last = user;
            size++;
            return "User added";

        } else {
            if (contain(user.getName()))
                return "User already exists";
            else {
                last.setNext(user);
                last.setLast(user);
                user.setPrev(last);
                user.setNext(first);
                user.setLast(user);
                user.setFirst(first);
                first.setPrev(user);
                first.setLast(user);
                last = user;
                size++;
                return "User added";
            }
        }

    }

    public String remove(String name) {
        User current = first;

        if (first == null)
            return "User not found.";

        if (first.getName().equals(name)) {
            first = first.getNext();
            first.setPrev(last);
            first.setFirst(first);
            first.setLast(last);
            last.setFirst(first);
            last.setNext(first);
            size--;
            return "User removed";
        }

        for (int i = 0; i < this.size; i++) {
            if (current.getName().equals(name)) {
                current.getPrev().setNext(current.getNext());
                current.getNext().setPrev(current.getPrev());
                size--;
                return "User removed";
            }
            current = current.getNext();
        }
        return "User not found.";
    }

    public String find(String name) {
        if (first != null) {
            User current = first;

            if (first.getName().equals(name))
                return current.getPrev().getName() + "<-" + current.getName() + "->" + current.getNext().getName();

            for (int i = 0; i < this.size; i++) {
                if (current.getName().equals(name))
                    return current.getPrev().getName() + "<-" + current.getName() + "->" + current.getNext().getName();
                current = current.getNext();
            }

            return "User not found.";
        }
        return "User not found.";

    }

    public Boolean contain(String name) {
        User current = first;

        if (first == null)
            return false;

        if (first.getName().equals(name))
            return true;

        for (int i = 0; i < this.size; i++) {
            if (current.getName().equals(name))
                return true;
            current = current.getNext();
        }

        return false;
    }
}

public class Social {
    public static void main(String[] args) throws IOException {
        File input = new File(args[0]);
        File output_file = new File(args[1]);
        StringBuilder commands = new StringBuilder();
        StringBuilder output = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            String st;
            while ((st = br.readLine()) != null)
                commands = commands.append(st).append("\n");
        }

        Users users = new Users();

        for (String command : commands.toString().split("\n")) {
            String[] commandSplit = command.split(" ", 2);
            String commandName = commandSplit[0];

            switch (commandName) {
                case "ADD":
                    String o_add = users.add(new User(commandSplit[1].trim()));
                    if (o_add.equals("User already exists"))
                        output.append("[ERROR] ADD " + commandSplit[1].trim()).append("\n");
                    else
                        output.append("[ OK  ] ADD " + commandSplit[1].trim()).append("\n");
                    break;
                case "REMOVE":
                    String o_remove = users.remove(commandSplit[1].trim());
                    if (o_remove.equals("User not found."))
                        output.append("[ERROR] " + "REMOVE " + commandSplit[1].trim()).append("\n");
                    else
                        output.append("[ OK  ] " + "REMOVE " + commandSplit[1].trim()).append("\n");
                    break;
                case "SHOW":
                    String o_show = users.find(commandSplit[1].trim());
                    if (o_show.equals("User not found."))
                        output.append("[ERROR] " + "?<-" + commandSplit[1].trim() + "->?")
                                .append("\n");
                    else
                        output.append("[ OK  ] " + o_show + "\n");
                    break;
                default:
                    throw new Error("Invalid command.");
            }
        }

        try {
            FileWriter fw = new FileWriter(output_file);
            fw.write(output.toString());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(output);
    }
}