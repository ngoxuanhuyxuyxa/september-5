package Demo.controller;

import Demo.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserManagement {
    List<User> userList = new ArrayList<>();

    public UserManagement() {
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void showAll(){
        for (User user:userList) {
            System.out.println(user);
        }
    }
    public void addNew(User user){
        userList.add(user);
    }

    public void updateById(int index,User user){
        userList.set(index,user);
    }
    public void deleteById(int index){
        userList.remove(index);
    }

    public int searchId(String id){
        int index = -1;
        for (int i = 0; i < userList.size(); i++) {
            if (id.equals(userList.get(i).getId())){
             index = i;
             break;
            }
        }
        return index;
    }
}
