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
        StringBuilder output = new StringBuilder();

        BufferedReader br = new BufferedReader(new FileReader(input));
        String line;

        Users users = new Users();

        while ((line = br.readLine()) != null) {
            String[] commands = line.split(" ", 2);

            String command = commands[0];
            String name = commands[1].trim();

            switch (command) {
                case "ADD":
                    String o_add = users.add(new User(name));
                    if (o_add.equals("User already exists"))
                        output.append("[ERROR] ADD " + name).append("\n");
                    else
                        output.append("[ OK  ] ADD " + name).append("\n");
                    break;
                case "REMOVE":
                    String o_remove = users.remove(name);
                    if (o_remove.equals("User not found."))
                        output.append("[ERROR] " + "REMOVE " + name).append("\n");
                    else
                        output.append("[ OK  ] " + "REMOVE " + name).append("\n");
                    break;
                case "SHOW":
                    String o_show = users.find(name);
                    if (o_show.equals("User not found."))
                        output.append("[ERROR] " + "?<-" + name + "->?")
                                .append("\n");
                    else
                        output.append("[ OK  ] " + o_show + "\n");
                    break;
                default:
                    throw new Error("Invalid command.");
            }

        }

        br.close();

        try {
            FileWriter fw = new FileWriter(output_file);
            fw.write(output.toString());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}