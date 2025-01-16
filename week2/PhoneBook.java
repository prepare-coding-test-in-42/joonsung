import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> books = new HashSet<>();
        for (String phone: phone_book)
            books.add(phone);
        
        for (String phone: phone_book) {
            for (int i = 0; i < phone.length(); i++) {
                String s = phone.substring(0, i);
                if (books.contains(s))
                    return false;
            }
        }
        return true;
    }
}
