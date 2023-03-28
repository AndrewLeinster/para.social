import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;

public class Tester {
    private Main main;

    public Tester()
    {
       main = new Main();
    }

    public static void main(String[] args)
    {
        Tester t = new Tester();
        t.addUsers();
        t.write();

    }

    public void write()
    {
        main.writeToFile();
    }

    public void addUsers()
    {
        User user1 = new User("Laura", "1", "Starbucks", "Glenrothes", "Images/PFPs/Laura.JPG", new ArrayList<String>());
        User user2 = new User("Adam", "2", "O2", "Dunfermline", "Images/PFPs/Adam.JPG", new ArrayList<String>());
        User user3 = new User("Iona", "3", "Tesco", "Monifieth", "Images/PFPs/Iona.jpg", new ArrayList<String>());
        User user4 = new User("Andrew", "4", "Self-Employed", "Fife", "Images/PFPs/Andrew.jpg", new ArrayList<String>());
        User user5 = new User("Marcus", "5", "Old Course", "Monikie", "Images/PFPs/Marcus.jpg", new ArrayList<String>());
        User user6 = new User("Adri", "6", "Odeon", "Las Vegas", "Images/PFPs/Adri.jpg", new ArrayList<String>());
        User user7 = new User("Beth", "7", "DUSA", "Falkirk", "Images/PFPs/Beth.jpg", new ArrayList<String>());
        User user8 = new User("Brandon", "8", "Worrel's Garage", "Glasgow", "Images/PFPs/Brandon.jpg", new ArrayList<String>());
        User user9 = new User("Danny", "9", "Big Band Jazz Consortiumm", "Gotham City", "Images/PFPs/Danny.jpg", new ArrayList<String>());
        User user10 = new User("Dennis", "10", "Monster Bike", "Stoketown", "Images/PFPs/Dennis.jpg", new ArrayList<String>());
        User user11 = new User("Dominique", "11", "Luigis Pizzeria", "Dundee", "Images/PFPs/Dominique.jpg", new ArrayList<String>());
        User user12 = new User("Evan", "12", "Sarcasm.Inc", "Bangor", "Images/PFPs/Evan.jpg", new ArrayList<String>());
        User user13 = new User("French", "13", "Bangin' Baguette Bakery", "Dubai", "Images/PFPs/Ffrench.jpg", new ArrayList<String>());
        User user14 = new User("Fin", "14", "Comrie Croft Bikes", "Comrie", "Images/PFPs/Fin.jpg", new ArrayList<String>());
        User user15 = new User("Gary", "15", "Nevis Cycles", "Fort William", "Images/PFPs/Gary.jpg", new ArrayList<String>());
        User user16 = new User("Grant", "16", "SDA", "Dundee", "Images/PFPs/Grant.jpg", new ArrayList<String>());
        User user17 = new User("James", "17", "RadVenture Tours", "Strathmiglo", "Images/PFPs/James.jpg", new ArrayList<String>());
        User user18 = new User("Joe", "18", "Mazda Motors", "NewPort", "Images/PFPs/Joe.jpg", new ArrayList<String>());
        User user19 = new User("John", "19", "Big Band Jazz Consortiumm", "NightCity", "Images/PFPs/John.jpg", new ArrayList<String>());
        User user20 = new User("Kyle", "20", "Monster Bike", "Inverness", "Images/PFPs/Kyle.jpg", new ArrayList<String>());
        User user21 = new User("Lewis", "21", "Army Stuff", "Dundee", "Images/PFPs/Lewis.jpg", new ArrayList<String>());
        User user22 = new User("Lindsay", "22", "NHS", "Kingskettle", "Images/PFPs/Lindsay.jpg", new ArrayList<String>());
        User user23 = new User("Matt", "23", "H+I Adventures", "Inverness", "Images/PFPs/Matt.jpg", new ArrayList<String>());
        User user24 = new User("Niamh", "24", "Montezumas Race Team", "Falkirk", "Images/PFPs/Niamh.jpg", new ArrayList<String>());
        User user25 = new User("Orla", "25", "Wholesome corp", "Glasgow", "Images/PFPs/Orla.jpg", new ArrayList<String>());
        User user26 = new User("Patryk", "26", "DUMRCC", "Arran", "Images/PFPs/Patryk.jpg", new ArrayList<String>());
        User user27 = new User("Ross", "27", "DUMRCC", "Rumbling Bridge", "Images/PFPs/Ross.jpg", new ArrayList<String>());
        User user28 = new User("Roy", "28", "DUMRCC", "Rumbling Bridge", "Images/PFPs/Roy.jpg", new ArrayList<String>());
        User user29 = new User("Sally", "29", "Aviemore Bikes", "Aviemore", "Images/PFPs/Sally.jpg", new ArrayList<String>());
        User user30 = new User("Sean", "30", "Grizzly Munro Diaries", "Dundee", "Images/PFPs/Sean.jpg", new ArrayList<String>());
        User user31 = new User("Sid", "31", "Sid's Clothing emporium", "Arran", "Images/PFPs/Sid.jpg", new ArrayList<String>());
        User user32 = new User("Tash", "32", "Avertical", "England:(", "Images/PFPs/Tash.jpg", new ArrayList<String>());
        User user33 = new User("Tilly", "33", "Hidden Glen", "Muchty", "Images/PFPs/Tilly.jpg", new ArrayList<String>());

        user1.addFriend(user2.getID());
        user1.addFriend(user3.getID());
        user1.addFriend(user4.getID());
        user1.addFriend(user5.getID());
        user1.addFriend(user33.getID());
        user1.addFriend(user29.getID());
        user1.addFriend(user16.getID());
        user1.addFriend(user14.getID());
        user1.addFriend(user11.getID());

        user2.addFriend(user1.getID());
        user2.addFriend(user3.getID());
        user2.addFriend(user4.getID());
        user2.addFriend(user10.getID());
        user2.addFriend(user12.getID());
        user2.addFriend(user30.getID());
        user2.addFriend(user24.getID());
        user2.addFriend(user15.getID());
        user2.addFriend(user18.getID());
        user2.addFriend(user33.getID());
        user2.addFriend(user19.getID());
        user2.addFriend(user29.getID());

        user3.addFriend(user1.getID());
        user3.addFriend(user2.getID());
        user3.addFriend(user4.getID());
        user3.addFriend(user5.getID());
        user3.addFriend(user27.getID());
        user3.addFriend(user14.getID());
        user3.addFriend(user10.getID());
        user3.addFriend(user12.getID());
        user3.addFriend(user16.getID());
        user3.addFriend(user19.getID());
        user3.addFriend(user9.getID());
        user3.addFriend(user29.getID());

        user4.addFriend(user1.getID());
        user4.addFriend(user2.getID());
        user4.addFriend(user4.getID());
        user4.addFriend(user5.getID());
        user4.addFriend(user28.getID());
        user4.addFriend(user13.getID());
        user4.addFriend(user19.getID());
        user4.addFriend(user29.getID());
        user4.addFriend(user32.getID());

        user5.addFriend(user1.getID());
        user5.addFriend(user3.getID());
        user5.addFriend(user11.getID());
        user5.addFriend(user12.getID());
        user5.addFriend(user15.getID());
        user5.addFriend(user14.getID());

        user6.addFriend(user7.getID());
        user6.addFriend(user12.getID());
        user6.addFriend(user2.getID());
        user6.addFriend(user5.getID());
        user6.addFriend(user4.getID());
        user6.addFriend(user29.getID());
        user6.addFriend(user30.getID());
        user6.addFriend(user19.getID());

        user7.addFriend(user20.getID());
        user7.addFriend(user30.getID());
        user7.addFriend(user31.getID());
        user7.addFriend(user33.getID());

        user8.addFriend(user21.getID());
        user8.addFriend(user22.getID());
        user8.addFriend(user23.getID());
        user8.addFriend(user24.getID());
        user8.addFriend(user25.getID());
        user8.addFriend(user26.getID());
        user8.addFriend(user27.getID());
        user8.addFriend(user28.getID());

        user9.addFriend(user19.getID());
        user9.addFriend(user28.getID());
        user9.addFriend(user18.getID());
        user9.addFriend(user17.getID());
        user9.addFriend(user16.getID());
        user9.addFriend(user15.getID());
        user9.addFriend(user14.getID());
        user9.addFriend(user13.getID());
        user9.addFriend(user12.getID());
        user9.addFriend(user11.getID());
        user9.addFriend(user6.getID());

        user10.addFriend(user20.getID());
        user10.addFriend(user1.getID());
        user10.addFriend(user2.getID());
        user10.addFriend(user3.getID());
        user10.addFriend(user4.getID());
        user10.addFriend(user5.getID());
        user10.addFriend(user6.getID());
        user10.addFriend(user7.getID());
        user10.addFriend(user8.getID());

        user11.addFriend(user20.getID());
        user11.addFriend(user4.getID());
        user11.addFriend(user29.getID());
        user11.addFriend(user33.getID());
        user11.addFriend(user32.getID());
        user11.addFriend(user15.getID());
        user11.addFriend(user16.getID());
        user11.addFriend(user9.getID());

        user12.addFriend(user6.getID());
        user12.addFriend(user4.getID());

        user13.addFriend(user29.getID());
        user13.addFriend(user4.getID());
        user13.addFriend(user33.getID());

        user14.addFriend(user6.getID());
        user14.addFriend(user3.getID());
        user14.addFriend(user4.getID());
        user14.addFriend(user5.getID());
        user14.addFriend(user27.getID());
        user14.addFriend(user28.getID());
        user14.addFriend(user29.getID());
        user14.addFriend(user30.getID());
        user14.addFriend(user31.getID());
        user14.addFriend(user32.getID());

        user15.addFriend(user1.getID());
        user15.addFriend(user2.getID());
        user15.addFriend(user10.getID());
        user15.addFriend(user12.getID());
        user15.addFriend(user20.getID());
        user15.addFriend(user12.getID());
        user15.addFriend(user30.getID());
        user15.addFriend(user31.getID());
        user15.addFriend(user32.getID());

        user16.addFriend(user4.getID());
        user16.addFriend(user2.getID());
        user16.addFriend(user20.getID());
        user16.addFriend(user25.getID());
        user16.addFriend(user26.getID());
        user16.addFriend(user27.getID());
        user16.addFriend(user28.getID());
        user16.addFriend(user29.getID());

        user17.addFriend(user4.getID());
        user17.addFriend(user16.getID());
        user17.addFriend(user15.getID());
        user17.addFriend(user13.getID());
        user17.addFriend(user12.getID());
        user17.addFriend(user11.getID());
        user17.addFriend(user8.getID());
        user17.addFriend(user9.getID());
        user17.addFriend(user17.getID());
        user17.addFriend(user19.getID());
        user17.addFriend(user23.getID());
        user17.addFriend(user33.getID());
        user17.addFriend(user32.getID());
        user17.addFriend(user31.getID());

        user18.addFriend(user2.getID());
        user18.addFriend(user4.getID());
        user18.addFriend(user6.getID());
        user18.addFriend(user8.getID());
        user18.addFriend(user10.getID());
        user18.addFriend(user12.getID());
        user18.addFriend(user14.getID());
        user18.addFriend(user16.getID());
        user18.addFriend(user18.getID());
        user18.addFriend(user20.getID());
        user18.addFriend(user22.getID());
        user18.addFriend(user24.getID());
        user18.addFriend(user1.getID());
        user18.addFriend(user28.getID());
        user18.addFriend(user30.getID());
        user18.addFriend(user32.getID());
        user18.addFriend(user33.getID());
        user18.addFriend(user31.getID());
        user18.addFriend(user29.getID());
        user18.addFriend(user27.getID());
        user18.addFriend(user25.getID());
        user18.addFriend(user23.getID());
        user18.addFriend(user21.getID());
        user18.addFriend(user19.getID());

        user19.addFriend(user9.getID());
        user19.addFriend(user5.getID());
        user19.addFriend(user6.getID());
        user19.addFriend(user7.getID());
        user19.addFriend(user11.getID());
        user19.addFriend(user10.getID());
        user19.addFriend(user2.getID());
        user19.addFriend(user3.getID());
        user19.addFriend(user1.getID());
        
        user20.addFriend(user10.getID());
        user20.addFriend(user1.getID());
        user20.addFriend(user4.getID());
        user20.addFriend(user16.getID());
        user20.addFriend(user17.getID());
        user20.addFriend(user9.getID());
        user20.addFriend(user19.getID());
        user20.addFriend(user11.getID());
        user20.addFriend(user10.getID());
        user20.addFriend(user14.getID());
        user20.addFriend(user21.getID());
        user20.addFriend(user31.getID());
        user20.addFriend(user12.getID());

        user21.addFriend(user1.getID());
        user21.addFriend(user4.getID());
        user21.addFriend(user8.getID());
        user21.addFriend(user10.getID());
        user21.addFriend(user18.getID());
        user21.addFriend(user19.getID());
        user21.addFriend(user1.getID());
        user21.addFriend(user1.getID());
        user21.addFriend(user1.getID());
        user21.addFriend(user1.getID());

        user22.addFriend(user4.getID());
        user22.addFriend(user16.getID());
        user22.addFriend(user15.getID());
        user22.addFriend(user13.getID());
        user22.addFriend(user12.getID());
        user22.addFriend(user11.getID());
        user22.addFriend(user8.getID());
        user22.addFriend(user9.getID());
        user22.addFriend(user17.getID());
        user22.addFriend(user19.getID());
        user22.addFriend(user23.getID());
        user22.addFriend(user33.getID());
        user22.addFriend(user32.getID());
        user22.addFriend(user31.getID());
        
        user23.addFriend(user1.getID());
        user23.addFriend(user2.getID());
        user23.addFriend(user4.getID());
        user23.addFriend(user5.getID());
        user23.addFriend(user27.getID());
        user23.addFriend(user14.getID());
        user23.addFriend(user10.getID());
        user23.addFriend(user12.getID());
        user23.addFriend(user16.getID());
        user23.addFriend(user19.getID());
        user23.addFriend(user9.getID());
        user23.addFriend(user29.getID());

        user24.addFriend(user1.getID());
        user24.addFriend(user2.getID());
        user24.addFriend(user4.getID());
        user24.addFriend(user5.getID());
        user24.addFriend(user28.getID());
        user24.addFriend(user13.getID());
        user24.addFriend(user19.getID());
        user24.addFriend(user29.getID());
        user24.addFriend(user32.getID());

        user25.addFriend(user1.getID());
        user25.addFriend(user3.getID());
        user25.addFriend(user11.getID());
        user25.addFriend(user12.getID());
        user25.addFriend(user15.getID());
        user25.addFriend(user14.getID());

        user26.addFriend(user7.getID());
        user26.addFriend(user12.getID());
        user26.addFriend(user2.getID());
        user26.addFriend(user5.getID());
        user26.addFriend(user4.getID());
        user26.addFriend(user29.getID());
        user26.addFriend(user30.getID());
        user26.addFriend(user19.getID());

        user27.addFriend(user20.getID());
        user27.addFriend(user30.getID());
        user27.addFriend(user31.getID());
        user27.addFriend(user33.getID());

        user28.addFriend(user21.getID());
        user28.addFriend(user22.getID());
        user28.addFriend(user23.getID());
        user28.addFriend(user24.getID());
        user28.addFriend(user25.getID());
        user28.addFriend(user26.getID());
        user28.addFriend(user27.getID());
        user28.addFriend(user30.getID());

        user29.addFriend(user19.getID());
        user29.addFriend(user28.getID());
        user29.addFriend(user18.getID());
        user29.addFriend(user17.getID());
        user29.addFriend(user16.getID());
        user29.addFriend(user15.getID());
        user29.addFriend(user14.getID());
        user29.addFriend(user13.getID());
        user29.addFriend(user12.getID());
        user29.addFriend(user11.getID());
        user29.addFriend(user6.getID());

        user30.addFriend(user1.getID());
        user30.addFriend(user2.getID());
        user30.addFriend(user4.getID());
        user30.addFriend(user5.getID());
        user30.addFriend(user27.getID());
        user30.addFriend(user14.getID());
        user30.addFriend(user10.getID());
        user30.addFriend(user12.getID());
        user30.addFriend(user16.getID());
        user30.addFriend(user19.getID());
        user30.addFriend(user9.getID());
        user30.addFriend(user29.getID());

        user31.addFriend(user1.getID());
        user31.addFriend(user2.getID());
        user31.addFriend(user4.getID());
        user31.addFriend(user5.getID());
        user31.addFriend(user27.getID());
        user31.addFriend(user14.getID());
        user31.addFriend(user10.getID());
        user31.addFriend(user12.getID());
        user31.addFriend(user16.getID());
        user31.addFriend(user19.getID());
        user31.addFriend(user9.getID());
        user31.addFriend(user29.getID());

        user32.addFriend(user1.getID());
        user32.addFriend(user2.getID());
        user32.addFriend(user4.getID());
        user32.addFriend(user5.getID());
        user32.addFriend(user28.getID());
        user32.addFriend(user13.getID());
        user32.addFriend(user19.getID());
        user32.addFriend(user29.getID());
        user32.addFriend(user32.getID());

        user33.addFriend(user1.getID());
        user33.addFriend(user2.getID());
        user33.addFriend(user4.getID());
        user33.addFriend(user5.getID());
        user33.addFriend(user27.getID());
        user33.addFriend(user14.getID());
        user33.addFriend(user10.getID());
        user33.addFriend(user12.getID());
        user33.addFriend(user16.getID());
        user33.addFriend(user19.getID());
        user33.addFriend(user9.getID());
        user33.addFriend(user29.getID());

        main.addUsers(user1);
        main.addUsers(user2);
        main.addUsers(user3);
        main.addUsers(user4);
        main.addUsers(user5);
        main.addUsers(user6);
        main.addUsers(user7);
        main.addUsers(user8);
        main.addUsers(user9);
        main.addUsers(user10);
        main.addUsers(user11);
        main.addUsers(user12);
        main.addUsers(user13);
        main.addUsers(user14);
        main.addUsers(user15);
        main.addUsers(user16);
        main.addUsers(user17);
        main.addUsers(user18);
        main.addUsers(user19);
        main.addUsers(user20);
        main.addUsers(user21);
        main.addUsers(user22);
        main.addUsers(user23);
        main.addUsers(user24);
        main.addUsers(user25);
        main.addUsers(user26);
        main.addUsers(user27);
        main.addUsers(user28);
        main.addUsers(user29);
        main.addUsers(user30);
        main.addUsers(user31);
        main.addUsers(user32);
        main.addUsers(user33);
    }

    public int getUserCount() {
        int max = 31;

        // Any thoughts on getting a max ID value?

        return max;
    }
}
