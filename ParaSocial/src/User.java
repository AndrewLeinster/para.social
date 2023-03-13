import java.util.Set;

import java.util.HashSet;
import java.awt.*;

public class User {

    private String name;
    private String ID;
    private String workPlace;
    private String homeTown;
    private Image pfp;
    private Set<User> friends;
    private Tree posts;



    public User(String name, String ID, String workPlace, String homeTown, Image pfp, HashSet<User> friends, Tree posts)
    {
        this.name = name;
        this.ID = ID;
        this.workPlace = workPlace;
        this.homeTown = homeTown;
        this.pfp = pfp;
        this.friends = friends;
        this.posts = null;
    }

    public User()
    {
        name = null;
        ID = null;
        workPlace = null;
        homeTown = null;
        pfp = null;
        friends = null;
        posts = null;
    }

    public void displayFriends()
    {
        User[] friendList = friends.toArray(new User[friends.size()]);

        for (int i = 0; i < friendList.length; i++)
        {
           friendList[i].displayUserInfo();
        }
    }

    public String getFriendInfo()
    {
        User[] friendList = friends.toArray(new User[friends.size()]);
        String friendInfo = "";
        for (int i = 0; i < friendList.length; i++)
        {
           
           friendInfo += "\n" + friendList[i].getUserInfo();
        }
        return friendInfo;
    }

    public void displayUserInfo()
    {
        Menu.displayUserPage(name, ID, workPlace, homeTown, pfp, friends, posts);
    }

    /**
     * Returns the user details as a string
     * @return The user information as a string
     */
    public String getUserInfo()
    {
        String userInfo = "ID:" + ID + "\nName: " + name + "\nWorkplace: " + workPlace + "\nHome Town: " + homeTown;
        return userInfo;
    }

    public void displayPosts()
    {

    }

    public Set<User> getMutuals(User a, User b)
    {
        Set<User> mutuals = a.getFriends();
        mutuals.retainAll(b.getFriends());

        return mutuals;
    }

    public boolean searchApplicable(String search)
    {
        
        if (compareStrings(ID, search) || compareStrings(name, search) || compareStrings(workPlace, search) || compareStrings(homeTown, search))
        {
            return true;
        }
    
        return false;

    }

    public boolean compareStrings(String a, String b)
    {
        for (int i = 0; i < a.length() - b.length(); i++)
        {
            if (a.substring(i, i + b.length()).equals(b))
            {
                return true;
            }
        }

        return false;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getID()
    {
        return ID;
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public String getWorkPlace()
    {
        return workPlace;
    }

    public void setWorkPlace(String workPlace)
    {
        this.workPlace = workPlace;
    }
    
    public String getHomeTown()
    {
        return homeTown;
    }

    public void setHomeTown(String homeTown)
    {
        this.homeTown = homeTown;
    }

    public Image getPfp()
    {
        return pfp;
    }

    public void setPfp(Image pfp)
    {
        this.pfp = pfp;
    }

    public Set<User> getFriends()
    {
        return friends;
    }

    public void setFriends(Set<User> friends)
    {
        this.friends = friends;
    }

    public void addFriend(User friend)
    {
        friends.add(friend);
    }

    public void removeFriend(User friend)
    {
        friends.remove(friend);
    }

}