package ba.arnel.spring.mvc.viewmodels;
import java.util.List;

public class UserInputVM {
    public static List<Row> rows;
    public static boolean alertNoData = true;
    public static boolean alertSuccessAdd = false;
    public static void Delete(int id){
        for(Row osoba : rows){
            if(osoba.getId() == id){
                rows.remove(osoba);
                break;
            }
        }
    }
    public static class Row {
        private int id ;
        private String firstName;
        private String lastName;
        private String address;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
       /* public static boolean isNewUser(){
            return (this.getId()<0||this.getId()>=0)?true:false;
        }*/
    }
}
