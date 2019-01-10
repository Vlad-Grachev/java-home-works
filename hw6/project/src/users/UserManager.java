package users;

import java.io.*;

public class UserManager {
    private String usersFileName = "users.txt";

    public UserManager(String servletPath) {
        this.usersFileName = servletPath;
    }

    public boolean isLoginCorrect(String newLogin) {
        boolean exist = false;
        try (BufferedReader br = new BufferedReader(new FileReader(usersFileName))) {
            String temp = br.readLine();
            while (!exist && temp != null) {
                if (temp.contains(newLogin))
                    exist = true;
                temp = br.readLine();
            }
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return exist;
        }
        return exist;
    }

    public boolean isPasswordCorrect(String login, String password) {
        boolean correct = false;
        try (BufferedReader br = new BufferedReader(new FileReader(usersFileName))) {
            String temp = br.readLine();
            while (!correct && temp != null) {
                if (temp.equals(login + " " + password))
                        correct = true;
                System.out.println(temp);
                temp = br.readLine();
            }
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return correct;
        }
        return correct;
    }

    public boolean addUser(String login, String password){
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(usersFileName))) {
            wr.newLine();
            wr.write(login + " " + password);
            wr.flush();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
