package java4.book4_1.jang1_2;

import java.util.ArrayList;
import java.util.Arrays;

public class Message {
    private String sender;
    private ArrayList<String> recipients;
    private String text;

    public Message(String sender, String text) {
        this.sender = sender;
        recipients = new ArrayList<String>();
        this.text = text;
    }

    public void addRecipient(String recipient) {
        recipients.add(recipient);
    }

    ;

    public Message clone() {
        try {
            Message cloned = (Message) super.clone();
            ArrayList<String> clonedRecipients = (ArrayList<String>) recipients.clone();
            cloned.recipients = clonedRecipients;
            return cloned;
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }

    public static void main(String[] args) {
        String[] strs = {"홍길동" , "김길동"};

        String[] strs2 = strs.clone();

        System.out.println(Arrays.toString(strs2));

        strs2[0] = "이길동";
        System.out.println(Arrays.toString(strs2));
        System.out.println(Arrays.toString(strs));

    }
}
